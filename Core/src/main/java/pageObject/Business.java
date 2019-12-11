package pageObject;

import java.util.List;

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

	By SearchBusiness = By.xpath("//*[@id='sidebar-wrapper']/ul/mdb-tabset/div/div/div[2]/div/mdb-tab[1]/ul/li[1]/div/input");
	By BusinessOptions = By.xpath("//*[@id='searchlist-vh1']/ul/li/a");
	By EditBusinessBtn = By.xpath("//*[@id='page-content-wrapper']/div/div[1]/div[2]/a");
	
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
	
	public WebElement getEditBusinesBtn() throws InterruptedException {

		return driver.findElement(EditBusinessBtn);
	}
	
	public WebElement getSearchBusiness() throws InterruptedException {

		return driver.findElement(SearchBusiness);
	}

	public List<WebElement> getBusinessOptions() throws InterruptedException {

		return driver.findElements(BusinessOptions);
	}

	public void selectBusiness(String Value) throws InterruptedException {

		Thread.sleep(5000);
		getSearchBusiness().click();
		Thread.sleep(5000);
		getSearchBusiness().sendKeys("New Business");
		Thread.sleep(10000);

		for (WebElement element : getBusinessOptions()) {
			if (element.getText().contains(Value)) {
				element.click();
				break;
			}

		}

	}
	
	
}
