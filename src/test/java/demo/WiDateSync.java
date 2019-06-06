package demo;

import java.util.Random;
import java.util.concurrent.ConcurrentSkipListSet;

public class WiDateSync
{
    private static ConcurrentSkipListSet<Thread> quene = new ConcurrentSkipListSet<>();

    public static boolean dateSync(Thread t)
    {
        if (quene.isEmpty())
        {
            quene.add(t);
            doSome();
            System.out.println("--sync");
            syncFinish();
        }
        quene.add(t);
        return true;
    }

    private static void doSome()
    {
        Random random = new Random(1000);// 指定种子数字
        long i = random.nextInt(1000);
        try
        {
            Thread.sleep(i);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private static void syncFinish()
    {
        for (Thread t : quene)
        {
            t.notify();
        }
        quene.clear();
    }
}
