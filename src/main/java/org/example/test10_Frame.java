package org.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test10_Frame {
    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();

        driver.switchTo().frame(driver.findElement(By.id("frame1")));
        System.out.println("Frame 1.- " + driver.findElement(By.id("sampleHeading")).getText());

        driver.switchTo().parentFrame(); // frame principal

        driver.switchTo().frame(driver.findElement(By.id("frame2")));
        System.out.println("Frame 2.- " + driver.findElement(By.id("sampleHeading")).getText());

    }
}
