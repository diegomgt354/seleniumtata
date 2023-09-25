package org.example.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test15 {

    static WebDriver driver;
    static WebDriverWait wait;
    static JavascriptExecutor js;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        By enlace = By.xpath("//table[@class='gf-t']//td[1]//li/a");

        for (int i = 0; i < driver.findElements(enlace).size(); i++) {
            List<WebElement> enlaces = driver.findElements(enlace);
            wait.until(ExpectedConditions.elementToBeClickable(enlaces.get(i))).click();
            driver.navigate().back();
        }
    }

    // static void scroll(WebElement element) {
    // js.executeScript("arguments[0].scrollIntoView(true);", element);
    // }

}
