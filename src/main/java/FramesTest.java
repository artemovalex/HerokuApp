import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FramesTest extends BaseTest {

    @Test
    public void checkFrame() {
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//a[text()=\"iFrame\"]")).click();
        driver.switchTo().frame("mce_0_ifr");
        Assert.assertEquals(driver.findElement(By.cssSelector("p")).getText(), "Your content goes here.", "No text in frame");
    }
}