import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class DropDownTest extends BaseTest {
    @Test
    public void checkDropDown() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));

        assertEquals(dropdown.getOptions().get(0).getText(), "Please select an option");
        assertEquals(dropdown.getOptions().get(1).getText(), "Option 1");
        assertEquals(dropdown.getOptions().get(2).getText(), "Option 2");

        dropdown.selectByVisibleText("Option 1");
        String opt = driver.findElement(By.id("dropdown")).getAttribute("value");
        Assert.assertEquals(opt, "1");
        dropdown.selectByVisibleText("Option 2");
        opt = driver.findElement(By.id("dropdown")).getAttribute("value");
        Assert.assertEquals(opt, "2");
    }
}