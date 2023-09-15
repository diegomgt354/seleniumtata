package org.example;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test9 {
    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String actual = iterator.next();
        String nuevo = iterator.next();

        driver.switchTo().window(nuevo);
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
        driver.switchTo().window(actual);
        System.out.println(driver.findElement(By.xpath("//h3")).getText());

    }
}
