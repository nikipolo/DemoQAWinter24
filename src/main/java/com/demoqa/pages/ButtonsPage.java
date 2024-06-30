package com.demoqa.pages;

import org.bouncycastle.asn1.esf.SPuri;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ButtonsPage extends BasePage {
    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickBtn;
    @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickMessage;
    @FindBy(id = "rightClickBtn")
    public WebElement rightClickBtn;
    @FindBy(id = "rightClickMessage")
    public WebElement rightClickMessage;

}
