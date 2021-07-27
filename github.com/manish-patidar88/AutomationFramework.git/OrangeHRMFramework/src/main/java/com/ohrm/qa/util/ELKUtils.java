/**
 * 
 */
package com.ohrm.qa.util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.ohrm.qa.enums.ConfigProperties;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Jul 15, 2021
 * 
 * @author Manish Patidar
 * @version 1.0
 * @since 1.0
 */
final class ELKUtils {

	/**
	 * constructor is private to avoid instantation by creating object
	 */
	private ELKUtils() {
	}

	/**
	 * 
	 * @author Manish Patidar Jul 15, 2021
	 * @param testname
	 * @param status
	 */
	public static void sendDetailsToELK(String testname, String status) {

		if (PropertiesUtils.get(ConfigProperties.SELENIUMGRIDURL).equalsIgnoreCase("yes")) {
			Map<String, String> map = new HashMap<>();
			map.put("testname", testname);
			map.put("status", status);
			map.put("executiontime", LocalDateTime.now().toString());

			Response response = RestAssured.given().header("content-Type", "application/json").log().all().body(map)
					.post(PropertiesUtils.get(ConfigProperties.ELASTICURL));

			Assert.assertEquals(response.statusCode(), 201);
			response.prettyPrint();
		}
	}

}
