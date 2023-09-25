package org.example.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class test14_busquedaEspecifica {
    static WebDriver driver;
    static Actions action;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement tabla = driver.findElement(By.cssSelector(".gf-t")); // identifico la tabla
        // muestro la cantidad de enlaces en la pantalla
        System.out.println("Enlaces en toda la pagina: " + driver.findElements(By.tagName("a")).size());
        // muestra la cantidad de enlaces en la tabla
        System.out.println("Enlaces en la tabla: " + tabla.findElements(By.tagName("a")).size());
        // identifico cuantas secciones hay
        List<WebElement> secciones = tabla.findElements(By.tagName("td"));

        System.out.println("OPCION 1");

        // opcion 1
        secciones.forEach(seccion -> { // recorro las secciones
            // muestra la cantidad de enlaces de cada seccion
            System.out.println("# Enlaces en la seccion " + seccion.findElements(By.tagName("a")).size());
            // identifico os enlaces de cada seccion
            List<WebElement> enlaces = seccion.findElements(By.tagName("a"));
            // muestro el texto de cada enlace de cada seccion
            enlaces.forEach(enlace -> System.out.println(enlace.getText()));
            System.out.println();
        });

        System.out.println("OPCION 2");

        // opcion 2
        for (int i = 0; i < secciones.size(); i++) {
            System.out.println(secciones.get(i).findElements(By.tagName("a")).size());
            List<WebElement> enlaces = secciones.get(i).findElements(By.tagName("a"));
            for (int j = 0; j < enlaces.size(); j++) {
                System.out.println(enlaces.get(j).getText());
            }
            System.out.println();
        }

    }
}
