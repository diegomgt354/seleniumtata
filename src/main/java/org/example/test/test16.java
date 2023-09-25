package org.example.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test16 {

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

        List<WebElement> enlaces = driver.findElements(enlace);
        List<String> titulos = new ArrayList<>();
        for (int i = 0; i < enlaces.size(); i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            wait.until(ExpectedConditions.elementToBeClickable(enlaces.get(i))).sendKeys(clickOnLinkTab);
        }

        Set<String> ventanas = driver.getWindowHandles();
        Iterator<String> iterador = ventanas.iterator();

        while (iterador.hasNext()) {
            driver.switchTo().window(iterador.next());
            titulos.add(driver.getTitle());
        }

        System.out.println(titulos.size());
        titulos.forEach(t -> {
            System.out.println(t);
        });

    }

}
