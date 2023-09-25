package org.example.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test21 {
    static WebDriver driver;
    static JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> instructores = driver.findElements(By.cssSelector(".left-align td:nth-child(1)"));
        List<WebElement> cursos = driver.findElements(By.cssSelector(".left-align td:nth-child(2)"));

        List<WebElement> precios = driver.findElements(By.cssSelector(".left-align td:nth-child(3)"));

        int contador = 1;
        for (int i = 0; i < instructores.size(); i++) {
            System.out.println("Datos " + contador);
            System.out.println("\tInstructor: " + instructores.get(i).getText());
            System.out.println("\tCurso: " + cursos.get(i).getText());
            System.out.println("\tPrecio: " + precios.get(i).getText());
            contador++;
        }
    }
}
