import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Resources should:")
class ResourcesTest {

    Resources resources = new Resources();

    @DisplayName("Have paths that are not empty")
    @Test
    void pathsNotEmpty(){
        assertAll(
                () -> assertFalse(resources.getWebpagesFilePath().toString().isEmpty()),
                () -> assertFalse(resources.getWebdriverFilePath().toString().isEmpty())
        );
    }

    @DisplayName("Files exist and is not empty")
    @Test
    void filesNotEmpty(){
        assertAll(
                () ->assertTrue(resources.fileNotEmpty(resources.getWebpagesFilePath())),
                () ->assertTrue(resources.fileNotEmpty(resources.getWebdriverFilePath()))
        );
    }

    @DisplayName("Throws error if files doesn't exist")
    @Test
    void throwsExceptionIfFilesNotFound(){
        resources.getWebpages();

    }


    @DisplayName("Files exist")
    @Test
    void checkFilesExist() {

        //File webpages = new File("C:\\Resources\\Data\\webpages.txt");
        File webpages = new File(resources.getWebpagesFilePath().toString());
        File webdriver = new File(resources.getWebpagesFilePath().toString());
        assertAll(
                () -> assertTrue(webpages.exists()),
                () -> assertTrue(webdriver.exists())
        );
    }


    @DisplayName("File doesn't exist")
    @Test
    void catchExceptionIfFileNotFound() {

    }

}