package day03;

/**
 * java的参数传递
 * java只有值传递
 * 基本类型传递的是本身值的副本
 * 引用类型(String，数组，列表，map，类对象等)传递的是对象类型的地址
 */
public class valueAndFunction {
    public static void main(String[] args){
        valueAndFunction vaf = new valueAndFunction();
        vaf.first();
    }

    public void first(){
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v,i);
        System.out.print(v.i);
    }

    public void second(Value v, int i){
        i = 0;
        v.i = 20; // 这里改变了实参的Value对象的i的值
        Value val = new Value(); // 这里是新的对象，地址不同，无法影响实参
        v = val;
        System.out.print(v.i+" "+i+" ");
    }
}

class Value{
    public int i = 15;
}
