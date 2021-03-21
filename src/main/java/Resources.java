import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Resources {

/***---------------- class variables ---------------***/
    /*** Paths ***/
    private final String webpageFilePath = "src/main/resources/Data/webpages.txt";
    private final String webdriverFilePath = "src/main/resources/Drivers/chromedriver.exe";

    /*** Getters ***/
    protected String getWebpageFilePath() {
        return webpageFilePath;
    }

    protected String getWebdriverFilePath() {
        return webdriverFilePath;
    }

    /***-------------- Class methods -----------------***/

    //Returns false if file doesn't exist or is empty
    public boolean fileNotEmpty(String path){
        File file = new File(path);
        if (file.length() != 0){
            return true;
        }  {
            throw new RuntimeException("Error: File at " + path + " is empty, or doesn't exist");
        }
    }

    //creates a String with the url to the webpage
    protected String getWebpage(){
        fileNotEmpty(webpageFilePath);
        String webpage = null;
        BufferedReader reader = null;

        try{
            reader = new BufferedReader(new FileReader(webpageFilePath));
            webpage = reader.readLine();
        }catch (IOException e){
            System.out.println("An error occurred while trying to read the file");
        }
        finally {
            try {
                assert reader != null;
                reader.close();
            }catch (IOException e){
                System.out.println("Error: Could not close the file");
            }
        } return webpage;
    }


    //Creates and returns instance of Webdriver
    public WebDriver getWebDriver() {
        fileNotEmpty(webdriverFilePath);
        System.setProperty("webdriver.chrome.driver", webdriverFilePath);
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
        }catch (Exception e){
            System.out.println("Execution failed: Cannot run program at " + System.getProperty("webdriver.chrome.driver")
                    + ": is not a valid chromedriver application" );
            e.printStackTrace();
        }
        return driver;
    }    //Creates and returns instance of Webdriver


    //Quit Webddriver
    public void quitWebdriver(WebDriver driver) {
        driver.quit();
    }
}

