package panshul.learning.multithreading.threadsync;

import java.util.Scanner;

/**
 * This setup is always seen to run, except for certain cases, when JVM decides to optimize
 * the code for performance by caching the variable "running"... so each thread has its own
 * copy of Processor and if one thread.. also maybe main thread changes the value of running
 * all threads might not check the updated value and continue running.. atleast for sometime.
 * As a solution, we make the "running" variable volatile. Now the variable is stored in the
 * main memory and not in the CPU cache... so if one thread changes its value it is read by
 * all threads processing over it.
 * It is ofcourse not performance efficient.
 * Usefull to shutdown multiple threads from one thread.
 * Alternative is to use AtomicBoolean.
 */
class Processor extends Thread
{

    private volatile boolean running = true;

    public void run()
    {
        while (running)
        {
            System.out.println("Hello");

            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void shutdown()
    {
        running = false;
    }
}

public class BasicThreadSynchronization
{
    public static void main(String[] args)
    {
        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Press return to stop...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        proc1.shutdown();
    }

}
