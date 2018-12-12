package day04;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 使用BlockingQueue实现生产者消费者问题
 * 客户端
 */
public class Client {
    public static void main(String[] args){
        BlockingDeque<String> queue = new LinkedBlockingDeque<>(5);
        for (int i = 0; i < 2; i++){
            new Thread(new Consumer(queue), "Consumer"+i).start();
        }
        for (int i = 0; i < 5; i++) {
            // 只有两个 Product，因此只能消费两个，其它三个消费者被阻塞
            new Thread(new Producer(queue), "Producer" + i).start();
        }
        for (int i = 2; i < 5; i++) {
            new Thread(new Consumer(queue), "Consumer" + i).start();
        }
    }
}
