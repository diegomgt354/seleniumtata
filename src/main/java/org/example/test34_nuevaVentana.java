package org.example;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class test34_nuevaVentana {
    static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // nueva ventana en blanco
        driver.switchTo().newWindow(WindowType.WINDOW);

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterators = handles.iterator();

        String parendtWindowId = iterators.next();
        String childtWindow = iterators.next();
        driver.switchTo().window(childtWindow);
        driver.get("https://rahulshettyacademy.com");

        String valueName = driver.findElement(By.cssSelector("h2 a[href*='javascript-sdet']")).getText();
        driver.switchTo().window(parendtWindowId);

        driver.findElement(By.cssSelector("form input[name='name']")).sendKeys(valueName);

    }
}
