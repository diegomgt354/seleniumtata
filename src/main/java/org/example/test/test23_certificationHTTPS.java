package org.example.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class test23_certificationHTTPS {

    // https://chromedriver.chromium.org/capabilities

    static WebDriver driver;

    public static void main(String[] args) {

        // aceptar ingresar aun te salte la alerta de inseguridad
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        // agregar proxi
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("localhost:8080");
        options.setCapability("proxy", proxy);

        // bloquear ventanas emergentes
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        // establecer un directorio de descarga
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "/directory/path");
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);

        // FirefoxOptions options = new FirefoxOptions();
        // options.setAcceptInsecureCerts(true);
        // driver = new FirefoxDriver(options);

        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
    }
}
