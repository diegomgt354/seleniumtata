package org.example.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

public class test27 {

    static WebDriver driver;
    static SoftAssert a;

    public static void main(String[] args) throws MalformedURLException, IOException {

        String ruta = "src/main/resources/geckodriver";
        System.setProperty("webdriver.gecko.driver", ruta);

        driver = new FirefoxDriver();

        a = new SoftAssert();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links = driver.findElement(By.id("gf-BIG")).findElements(By.tagName("a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("HEAD");
            con.connect();
            int responseCode = con.getResponseCode();

            a.assertTrue(responseCode != 404, "UPSSSSSSSSS " + link.getText() + " ES INCORRECTO");

            System.out.println(url + " - " + link.getText() + " - " + responseCode);
            con.disconnect();
        }

        a.assertAll();

    }
}
