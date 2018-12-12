package day04;

import java.util.concurrent.BlockingDeque;

/**
 * 使用BlockingQueue实现生产者消费者问题
 * 消费者
 */
public class Consumer implements Runnable {
    private BlockingDeque<String> queue;
    public Consumer(BlockingDeque queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String product = queue.take(); // 如果队列为空 take() 将一直阻塞到队列中有内容
            System.out.println(Thread.currentThread().getName()+" is consuming product "+product+"...");
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
