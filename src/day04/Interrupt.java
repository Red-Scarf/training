package day04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 响应中断
 * 使用lockInterruptibly方法，在等待资源的时候可以被中断，而synchronized在等待时则不能被中断
 */
public class Interrupt {
    private Lock lock = new ReentrantLock();
    public void insert(Thread thread) throws InterruptedException {
        lock.lockInterruptibly(); //注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将InterruptedException抛出
        try {
            System.out.println(thread.getName()+"得到了锁");
            long startTime = System.currentTimeMillis();
            for ( ; ; ){
                if(System.currentTimeMillis() - startTime >= Integer.MAX_VALUE){
                    break;
                    // 插入数据
                }
            }
        }finally {
            System.out.println(thread.getName()+"执行finally");
            lock.unlock();
            System.out.println(thread.getName()+"释放了锁");
        }
    }

    public static void main(String[] args){
        Interrupt interrupt = new Interrupt();
        MyThread thread1 = new MyThread(interrupt);
        MyThread thread2 = new MyThread(interrupt);
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        thread2.interrupt();
    }
}
