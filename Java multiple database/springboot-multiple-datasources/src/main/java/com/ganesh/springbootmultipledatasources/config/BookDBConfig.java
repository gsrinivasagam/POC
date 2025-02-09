package com.ganesh.springbootmultipledatasources.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class BookDBConfig {


    @Bean(name="dataSource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().username("root").password("root").url("jdbc:mysql://localhost:3306/myusers").build();
    }

    @Primary
    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("dataSource") DataSource dataSource){
        return builder.dataSource(dataSource).packages("com.ganesh.springbootmultipledatasources").build();
    }

    @Primary
    @Bean(name="transactionManager")
    public PlatformTransactionManager bookTransactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory bookEntityManagerFactory){
        return new JpaTransactionManager(bookEntityManagerFactory);
    }
}
