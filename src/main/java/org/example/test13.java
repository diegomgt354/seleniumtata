package org.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test13 {

    static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        List<WebElement> frames = driver.findElements(By.tagName("frame"));
        frames.forEach(frame -> {
            driver.switchTo().frame(frame);
            List<WebElement> frames_interior = driver.findElements(By.tagName("frame"));
            if (frames_interior.size() > 0) {
                frames_interior.forEach(frame_interior -> {
                    driver.switchTo().frame(frame_interior);
                    System.out.println(driver.findElement(By.tagName("body")).getText());
                    driver.switchTo().parentFrame();
                });
            } else {
                System.out.println(driver.findElement(By.tagName("body")).getText());
            }
            driver.switchTo().defaultContent();
        });
    }

}
