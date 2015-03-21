package panshul.learning.multithreading.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable
{

    private CountDownLatch latch;

    public Processor(CountDownLatch latch)
    {
        this.latch = latch;
    }

    @Override public void run()
    {
        System.out.println("Started...");

        try
        {
            Thread.sleep(3);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        latch.countDown();

    }
}

public class App
{
    public static void main(String[] args)
    {
        //Threadsafe counter.
        CountDownLatch latch = new CountDownLatch(5);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++)
        {
            executor.submit(new Processor(latch));
        }

        try
        {
            latch.await(); // waits for the latch to count down for the given time.
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("Completed.");
    }
}
