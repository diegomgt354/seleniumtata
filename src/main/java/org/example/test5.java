package org.example;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test5 {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    By username = By.id("username");
    By password = By.id("password");
    By opcionUser = By.xpath("//label[@class='customradio'][2]");
    By okayBtnMOdal = By.id("okayBtn");
    By typeUser = By.xpath("//select[@class='form-control']");
    By terms = By.id("terms");
    By signInBtn = By.id("signInBtn");
    By btnCheckout = By.xpath("//a[@class='nav-link btn btn-primary']");
    By btnComprar = By.xpath("//button[contains(text(),'Checkout')]");
    By country = By.xpath("//input[@id='country']");
    By terminos = By.xpath("//label[@for='checkbox2']");
    By purchase = By.xpath("//input[@type='submit']");
    By confirmacion = By.xpath("//div[@class='alert alert-success alert-dismissible']");

    @BeforeTest
    public void antes() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        // ingresamos
        sendKey(username, "rahulshettyacademy");
        sendKey(password, "learning");
        clic(opcionUser);
        clic(okayBtnMOdal);
        select(typeUser, "consult");
        clic(terms);
        clic(signInBtn);

        // agregamos los productos
        Map<String, Integer> productos = new HashMap<>() {
            {
                put("iphone X", 4);
                put("Samsung Note 8", 5);
                put("Nokia Edge", 2);
                put("Blackberry", 7);
            }
        };

        productos.forEach((pro, size) -> {
            By btnProducto = By
                    .xpath("//a[contains(text(),'" + pro + "')]/ancestor::div/following-sibling::div/button");
            scroll(btnProducto);
            clic(btnProducto);
        });

        // validamos que los productos esten seleccionados
        " Checkout ( 4 )".equals(elementVisible(btnCheckout).getText());
        scroll(btnCheckout);
        clic(btnCheckout);

        productos.forEach((pro, size) -> {
            By cantProducto = By.xpath("//tr//a[contains(text(),'" + pro + "')]/ancestor::tr//input");
            elementVisible(cantProducto).clear();
            sendKey(cantProducto, String.valueOf(size));
        });
        // compramos
        clic(btnComprar);
        sendKey(country, "Peru");
        clic(terminos);
        clic(purchase);

        // validamos el mensaje
        elementVisible(confirmacion).getText().equals("Success! Thank you! Your order will be delivered in next few weeks :-).");

    }

    @AfterTest
    public void despues() {
        driver.close();
    }

    public WebElement elementVisible(By elementBy) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void sendKey(By elementBy, String txt) {
        elementVisible(elementBy).sendKeys(txt);
    }

    public void clic(By elementBy) {
        elementVisible(elementBy).click();
    }

    public void select(By elementBy, String value) {
        Select op = new Select(driver.findElement(elementBy));
        op.selectByValue(value);
    }

    public void scroll(By elementBy) {
        js.executeScript("arguments[0].scrollIntoView();", elementVisible(elementBy));
    }

}
