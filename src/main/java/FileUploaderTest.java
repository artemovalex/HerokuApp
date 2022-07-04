import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FileUploaderTest extends BaseTest {

    @Test
    public void checkFileUploader() {
        driver.get("http://the-internet.herokuapp.com/upload");

        String filePath = System.getProperty("user.dir") + "/src/main/resources/testFile.txt";
        driver.findElement(By.id("file-upload")).sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "testFile.txt", "file is not loaded");
    }
}