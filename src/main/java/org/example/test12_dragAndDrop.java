package org.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test12_dragAndDrop {

    static WebDriver driver;
    static WebDriverWait wait;
    static Actions action;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        action = new Actions(driver);
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();

        WebElement target_drag = driver.findElement(By.id("draggable"));
        WebElement target_drop = driver.findElement(By.id("droppable"));

        action.dragAndDrop(target_drag, target_drop).build().perform(); // de drag a drop

        action.dragAndDropBy(target_drop, 100, 100).build().perform(); // de drag a un lugar definido

    }
}
