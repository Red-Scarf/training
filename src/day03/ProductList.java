package day03;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式的被观察者
 */
public class ProductList extends Observable {
    private List<String> productList = null; // 产品列表
    private static ProductList instance; // 单例模式
    private ProductList(){}

    /**
     * 取得唯一实例
     * @return 产品列表唯一实例
     */
    public static ProductList getInstance(){
        if (instance == null){
            instance = new ProductList();
            instance.productList = new ArrayList<String>();
        }
        return instance;
    }

    /**
     * 增加观察者(电商接口)
     * @param observer 观察者
     */
    public void addProductListObserver(Observer observer){
        this.addObserver(observer);
    }

    public void addProduct(String newProduct){
        productList.add(newProduct);
        System.out.println("产品列表新增产品:"+newProduct);
        this.setChanged(); // 设置被观察者对象发生了变化
        this.notifyObservers(newProduct); // 通知所有的观察者，传递新产品
    }
}
