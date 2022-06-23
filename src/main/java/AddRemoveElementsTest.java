import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void addRemoveElement() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath(("//button[text()='Delete']"))).click();
        List<WebElement> elementList = driver.findElements(By.xpath(("//button[text()='Delete']")));
        assertEquals(elementList.size(), 1, "Количество элементов не равно 1");
    }
}