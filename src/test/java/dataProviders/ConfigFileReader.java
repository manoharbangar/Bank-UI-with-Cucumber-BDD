package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private final String pathToConfigFile = "Cofigs/Configuration.properties";
	private Properties properties;

	public ConfigFileReader() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(pathToConfigFile));
			properties = new Properties();
			try {
				properties.load(br);
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException f) {
			throw new RuntimeException("Configuration.properties not found at " + pathToConfigFile);
		}
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("chromeDriverPath");
		if (driverPath == null)
			throw new RuntimeException("driverPath is not specified in the Configuration.properties file.");
		else
			return driverPath;
	}

	public int getImplicitlyWaitTime() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait == null)
			throw new RuntimeException("implicitlyWait time is not specified in the Configuration.properties file.");
		else
			return Integer.parseInt(implicitlyWait);
	}

	public String getBaseURL() {
		String baseURL = properties.getProperty("baseURL");
		if (baseURL == null)
			throw new RuntimeException("baseURL is not specified in the Configuration.properties file.");
		else
			return baseURL;
	}

}
