package demo.utils;

public class ClearUserFile implements Runnable
{
    private Thread t;
    private String threadName;

    public ClearUserFile(String name)
    {
        this.threadName = name;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("当前线程:" + threadName);
    }

    public void start()
    {
        if (t == null)
        {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
