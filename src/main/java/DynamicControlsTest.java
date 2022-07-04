import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void checkDynamicControlsCheckbox() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        Assert.assertTrue(checkBox.isSelected(), "Checkbox is not selected");
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        List<WebElement> list = driver.findElements(By.xpath("//input[@type='checkbox']"));
        Assert.assertEquals(list.size(), 0, "Checkbox is not deleted");
    }

    @Test
    public void checkDynamicControlsInput() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(Boolean.parseBoolean(input.getAttribute("disabled")), "Input is enabled");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's enabled!\"]")));
        Assert.assertFalse(Boolean.parseBoolean(input.getAttribute("disabled")), "Input is disabled");
    }
}