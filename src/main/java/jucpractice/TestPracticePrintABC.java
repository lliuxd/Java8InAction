//package jucpractice;
//
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class TestPracticePrintABC {
//
//    public static void main(String[] args) {
//        WorkFactory workFactory = new WorkFactory();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 20; i++) {
//                    workFactory.loopA(i);
//                }
//            }
//        }, "A").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 20; i++) {
//                    workFactory.loopB(i);
//                }
//            }
//        }, "B").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 20; i++) {
//                    workFactory.loopC(i);
//                }
//            }
//        }, "C").start();
//
//
//    }
//
//}
//
//class WorkFactory {
//    private ReentrantLock lock = new ReentrantLock();
//    private Condition conditionA = lock.newCondition();
//    private Condition conditionB = lock.newCondition();
//    private Condition conditionC = lock.newCondition();
//    private String flag = "A";
//
//
//    public void loopA(int total) {
//        try {
//            System.out.println(Thread.currentThread().getName()+"当前flag"+flag+"当前是否在竞争锁"+lock.hasQueuedThreads() + total);
//            lock.lock();
//            if ("A".equals(flag)) {
//                System.out.println(flag + "\t" + total);
//                flag = "B";
//                conditionB.signal();
//            } else {
//                conditionA.await();
//                System.out.println("A wake");
//                conditionB.signal();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void loopB(int total) {
//        try {
//            System.out.println(Thread.currentThread().getName()+"当前flag"+flag+"当前是否在竞争锁"+lock.hasQueuedThreads() + total);            lock.lock();
//            if ("B".equals(flag)) {
//                System.out.println(flag + "\t" + total);
//                flag = "C";
//                conditionC.signal();
//            } else {
//                conditionB.await();
//                System.out.println("B wake");
//                conditionC.signal();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void loopC(int total) {
//        try {
//            System.out.println(Thread.currentThread().getName()+"当前flag"+flag+"当前是否在竞争锁"+lock.hasQueuedThreads() + total);            lock.lock();
//            if ("C".equals(flag)) {
//                System.out.println(flag + "\t" + total);
//                System.out.println("----------------------------");
//                flag = "A";
//                conditionA.signal();
//            } else {
//                conditionC.await();
//                System.out.println("C wake");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//
//}
//
