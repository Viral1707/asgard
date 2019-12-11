package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class ProfileComp {

	public WebDriver driver;

	public ProfileComp(WebDriver driver) {
		this.driver = driver;
	}

	By AddCompetitor = By.xpath(
			"//*[@id=\"basic-info\"]/mdb-tabset/div/div/div[2]/div/mdb-tab[4]/mim-asgard-settings/mdb-tabset/div/div/div[2]/div/mdb-tab[4]/app-competitors/div/div[1]/div[2]/div[2]/a[1]");

	public WebElement getAddCompetitor() throws InterruptedException {

		return driver.findElement(AddCompetitor);
	}

	By CompName = By.xpath("//*[@id=\'editCompetitorForm-competitorName\']");

	public WebElement getCompName() throws InterruptedException {

		return driver.findElement(CompName);
	}

	By CompDomain = By.xpath("//*[@id='editCompetitorForm-competitorDomain']");

	public WebElement getCompDomain() throws InterruptedException {

		return driver.findElement(CompDomain);
	}

	By CompStreet1 = By.xpath("//*[@id='editCompetitorForm-street1']");

	public WebElement getCompStreet1() throws InterruptedException {

		return driver.findElement(CompStreet1);
	}

	By CompCountry = By.xpath("//*[@id=\'competitorCountry\']/div/div");

	public WebElement getCompCountry() throws InterruptedException {

		return driver.findElement(CompCountry);
	}

	By CompCountryOpt = By.xpath("//*[@id='competitorCountry']/mdb-select-dropdown/div/div[2]/ul/li");

	public List<WebElement> getCompCountryOpt() throws InterruptedException {

		return driver.findElements(CompCountryOpt);
	}

	public void selectCompCountry(String Value) throws InterruptedException {

		getCompCountry().click();
		Thread.sleep(5000);
		for (WebElement element : getCompCountryOpt()) {
			if (Value.equals(element.getText())) {
				element.click();
				break;
			}

		}

	}

	By CompState = By.xpath("//*[@id='competitorState']/div/div");

	public WebElement getCompState() throws InterruptedException {

		return driver.findElement(CompState);
	}

	By CompStateOpt = By.xpath("//*[@id='competitorState']/mdb-select-dropdown/div/div[2]/ul/li");

	public List<WebElement> getCompStateOpt() throws InterruptedException {

		return driver.findElements(CompStateOpt);
	}

	public void selectCompState(String Value) throws InterruptedException {

		getCompState().click();
		Thread.sleep(5000);
		for (WebElement element : getCompStateOpt()) {
			if (Value.equals(element.getText())) {
				element.click();
				break;
			}

		}

	}

	By CompCity = By.xpath("//*[@id=\'editCompetitorForm-city\']");

	public WebElement getCompCity() throws InterruptedException {

		return driver.findElement(CompCity);
	}

	By CompPostCode = By.xpath("//*[@id='editCompetitorForm-postalCode']");

	public WebElement getCompPostCode() throws InterruptedException {

		return driver.findElement(CompPostCode);
	}

	By CompPhone = By.xpath("//*[@id='editCompetitorForm-phoneNumber']");

	public WebElement getCompPhone() throws InterruptedException {

		return driver.findElement(CompPhone);
	}

	By CompSave = By.xpath(
			"//*[@id='basic-info']/mdb-tabset/div/div/div[2]/div/mdb-tab[4]/mim-asgard-settings/mdb-tabset/div/div/div[2]/div/mdb-tab[4]/app-competitors/div/div[2]/div[1]/div/a");

	public WebElement getCompSave() throws InterruptedException {

		return driver.findElement(CompSave);
	}

	By SavedComp = By.xpath(
			"/html/body/mim-asgard-app/app-layout/app-navigation-bar/div/div[2]/app-provisioning/mim-asgard-provisioning-profilelisting/mim-asgard-profile/div/div/div/div/form/mdb-tabset/div/div/div[2]/div/mdb-tab[4]/mim-asgard-settings/mdb-tabset/div/div/div[2]/div/mdb-tab[4]/app-competitors/div/div[1]/div[3]/div/div/table/tbody/tr[1]/td[2]");

	public WebElement getSavedComp() throws InterruptedException {

		return driver.findElement(SavedComp);
	}

	By CompListOpt = By.xpath(
			"//*[@id='basic-info']/mdb-tabset/div/div/div[2]/div/mdb-tab[4]/mim-asgard-settings/mdb-tabset/div/div/div[2]/div/mdb-tab[4]/app-competitors/div/div[1]/div[3]/div/div/table/tbody/tr/td[2]");

	public List<WebElement> getCompListOpt() throws InterruptedException {

		return driver.findElements(CompListOpt);
	}

	By searchComp = By.xpath(
			"//*[@id='basic-info']/mdb-tabset/div/div/div[2]/div/mdb-tab[4]/mim-asgard-settings/mdb-tabset/div/div/div[2]/div/mdb-tab[4]/app-competitors/div/div[1]/div[1]/div/div/input");

	public WebElement getsearchComp() throws InterruptedException {

		return driver.findElement(searchComp);
	}

	public void assertNewComp(String Value) throws InterruptedException {
		Thread.sleep(5000);
		getsearchComp().click();
		Thread.sleep(5000);
		getsearchComp().sendKeys("Test");
		Thread.sleep(5000);
		for (WebElement element : getCompListOpt()) {
			if (element.getText().equals(Value)) {
				element.click();
				break;

			}

		}

	}

	By checkboxComp = By.xpath(
			"//*[@id='basic-info']/mdb-tabset/div/div/div[2]/div/mdb-tab[4]/mim-asgard-settings/mdb-tabset/div/div/div[2]/div/mdb-tab[4]/app-competitors/div/div[1]/div[3]/div/div/table/tbody/tr/td[1]/div/label");

	public WebElement getcheckboxComp() throws InterruptedException {

		return driver.findElement(checkboxComp);
	}
	
	By deleteComp = By.xpath(
			"//*[@id='basic-info']/mdb-tabset/div/div/div[2]/div/mdb-tab[4]/mim-asgard-settings/mdb-tabset/div/div/div[2]/div/mdb-tab[4]/app-competitors/div/div[1]/div[2]/div[1]");

	public WebElement getdeleteComp() throws InterruptedException {

		return driver.findElement(deleteComp);
	}

	public String getComp() {

		return null;

	}

}
