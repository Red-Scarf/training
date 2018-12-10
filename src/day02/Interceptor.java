package day02;

import java.lang.reflect.Method;

/**
 * 拦截器接口
 */
public interface Interceptor {
    /**
     * 实现逻辑方法
     * @param proxy 代理对象
     * @param target 真实对象
     * @param method method方法
     * @param args 运行参数
     * @return 在真实对象前调用，true反射真实对象的方法，false调用around方法
     */
    public boolean before(Object proxy, Object target, Method method, Object[] args);
    public void around(Object proxy, Object target, Method method, Object[] args);
    public void after(Object proxy, Object target, Method method, Object[] args);
}
