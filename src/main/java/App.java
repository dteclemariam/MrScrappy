import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class App {

    String y = "Test";

    public static void main(String[] args) {

        //Specifies type of driver and location
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Daniel\\Dropbox\\Code\\Resources\\Drivers\\chromedriver.exe");

        //Creates an instance of a chrome webdrivver
        WebDriver driver = new ChromeDriver();

        //Applied wait time
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //maximize window
        driver.manage().window().maximize();

        //open browser with desired URL
        driver.get("https://www.google.com");

        driver.get("https://.no");

        //closing the browser
        driver.close();
    }
}
