package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPg {

	public WebDriver driver;

	public LoginPg(WebDriver driver) {
		this.driver = driver;
	}

	By Username = By.xpath("//input[@id='inputEmail']");
	By Password = By.xpath("//input[@id='inputPassword']");
	By SignIn = By.xpath("//*[@id='sign_in']/div[3]/button");
	By ForgotPassword = By.xpath("/html/body/mim-asgard-app/app-account/div/section[2]/app-login/div/span[1]/a");
	
	
	//*[@id="sign_in"]/div[3]/button

	public WebElement getUsername() throws InterruptedException {

		return driver.findElement(Username);
	}
	
	public WebElement getPassword() throws InterruptedException {

		return driver.findElement(Password);
	}
	
	public WebElement getSignIn() throws InterruptedException {

		return driver.findElement(SignIn);
	}
	
	public WebElement getForgotPassword() throws InterruptedException {

		return driver.findElement(ForgotPassword);
	}

}
