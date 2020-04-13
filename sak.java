// @Author: Mohammad Alabed

class sak
{
    public static void main(String[] args)
    {
        //Creates a timer in milliseconds
        long start = System.currentTimeMillis();
        
        System.out.println("");
        if (args.length < 1) 
        {
			System.out.println("At least one arguement needed. Use \"-Help\" for more information.");
            Help.printHelp();
            System.out.println("");
            System.out.println("Time Elapsed: " + (System.currentTimeMillis()-start) + "ms\n");		 
		} 
        else if (args[0].equalsIgnoreCase("-Help")) 
        {
			System.out.println("----------Running Help----------");
            Help.printHelp();
            System.out.println("");
            System.out.println("Time Elapsed: " + (System.currentTimeMillis()-start) + "ms\n");		  
		} 
        else if (args[0].equalsIgnoreCase("-HttpRequest")) 
        {
            System.out.println("-------Running HttpRequest-------");
            System.out.println("");
            if (args.length <2) 
            {
                System.out.println("-HttpRequest requires a valid URL.");
                System.out.println("Time Elapsed: " + (System.currentTimeMillis()-start) + "ms\n");
            } 
            else 
            {
				String URL = args[1];
				HttpRequest request = new HttpRequest();
                if (request.readURL(URL)) 
                {
                    System.out.println(request);
                    System.out.println("Time Elapsed: " + (System.currentTimeMillis()-start) + "ms\n");
				}
			}
		}
        else if (args[0].equalsIgnoreCase("-HttpRequestIndex")) 
        {
             System.out.println("-----Running HttpRequestIndex-----");
             System.out.println("");	
            if (args.length != 2) 
            {
                System.out.println("-HttpRequestIndex requires a valid URL.");
                System.out.println("");
                System.out.println("Time Elapsed: " + (System.currentTimeMillis()-start) + "ms\n");
            } 
            else
            {
				String indexURL = args[1];
                HttpRequest index = new HttpRequestIndex();
                if (index.readURL(indexURL)) 
                {
                    System.out.println(indexURL);
                    HttpRequestIndex requestIndex = new HttpRequestIndex();

                    //All URL's get read and printed in the order they are shown
                    System.out.println("-------------Parsing-------------");
                    requestIndex.readURL("https://thunderbird-index.azurewebsites.net/w0a6zk195e.json");
                    requestIndex.readURL("https://thunderbird-index.azurewebsites.net/w0a6zk195f.json");
                    requestIndex.readURL("https://thunderbird-index.azurewebsites.net/no-last-name.json");
                    requestIndex.readURL("https://thunderbird-index.azurewebsites.net/too-short-a-last-name.json");
                    
                    requestIndex.parseIndex();
                
                    System.out.println("-----------End Parsing-----------");
                    System.out.println("Time Elapsed: " + (System.currentTimeMillis()-start) + "ms\n");
                }
            }
        }
        else if (args[0].equalsIgnoreCase("-Sleep"))
        {
            System.out.println("-----------Sleep-----------");

            Sleep sleep = new Sleep();
            sleep.SleepFunction();

            System.out.println("");
            System.out.println("Time Elapsed: " + (System.currentTimeMillis()-start) + "ms\n");
        }
        else if (args[0].equalsIgnoreCase("-SleepFast"))
        {
            System.out.println("-----------SleepFast-----------");
            
            SleepFast sleepFast = new SleepFast();
            sleepFast.SleepFastFuntion();
            
            System.out.println("");
            System.out.println("Time Elapsed: " + (System.currentTimeMillis()-start) + "ms\n");
        }
        else if (args[0].equalsIgnoreCase("-SleepFastImplementsRunnable"))
        {
            System.out.println("-----------SleepFastImplementsRunnable-----------");
           
            SleepFastImplementsRunnable sleepFastImplementsRunnable = new SleepFastImplementsRunnable();
            sleepFastImplementsRunnable.SleepFastImplementsRunnableFunction();
            
            System.out.println("");
            System.out.println("Time Elapsed: " + (System.currentTimeMillis()-start) + "ms\n");
        }
        else if (args[0].equalsIgnoreCase("-JSONValidateIndex"))
        {
            JSONValidateIndex validate = new JSONValidateIndex();
            validate.readURL("https://thunderbird-index.azurewebsites.net/w0a6zk195d.json");
            validate.parseIndex();

            System.out.println("Time Elapsed: " + (System.currentTimeMillis()-start) + "ms\n");
        }

        System.out.println("");
    }
}