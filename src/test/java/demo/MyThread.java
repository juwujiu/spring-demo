package demo;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MyThread implements Runnable
{
    private Thread t;
    private String n;
    private CountDownLatch l;

    MyThread(String name, CountDownLatch latch)
    {
        n = name;
        l = latch;
    }

    @Override
    public void run()
    {
        System.out.println("--start-" + n);
        Random random = new Random(1000);// 指定种子数字
        long i = random.nextInt(1000);
        try
        {
            Thread.sleep(2000);
            System.out.println("--end" + n);
            l.countDown();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void start()
    {
        if (t == null)
        {
            t = new Thread(this, n);
            t.start();
        }
    }
}
