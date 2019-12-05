package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class Profile {

	public WebDriver driver;

	public Profile(WebDriver driver) {
		this.driver = driver;
	}

	By ProfileTab = By.xpath("//*[@id='mainWrapper']/mdb-navbar[1]//ul[1]/li[3]/a");
	By addProfile = By.xpath("//*[@id='sidebar-wrapper']/ul/li[1]/a");
	By OBusinessName = By.xpath("//*[@id='o-businessname']");
	By Industry = By.xpath("//*[@id='mainbusinessinfo']/div//div[4]/div[1]//mdb-select/div/div");
	By OptionList = By.xpath(
			"//*[@id='mainbusinessinfo']/div/mdb-item-body/div/div/div[4]/div[1]/div/mdb-select/mdb-select-dropdown/div/div[2]/ul/li");

	By SaveProfile = By.xpath("//*[@id='basic-info']/mdb-tabset//div[1]/div/a[2]");
	By NewProfile = By.xpath("//*[@id='page-content-wrapper']/div/div[1]/div[1]/h4");
	By SearchProfile = By.xpath("//*[@class='tab-pane fade show active']//*[@id='searchUser']");
	By ProfileOptions = By.xpath("//*[@heading='Active']//*[@class='searchlist-vh']//a");
	By editProfile = By.xpath("//*[@id=\'page-content-wrapper\']/div/div[1]/div[2]/a/i");
	By ProfileStng = By.xpath("//*[@id='basic-info']/mdb-tabset/div/div/div[1]/ul/li[3]/a/span");
	By ProfileCompetitor = By.xpath(
			"//*[@id='basic-info']/mdb-tabset/div/div/div[2]/div/mdb-tab[4]/mim-asgard-settings/mdb-tabset/div/div/div[1]/ul/li[4]/a/span");

	public WebElement getProfileTab() throws InterruptedException {

		return driver.findElement(ProfileTab);
	}

	public WebElement getaddProfile() throws InterruptedException {

		return driver.findElement(addProfile);
	}

	public WebElement getOBusinessName() throws InterruptedException {

		return driver.findElement(OBusinessName);
	}

	public WebElement getIndustry() throws InterruptedException {

		return driver.findElement(Industry);
	}

	public WebElement getSaveProfile() throws InterruptedException {

		return driver.findElement(SaveProfile);
	}

	public WebElement getNewProfile() throws InterruptedException {

		return driver.findElement(NewProfile);
	}

	public List<WebElement> getOptionList() throws InterruptedException {

		return driver.findElements(OptionList);
	}

	public void selectindustry(String Value) throws InterruptedException {

		getIndustry().click();
		Thread.sleep(5000);
		for (WebElement element : getOptionList()) {
			if (Value.equals(element.getText())) {
				element.click();
				break;
			}

		}

	}

	public WebElement getSearchProfile() throws InterruptedException {

		return driver.findElement(SearchProfile);
	}

	public List<WebElement> getProfileOptions() throws InterruptedException {

		return driver.findElements(ProfileOptions);
	}

	public void selectProfile(String Value) throws InterruptedException {

		Thread.sleep(5000);
		getSearchProfile().click();
		Thread.sleep(5000);
		getSearchProfile().sendKeys("Hotel Los Gatos");
		Thread.sleep(10000);

		for (WebElement element : getProfileOptions()) {
			if (element.getText().contains(Value)) {
				element.click();
				break;
			}

		}

	}

	public WebElement geteditProfile() throws InterruptedException {

		return driver.findElement(editProfile);
	}

	public WebElement getProfileStng() throws InterruptedException {

		return driver.findElement(ProfileStng);
	}

	public WebElement getProfileCompetitor() throws InterruptedException {

		return driver.findElement(ProfileCompetitor);
	}

}
