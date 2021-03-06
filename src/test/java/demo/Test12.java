package demo;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import demo.inter.RequestUrl;
import demo.inter.RequstType;
import demo.inter.RequstType.Type;

public class Test12
{

    // 创建线程池来执行任务
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(4, // 核心线程数
            12, // 最大线程数
            60, // 线程空闲周期
            TimeUnit.SECONDS, // 周期单位s
            new SynchronousQueue<>()// 创建一个任务队列
    );

    public static void main(String[] args)
    {
        requestFromNet();
    }

    @RequestUrl(Constant.NETURL)
    @RequstType(Type.GET)
    public static void requestFromNet()
    {

        executor.execute(new Runnable()
        {
            @Override
            public void run()
            {
                // TODO Auto-generated method stub
                String result = RequestNet.parseRequest(new Test12());
                System.out.println("网络请求成功！！！结果：==" + result);
            }
        });

    }
}
