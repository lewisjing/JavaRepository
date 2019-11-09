package proxy.dynamicproxy;

public class Test {
    public static void main(String[] args) {
        // 目标对象
        IUserDao target = new UserDao();

        // 原始的类型
        System.out.println(target.getClass());

        ProxyFactory proxyFactory = new ProxyFactory(target);

        IUserDao proxy = (IUserDao) proxyFactory.getProxyInstance();

        // 在内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        proxy.save();
    }
}
