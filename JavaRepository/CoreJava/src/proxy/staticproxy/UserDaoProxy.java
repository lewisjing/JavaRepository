package proxy.staticproxy;

// 代理对象
public class UserDaoProxy implements IUserDao{

    private IUserDao iUserDao;

    public UserDaoProxy(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }

    @Override
    public void save() {
        iUserDao.save();
    }
}
