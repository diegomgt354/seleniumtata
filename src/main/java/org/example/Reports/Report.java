package org.example.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {


    public static ExtentReports getExtentReports(){
        //      extendsResport - ExtentSpartReporter
        String location = System.getProperty("user.dir")+"/reports/index.html";
//        se utiliza para especificar la ubicación y la configuración del informe html
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(location);
        extentSparkReporter.config().setReportName("Web Automation Result"); // nombre del informe
        extentSparkReporter.config().setDocumentTitle("Test Results"); // titulo del documento

        ExtentReports extentReports = new ExtentReports(); // entrada principal para crear y gestionar informes
        extentReports.attachReporter(extentSparkReporter); // adjuntar el reporte
        extentReports.setSystemInfo("Tester","Diego Gutierrez"); // informacion del reporte
        return extentReports;
    }
}
