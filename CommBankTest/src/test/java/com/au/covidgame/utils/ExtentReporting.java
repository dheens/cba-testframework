package com.au.covidgame.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporting {
    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;

    public static ExtentReports getExtentInstance() {
        if (extent == null) {
            htmlReporter = new ExtentSparkReporter(
                    System.getProperty("user.dir") + "/test-output/screenshots/AutomationReport.html");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);

            extent.setSystemInfo("Host Name", "Herokuapp");
            extent.setSystemInfo("Environment", "PROD");
            extent.setSystemInfo("User Name", "Dhinash");

            htmlReporter.config().setDocumentTitle("Extent Report Result");
            htmlReporter.config().setReportName("Covid Game - Test Automation result");
            htmlReporter.config().setTheme(Theme.STANDARD);
        }
        return extent;
    }
}
