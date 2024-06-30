package com.demoqa.pages;

import com.demoqa.entities.PracticeFormEntity;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PracticeFormPage extends BasePage{
    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy (id = "lastName")
    public  WebElement lastNameInput;

    @FindBy (id = "userEmail")
    public WebElement emailInput;

    @FindBy (xpath = "(//div[@class = 'custom-control custom-radio custom-control-inline'])[1]")
    public WebElement radio1;

    @FindBy (xpath = "(//div[@class = 'custom-control custom-radio custom-control-inline'])[2]")
    public WebElement radio2;

    @FindBy (xpath = "(//div[@class = 'custom-control custom-radio custom-control-inline'])[3]")
    public WebElement radio3;

    @FindBy (id = "userNumber")
    public  WebElement mobileNumberInput;

    @FindBy (id = "dateOfBirthInput")
    public  WebElement dateOfBirthInput;

    @FindBy (id = "//*[@class=\"react-datepicker__month-select\"]")
    public WebElement monthOfBirthInput;

    @FindBy (id = "//*[@class=\"react-datepicker__year-select\"]")
    public WebElement yearOfBirthInput;

    @FindBy (id = "subjectsInput")
    public WebElement subjectsContainerInput;

    @FindBy(xpath = "//label[normalize-space(text())='Reading']")
    public WebElement checkbox1;

    @FindBy (how = How.XPATH, using = "//*[@id='hobbies-checkbox-2' or @for='hobbies-checkbox-2']")
    public WebElement checkbox2;

    @FindBy (how = How.XPATH, using = "//*[@id='hobbies-checkbox-3' or @for='hobbies-checkbox-3']")
    public WebElement checkbox3;

    @FindBy (id = "uploadPicture")
    public  WebElement uploadPicture;

    @FindBy (id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy (id = "react-select-3-input")
    public WebElement stateInput;

    @FindBy (id = "react-select-4-input")
    public  WebElement cityInput;

    @FindBy (id = "submit")
    public WebElement submitBtn;

    public PracticeFormPage fillUpPracticeForm(PracticeFormEntity practiceFormEntity){
        webElementActions.sendKeys(firstNameInput, practiceFormEntity.getFirstNameInput())
                .sendKeys(lastNameInput, practiceFormEntity.getLastNameInput())
                .sendKeys(emailInput,practiceFormEntity.getEmailInput())
                .click(radio1)
                .sendKeys(mobileNumberInput, practiceFormEntity.getMobileNumberInput())
                .sendKeysWithEnter(subjectsContainerInput, practiceFormEntity.getSubjectsContainerInput())
                .click(checkbox1)
                .sendKeys(uploadPicture, practiceFormEntity.getPicturePath())
                .sendKeys(currentAddressInput, practiceFormEntity.getCurrentAddressInput())
                .sendKeysWithEnter(stateInput, practiceFormEntity.getStateInput())
                .sendKeysWithEnter(cityInput, practiceFormEntity.getCityInput())
                .click(submitBtn);
        return this;
    }
}
