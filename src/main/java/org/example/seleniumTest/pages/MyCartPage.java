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
import java.util.*;
import java.util.stream.Collectors;

public class MyCartPage extends FunctionsAbstracts {
//    WebDriver driver;

    public MyCartPage(WebDriver driver){
        super(driver);
//        this.driver = driver;
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
                .map(element->element.findElement(titleProduct).getText()).collect(Collectors.toList());
        Set<String> setProducts = new HashSet<>(products);
        Set<String> setProductsInCart = new HashSet<>(productsInCart);
        return setProducts.equals(setProductsInCart);
    }

    public List<String> deleteProductRandom(List<String> products){
        Random random = new Random();
        int indexAleatory = random.nextInt(products.size());
        String txtProductDelete = products.get(indexAleatory);
        visibilityElements(cartProducts).stream()
                .filter(element->element.findElement(titleProduct).getText()
                .equals(txtProductDelete)).findFirst().ifPresent(pro->{
                    pro.findElement(btnDeleteProducto).click();
                    invisibilityElement(pro);
                    System.out.println("Producto eliminado: "+txtProductDelete);
                });
        List<String> productsOrder = new ArrayList<>();
        products.stream().filter(txt->!txt.equals(txtProductDelete)).forEach(productsOrder::add);
        return productsOrder;
    }

    public PaymentPage goToCheckout(){
//        continuar con la compra
        clickElement(btnCheckout);
        return new PaymentPage(driver);
    }


}
