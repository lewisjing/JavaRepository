package proxy.cglibproxy;

// 目标对象，不需要实现任何接口
public class UserDao {
    public void save() {
        System.out.println("目标对象的方法");
    }
}
