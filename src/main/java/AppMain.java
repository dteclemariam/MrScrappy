import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class MrScrapperMain {
    public static void main(String[] args) {
        Controller controller = new Controller();
        AppData data = new AppData();
        data.printWebpages();

        //Setting driver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Resources\\Drivers\\chromedriver.exe");

        //Creates an instance of a chrome webdrivver
        WebDriver driver = new ChromeDriver();

        //Applied wait time
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //maximize window
        driver.manage().window().maximize();

        //open browser with desired URL
        driver.get("https://www.google.com");

        controller.randomWaitTime();

        driver.get("https://www.vg.no");

        controller.randomWaitTime();

        //closing the browser
        driver.close();
    }
}
