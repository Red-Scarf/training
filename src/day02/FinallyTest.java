package day02;

/**
 * try catch finally执行顺序
 * 执行完try语句块之后，如果没有错误，则不会执行catch语句，但是会执行finally语句块
 * 在try语句块中有return时，会将return的值存在一个临时栈中
 * 执行完finally后，如果finally块中没有return值，则返回临时栈的值，如果有return则更新临时栈的返回值
 */
public class FinallyTest {
    public static void main(String[] args){
        System.out.println("number: "+beforeFinally());
    }
    public static int beforeFinally(){
        int a = 0;
        try{
            a = 1;
            return a;
        } finally {
            System.out.println("finally语句");
            a = 2;
//            return a;
        }
    }
}
