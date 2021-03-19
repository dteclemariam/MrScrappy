import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@DisplayName("Resources should:")
class ResourcesTest {

    Resources resources = new Resources();

    @DisplayName("Webdriver and webpages.txt exist and is not empty")
    @Test
    void filesExist() {
                assertAll(
                () -> assertTrue(resources.fileNotEmpty(resources.getWebpageFilePath())),
                () -> assertTrue(resources.fileNotEmpty(resources.getWebdriverFilePath()))
        );
    }

    @DisplayName("Throws error if files doesn't exist or is empty")
    @Test
    void throwsExceptionIfFilesNotFoundOrIsEmpty() {
        try {
            Path wrongPath = Paths.get("C:\\Resources\\Data\\wwwebpages.txt");
            Throwable errorFileDoesntExist = assertThrows(RuntimeException.class,
                    () -> resources.fileNotEmpty(wrongPath));

            File tempEmptyFile = File.createTempFile("tempEmptyFile", "txt");
            Path pathToEmptyFile = Paths.get(tempEmptyFile.getPath());
            Throwable errorFileIsEmpty = assertThrows(RuntimeException.class,
                    () -> resources.fileNotEmpty(pathToEmptyFile));

            assertAll(
                    () -> assertEquals("Error: File at " + wrongPath.toString()
                            + " is empty, or doesn't exist", errorFileDoesntExist.getMessage()),
                    () -> assertEquals("Error: File at " + pathToEmptyFile.toString()
                            + " is empty, or doesn't exist", errorFileIsEmpty.getMessage())
            );

            try {
                tempEmptyFile.delete();
            } catch (SecurityException e) {
                System.out.println(e.getMessage());
            }
            assertFalse(tempEmptyFile.exists());

        } catch (IOException e) {
            e.printStackTrace();
            fail("Something went wrong, couldn't delete tempEmptyFile");
        }
    }


    @DisplayName("Returns String with URL")
    @Test
    void returnStringWithUrl() {
        String url = resources.getWebpage();
        assertNotNull(url);
    }

    @DisplayName("Returns a webdriver to calling method")
    @Test
    void returnsWebDriverInstance() {
        WebDriver driver = resources.getWebDriver();
        assertNotNull(driver);
        driver.close();
    }


}