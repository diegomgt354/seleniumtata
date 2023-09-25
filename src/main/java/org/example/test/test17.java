package org.example.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test17 {

    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        List<WebElement> checkboxs = driver.findElements(By.cssSelector("#checkbox-example fieldset label input"));
        checkboxs.forEach(checkbox -> {
            checkbox.click();
            String valor = checkbox.getAttribute("value");

            WebElement lista = driver.findElement(By.id("dropdown-class-example"));
            Select selector = new Select(lista);
            selector.selectByValue(valor);

            WebElement campoAlerta = driver.findElement(By.id("name"));
            campoAlerta.sendKeys(valor);
            driver.findElement(By.id("alertbtn")).click();

            Alert alert = driver.switchTo().alert();

            String txtAlerta = alert.getText();
            alert.dismiss();
            if (txtAlerta.contains(valor)) {
                System.out.println("Ingreso correcto de ".concat(valor));
            }
        });
    }

}
