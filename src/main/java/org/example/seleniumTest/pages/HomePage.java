package org.example.seleniumTest.pages;

import org.example.seleniumTest.utilities.FunctionsAbstracts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends FunctionsAbstracts {
//    WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
//        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'Cart')]")
    WebElement btnCart;

    @FindBy(css = "#toast-container")
    WebElement toastContainer;

    @FindBy(css = ".ng-trigger")
    WebElement imgCarga;

    @FindBy(css = ".mb-3")
    List<WebElement> cardProduct;

    @FindBy(css = ".cartWrap")
    List<WebElement> cartProduct;


    public void selectProducts(List<String> products){
        for(String pro : products){
            WebElement product = visibilityElements(cardProduct).stream().filter(element->element.findElement(By.cssSelector("b")).getText().equals(pro)).findFirst().orElse(null);
            if(product!=null){
                product.findElement(By.cssSelector(".card-body button:last-of-type")).click(); // button:last-of-type selecciona el ultimo boton
                visibilityElement(toastContainer);
                if(invisibilityElement(imgCarga)) System.out.println("Producto '"+pro+"' seleccionado.");
            }
        }
    }

    public MyCartPage goToCartPage(){
//      cart
        clickElement(btnCart);
        return new MyCartPage(driver);
    }




}
