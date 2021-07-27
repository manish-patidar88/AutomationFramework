/**
 * 
 */
package com.ohrm.qa.util;

/**
 * Jun 22, 2021
 * 
 * @author Manish Patidar
 * @version 1.0
 * @since 1.0
 */
public final class DynamicXpathUtils {

	private DynamicXpathUtils() {
	}

	public static String getXpath(String xPath, String value) {
		return String.format("%s", value);
	}

}
