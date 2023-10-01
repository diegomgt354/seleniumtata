package org.example.seleniumTest.pages;

import org.example.seleniumTest.utilities.FunctionsAbstracts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends FunctionsAbstracts {
    WebDriver driver;

    public RegisterPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement bthLogin;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userMobile")
    WebElement userMobile;

    @FindBy(css = "select.custom-select")
    WebElement selectOccupation;

    @FindBy(xpath = "//input[@type='radio'][@value='Male']")
    WebElement radioMale;

    @FindBy(id = "confirmPassword")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement aboveYear;

    @FindBy(xpath = "//section[2]/div/div[2]/button")
    WebElement returnLogin;

    public void register(String txtUserEmail, String txtUserPassword){
        sendKey(firstName,"diego");
        sendKey(lastName,"gutierrez");
        sendKey(userEmail,txtUserEmail);
        sendKey(userMobile,"9876543210");
        selectText(selectOccupation,"Student");
        clickElement(radioMale);
        sendKey(userPassword,txtUserPassword);
        sendKey(confirmPassword,txtUserPassword);
        clickElement(aboveYear);
        clickElement(bthLogin);
    }


    public void goToLogin(){
//        return login
        clickElement(returnLogin);
    }
}
