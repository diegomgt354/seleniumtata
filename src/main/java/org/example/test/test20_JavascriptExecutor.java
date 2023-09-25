package org.example.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test20_JavascriptExecutor {

    static WebDriver driver;
    static JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // js.executeScript("window.scrollBy(0,1000);");

        // Thread.sleep(2000);

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500;");

        List<WebElement> Amounts = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sumaAmounts = 0;
        for (WebElement amount : Amounts) {
            sumaAmounts = sumaAmounts + Integer.parseInt(amount.getText());
        }
        if (driver.findElement(By.className("totalAmount")).getText().contains(String.valueOf(sumaAmounts))) {
            System.out.println("Suma correcta");
        } else {
            System.out.println("Suma incorrecta");
        }
    }

}
