package com.ohrm.qa.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ohrm.qa.constants.FrameworkConstants;

public final class ExtentReport {

	private ExtentReport() {
	}

	private static ExtentReports extent;

	@BeforeSuite
	public static void initReport() {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFolderPath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("OrangeHMR Report");
			spark.config().setReportName("My Report");
		}
	}

	@AfterSuite
	public static void flushReports() {
		if (Objects.nonNull(extent)) {
			extent.flush();
			ExtentManager.unload();
		}
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFolderPath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createTest(String testcasename) {
		ExtentTest test = extent.createTest(testcasename);
		ExtentManager.setExtentTest(test);
	}
}
