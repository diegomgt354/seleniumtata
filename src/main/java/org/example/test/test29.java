package org.example.test;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class test29 {
    static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.xpath("//th[@role='columnheader'][1]")).click();

        List<WebElement> elementsNames = driver.findElements(By.xpath("//td[1]"));

        List<String> names = elementsNames.stream().map(n -> n.getText()).collect(Collectors.toList());

        List<String> namesOrder = elementsNames.stream().map(n -> n.getText()).sorted()
                .collect(Collectors.toList());

        Assert.assertTrue(names.equals(namesOrder));

        elementsNames.stream().map(name -> name.getText()).forEach(System.out::println);

        for (String name : names) {
            List<String> price = elementsNames.stream().filter(n -> n.getText().contains(name)).map(n -> getPrice(n))
                    .collect(Collectors.toList());
            System.out.println("Producto: " + name + "\nPrecio: " + price.get(0));
        }
    }

    static String getPrice(WebElement element) {
        return element.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
