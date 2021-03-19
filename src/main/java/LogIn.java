import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn {


    protected void logIn(WebDriver driver){
        boolean loggedIn;
        //driver.get();
        WebElement buttonLogIn = driver.findElement(By.xpath("/html/body/div[1]/section/section[2]/section/section/section/div[2]/div/button"));
        buttonLogIn.click();
    }

}
