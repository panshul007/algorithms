package panshul.learning.multithreading.semaphores;

import java.util.concurrent.Semaphore;

public class Connection
{
    private static Connection instance = new Connection();

    //True - says that the thread requesting a permit and is waiting, will get a permit first, when it is released.
    private Semaphore sem = new Semaphore(10, true);

    private int connections = 0;

    private Connection()
    {

    }

    public static Connection getInstance()
    {
        return instance;
    }

    public void connect()
    {
        try
        {
            sem.acquire();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        try
        {
            doConnect();
        }
        finally
        {
            sem.release();
        }
    }

    public void doConnect()
    {
        synchronized (this)
        {
            connections++;
            System.out.println("Current connections: " + connections);
        }
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        synchronized (this)
        {
            connections--;
        }
    }
}
