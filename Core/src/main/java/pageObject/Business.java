package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Business {

	public WebDriver driver;

	public Business(WebDriver driver) {
		this.driver = driver;
	}

	By BusinessTab = By.xpath("//*[@id=\'mainWrapper\']/mdb-navbar[1]/nav//ul[1]/li[2]/a");
	By addBusiness = By.xpath("//*[@id=\'sidebar-wrapper\']/ul/li[1]/a");
	By BusinessName = By.xpath("//*[@id=\"businessname\"]");
	By Alias = By.xpath("//*[@id=\"alias\"]");
	By SaveBusiness = By.xpath("//*[@id='page-content-wrapper']/div//div[1]/div/a[2]");
	By NewBusiness = By.xpath("//*[@id='page-content-wrapper']/div/div[1]/div[1]/h4");

	public WebElement getBusinessTab() throws InterruptedException {

		return driver.findElement(BusinessTab);
	}

	public WebElement getaddBusiness() throws InterruptedException {

		return driver.findElement(addBusiness);
	}

	public WebElement getBusinessName() throws InterruptedException {

		return driver.findElement(BusinessName);
	}

	public WebElement getAlias() throws InterruptedException {

		return driver.findElement(Alias);
	}

	public WebElement getSaveBusiness() throws InterruptedException {

		return driver.findElement(SaveBusiness);
	}

	public WebElement getNewBusiness() throws InterruptedException {

		return driver.findElement(NewBusiness);
	}
}
