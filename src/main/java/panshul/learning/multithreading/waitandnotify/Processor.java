package panshul.learning.multithreading.waitandnotify;

import java.util.LinkedList;
import java.util.Random;

public class Processor
{

    private       LinkedList<Integer> list  = new LinkedList<Integer>();
    private final int                 LIMIT = 10;
    private final Object              lock  = new Object();

    /**
     * Wait - can be used in synchronized block
     * losses control of lock
     * can resume only when it gets a notify event
     */
    public void produce() throws InterruptedException
    {
        Random random = new Random();
        System.out.println("Producer thread running...");

        int value = 0;
        while (true)
        {
            synchronized (lock)
            {
                while (list.size() == LIMIT)
                {
                    lock.wait();
                }
                list.add(value++);
                lock.notify();
            }
            Thread.sleep(random.nextInt(500));
        }
    }

    /**
     * Notify - Can only be called by a synchronized block.
     * does not relinquish control of lock.
     * notifies all threads waiting on the same lock.
     * relinquishes the lock when the synchronized block is finished.
     */
    public void consume() throws InterruptedException
    {
        Random random = new Random();
        while (true)
        {
            synchronized (lock)
            {
                while (list.size() == 0)
                {
                    lock.wait();
                }

                System.out.print("List size is: " + list.size());
                int value = list.removeFirst();
                System.out.println("; value is: " + value);
                lock.notify();
            }
            Thread.sleep(random.nextInt(1000));
        }
    }
}
