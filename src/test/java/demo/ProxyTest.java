package demo;

import demo.inter.IUserDao;
import demo.inter.Invoker;

public class ProxyTest
{
    public static void main(String[] args)
    {
        IUserDao invoker = (IUserDao) new Invoker().getInstance(IUserDao.class);
        System.out.println(invoker.getUserName());
    }
}
