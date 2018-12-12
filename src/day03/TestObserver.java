package day03;

/**
 * 测试观察者模式
 */
public class TestObserver {
    public static void main(String[] args){
        ProductList observable = ProductList.getInstance();
        TaoBaoObserver taoBaoObserver = new TaoBaoObserver();
        JingDongObserver jingDongObserver = new JingDongObserver();
        // 对被观察者注册观察者对象
        observable.addObserver(jingDongObserver);
        observable.addObserver(taoBaoObserver);

        observable.addProduct("新增产品1");
    }
}
