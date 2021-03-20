import org.openqa.selenium.WebDriver;


import java.util.concurrent.TimeUnit;

public class Controller {

    /*** class variables ***/
            /*** objects ***/
    private UserInterface ui = new UserInterface();
    private AppVariable appVariable = new AppVariable();
    private Resources resources = new Resources();
    private WebDriver driver = null;
    private LogIn logIn = new LogIn();

    /*** class methods ***/
    protected void start(){
        ui.initializing();
        driver = resources.getWebDriver();
        appVariable.randomWaitTime();
        driver.get(resources.getWebpage());
        //logIn.logIn(driver);
        //driver.get("https://classic.nordnet.no/mux/login/startNO.html?clearEndpoint=0&intent=shareville");
        appVariable.randomWaitTime();
        stopApp();
      }

      protected void stopApp(){
          //resources.closeWebdriver(driver);
          exit();
      }

      //Make a method that checks if the page is up

    //Method for exiting the program
    protected void exit() {
        System.out.print("The application is closing");
        //10 sec delay on close
        int seconds = 10;
        try {
            for (int i = 0; i < seconds; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
            }
        }catch (InterruptedException ie){
            Thread.currentThread().interrupt();
        }
        System.exit(0);
    }
}
