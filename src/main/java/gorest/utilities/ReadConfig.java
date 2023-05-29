package gorest.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {


	private ReadConfig() {


	}

	static Properties prop = new Properties();

	public static void readProperties() {


		try (FileReader fr = new FileReader(System.getProperty("user.dir") + "/config/config.properties")) {
			prop.load(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getProperty(String key) {

		return prop.getProperty(key);


	}

}

