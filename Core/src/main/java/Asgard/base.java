package Asgard;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	
	

	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		//Test

		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Viral\\Automation\\asgard\\Core\\src\\main\\java\\Asgard\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
			ChromeOptions o = new ChromeOptions();
			o.addArguments("disable-extensions");
			o.addArguments("--start-maximized");
			
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
