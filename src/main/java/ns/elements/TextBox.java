package ns.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBox {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
    }

    @AfterMethod
    public void metClose() {
        driver.close();
        driver.quit();
    }


    @Test(groups = {"Smoke","3576"},description = "Text Box")
    void testBoxTest1() throws InterruptedException {
        WebElement fullname = driver.findElement(By.id("userName"));
        fullname.sendKeys("Aijan");
    }


    @Test
    public void testBoxTest2() {
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("akydybaeva@gmail.com");
    }

    @Test
    public void testBoxTest3() {
        WebElement currentaddress = driver.findElement(By.id("currentAddress"));
        currentaddress.sendKeys("KG, Tokmok 25");
    }

    @Test
    public void testBoxTest4() {
        WebElement permanentaddress = driver.findElement(By.id("permanentAddress"));
        permanentaddress.sendKeys("KG, Bishkek 54");
    }

    @Test
    public void testBoxTest5() {
        WebElement fullname = driver.findElement(By.id("userName"));
        fullname.sendKeys("Aijan");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("akydybaeba@gmail.com");

        WebElement currentaddress = driver.findElement(By.id("currentAddress"));
        currentaddress.sendKeys("KG, Tokmok 25");

        WebElement permanentaddress = driver.findElement(By.id("permanentAddress"));
        permanentaddress.sendKeys("KG, Bishkek 54");
    }

}
