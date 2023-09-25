package org.example.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test1 {

        static WebDriver driver;
        static WebDriverWait wait;

        public static void main(String[] args) throws InterruptedException {

                // String rutaWebDriver = System.getProperty("user.dir");

                // Chrome
                ChromeOptions options = new ChromeOptions();
                // options.addArguments("--remote-allow-origins=*");
                // System.setProperty("webdriver.chrome.driver",
                // rutaWebDriver+"\\resources\\chromedriver.exe");
                driver = new ChromeDriver(options);

                // //Firefox
                // System.setProperty("webdriver.gecko.driver",
                // rutaWebDriver+"\\resources\\geckodriver.exe");
                // driver = new FirefoxDriver();

                // //Microsoft Edge
                // System.setProperty("webdriver.edge.driver",
                // rutaWebDriver+"\\resources\\msedgedriver.exe");
                // driver = new EdgeDriver();

                wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                driver.get("https://google.com");
                driver.manage().window().maximize();
                driver.findElement(By.name("q")).sendKeys("python con selenium");
                // Thread.sleep(2000); // espera 2 seg siempre
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("/html/body/div[1]/div[3]/form//div[2]//center/input[1]"))).click();

                System.out.println("TITULO: " + driver.getTitle());

                System.out.println("URL: " + driver.getCurrentUrl());

                driver.close();

                // driver.quit();

        }
}
