package org.example.seleniumTest.Components;

import org.example.seleniumTest.pages.LoginPage;
import org.example.seleniumTest.pages.Navbar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public WebDriver driver;
    public LoginPage login;
    public Navbar nav;

    public WebDriver inicializeDriver() throws IOException {

//        propiedades
        Properties prop = new Properties();
        String ubication = System.getProperty("user.dir")+"//src//main//java//org//example//seleniumTest//Resources//GlobalData.properties";
        FileInputStream file = new FileInputStream(ubication);
        prop.load(file);

        String browser = prop.getProperty("browser");

        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;
    }

    @BeforeMethod(alwaysRun = true) // asegura que ejecutará siempre
    public void launchApplication() throws IOException {
        driver = inicializeDriver();
        login = new LoginPage(driver);
        nav = new Navbar(driver);
        login.toGo(); // vamos a la pagina
    }

    @AfterMethod(alwaysRun = true)
    public void despues(){
        driver.close();
    }
}
