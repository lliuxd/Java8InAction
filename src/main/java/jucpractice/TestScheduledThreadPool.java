package jucpractice;

import java.util.Random;
import java.util.concurrent.*;

public class TestScheduledThreadPool {

    public static void main(String[] args) throws Exception {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            Future<Integer> result = pool.schedule(new Callable<Integer>(){

                @Override
                public Integer call() throws Exception {
                    int num = new Random().nextInt(100);//生成随机数
                    System.out.println(Thread.currentThread().getName() + " : " + num);
                    return num;
                }

            }, 1, TimeUnit.SECONDS);   //延迟线程，延迟时间，时间单位

            System.out.println(result.get());
        }

        pool.shutdown();
    }

}
