package Asgard;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	
	

	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException {
		//Test

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Viral\\Automation\\asgard\\Core\\src\\main\\java\\Asgard\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		else if (browserName.equals("IE")) {

		}

		else if (browserName.equals("Mozila")) {

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

}
