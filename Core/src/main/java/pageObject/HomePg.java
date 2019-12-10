package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePg {
	
	public WebDriver driver;
	
	public HomePg(WebDriver driver) {
		this.driver = driver;
	}
	
	By UserSet = By.xpath("//*[@id='mainWrapper']/mdb-navbar[1]/nav/div/div[2]/links/ul[2]/li[4]/a");
	By Settings = By.xpath("//*[@id='mainWrapper']/mdb-navbar[1]/nav/div/div[2]/links/ul[2]/li[5]/a/i");
	By Logout = By.xpath("//*[@id='mainWrapper']/mdb-navbar[1]/nav/div/div[2]/links/ul[2]/li[4]/div/a[4]");
	By StgHp = By.xpath("//*[@id='mainWrapper']//li[4]/div/a");
	
	

	
	public WebElement getUserSet() throws InterruptedException {

		return driver.findElement(UserSet);
	}
	
	public WebElement getSettings() throws InterruptedException {

		return driver.findElement(Settings);
	}
	
	public WebElement getLogout() throws InterruptedException {

		return driver.findElement(Logout);
	}
	
	public WebElement getstgHp() throws InterruptedException {

		return driver.findElement(StgHp);
	}
}
