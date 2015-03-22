package panshul.learning.multithreading.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock ur locks in the same order to avoid deadlocks
 * Trylock method of ReentrantLock will try to get the lock and return true if it gets a lock else will return false.
 * is it can be used to avoid deadlocks.
 */
public class Runner
{
    private Account acc1 = new Account();
    private Account acc2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    /**
     * Acquire both locks in such a way that dead locks so not occur.
     * @param firstLock
     * @param secondLock
     */
    private void acquireLocks(Lock firstLock, Lock secondLock) throws InterruptedException
    {
        while (true)
        {
            // Acquire locks
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;

            try
            {
                // Tries to get both locks.
                gotFirstLock = firstLock.tryLock();
                gotSecondLock = secondLock.tryLock();
            }
            finally
            {
                /**
                 * Checks if both the locks have been acquired.
                 */
                if (gotFirstLock && gotSecondLock)
                {
                    return;
                }
                /**
                 * If both locks are not acquired then it releases any of the
                 * two locks that have been acquired so that other waiting threads
                 * can try to acquire both locks.
                 */
                if (gotFirstLock)
                {
                    firstLock.unlock();
                }
                if (gotSecondLock)
                {
                    secondLock.unlock();
                }
            }
            //Locks not acquired
            Thread.sleep(1);
        }
    }

    public void firstThread() throws InterruptedException
    {
        Random random = new Random();
        for (int i = 0; i < 10000; i++)
        {
            acquireLocks(lock1, lock2);
            try
            {
                Account.transfer(acc1, acc2, random.nextInt(100));
            }
            finally
            {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() throws InterruptedException
    {
        Random random = new Random();
        for (int i = 0; i < 10000; i++)
        {
            acquireLocks(lock2, lock1);
            try
            {
                Account.transfer(acc2, acc1, random.nextInt(100));
            }
            finally
            {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished()
    {
        System.out.println("Account 1 balance: " + acc1.getBalance());
        System.out.println("Account 2 balance: " + acc2.getBalance());
        System.out.println("Total balance: " + (acc2.getBalance() + acc1.getBalance()));

    }
}
