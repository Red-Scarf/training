package day04;

abstract class Inner{
    public abstract void show();
    public abstract void show1();
}
public class NoName {
    public void print(){
        Inner i = new Inner(){
            public void show(){
                System.out.println("匿名内部类的show输出");
            }
            public void show1(){
                System.out.println("匿名内部类的show1输出");
            }
        };
        i.show();
        i.show1();
    }

    public static void main(String[] args){
        NoName n = new NoName();
        n.print();
    }
}
