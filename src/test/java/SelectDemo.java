import com.demoqa.helper.DropdownHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SelectDemo extends BaseTest{
    @Test
    void test123() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        WebElement selectMenu = driver.findElement(By.id("oldSelectMenu"));
        DropdownHelper dropdownHelper = new DropdownHelper(driver);
        dropdownHelper.selectByVisibleText(selectMenu,"Green");
        Thread.sleep(4000);
    }

}
