package Asgard;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.Business;
import pageObject.HomePg;
import pageObject.LoginPg;
import pageObject.Profile;
import pageObject.ProfileComp;
import pageObject.User;

public class LoginPage extends base {

	@Test(description = "Verify that user is able to login to Asgard with valid credentials", dataProvider = "getData")
	public void Login(String Username, String Password, String URL, String HomepageUrl, String BusinessName,
			String Alias, String ProfileName, String IndustryName, String Username1, String FirstName, String LastName,
			String Role) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		LoginPg LP = new LoginPg(driver);
		LP.getUsername().sendKeys(Username);
		LP.getPassword().sendKeys(Password);
		LP.getSignIn().click();
		Thread.sleep(10000);
		String actual = driver.getCurrentUrl(); //
		Assert.assertEquals(HomepageUrl, actual);
		driver.close();
	}

	@Test(description = "Verify that user is able to Logout correctly", dataProvider = "getData")
	public void Logout(String Username, String Password, String URL, String HomepageUrl, String BusinessName,
			String Alias, String ProfileName, String IndustryName, String Username1, String FirstName, String LastName,
			String Role) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		LoginPg LP = new LoginPg(driver);
		LP.getUsername().sendKeys(Username);
		LP.getPassword().sendKeys(Password);
		LP.getSignIn().click();
		HomePg HP = new HomePg(driver);
		Thread.sleep(5000);
		HP.getUserSet().click(); //
		HP.getLogout().click();
		Thread.sleep(5000);
		String LoginURL = driver.getCurrentUrl();
		Thread.sleep(5000);
		String actual = driver.getCurrentUrl();
		System.out.println(actual);
		Assert.assertEquals(URL, LoginURL);
		driver.close();
	}

	@Test(description = "Verify that user is able create business", dataProvider = "getData")
	public void CreateBusiness(String Username, String Password, String URL, String HomepageUrl, String BusinessName,
			String Alias, String ProfileName, String IndustryName, String Username1, String FirstName, String LastName,
			String Role) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		LoginPg LP = new LoginPg(driver);
		LP.getUsername().sendKeys(Username);
		LP.getPassword().sendKeys(Password);
		LP.getSignIn().click();
		HomePg HP = new HomePg(driver);
		Thread.sleep(5000);
		HP.getSettings().click();
		Thread.sleep(5000);
		//HP.getstgHp().click();
		Thread.sleep(5000);
		Business Business = new Business(driver);
		Business.getBusinessTab().click();
		Business.getaddBusiness().click();
		Business.getBusinessName().sendKeys(BusinessName);
		Business.getAlias().sendKeys(Alias);
		Thread.sleep(5000);
		Business.getSaveBusiness().click();
		Thread.sleep(5000);
		String NewBusiness = Business.getNewBusiness().getText();
		Assert.assertEquals(NewBusiness, BusinessName);
		driver.close();
	}

	@Test(description = "Verify that user is able create profile", dataProvider = "getData")
	public void CreateProfile(String Username, String Password, String URL, String HomepageUrl, String BusinessName,
			String Alias, String ProfileName, String IndustryName, String Username1, String FirstName, String LastName,
			String Role) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		LoginPg LP = new LoginPg(driver);
		LP.getUsername().sendKeys(Username);
		LP.getPassword().sendKeys(Password);
		LP.getSignIn().click();
		
		HomePg HP = new HomePg(driver);
		Thread.sleep(5000);
		HP.getSettings().click();
		Thread.sleep(5000);
		//HP.getstgHp().click();
		Thread.sleep(5000);
		Profile Profile = new Profile(driver);
		Profile.getProfileTab().click();
		Profile.getaddProfile().click();
		Profile.getOBusinessName().sendKeys(ProfileName);
		Profile.selectindustry("Auto");
		Thread.sleep(3000);
		Profile.getSaveProfile().click();
		Thread.sleep(5000);
		String NewProfile = Profile.getNewProfile().getText();
		Assert.assertEquals(NewProfile, ProfileName);
		driver.close();
	}

	@Test(description = "Verify that user is able create user", dataProvider = "getData")
	public void CreateUser(String Username, String Password, String URL, String HomepageUrl, String BusinessName,
			String Alias, String ProfileName, String IndustryName, String Username1, String FirstName, String LastName,
			String Role) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		LoginPg LP = new LoginPg(driver);
		LP.getUsername().sendKeys(Username);
		LP.getPassword().sendKeys(Password);
		LP.getSignIn().click();
		HomePg HP = new HomePg(driver);
		Thread.sleep(5000);
		HP.getSettings().click();
		Thread.sleep(5000);
		//HP.getstgHp().click();
		Thread.sleep(5000);
		User User = new User(driver);
		User.getUserTab().click();
		User.getaddUser().click();
		User.selectBusiness("200 Main");
		Thread.sleep(10000);
		User.getnewUsername().sendKeys(Username1);
		User.getfirstName().sendKeys(FirstName);
		User.getlastName().sendKeys(LastName);

		User.getTimeList().click();
		Thread.sleep(5000);
		User.getIndiaTime().click();
		User.selectRole(Role);
		// User.selectTimezone("(UTC+05:30) Chennai, Kolkata, Mumbai, New Delhi");
		User.getSaveBtn().click();
		Thread.sleep(5000);
		String NewUser = User.getNewUser().getText();
		String NewUser1 = (FirstName + " " + LastName);
		Assert.assertEquals(NewUser, NewUser1);
		driver.close();
		
	}

	@Test(description = "Verify that user is able add competitor", dataProvider = "getData")
	public void AddCompetitor(String Username, String Password, String URL, String HomepageUrl, String BusinessName,
			String Alias, String ProfileName, String IndustryName, String Username1, String FirstName, String LastName,
			String Role) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		LoginPg LP = new LoginPg(driver);
		LP.getUsername().sendKeys(Username);
		LP.getPassword().sendKeys(Password);
		LP.getSignIn().click();
		HomePg HP = new HomePg(driver);
		Thread.sleep(5000);
		HP.getSettings().click();
		Thread.sleep(5000);
		//HP.getstgHp().click();
		Thread.sleep(5000);
		Profile Profile = new Profile(driver);
		Profile.getProfileTab().click();
		Thread.sleep(5000);
		Profile.selectProfile("Hotel Los Gatos");
		Thread.sleep(5000);
		Profile.geteditProfile().click();
		Thread.sleep(2000);
		Profile.getProfileStng().click();
		Thread.sleep(2000);
		Profile.getProfileCompetitor().click();

		ProfileComp ProfileC = new ProfileComp(driver);
		ProfileC.getAddCompetitor().click();
		Thread.sleep(2000);
		ProfileC.getCompName().sendKeys("ATestComp1");
		Thread.sleep(2000);
		ProfileC.getCompDomain().sendKeys("http://www.testcomp.com");
		Thread.sleep(2000);
		ProfileC.getCompStreet1().sendKeys("Test Street 1");
		Thread.sleep(2000);
		ProfileC.selectCompCountry("United States");
		Thread.sleep(5000);
		ProfileC.selectCompState("California");
		Thread.sleep(2000);
		ProfileC.getCompCity().sendKeys("TestCity");
		Thread.sleep(2000);
		ProfileC.getCompPostCode().sendKeys("159863");
		Thread.sleep(2000);
		ProfileC.getCompPhone().sendKeys("9655478142");
		Thread.sleep(2000);
		ProfileC.getCompSave().click();
		Thread.sleep(4000);
		ProfileC.assertNewComp("ATestComp1");
		
		driver.close();

	}
	
	

	@Test(description = "Verify that user is able edit profile", dataProvider = "getData")
	public void EditProfile(String Username, String Password, String URL, String HomepageUrl, String BusinessName,
			String Alias, String ProfileName, String IndustryName, String Username1, String FirstName, String LastName,
			String Role) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		LoginPg LP = new LoginPg(driver);
		LP.getUsername().sendKeys(Username);
		LP.getPassword().sendKeys(Password);
		LP.getSignIn().click();
		HomePg HP = new HomePg(driver);
		Thread.sleep(5000);
		HP.getSettings().click();
		Thread.sleep(5000);
		//HP.getstgHp().click();
		Thread.sleep(5000);
		Profile Profile = new Profile(driver);
		Profile.getProfileTab().click();
		//Profile.getaddProfile().click();
		Profile.selectProfile("Hotel Los Gatos");
		Thread.sleep(5000);
		Profile.geteditProfile().click();
		Profile.getOBusinessName().clear();
		Thread.sleep(2000);
		Profile.getOBusinessName().sendKeys(ProfileName);
		Profile.selectindustry("Auto");
		Thread.sleep(3000);
		Profile.getSaveProfile().click();
		Thread.sleep(5000);
		String NewProfile = Profile.getNewProfile().getText();
		Thread.sleep(2000);
		//Assert.assertEquals(NewProfile, ProfileName);
		assertTrue(NewProfile.contains(ProfileName));
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		// Row - how many different data types of test
		// Column - how many values per each test
		Object[][] data = new Object[1][12];

		data[0][0] = "viral.p@milestoneinternet.com";
		data[0][1] = "New@1212";
		data[0][2] = "https://u-asgard.azurewebsites.net/account/login";
		data[0][3] = "https://u-asgard.azurewebsites.net/dashboard";
		data[0][4] = "New Business";
		data[0][5] = "14569882";
		data[0][6] = "New Hotel Los Gatos";
		data[0][7] = "Auto";
		data[0][8] = "rst@gmail.com";
		data[0][9] = "AutoFN";
		data[0][10] = "AutoLN";
		data[0][11] = "Accounting";
		return data;
		

	}

}