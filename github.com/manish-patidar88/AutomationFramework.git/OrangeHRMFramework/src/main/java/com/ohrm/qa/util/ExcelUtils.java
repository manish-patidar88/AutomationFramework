package com.ohrm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ohrm.qa.constants.FrameworkConstants;
import com.ohrm.qa.exceptions.FrameworkException;
import com.ohrm.qa.exceptions.InvalidPathForFileException;

public final class ExcelUtils {

	private ExcelUtils() {
	}

	static XSSFWorkbook workbook;

	public static List<Map<String, String>> getTestData(String wrkSheet) {
		List<Map<String, String>> list = null;
		try (FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelpath());) {

			workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(wrkSheet);

			int rownum = sheet.getLastRowNum();
			int colnum = sheet.getRow(0).getLastCellNum();

			list = new ArrayList<>();
			Map<String, String> map = new HashMap<>();
			for (int i = 1; i <= rownum; i++) {
				map = new HashMap<>();
				for (int j = 0; j < colnum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}
		} catch (FileNotFoundException e) {
			throw new InvalidPathForFileException("Excel file you are trying to read is not found");
		} catch (IOException e1) {
			throw new FrameworkException("some io exception happened while reading excel file");
		}
		return list;
	}

}
