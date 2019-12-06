package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class User {

	public WebDriver driver;
//Test1234
	//Office
	public User(WebDriver driver) {
		this.driver = driver;
	}

	By UserTab = By.xpath("//*[@id='mainWrapper']/mdb-navbar[1]//div[2]/links/ul[1]/li[4]/a");
	By addUser = By.xpath("//*[@id='sidebar-wrapper']/ul/li[1]/a");
	By newUsername = By.xpath("//*[@id=\'username\']");
	By firstName = By.xpath("//*[@id=\'firstname\']");
	By lastName = By.xpath("//*[@id=\'lastname\']");
	By BusinessList = By.xpath(
			"//*[@id=\'agencyform\']/mdb-tabset/div/div/div[2]/div/mdb-tab[1]/div[2]/div/div/mdb-select/div/div/div[1]");
	By BusinessOptionList = By.xpath(
			"//*[@id=\'agencyform\']/mdb-tabset/div/div/div[2]/div/mdb-tab[1]/div[2]/div/div/mdb-select/mdb-select-dropdown/div/div[2]/ul/li");
	By RoleList = By.xpath("//*[@id='agencyform']//*[@formcontrolname='inputRolelist']");
	By RoleOptionList = By
			.xpath("//*[@id='agencyform']//*[@formcontrolname='inputRolelist']//*[@class='options']//span ");
	By SaveBtn = By.xpath("//*[@id=\'agencyform\']/mdb-tabset/div/div/div[2]/div/mdb-tab[1]/div[1]/div/a[2]");
	By NewUser = By.xpath("//*[@id=\'page-content-wrapper\']/div/div[1]/div[1]/h4");
	By TimeList = By.xpath(
			"//*[@id='agencyform']/mdb-tabset/div/div/div[2]/div/mdb-tab[1]/div[5]/div[1]/div/mdb-select/div/div");
	By TimeOptionList = By.xpath(
			"//*[@id=\"agencyform\"]/mdb-tabset/div/div/div[2]/div/mdb-tab[1]/div[5]/div[1]/div/mdb-select/mdb-select-dropdown/div/div[2]/ul/li");

	By IndiaTime = By.xpath(
			"//*[@id=\"agencyform\"]/mdb-tabset/div/div/div[2]/div/mdb-tab[1]/div[5]/div[1]/div/mdb-select/mdb-select-dropdown/div/div[2]/ul/li");

	//*[@id="agencyform"]/mdb-tabset/div/div/div[2]/div/mdb-tab[1]/div[5]/div[1]/div/mdb-select/mdb-select-dropdown/div/div[2]/ul/li[91]/span
	
	public WebElement getUserTab() throws InterruptedException {

		return driver.findElement(UserTab);
	}

	public WebElement getaddUser() throws InterruptedException {

		return driver.findElement(addUser);
	}

	public WebElement getnewUsername() throws InterruptedException {

		return driver.findElement(newUsername);
	}

	public WebElement getfirstName() throws InterruptedException {

		return driver.findElement(firstName);
	}

	public WebElement getlastName() throws InterruptedException {

		return driver.findElement(lastName);
	}

	public WebElement getBusinessList() throws InterruptedException {

		return driver.findElement(BusinessList);
	}

	public WebElement getRoleList() throws InterruptedException {

		return driver.findElement(RoleList);
	}

	public List<WebElement> getBusinessOptionList() throws InterruptedException {

		return driver.findElements(BusinessOptionList);
	}

	public List<WebElement> getRoleOptionList() throws InterruptedException {

		return driver.findElements(RoleOptionList);
	}

	public WebElement getSaveBtn() throws InterruptedException {

		return driver.findElement(SaveBtn);
	}

	public WebElement getNewUser() throws InterruptedException {

		return driver.findElement(NewUser);
	}

	public void selectBusiness(String Value) throws InterruptedException {

		getBusinessList().click();
		Thread.sleep(5000);
		for (WebElement element : getBusinessOptionList()) {
			if (Value.equals(element.getText())) {
				element.click();
				break;
			}

		}

	}

	public void selectRole(String Value) throws InterruptedException {

		getRoleList().click();
		Thread.sleep(5000);
		for (WebElement element : getRoleOptionList()) {
			if (Value.equals(element.getText())) {
				element.click();
				break;
			}

		}

	}

	public WebElement getTimeList() throws InterruptedException {

		return driver.findElement(TimeList);
	}
	
	public WebElement getIndiaTime() throws InterruptedException {

		return driver.findElement(IndiaTime);
	}

	public List<WebElement> getTimeOptionList() throws InterruptedException {

		return driver.findElements(TimeOptionList);
	}

	public void selectTimezone(String Value) throws InterruptedException {

		getTimeList().click();
		Thread.sleep(5000);
		for (WebElement element : getTimeOptionList()) {
			if (Value.contains(element.getText())) {
				element.click();
				break;
			}

		}

	}
}
