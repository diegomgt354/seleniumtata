package org.example.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.example.seleniumTest.Components.Base;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends Base implements ITestListener {
    ExtentTest test;
    ExtentReports report = Report.getExtentReports();

    @Override
    public void onTestStart(ITestResult result) { // antes de cada test
        test=report.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) { // si el test es exitoso
        test.log(Status.PASS,"Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) { // si la prueba llega a fallar
        test.fail(result.getThrowable());
//        test.log(Status.FAIL,"Test fail");

        try {
//            Esta línea se utiliza para obtener el controlador WebDriver de la clase de prueba actual.
//            getTestClass, obtiene la clase de prueba
//            getRealClass, obtiene la clase real
//            getField("driver"), busca el campo llamado "driver" en la clase de prueba.
//            get(result.getInstance()) obtiene el valor del campo "driver" en la instancia
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

//        screenshot
        String locationReport = null;
        String methodName = result.getMethod().getMethodName();
        try {
            locationReport = getScreenshot(methodName, driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(locationReport,methodName);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        report.flush(); // finaliza el reporte y agrega el resultado en el html
    }
}
