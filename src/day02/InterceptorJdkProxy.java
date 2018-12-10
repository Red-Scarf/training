package day02;

import day1.HelloWorld;
import day1.HelloWorldImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 拦截器代理对象
 * 实现步骤:
 *      1.在bind方法中用JDK动态绑定一个对象并返回该代理对象
 *      2.如果没有拦截器则直接反射真实对象的方法，然后结束，否则进行第3步
 *      3.通过反射生成拦截器，并准备使用它
 *      4.调用拦截器的before方法，如果返回true，反射原来的方法，否则运行拦截器的around方法
 *      5.调用拦截器after方法
 *      6.返回结果
 */
public class InterceptorJdkProxy implements InvocationHandler {
    private Object target;// 真实对象
    private String interceptorClass = null; // 拦截器全限定名

    public InterceptorJdkProxy(Object target, String interceptorClass){
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    /**
     * 绑定委托对象并返回一个代理占位
     * @param target 真实对象
     * @param interceptorClass 代理对象的占位
     * @return
     */
    public static Object bind(Object target, String interceptorClass){
        // 取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InterceptorJdkProxy(target, interceptorClass));
    }

    /**
     * 通过代理对象调用方法，首先进入这个方法
     * @param proxy 代理对象
     * @param method 方法，被调用方法
     * @param args 方法参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (interceptorClass == null){
            // 没有拦截器则直接返回原有方法
            return method.invoke(target, args);
        }
        Object result = null;
        // 通过反射生成拦截器
        Interceptor interceptor = (Interceptor)Class.forName(interceptorClass).newInstance();
        // 调用前置方法
        if (interceptor.before(proxy, target, method, args)){
            // 反射原有方法
            result = method.invoke(target, args);
        } else { // 返回false执行around方法
            interceptor.around(proxy, target, method, args);
        }
        // 调用后置方法
        interceptor.after(proxy, target, method, args);
        return result;
    }

    public static void main(String[] args){
        HelloWorld proxy = (HelloWorld)InterceptorJdkProxy.bind(new HelloWorldImpl(), "day02.Mylnterceptor");
        proxy.sayHelloWorld();
    }
}
