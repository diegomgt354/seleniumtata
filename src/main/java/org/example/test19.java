package org.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test19 {
        static WebDriver driver;
        static WebDriverWait wait;
        static Actions action;

        public static void main(String[] args) throws InterruptedException {
                driver = new ChromeDriver();
                wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                action = new Actions(driver);
                driver.get("https://www.path2usa.com/travel-companion/");
                driver.manage().window().maximize();

                driver.findElement(By.xpath("//body[contains(@class,'page-template')]")).sendKeys(Keys.PAGE_DOWN);

                wait.until(ExpectedConditions
                                .elementToBeClickable(By.xpath("//input[@id='form-field-travel_comp_date']")))
                                .click();

                String day = "5";
                String month = "May";
                String year = "2030";

                // seleccionamos el mes
                while (!wait.until(ExpectedConditions.visibilityOfElementLocated(
                                By.cssSelector("[class='flatpickr-month'] [class='cur-month']")))
                                .getText().equals(month)) {
                        wait.until(ExpectedConditions.elementToBeClickable(
                                        By.cssSelector("span[class='flatpickr-next-month']")))
                                        .click();
                        Thread.sleep(500);
                }

                List<WebElement> days = driver
                                .findElements(By
                                                .xpath("//span[contains(@class,'flatpickr-day')][contains(@aria-label,'"
                                                                + month + "')]"));

                // seleccionamos el anio
                action.moveToElement(driver.findElement(By.xpath("//input[contains(@class,'cur-year')]"))).build()
                                .perform();
                int diferenciaYear = Integer.parseInt(year)
                                - Integer.parseInt(days.get(0).getAttribute("aria-label").split(", ")[1]);

                while (diferenciaYear > 0) {
                        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(
                                        By.xpath("//span[@class='arrowUp']")))).click();
                        Thread.sleep(500);
                        diferenciaYear--;
                }

                days = driver.findElements(By.xpath(
                                "//span[contains(@class,'flatpickr-day')][contains(@aria-label,'" + month + "')]"));
                // seleccionamos el dia
                for (WebElement d : days) {
                        if (d.getText().equals(day)) {
                                wait.until(ExpectedConditions.elementToBeClickable(d)).click();
                                break;
                        }

                }
        }
}
