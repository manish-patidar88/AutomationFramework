package com.ohrm.qa.constants;

import com.ohrm.qa.enums.ConfigProperties;
import com.ohrm.qa.util.PropertiesUtils;

public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final String USERDIR = System.getProperty("user.dir");
	private static final String RESOURCEPATH = USERDIR + "/src/test/resources";
	private static final String CONFIGPATH = RESOURCEPATH + "/config.properties";
	private static final String JOSNCONFIGPATH = USERDIR + "/src/test/resources/config.json";
	private static final String EXTENTREPORTFOLDERPATH = USERDIR + "/extent-test-output";
	private static final String EXCELPATH = RESOURCEPATH + "/testdata.xlsx";
	private static String extentReportFilePath = "";
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	private static final String DATASHEET = "DATA";
	private static final long PAGE_LOAD_TIMEOUT = 20;
	private static final long IMPLICIT_WAIT = 10;

	public static String getExtentReportFolderPath() {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath() {
		if (PropertiesUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH + "/" + System.currentTimeMillis() + "/index.html";
		} else {
			return EXTENTREPORTFOLDERPATH + "/index.html";
		}
	}

	/**
	 * 
	 * TODO lombak plugin to remove getter/setter code
	 */
	public static String getExcelpath() {
		return EXCELPATH;
	}

	public static String getConfigPath() {
		return CONFIGPATH;
	}

	public static String getJsonConfigPath() {
		return JOSNCONFIGPATH;
	}

	public static String getRunmanagersheet() {
		return RUNMANAGERSHEET;
	}

	public static String getDatasheet() {
		return DATASHEET;
	}

	public static long getPageLoadTimeout() {
		return PAGE_LOAD_TIMEOUT;
	}

	public static long getImplicitWait() {
		return IMPLICIT_WAIT;
	}

}
