import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Resources {

    //private ArrayList webpages = new ArrayList();
    private Path webpagesFilePath = Paths.get("C:\\Resources\\Data\\webpages.txt");
    private Path webdriverFilePath = Paths.get("C:\\Resources\\Drivers\\chromedriver.exe");

    //Getters
    public Path getWebpagesFilePath() {
        return webpagesFilePath;
    }

    public Path getWebdriverFilePath(){
        return webdriverFilePath;
    }

    //Returns false if file doesn't exist or is empty
    public boolean fileNotEmpty(Path path){
        boolean fileNotEmpty = false;
        File file = new File(path.toString());
        if (file.length() != 0){
            fileNotEmpty = true;
        } return fileNotEmpty;
    }


    //Creates and returns an Array with web page
    public ArrayList getWebpages() {
        ArrayList webpages = new ArrayList();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(String.valueOf(webpagesFilePath)));
            String inputLine = null;

            while ((inputLine = reader.readLine()) != null) {
                inputLine = reader.readLine().replaceAll("\\s", "");
                String[] links = inputLine.split(",");

                for (String currentLink : links) {
                    webpages.add(currentLink);
                    System.out.println(currentLink);
                }
            }
        } catch (IOException e) {
            System.out.println("The file was not found at path: " + webpagesFilePath);
        }finally {
            try{
                reader.close();
            }catch (IOException e){
                System.out.println("The file couldn't be closed");
            }
        }return webpages;
    }


}

