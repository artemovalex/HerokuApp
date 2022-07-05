import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScripTest extends BaseTest {
    @Test
    public void checkScrollOnliner() {
        driver.get("https://www.onliner.by/");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,100)");

        WebElement element = driver.findElement(By.xpath("//div[@class=\"b-main-page-grid-4 b-main-page-news-2\"]"));
        jse.executeScript("arguments[0].scrollIntoView();", element);

        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
    }
}