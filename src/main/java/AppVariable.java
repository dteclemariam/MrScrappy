import org.openqa.selenium.WebDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AppVariable {

    /*** --------------- Class variables------ ***/

        /*** Variable for the random wait time ***/
    private final int minimumMilliseconds = 3000;
    private final int maximumMilliseconds = 25000;
    private Random random = new Random();

    /*** Getters ***/
    public int getMinimumMilliseconds() {
        return minimumMilliseconds;
    }

    public int getMaximumMilliseconds() {
        return maximumMilliseconds;
    }

    /*** Methods ***/

    //Runs a random wait time between minimumMilliseconds and maximumMilliseconds
    protected void randomWaitTime(){
        try {
            TimeUnit.MILLISECONDS.sleep((random.nextInt(maximumMilliseconds
                    - minimumMilliseconds) + 1) + minimumMilliseconds);
        }catch (InterruptedException ie){
            Thread.currentThread().interrupt();
        }
    }

}
