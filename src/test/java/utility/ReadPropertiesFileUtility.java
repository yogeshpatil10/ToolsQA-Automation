package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ReadPropertiesFileUtility {
	WebDriver driver;

	public ReadPropertiesFileUtility(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public static String getGlobalValue(String key) {
		Properties prop = new Properties();

		FileInputStream fis;
		try {
			fis = new FileInputStream(Constant.configPropertiesFilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop.getProperty(key);
	}

}
