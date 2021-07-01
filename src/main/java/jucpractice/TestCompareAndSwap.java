package jucpractice;

import java.util.Random;

public class TestCompareAndSwap {

    public static void main(String[] args) {
        CompareAndSwap cas = new CompareAndSwap();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int expectedValue = cas.get();
                    cas.compareAndSet(expectedValue,new Random().nextInt(100));
                }
            });

        }
    }

}


class CompareAndSwap{

    private int value;

    public synchronized int get(){
        return value;
    }

    public synchronized int compareAndSwap(int expectedValue,int newValue){
        int oldValue = value;
        if(oldValue == expectedValue){
            this.value = newValue;
        }
        return oldValue;
    }

    public synchronized boolean compareAndSet(int expectedValue,int newValue){
        return expectedValue == compareAndSwap(expectedValue,newValue);
    }


}
