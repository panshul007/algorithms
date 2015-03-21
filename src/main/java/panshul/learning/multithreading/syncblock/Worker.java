package panshul.learning.multithreading.syncblock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Demonstrates how to make two methods of a class executed at the same time by different threads by using
 * Synchronized blocks.
 * If we make the two methods as synchronized, then the lock by a thread is obtained for both the methods
 * by obtaining a lock on the complete worker object.
 * As a solution we made two locks, and then used them to make two synchronized blocks and put the methods
 * in these separate synchronized blocks. Now the threads can obtain locks on both methods separately.
 * This works because both methods are independent of each other, they do not even share any data variables.
 * It could work by making the blocks synchronized over the lists as locks, but it is always a good a practice
 * to keep the locks and operational data variables separate.
 */
public class Worker
{
    private Random random = new Random();

    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    //public synchronized void stageOne()
    public void stageOne()
    {
        synchronized (lock1)
        {
            try
            {
                // just simulating doing something
                Thread.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            list1.add(random.nextInt(100));
        }
    }

    //public synchronized void stageTwo()
    public void stageTwo()
    {
        synchronized (lock2)
        {
            try
            {
                // just simulating doing something
                Thread.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            list2.add(random.nextInt(100));
        }
    }

    public void process()
    {
        for (int i = 0; i < 1000; i++)
        {
            stageOne();
            stageTwo();
        }
    }

    public void main()
    {
        System.out.println("Starting...");

        long start = System.currentTimeMillis();

        Thread t1 = new Thread(
                new Runnable()
                {
                    @Override public void run()
                    {
                        process();
                    }
                });

        Thread t2 = new Thread(
                new Runnable()
                {
                    @Override public void run()
                    {
                        process();
                    }
                });

        t1.start();
        t2.start();

        try
        {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("Time taken: " + (end - start));
        System.out.println("List1: " + list1.size() + " List2: " + list2.size());
    }
}
