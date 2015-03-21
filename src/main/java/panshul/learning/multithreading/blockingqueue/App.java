package panshul.learning.multithreading.blockingqueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Demonstrating producer consumer pattern.
 * A BlockingQueue is used, it is thread safe queue.
 * The producer is pushing elements into the queue. If queue is full, it will wait till there is
 * space to put in more elements.
 * The consumer is taking elements form the queue at random intervals. If the queue is empty it
 * will wait for more elements to be pushed into the queue.
 */
public class App
{
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args) throws InterruptedException
    {
        Thread t1 = new Thread(
                new Runnable()
                {
                    @Override public void run()
                    {
                        try
                        {
                            producer();
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                });

        Thread t2 = new Thread(
                new Runnable()
                {
                    @Override public void run()
                    {
                        try
                        {
                            consumer();
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                });

        t1.start();
        t2.start();

        t1.join(); //waits for the thread to complete its task and then terminate.
        t2.join();
    }

    private static void producer() throws InterruptedException
    {
        Random random = new Random();

        while (true)
        {
            queue.put(random.nextInt(100));
        }
    }

    private static void consumer() throws InterruptedException
    {
        Random random = new Random();

        while (true)
        {
            Thread.sleep(100);

            if (random.nextInt(10) == 0)
            {
                Integer value = queue.take();

                System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());
            }
        }
    }
}
