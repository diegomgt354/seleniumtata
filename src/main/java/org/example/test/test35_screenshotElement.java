package org.example.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test35_screenshotElement {

    static WebDriver driver;

    public static void main(String[] args) throws IOException {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Diego Gutierrez Tafur");
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Esto es una prueba");

        // captura de elementos
        File fileFirstName = firstName.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(fileFirstName, new File("firstName.png"));

        File fileCurrentAddress = currentAddress.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(fileCurrentAddress, new File("currentAddress.png"));

        // obtenemos las dimensiones del elemento
        System.out.println("firstName height: " + firstName.getRect().getDimension().getHeight());
        System.out.println("firstName width: " + firstName.getRect().getDimension().getWidth());

        System.out.println("currentAddress height: " + currentAddress.getRect().getDimension().getHeight());
        System.out.println("currentAddress width: " + currentAddress.getRect().getDimension().getWidth());
    }
}
