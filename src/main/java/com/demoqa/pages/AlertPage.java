package com.demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {
    @FindBy(id = "confirmButton")
    public WebElement confirmAlertBtn;


}
