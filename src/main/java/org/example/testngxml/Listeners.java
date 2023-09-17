package org.example.testngxml;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
//        se ejecuta al iniciar el test
        System.out.println("onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
//        se ejecuta cuando el test es un exito
        System.out.println("onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult result) {
//        se ejecuta cuando el test falla
        System.out.println("onTestFailure - "+result.getName());
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
        ITestListener.super.onFinish(context);
    }
}
