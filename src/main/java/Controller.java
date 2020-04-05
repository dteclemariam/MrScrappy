import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Controller {
    //creates instance of other classes
    AppVariables appVariables = new AppVariables();
    Resources data = new Resources();


    //creates instance of Random
    Random random = new Random();

    //Return a random number between minimumMilliseconds and maximumilliseconds
    protected int randomNumber(){
        return random.nextInt((appVariables.maximumMilliseconds - appVariables.minimumMilliseconds) + 1)
                + appVariables.minimumMilliseconds;

    }

    //Runs a random wait time
    protected void randomWaitTime(){
        try {
            TimeUnit.MILLISECONDS.sleep(randomNumber());
        }catch (InterruptedException ie){
            Thread.currentThread().interrupt();
        }
    }
}
