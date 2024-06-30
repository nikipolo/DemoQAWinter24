import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitDemo {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://example.com");

            FluentWait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(3))
                    .ignoring(NoSuchElementException.class);

            WebElement element = wait.until(new Function<WebDriver, WebElement>() {
                   public WebElement apply(WebDriver driver){
                       return driver.findElement(By.id("someID"));
            }
            });

            element.click();
        }finally {
            driver.quit();
        }
    }
}
