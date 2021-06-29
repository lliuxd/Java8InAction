package jucpractice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestPracticePrintABANDC {

    public static void main(String[] args) {
        AlternaticePlace alternaticePlace = new AlternaticePlace();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    alternaticePlace.loopA(i);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    alternaticePlace.loopB(i);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    alternaticePlace.loopC(i);
                }
            }
        }).start();


    }




}


class AlternaticePlace{
    private String flag= "A";
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();


     void loopA(int total){
        try {
            lock.lock();
            if(!"A".equals(flag)){
                conditionA.await();
            }
            System.out.println("A"+total);
            flag = "B";
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

     void loopB(int total){
        try {
            lock.lock();
            if(!"B".equals(flag)){
                conditionB.await();
            }
            System.out.println("B"+total);
            flag = "C";
            conditionC.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

     void loopC(int total){
        try {
            lock.lock();
            if(!"C".equals(flag)){
                conditionC.await();
            }
            System.out.println("C"+total);
            System.out.println("-------------------------");
            flag = "A";
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}