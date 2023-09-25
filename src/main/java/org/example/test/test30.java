package org.example.test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test30 {

    static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        List<String> productPrice;
        do {
            List<WebElement> productsElements = driver.findElements(By.xpath("//td[1]"));
            productPrice = productsElements.stream()
                    .filter(product -> product.getText().contains("Cheese"))
                    .map(test30::nameText).collect(Collectors.toList());
            if (productPrice.size() < 1) {
                driver.findElement(By.xpath("//li/a[@aria-label='Next']")).click();
            } else {
                System.out.println(productPrice.get(0));
                break;
            }

        } while (productPrice.size() < 1);
    }

    static String nameText(WebElement element) {
        return element.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
