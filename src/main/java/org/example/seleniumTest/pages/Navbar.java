package org.example.seleniumTest.pages;

import org.example.seleniumTest.utilities.FunctionsAbstracts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navbar extends FunctionsAbstracts {
//    WebDriver driver;

    public Navbar(WebDriver driver){
        super(driver);
//        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'HOME')]")
    WebElement btnHome;

    @FindBy(xpath = "//button[contains(text(),'ORDERS')]")
    WebElement btnOrders;

    @FindBy(xpath = "//button[contains(text(),'Cart')]")
    WebElement btnCart;

    @FindBy(xpath = "//button[contains(text(),'Sign Out')]")
    WebElement btnSignOut;

    public HomePage goToHomePage(){
        clickElement(btnHome);
        return new HomePage(driver);
    }

    public OrdersPage goToOrdersPage(){
        clickElement(btnOrders);
        return new OrdersPage(driver);
    }

    public MyCartPage goToCartPage(){
        clickElement(btnCart);
        return new MyCartPage(driver);
    }

    public LoginPage goSignOut(){
        clickElement(btnSignOut);
        return new LoginPage(driver);
    }

}
