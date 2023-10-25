package org.example.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExtentReportDemo {

    public WebDriver driver;

    public ExtentReports extentReports;

    @BeforeTest
    public void config(){
//      extendsResport - ExtentSpartReporter
        String location = System.getProperty("user.dir")+"//reports//index.html";
//        se utiliza para especificar la ubicación y la configuración del informe html
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(location);
        extentSparkReporter.config().setReportName("Web Automation Result"); // nombre del informe
        extentSparkReporter.config().setDocumentTitle("Test Results"); // titulo del documento

        extentReports = new ExtentReports(); // entrada principal para crear y gestionar informes
        extentReports.attachReporter(extentSparkReporter); // adjuntar el reporte
        extentReports.setSystemInfo("Tester","Diego Gutierrez"); // informacion del reporte
        extentReports.setSystemInfo("Tipo","Test in selenium");
    }


    @Test
    public void demo(){
        extentReports.createTest("Iniciando la prueba"); // add information and result in informe
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/client/");

        driver.findElement(By.id("userEmail")).sendKeys("diegogutierrez7@testing.com");
        driver.findElement(By.id("userPassword")).sendKeys("Diego123!");
        driver.findElement(By.id("login")).click();
//        test.fail("XDDDDD error");
        extentReports.flush(); //final report and add result in html
    }
}
