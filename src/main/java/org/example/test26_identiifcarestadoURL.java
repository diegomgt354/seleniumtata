package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test26_identiifcarestadoURL {

    static WebDriver driver;

    public static void main(String[] args) throws MalformedURLException, IOException {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String url = driver.findElement(By.cssSelector("a[href*='restapi']")).getAttribute("href");
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("HEAD");
        con.connect();
        int responseCode = con.getResponseCode();
        System.out.println(responseCode);
        con.disconnect();

    }

}
