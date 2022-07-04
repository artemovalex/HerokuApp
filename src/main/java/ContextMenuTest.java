import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

public class ContextMenuTest extends BaseTest {

    @Test
    public void checkContextMenu() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "You selected a context menu", "Context menu is not opened");
        alert.accept();
    }
}