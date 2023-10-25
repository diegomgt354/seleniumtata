package org.example.seleniumTest.Components;

import org.apache.commons.io.FileUtils;
import org.example.seleniumTest.pages.LoginPage;
import org.example.seleniumTest.pages.Navbar;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
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

    //    screenshot
    public String getScreenshot(String testClassName, WebDriver driver) throws IOException {
        String location = System.getProperty("user.dir")+"/reports/"+testClassName+".png";
        TakesScreenshot ts =  (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(location);
        FileUtils.copyFile(source,file);
        return location;
    }

    @BeforeMethod(alwaysRun = true) // asegura que ejecutará siempre
    public LoginPage launchApplication() throws IOException {
        driver = inicializeDriver();
        login = new LoginPage(driver);
        nav = new Navbar(driver);
        login.toGo(); // vamos a la pagina
        return login;
    }

    @AfterMethod(alwaysRun = true)
    public void closeApplication(){
        driver.close();
    }
}
