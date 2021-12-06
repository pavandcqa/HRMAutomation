package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	FileInputStream fis;
	Properties prop;

	public ConfigReader() {

		File f = new File("./config.properties");

		try {
			fis = new FileInputStream(f);

			prop = new Properties();

			prop.load(fis);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getBrowserValue() {

		String br = prop.getProperty("browser");
		return br;
	}

	public String getAppUrl() {

		String url = prop.getProperty("appurl");
		return url;
	}

	public String getUserName() {

		String uname = prop.getProperty("username");
		return uname;
	}

	public String getPassword() {

		String pwd = prop.getProperty("password");
		return pwd;
	}

	public String getChromeKey() {

		String key = prop.getProperty("chromeDriverKey");
		return key;
	}

	public String getFirefoxKey() {

		String key = prop.getProperty("firefoxDriverKey");
		return key;
	}

	public String getChromePath() {

		String path = prop.getProperty("chromeDriverPath");
		return path;
	}

	public String getFirefoxPath() {

		String path = prop.getProperty("firefoxDriverPath");
		return path;
	}

	public String getTestDataFilePath() {

		String path = prop.getProperty("testDataFile");
		return path;
	}

}
