package org.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test18 {

    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        String day = "5";
        String month = "May";
        String year = "1989";

        driver.findElement(By.id("dateOfBirthInput")).click();

        WebElement yearElement = wait.until(
                ExpectedConditions.visibilityOf(driver.findElement(By.className("react-datepicker__year-select"))));
        Select selectYear = new Select(yearElement);
        selectYear.selectByValue(year);

        WebElement monthElement = wait.until(
                ExpectedConditions.visibilityOf(driver.findElement(By.className("react-datepicker__month-select"))));
        Select selectMonth = new Select(monthElement);
        selectMonth.selectByVisibleText(month);

        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("// div[contains(@aria-label,'" + month + "')][text()='" + day + "']"))))
                .click();
    }
}
