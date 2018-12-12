package day04;

import java.util.concurrent.BlockingDeque;

/**
 * 使用BlockingQueue实现生产者消费者问题
 * 生产者
 */
public class Producer implements Runnable {
    private BlockingDeque<String> queue;
    public Producer(BlockingDeque queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"is making product...");
        String product = "made by"+Thread.currentThread().getName();
        try {
            queue.put(product); // 如果队列为满 put() 将阻塞到队列有空闲位置
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
