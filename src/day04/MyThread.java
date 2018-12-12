package day04;

/**
 * 响应中断的测试线程
 */
public class MyThread extends Thread {
    private Interrupt interrupt = null;
    public MyThread(Interrupt interrupt){
        this.interrupt = interrupt;
    }

    @Override
    public void run() {
        try {
            interrupt.insert(Thread.currentThread());
        } catch (InterruptedException e){
            System.out.println(Thread.currentThread().getName()+"被中断");
        }
    }
}
