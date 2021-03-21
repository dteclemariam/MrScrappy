import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@DisplayName("Resources should:")
class ResourcesTest {

    Resources resources = new Resources();

    @DisplayName("FileNotEmpty returns true if file exists and is not empty")
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
            String wrongPath = "src/maaaaaaiiiiin/resources/Data/webpagessssss.txt";
            Throwable errorFileDoesntExist = assertThrows(RuntimeException.class,
                    () -> resources.fileNotEmpty(wrongPath));

            File tempEmptyFile = File.createTempFile("tempEmptyFile", "txt");
            String pathToEmptyFile = Paths.get(tempEmptyFile.getPath()).toString();
            Throwable errorFileIsEmpty = assertThrows(RuntimeException.class,
                    () -> resources.fileNotEmpty(pathToEmptyFile));

            assertAll(
                    () -> assertEquals("Error: File at " + wrongPath
                            + " is empty, or doesn't exist", errorFileDoesntExist.getMessage()),
                    () -> assertEquals("Error: File at " + pathToEmptyFile
                            + " is empty, or doesn't exist", errorFileIsEmpty.getMessage())
            );

            try {
                Files.deleteIfExists(Paths.get(tempEmptyFile.getPath()));
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
        driver.quit();
    }

    @DisplayName("Quit Webdriver")
    @Test
    void quitWebdriver(){
        WebDriver driver = resources.getWebDriver();
        driver.get("https://www.google.com/");
        resources.quitWebdriver(driver);
        assertEquals(null, ((RemoteWebDriver)driver).getSessionId());
    }


}