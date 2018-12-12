package day04;

/**
 * 内部类值的调用
 */
public class Outer {
    int num = 10;
    class Inner{
        int num = 20;
        public void show(){
            // 等同于this.num，类似继承树从下往上检索符合条件的this，该this在Inner类就停止检索并退出使用
            System.out.println("show num: " + num);
            // 要调用外部类的this需要再声明是Outer的this
            System.out.println("show num: " + Outer.this.num);
        }
    }
}

class Demo03{
    public static void main(String[] args){
        Outer.Inner in = new Outer().new Inner();
        in.show();
    }
}