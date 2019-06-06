package demo;

public class MyThread implements Runnable
{
    private Thread t;
    private String n;

    MyThread(String name)
    {
        n = name;
    }

    @Override
    public void run()
    {
        Thread j = new Thread()
        {
            @Override
            public void run()
            {
                System.out.println("--start-" + n);
                WiDateSync.dateSync(t);
            }
        };
        j.start();
        synchronized (t)
        {
            try
            {
                t.wait();
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("--end" + n);
    }

    public void start()
    {
        if (t == null)
        {
            t = new Thread(this, n);
            t.start();
        }
    }

    public void myNotify()
    {
        Thread.currentThread().notify();
    }
}
