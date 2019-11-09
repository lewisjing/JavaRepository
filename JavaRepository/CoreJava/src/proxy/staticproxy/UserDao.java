package proxy.staticproxy;

// 目标对象
public class UserDao implements IUserDao{

    @Override
    public void save() {
        System.out.println("目标对象");
    }
}
