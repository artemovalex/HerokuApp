import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TyposTest extends BaseTest {
    @Test
    public void checkTypos() {
        driver.get("http://the-internet.herokuapp.com/typos");
        String typos = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(typos, "This example demonstrates a typo being introduced. It does it randomly on each page load.");
        typos = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]")).getText();
        Assert.assertEquals(typos, "Sometimes you'll see a typo, other times you won't.");
    }
}