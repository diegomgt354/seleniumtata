package org.example.seleniumTest.pages;

import org.example.seleniumTest.utilities.FunctionsAbstracts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends FunctionsAbstracts {
    WebDriver driver;

    public LoginPage(WebDriver driver){
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

    @FindBy(linkText = "Register here")
    WebElement btnRegister;

    public void toGo(){
        toGo("https://rahulshettyacademy.com/client/");
    }

    public RegisterPage goToRegister(){
        clickElement(btnRegister);
        return new RegisterPage(driver);
    }

    public DashboardPage login(String txtUserEmail, String txtUserPassword){
        sendKey(userEmail,txtUserEmail);
        sendKey(userPassword,txtUserPassword);
        clickElement(bthLogin);
        return new DashboardPage(driver);
    }

}
