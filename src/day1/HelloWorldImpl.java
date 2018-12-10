package day1;

public class HelloWorldImpl implements HelloWorld {
    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sayHelloWorld() {
        System.out.println(this.name+"Hello World");
    }
}
