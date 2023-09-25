package org.example.test;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class test6_FluentWait {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/dynamic-properties");

        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30)) // tiempo de espera
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class, NoClassDefFoundError.class); // cada cierto tiempo

        WebElement visibleAfter = fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                if (driver.findElement(By.id("enableAfter")).isDisplayed()) {
                    return driver.findElement(By.id("visibleAfter"));
                } else {
                    return null;
                }
            }
        });

        System.out.println(visibleAfter.getText());

    }
}