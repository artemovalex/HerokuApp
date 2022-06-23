import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputsTest extends BaseTest {
    @Test
    public void checkCheckBoxes() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        String value = driver.findElement((By.tagName("input"))).getAttribute("value");
        Assert.assertEquals(value, "1");

        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        value = driver.findElement((By.tagName("input"))).getAttribute("value");
        Assert.assertEquals(value, "-1");

        driver.findElement(By.tagName("input")).clear();
        driver.findElement(By.tagName("input")).sendKeys("aaa");
        String string = driver.findElement((By.tagName("input"))).getAttribute("value");
        Assert.assertEquals(string, "");
    }
}