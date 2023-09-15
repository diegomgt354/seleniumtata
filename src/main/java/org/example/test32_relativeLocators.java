package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class test32_relativeLocators {
    static WebDriver driver;

    // https://www.selenium.dev/documentation/webdriver/elements/locators/

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement userEmail = driver.findElement(By.id("userEmail-label"));
        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));

        // derecha
        driver.findElement(with(By.id("firstName")).toLeftOf(lastName)).sendKeys("estoy a la izquierda de lastName");

        System.out.println(driver.findElement(with(By.id("userName-label")).toLeftOf(By.id("firstName"))).getText());

        // izquierda
        driver.findElement(with(By.id("lastName")).toRightOf(firstName)).sendKeys("estoy a la derecha de firstName");

        // arriba
        driver.findElement(with(By.id("userEmail")).above(subjectsInput)).sendKeys("estoy arriba de subjects");

        System.out.println(
                driver.findElement(with(By.id("userEmail-label")).toLeftOf(By.id("userEmail-label"))).getText());

        // abajo
        driver.findElement(with(By.id("subjectsInput")).below(userEmail)).sendKeys("estoy abajo de email");

        // cerca
        // driver.findElement(with(By.id("hobbies-checkbox-1")).toRightOf(By.id("hobbies-checkbox-2"))).click();
    }
}
