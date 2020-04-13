# SwissArmyKnife_V2
//@Author: Mohammad Alabed
//Credit to Eric Pogue
//Credit to Henry, worked with him to get the validation to work.

This application takes a Json files provided and parses them down to the information inside. Along with that there are multiple functions you can call such as
sak -HttpRequest
Works just as it did in SwissArmyKnife.
sak -HttpRequestIndex
Works just as it did in SwissArmyKnife.
sak -Sleep
Allows sak to sleep and wake for a certain duration.
sak -SleepFast
Allows sak to sleep and wake for a certain duration as well the same duration in a thread.
sak -SleepFastImplementsRunnable
Works just like -SleepFast but uses runnable for threading.
sak -JSONValidateIndex
Takes a Json file and parses the content and retrieves additional urls and parses those. It then tells you weather or not certain indexes are found to be valid or invalid. Note, this doesn't work at 100%, some indexes will sometimes say valid when they are not found and should be invalid.
sak -JSONValidateIndexThread
Was not able to create this function.
