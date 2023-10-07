package org.example.seleniumTest.pages;

import org.example.seleniumTest.utilities.FunctionsAbstracts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends FunctionsAbstracts {
//    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
//        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement bthLogin;

    @FindBy(linkText = "Register here")
    WebElement btnRegister;

    @FindBy(css = ".toast-error")
    WebElement msgError;

    public void toGo(){
        toGo("https://rahulshettyacademy.com/client/");
    }

    public RegisterPage goToRegister(){
        clickElement(btnRegister);
        return new RegisterPage(driver);
    }

    public HomePage login(String txtUserEmail, String txtUserPassword){
        sendKey(userEmail,txtUserEmail);
        sendKey(userPassword,txtUserPassword);
        clickElement(bthLogin);
        return new HomePage(driver);
    }

    public boolean validateMsgError(String txtError){
        return visibilityElement(msgError).getText().equals(txtError);
    }

}
