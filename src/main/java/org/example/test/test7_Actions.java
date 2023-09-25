package org.example.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test7_Actions {

        static WebDriver driver;
        static WebDriverWait wait;

        public static void main(String[] args) {
                driver = new ChromeDriver();
                driver.get("https://demoqa.com/menu");
                driver.manage().window().maximize();
                Actions accion = new Actions(driver);

                wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // mover el cursor en un elemento en especifico
                accion.moveToElement(visible(driver.findElement(By.xpath("//a[contains(text(),'Main Item 2')]"))))
                                .build()
                                .perform();

                accion.moveToElement(visible(driver.findElement(By.xpath("//a[contains(text(),'SUB SUB LIST »')]"))))
                                .build()
                                .perform();

                accion.moveToElement(
                                visible(driver.findElement(By.xpath("//div[contains(@class,'accordion')]/div[1]"))))
                                .click()
                                .build()
                                .perform();

                accion.moveToElement(
                                visible(driver.findElement(
                                                By.xpath("//div[contains(@class,'accordion')]/div[1]//ul/li[1]"))))
                                .click().build()
                                .perform();

                accion.moveToElement(driver.findElement(By.id("userName"))).click().keyDown(Keys.SHIFT)
                                .sendKeys("diego gutierrez").keyUp(Keys.SHIFT).build().perform();

                accion.moveToElement(driver.findElement(By.id("userEmail"))).click()
                                .sendKeys("diego@gmail.com").doubleClick().contextClick().build().perform();
        }

        static WebElement visible(WebElement elemento) {
                return wait.until(ExpectedConditions.visibilityOf(elemento));
        }
}
