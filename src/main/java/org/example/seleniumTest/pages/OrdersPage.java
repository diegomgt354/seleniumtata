package org.example.seleniumTest.pages;

import org.example.seleniumTest.utilities.FunctionsAbstracts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class OrdersPage extends FunctionsAbstracts {

    WebDriver driver;

    public OrdersPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "table tbody")
    WebElement idTable;

    @FindBy(css = "tr td:nth-child(3)")
    List<WebElement> nameProducts;

    @FindBy(css = "tr th[scope='row']")
    List<WebElement> idProducts;


    By tr = By.cssSelector("tr");
    By th = By.cssSelector("th");


    public boolean validateProductsById(List<String> txtIds){
        List<String> txtIdsTable = visibilityElements(idProducts).stream().map(WebElement::getText).collect(Collectors.toList());
        return new HashSet<>(txtIdsTable).containsAll(txtIds);
    }

    public boolean validateProductsByName(List<String> txtNames){
        List<String> txtNamesTable = visibilityElements(nameProducts).stream().map(name->name.getText().toUpperCase()).collect(Collectors.toList());
        return new HashSet<>(txtNamesTable).containsAll(txtNames);
//        return nameProducts.stream().anyMatch(pro->pro.getText().equalsIgnoreCase("niidea"));
    }

}
