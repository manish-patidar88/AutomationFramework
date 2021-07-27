package com.ohrm.qa.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.ohrm.qa.constants.FrameworkConstants;

public final class DataProviderUtils {

	private static List<Map<String, String>> list = new ArrayList<>();

	@DataProvider
	public static Object[] getdata(Method m) {

		String tcName = m.getName();
		if (list.isEmpty()) {
			list = ExcelUtils.getTestData(FrameworkConstants.getDatasheet());
		}

		List<Map<String, String>> reducedlist = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("testname").equalsIgnoreCase(tcName)) {
				if (list.get(i).get("execute").equalsIgnoreCase("yes")) {
					reducedlist.add(list.get(i));
				}

			}
		}
		return reducedlist.toArray();
	}

}
