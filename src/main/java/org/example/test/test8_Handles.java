package org.example.test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test8_Handles {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(By.xpath("//a[@class='blinkingText']")).click();

        Set<String> windows = driver.getWindowHandles(); // obtenemos las ventanas

        Iterator<String> iterator = windows.iterator(); // para iterar/recorrer las ventanas

        // while (iterator.hasNext()) { System.out.println(iterator.next()); }
        String actual = iterator.next();
        String nuevo = iterator.next();
        driver.switchTo().window(nuevo);

        String mensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".im-para.red")))
                .getText();
        String email = mensaje.split("at")[1].trim().split(" ")[0];
        System.out.println("Email: " + email);
        driver.switchTo().window(actual);
        driver.findElement(By.id("username")).sendKeys(email);
        Thread.sleep(2000); // esperamos 2 segundos
        driver.switchTo().window(nuevo);
        String mensaje2 = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.im-para:nth-child(1)")))
                .getText();
        System.out.println(mensaje2);
    }
}
