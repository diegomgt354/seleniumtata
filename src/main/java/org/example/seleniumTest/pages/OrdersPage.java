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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrdersPage extends FunctionsAbstracts {

    WebDriver driver;

    public OrdersPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "table tbody")
    WebElement idTable;

    By tr = By.cssSelector("tr");
    By th = By.cssSelector("th");

    public boolean validateProducts(List<String> txtIds){
        List<String> txtIdsTable = visibilityElement(idTable).findElements(tr).stream().map(element -> element.findElement(th).getText()).toList();
        Set<String> setTxtIds = new HashSet<>(txtIds);
        Set<String> setTxtIdsTable = new HashSet<>(txtIdsTable);
        return setTxtIdsTable.containsAll(setTxtIds);
    }

}
