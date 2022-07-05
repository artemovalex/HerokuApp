import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTest extends BaseTest {

    @Test
    public void checkAlerts() {
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("alertButton")).click();
        Alert firstAlert = driver.switchTo().alert();
        String firstAlertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(firstAlertMessage, "You clicked a button", "firstAlert is not opened");
        firstAlert.accept();


        driver.findElement(By.id("timerAlertButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert secondAlert = driver.switchTo().alert();
        String secondAlertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(secondAlertMessage, "This alert appeared after 5 seconds", "secondAlert is not opened");
        secondAlert.accept();


        driver.findElement(By.id("confirmButton")).click();
        Alert thirdAlert = driver.switchTo().alert();
        String thirdAlertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(thirdAlertMessage, "Do you confirm action?", "thirdAlert is not opened");
        thirdAlert.dismiss();
        Assert.assertEquals(driver.findElement(By.id("confirmResult")).getText(), "You selected Cancel", "The message is invalid");


        driver.findElement(By.id("promtButton")).click();
        Alert fourthAlert = driver.switchTo().alert();
        String fourthAlertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(fourthAlertMessage, "Please enter your name", "thirdAlert is not opened");
        fourthAlert.sendKeys("Alexander");
        fourthAlert.accept();
        Assert.assertEquals(driver.findElement(By.id("promptResult")).getText(), "You entered Alexander", "The message is invalid");
    }
}