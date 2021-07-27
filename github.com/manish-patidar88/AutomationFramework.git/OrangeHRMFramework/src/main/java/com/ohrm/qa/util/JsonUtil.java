package com.ohrm.qa.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohrm.qa.constants.FrameworkConstants;
import com.ohrm.qa.enums.ConfigProperties;
import com.ohrm.qa.exceptions.FrameworkException;
import com.ohrm.qa.exceptions.InvalidPathForFileException;
import com.ohrm.qa.exceptions.PropertyFileUsageException;

public final class JsonUtil {

	private static Map<String, String> CONFIGMAP = null;

	private JsonUtil() {

	}

	static {
		try {
			CONFIGMAP = new ObjectMapper().readValue(new File(FrameworkConstants.getJsonConfigPath()),
					new TypeReference<HashMap<String, String>>() {
					});

		} catch (FileNotFoundException e1) {
			throw new InvalidPathForFileException("JSon file you are trying to read is not found");
		} catch (IOException e1) {
			throw new FrameworkException("some io exception happened while reading Json file");
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
