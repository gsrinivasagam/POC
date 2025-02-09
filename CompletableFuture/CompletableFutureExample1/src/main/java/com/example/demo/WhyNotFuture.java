package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class WhyNotFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("print");

        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<List<Integer>> future = service.submit(()->{
            System.out.println("Thread --"+Thread.currentThread().getName());
//            delay(1);
            return Arrays.asList(1,2,3,4,5);
        });


        CompletableFuture future1 = new CompletableFuture();
        future1.get();
        future1.complete("complete it");
         List<Integer> list = future.get();
        System.out.println(list);

    }


    private static void delay(int min) {
        try {
            TimeUnit.MINUTES.sleep(min);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
