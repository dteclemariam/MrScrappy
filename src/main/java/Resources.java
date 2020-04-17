import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class Resources {

    //Returns false if file doesn't exist or is empty
    public boolean fileNotEmpty(Path path){
        boolean fileNotEmpty = false;

        File file = new File(path.toString());
        if (file.length() != 0){
            fileNotEmpty = true;
        } else {
            throw new RuntimeException("Error: File at " + path.toString() + " is empty, or doesn't exist");
        }
        return fileNotEmpty;
    }

    //Creates and returns an Array with web page
    public ArrayList getWebpages(Path webpagesFilePath) {
        fileNotEmpty(webpagesFilePath);
        ArrayList <String> webpages = new ArrayList<String>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(webpagesFilePath.toString()));
            String inputLine = null;

            while ((inputLine = reader.readLine()) != null) {
                inputLine = inputLine.replaceAll("\\s", "");
                String[] links = inputLine.split(",");

                for (String currentLink : links) {
                    webpages.add(currentLink);
                }
            }
        } catch (IOException e) {
            System.out.println("The file was not found at path: " + webpagesFilePath);
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                System.out.println("The file couldn't be closed");
            }
            return webpages;
        }
    }


    public WebDriver getWebDriver(Path webdriverFilePath) {
        fileNotEmpty(webdriverFilePath);
        System.setProperty("webdriver.chrome.driver", webdriverFilePath.toString());
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
        }catch (Exception e){
            System.out.println("Execution failed: Cannot run program at " + System.getProperty("webdriver.chrome.driver")
                    + ": is not a valid chromedriver application" );
            e.printStackTrace();
        }
        return driver;
    }
}

