package proxy.dynamicproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 创建代理对象
// 动态代理不需要实现接口，但需要指定接口的类型
public class ProxyFactory {
    // 维护一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 给目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始调用目标对象的方法");
                        Object returnValue = method.invoke(target, args);
                        System.out.println("调用结束");
                        return returnValue;
                    }
        });
    }

}
