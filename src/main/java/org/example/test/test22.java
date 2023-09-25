package org.example.test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test22 {

    static WebDriver driver;
    static WebDriverWait wait;
    static Actions action;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        action = new Actions(driver);

        WebElement selectCountries = driver.findElement(By.id("autocomplete"));

        // String countri = "India";

        List<String> countries = Arrays.asList("Peru", "India", "United States (USA)");

        for (String countri : countries) {
            try {
                selectCountries.clear();
                selectCountries.sendKeys(countri);
                Thread.sleep(500);

                action.moveToElement(
                        driver.findElement(By.xpath("//li[@class='ui-menu-item']/div[text()='" + countri + "']")))
                        .click().build().perform();

                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
