package org.example;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test4 {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        // espera explicita
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // espera implicita
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.manage().window().maximize();

        List<WebElement> listaProductos = driver.findElements(By.cssSelector("h4.product-name"));

        listaProductos.forEach(p -> {
            // System.out.println(p.getText());
            String[] pro = p.getText().split("-");
            System.out.println(pro[0].trim());
        });

        Map<String, Integer> productos = new HashMap<>() {
            {
                put("Cucumber", 5);
                put("Tomato", 7);
                put("Carrot", 8);
                put("Brocolli", 9);
                put("Cauliflower", 11);
                put("Beetroot", 3);
                put("Beans", 1);
                put("Brinjal", 5);
            }
        };
        // // agregamos los productos del diccionario
        addProductos(driver, productos);
        // productos.forEach((product, size) -> {
        // WebElement btnAgregar = driver
        // .findElement(By.xpath("//h4[contains(text(),'" + product +
        // "')]/following-sibling::*[3]/button"));
        // WebElement btnIncrementar = driver.findElement(
        // By.xpath("//h4[contains(text(),'" + product +
        // "')]/following-sibling::*[2]/a[@class='increment']"));

        // for (int i = 1; i < size; i++) {
        // btnIncrementar.click();
        // }
        // btnAgregar.click();

        // });
        // ingresamos al carrito
        driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        // ingresamos codigo promocional
        driver.findElement(By.xpath("//input[contains(@placeholder,'Enter promo code')]"))
                .sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

        // esperamos a que salga el mensaje de confirmacion promocional
        String mensajePromo = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")))
                .getText();

        mensajePromo.equals("Code applied ..!");

        // ordenamos
        driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();

        // seleccionamos el pais
        Select country = new Select(
                driver.findElement(By.cssSelector(".wrapperTwo > div:nth-child(3) > select:nth-child(1)")));
        country.selectByValue("Peru");

        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
        WebElement mensajeConfirmacion = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='wrapperTwo']"))));

        System.out.println(mensajeConfirmacion.getText());
    }

    static void addProductos(WebDriver driver, Map<String, Integer> productos) {
        // agregamos los productos del diccionario
        productos.forEach((product, size) -> {
            WebElement btnAgregar = driver
                    .findElement(By.xpath("//h4[contains(text(),'" + product +
                            "')]/following-sibling::*[3]/button"));
            WebElement btnIncrementar = driver.findElement(
                    By.xpath("//h4[contains(text(),'" + product + "')]/following-sibling::*[2]/a[@class='increment']"));

            for (int i = 1; i < size; i++) {
                btnIncrementar.click();
            }
            btnAgregar.click();

        });
    }

}
