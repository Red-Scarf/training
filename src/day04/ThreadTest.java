package day04;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock同步机制
 */
public class ThreadTest {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    // 当Lock为类属性时，就可以进行同一方法多次调用的同步
    private Lock lock = new ReentrantLock();
    public static void main(String[] args){
        final  ThreadTest tt = new ThreadTest();

        new Thread(){
            @Override
            public void run() {
                tt.insert(Thread.currentThread());
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                tt.insert(Thread.currentThread());
            }
        }.start();
    }

    public void insert(Thread thread){
        // 当Lock为局部变量时，每个线程执行该方法时都会保存一个副本，所以无法进行同步
//        Lock lock = new ReentrantLock();
        lock.lock();
        try{
            System.out.println(thread.getName()+"得到了锁");
            for (int i=0;i<5;i++){
                arrayList.add(i);
            }
        } catch (Exception e){

        } finally {
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();
        }
    }
}
