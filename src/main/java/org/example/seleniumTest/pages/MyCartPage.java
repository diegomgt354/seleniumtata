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
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class MyCartPage extends FunctionsAbstracts {
    WebDriver driver;

    public MyCartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".cartWrap")
    List<WebElement> cartProducts;

    @FindBy(xpath = "//li/button[text()='Checkout']")
    WebElement btnCheckout;

    By titleProduct = By.cssSelector("h3");
    By btnDeleteProducto = By.cssSelector("button.btn-danger");

    public boolean validateProducts(List<String> products){
        List<String> productsInCart = visibilityElements(cartProducts).stream()
                .map(element->element.findElement(titleProduct).getText()).toList();
        Set<String> setProducts = new HashSet<>(products);
        Set<String> setProductsInCart = new HashSet<>(productsInCart);
        return setProducts.equals(setProductsInCart);
    }

    public void deleteProductRandom(List<String> products){
        Random random = new Random();
        int indiceAleatorio = random.nextInt(products.size());
        visibilityElements(cartProducts).stream()
                .filter(element->element.findElement(titleProduct).getText()
                .equals(products.get(indiceAleatorio))).findFirst().ifPresent(pro->{
                    pro.findElement(btnDeleteProducto).click();
                    invisibilityElement(pro);
                    System.out.println("Producto eliminado: "+products.get(indiceAleatorio));
                });

    }

    public PaymentPage goToCheckout(){
//        continuar con la compra
        clickElement(btnCheckout);
        return new PaymentPage(driver);
    }


}
