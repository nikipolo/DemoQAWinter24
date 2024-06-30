package com.demoqa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.demoqa.utils.ConfigReader.getValue;

public class ChromeWebDriver {
    //    public static WebDriver loadChromeDriver(){
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        return driver;
//    }
    public  static WebDriver loadChromeDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote=allow-Origins=*");//передаем какие то настройки когда будем запускать через удалленой сервис ->
        options.addArguments("--disable-extensions");// -> и даем разрешения
        options.addArguments("--window-size-1920,1080");
        options.addArguments("--no-sandbox"); //относится ccd
        if (Boolean.parseBoolean(getValue("headless"))){ // обычный стринг запарсили в буллиан если TRUE (add.properties указываем) а если укажем в if(headless) браузер не будет открываться но тест начинает бегать
            options.addArguments("--headless");
        }
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return  driver;

    }
}
