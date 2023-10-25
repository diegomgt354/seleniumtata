package org.example.seleniumTest.pages;

import org.example.seleniumTest.utilities.FunctionsAbstracts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class PaymentPage extends FunctionsAbstracts {
    WebDriver driver;

    public PaymentPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[contains(text(),'Card Number')]/../input")
    WebElement crediCard;

    @FindBy(xpath = "//div[contains(text(),'Expiry Date')]/../select[1]")
    WebElement expirateMonth;

    @FindBy(xpath = "//div[contains(text(),'Expiry Date')]/../select[2]")
    WebElement expirateDay;

    @FindBy(xpath = "//div[contains(text(),'CVV Code')]/../input")
    WebElement CVVCode;

    @FindBy(xpath = "//div[contains(text(),'Name on Card')]/../input")
    WebElement NameCard;

    @FindBy(xpath = "//div[contains(text(),'Apply Coupon')]/../input")
    WebElement ApplyCoupon;

    @FindBy(xpath = "//button[text()='Apply Coupon']")
    WebElement btnApplyCoupon;

    @FindBy(xpath = "//p[text()='* Coupon Applied']")
    WebElement MsgCouponApplied;

    @FindBy(xpath = "//label/../input[contains(@class,'input')]")
    WebElement direction;

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement country;

    @FindBy(css = "button.ta-item span")
    List<WebElement> countrysSelect;

    @FindBy(xpath = "//a[contains(text(),'Place Order')]")
    WebElement btnPlaceOlder;

    @FindBy(css = ".ng-trigger")
    WebElement imgCarga;


    public void informationPlaceOlder(String selectionCountryTxt){

//        informacion de pago
        sendKey(crediCard, "1234 5678 9012 3456");
        selectText(expirateMonth,"07");
        selectText(expirateDay,"19");
        sendKey(CVVCode, "123");
        sendKey(NameCard, "Diego Manuel");
        sendKey(ApplyCoupon, "rahulshettyacademy");
        clickElement(btnApplyCoupon);
        if(invisibilityElement(imgCarga)) System.out.println(visibilityElement(MsgCouponApplied).getText());
        sendKey(direction, "Mi casa al costado del poste");

        sendKey(country, selectionCountryTxt);

        visibilityElements(countrysSelect);
        for(WebElement countryList : countrysSelect){
            if (countryList.getText().trim().equals(selectionCountryTxt)){
                countryList.click();
            }
        }

    }

    public IdsOrdersPage toGoPlaceOrders(){
        clickElement(btnPlaceOlder);
        return new IdsOrdersPage(driver);
    }

}
