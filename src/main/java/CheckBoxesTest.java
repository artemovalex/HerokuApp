import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxesTest extends BaseTest {
    @Test
    public void checkCheckBoxes() {
        // проверка первого чекбокса
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckBox = driver.findElement(By.cssSelector("[type=checkbox]"));
        Assert.assertFalse(firstCheckBox.isSelected(), "First checkbox is checked");
        driver.findElement(By.cssSelector("[type=checkbox]")).click();
        firstCheckBox = driver.findElement(By.cssSelector("[type=checkbox]"));
        Assert.assertTrue(firstCheckBox.isSelected(), "First checkbox is unchecked");

        // проверка второго чекбокса
        WebElement secondCheckBox = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        Assert.assertTrue(secondCheckBox.isSelected(), "Second checkbox is unchecked");
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
        secondCheckBox = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        Assert.assertFalse(secondCheckBox.isSelected(), "Second checkbox is checked");
    }

}
