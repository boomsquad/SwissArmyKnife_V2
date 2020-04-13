import java.util.ArrayList;

public class SleepFast
{
    class OneSecondSleeperThread extends Thread
    {
        private int sleepNumber;

        OneSecondSleeperThread(int sleepNumberIn)
        {
            sleepNumber = sleepNumberIn;
        }
        public void sleep()
        {
            System.out.println(sleepNumber + " - Going to sleep.");
            try
            {
                Thread.sleep(1000); //command for sleep for one second
            } catch (Exception e) {
                System.out.println("Exception:" + e);
            }

            System.out.println("..." + sleepNumber + " - Done sleeping.");
        }

        public void run()
        {
            sleep();
        }
    }
    
    public void SleepFastFuntion()
    {
        System.out.println("Starting Sleep...");
        OneSecondSleeperThread sleeper0 = new OneSecondSleeperThread(0);
        OneSecondSleeperThread sleeper1 = new OneSecondSleeperThread(1);

        System.out.println("\nNon-Threaded Sleep");
        long start = System.currentTimeMillis();

        sleeper0.sleep();
        sleeper1.sleep();

        System.out.println("Elapsed time = " + (System.currentTimeMillis() - start));

        System.out.println("\nThreaded Sleep");
        start = System.currentTimeMillis();
        sleeper0.start();
        sleeper1.start();

        try 
        {
            sleeper0.join();
            sleeper1.join();
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }

        System.out.println("Elapsed time = " + (System.currentTimeMillis() - start));

        //Sleeping ArrayList
        ArrayList<OneSecondSleeperThread> sleeperList = new ArrayList<OneSecondSleeperThread>();
        for (int i = 2; i < 12; i++)
        {
            sleeperList.add(new OneSecondSleeperThread(i));
        }

        System.out.println("\nNon-Threaded ArrayList sleep:");
        start = System.currentTimeMillis();
        for (OneSecondSleeperThread s: sleeperList)
        {
            s.sleep();
        }
        System.out.println("Elapsed time = " + (System.currentTimeMillis() - start));

        System.out.println("\nThreaded ArrayList sleep:");
        start = System.currentTimeMillis();
        for (OneSecondSleeperThread s: sleeperList)
        {
            s.start();
        }

        try 
        {
            for (OneSecondSleeperThread s: sleeperList)
            {
                s.join();
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        System.out.println("Elapsed time = " + (System.currentTimeMillis() - start));
    }
}