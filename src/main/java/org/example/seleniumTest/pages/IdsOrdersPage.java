package org.example.seleniumTest.pages;

import org.example.seleniumTest.utilities.FunctionsAbstracts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class IdsOrdersPage extends FunctionsAbstracts {
//    WebDriver driver;

    public IdsOrdersPage(WebDriver driver){
        super(driver);
//        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'ORDERS')]")
    WebElement btnOrders;

    @FindBy(xpath = "//td/label[@class='ng-star-inserted']")
    List<WebElement> idProduct;


    public List<String> txtOrdersIds(){
        return visibilityElements(idProduct).stream().map(id->id.getText().replace("|","").trim()).toList();
    }

    public OrdersPage goToOrders(){
        clickElement(btnOrders);
        return new OrdersPage(driver);
    }

}
