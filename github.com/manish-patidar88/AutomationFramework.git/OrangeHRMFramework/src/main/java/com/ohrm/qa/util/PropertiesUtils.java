package com.ohrm.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.ohrm.qa.constants.FrameworkConstants;
import com.ohrm.qa.enums.ConfigProperties;
import com.ohrm.qa.exceptions.PropertyFileUsageException;

public final class PropertiesUtils {

	private PropertiesUtils() {

	}

	private static Properties config = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();
	static {
		try (FileInputStream ip = new FileInputStream(FrameworkConstants.getConfigPath());) {
			config.load(ip);
			config.entrySet().forEach(
					entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()));

		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(0); // problem with static block "initializerError" comming extra if the file path
							// is wrong| main method is not there to propagate exp
		}
	}

	public static String get(ConfigProperties key) {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new PropertyFileUsageException(
					"Property name" + key + " is not found. Please check config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
