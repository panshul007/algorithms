package panshul.learning.multithreading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable
{

    private int id;

    public Processor(int id)
    {
        this.id = id;
    }

    @Override public void run()
    {
        System.out.println("Starting: " + id);

        //Simulating doing something
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("Completed: " + id);

    }
}

/**
 * Demonstrating thread pools using Executor Service.
 */
public class App
{
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++)
        {
            executor.submit(new Processor(i));
        }

        executor.shutdown(); //waits for all submitted threads to be completed.

        System.out.println("All tasks submitted");

        try
        {
            executor.awaitTermination(1, TimeUnit.DAYS); //waits for threads to complete till assigned time.
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("All tasks completed");
    }
}
