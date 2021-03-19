import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Resources {

/***---------------- class variables ---------------***/
    /*** Paths ***/
    private final Path webpageFilePath = Paths.get("C:\\Resources\\Data\\webpages.txt");
    private final Path webdriverFilePath = Paths.get("C:\\Resources\\Drivers\\chromedriver.exe");

    /*** Getters ***/
    protected Path getWebpageFilePath() {
        return webpageFilePath;
    }

    protected Path getWebdriverFilePath() {
        return webdriverFilePath;
    }

    /***-------------- Class methods -----------------***/

    //Returns false if file doesn't exist or is empty
    public boolean fileNotEmpty(Path path){
        File file = new File(path.toString());
        if (file.length() != 0){
            return true;
        }  {
            throw new RuntimeException("Error: File at " + path.toString() + " is empty, or doesn't exist");
        }
    }

    //creates a String with the url to the webpage
    protected String getWebpage(){
        fileNotEmpty(webpageFilePath);
        String webpage = null;
        BufferedReader reader = null;

        try{
            reader = new BufferedReader(new FileReader(webpageFilePath.toString()));
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
        System.setProperty("webdriver.chrome.driver", webdriverFilePath.toString());
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            System.out.println("creates driver");
        }catch (Exception e){
            System.out.println("Execution failed: Cannot run program at " + System.getProperty("webdriver.chrome.driver")
                    + ": is not a valid chromedriver application" );
            e.printStackTrace();
        }
        System.out.println("Returns driver");
        return driver;
    }    //Creates and returns instance of Webdriver

    public void openWebdriver() {
        fileNotEmpty(webdriverFilePath);
        System.setProperty("webdriver.chrome.driver", webdriverFilePath.toString());
        WebDriver driver = null;
        try {
            //System.setProperty("webdriver.chrome.driver", webdriverFilePath.toString());
            driver = new ChromeDriver();
            System.out.println("creates driver");
            driver.get("https://www.vg.no/");
            System.out.println("vg");
        }catch (Exception e){
            System.out.println("Execution failed: Cannot run program at " + System.getProperty("webdriver.chrome.driver")
                    + ": is not a valid chromedriver application" );
            e.printStackTrace();
        }
    }
}

