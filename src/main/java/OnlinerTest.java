import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class OnlinerTest extends BaseTest {
    @Test
    public void checkOnliner() {
        driver.get("https://www.onliner.by/");

        driver.findElement(By.xpath("//input[@class=\"fast-search__input\"]")).sendKeys("Тостер");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"modal-iframe\"]")));
        By xpath = By.xpath("//a[@class=\"product__title-link\"]");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(xpath));
        String productName = driver.findElement(xpath).getText();
        driver.findElement(By.xpath("//input[@class=\"search__input\"]")).clear();
        driver.findElement(By.xpath("//input[@class=\"search__input\"]")).sendKeys(productName);
        driver.findElement(By.xpath("//span[@class=\"search__close\"]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class=\"text_match\"]")).getText(), productName, "Product name is invalid");
    }
}