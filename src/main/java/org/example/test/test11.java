package org.example.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test11 {
    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/nestedframes");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();

        // System.out.println(driver.findElements(By.tagName("iframe")).size());
        List<WebElement> frames = driver.findElements(By.tagName("iframe")); // buscamos todos los frames
        frames.forEach(frame -> { // recorremos los frames
            driver.switchTo().frame(frame); // ingresamos al frame
            int searchFrame = driver.findElements(By.tagName("iframe")).size(); // contamos cuandos frames hay dentro
                                                                                // del frame
            if (searchFrame > 0) { // si hay al menos 1 ingresamos
                System.out.println(driver.findElement(By.tagName("body")).getText()); // imprimimos el texto
                driver.switchTo().frame(0); // ingresamos al primer frame
                System.out.println(driver.findElement(By.tagName("body")).getText()); // imprimimos el texto de ese
                                                                                      // frame nuevo

            }
            driver.switchTo().defaultContent(); // ingresamos a la pagina inicial

        });
    }

}
