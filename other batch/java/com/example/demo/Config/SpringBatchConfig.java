package com.example.demo.Config;

import com.example.demo.Entity.Customer;
import com.example.demo.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@AllArgsConstructor
public class SpringBatchConfig {

//    private JobBuilderFactory jobBuilderFactory;
//
//    private StepBuilderFactory stepBuilderFactory;

    private CustomerRepository customerRepository;

    public FlatFileItemReader<Customer> reader(){
            FlatFileItemReader itemReader = new FlatFileItemReader();
            itemReader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
            itemReader.setName("csvReader");
            itemReader.setLineMapper(lineMapper());
            itemReader.setLinesToSkip(1);

            return itemReader;
    }

    private LineMapper<Customer> lineMapper() {
        DefaultLineMapper lineMapper = new DefaultLineMapper();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id","firstName","lastName","email","gender","contactNo","country","dob");

        BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Customer.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }

    @Bean
    public CustomerProcessor processor(){
        return new CustomerProcessor();
    }

    @Bean
    public RepositoryItemWriter<Customer> writer(){
        RepositoryItemWriter<Customer> writer = new RepositoryItemWriter<>();
        writer.setRepository(customerRepository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager){
            return new StepBuilder("csv-step",jobRepository).<Customer,Customer>chunk(10,platformTransactionManager).reader(reader()).processor(processor()).writer(writer()).build();
    }

    @Bean
    public Job runJob(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager){
        return new JobBuilder("importCustomers",jobRepository).flow(step1(jobRepository,platformTransactionManager)).end().build();
    }
}
