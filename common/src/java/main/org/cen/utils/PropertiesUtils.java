package org.cen.utils;

import java.util.Properties;

/**
 * Helper class for reading properties.
 * 
 * @author Emmanuel ZURMELY
 */
public class PropertiesUtils {

	public static double getDouble(Properties properties, String key) {
		return getDouble(properties, key, Double.NaN);
	}

	/**
	 * Returns a double value read from the specified properties.
	 * 
	 * @param properties
	 *            the properties
	 * @param key
	 *            the key
	 * @param defaultValue
	 *            the default value to return if the key is not found or if the
	 *            value is incorrect
	 * @return the double value associated to the key if it exists, the default
	 *         value otherwise
	 */
	public static double getDouble(Properties properties, String key, double defaultValue) {
		String value = properties.getProperty(key);
		if (value == null) {
			System.err.println("missing property: " + key);
		}
		try {
			return Double.valueOf(value);
		} catch (Exception e) {
			System.err.println("invalid property value: " + key + "=" + value);
			e.printStackTrace();
		}
		return defaultValue;
	}
}
