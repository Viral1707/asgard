package Asgard;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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
	public void ALogin(String Username, String Password, String URL, String HomepageUrl, String BusinessName,
			String Alias, String ProfileName, String IndustryName, String Username1, String FirstName, String LastName,
			String Role) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		LoginPg LP = new LoginPg(driver);
		LP.getUsername().sendKeys(prop.getProperty("username"));
		LP.getPassword().sendKeys(prop.getProperty("password"));
		Thread.sleep(3000);
		LP.getSignIn().click();
		Thread.sleep(10000);
		String actual = driver.getCurrentUrl(); //
		Assert.assertEquals(prop.getProperty("homepageUrl"), actual);
		Thread.sleep(4000);
		driver.close();
	}

	@Test(description = "Verify that user is able to Logout correctly", dataProvider = "getData")
	public void BLogout(String Username, String Password, String URL, String HomepageUrl, String BusinessName,
			String Alias, String ProfileName, String IndustryName, String Username1, String FirstName, String LastName,
			String Role) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		LoginPg LP = new LoginPg(driver);
		LP.getUsername().sendKeys(prop.getProperty("username"));
		LP.getPassword().sendKeys(prop.getProperty("password"));
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
		Assert.assertEquals(prop.getProperty("url"), LoginURL);
		Thread.sleep(4000);
		driver.close();
	}

	@Test(description = "Verify that user is able to create business", dataProvider = "getData")
	public void CCreateBusiness(String Username, String Password, String URL, String HomepageUrl, String BusinessName,
			String Alias, String ProfileName, String IndustryName, String Username1, String FirstName, String LastName,
			String Role) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		LoginPg LP = new LoginPg(driver);
		LP.getUsername().sendKeys(prop.getProperty("username"));
		LP.getPassword().sendKeys(prop.getProperty("password"));
		LP.getSignIn().click();
		HomePg HP = new HomePg(driver);
		Thread.sleep(5000);
		HP.getSettings().click();
		Thread.sleep(5000);
		// HP.getstgHp().click();
		Thread.sleep(5000);
		Business Business = new Business(driver);
		Business.getBusinessTab().click();
		Business.getaddBusiness().click();
		Thread.sleep(3000);

		Business.getBusinessName().sendKeys(prop.getProperty("businessName"));
		Business.getAlias().sendKeys(prop.getProperty("businessAlias"));
		Thread.sleep(5000);
		Business.getSaveBusiness().click();
		Thread.sleep(5000);
		String NewBusiness = Business.getNewBusiness().getText();
		Assert.assertEquals(NewBusiness, prop.getProperty("businessName"));
		Thread.sleep(4000);
		driver.close();
	}

	@Test(description = "Verify that user is able to create profile", dataProvider = "getData")
	public void DCreateProfile(String Username, String Password, String URL, String HomepageUrl, String BusinessName,
			String Alias, String ProfileName, String IndustryName, String Username1, String FirstName, String LastName,
			String Role) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		LoginPg LP = new LoginPg(driver);
		LP.getUsername().sendKeys(prop.getProperty("username"));
		LP.getPassword().sendKeys(prop.getProperty("password"));
		LP.getSignIn().click();

		HomePg HP = new HomePg(driver);
		Thread.sleep(5000);
		HP.getSettings().click();
		Thread.sleep(5000);
		Profile Profile = new Profile(driver);
		Profile.getProfileTab().click();
		Profile.getaddProfile().click();
		Profile.getOBusinessName().sendKeys(prop.getProperty("profileName"));
		Profile.selectindustry(prop.getProperty("industry"));
		Thread.sleep(3000);
		Profile.getSaveProfile().click();
		Thread.sleep(5000);
		String NewProfile = Profile.getNewProfile().getText();
		Assert.assertEquals(NewProfile, prop.getProperty("profileName"));
		Thread.sleep(4000);
		driver.close();
	}

	@Test(description = "Verify that user is able to create user", dataProvider = "getData")
	public void ECreateUser(String Username, String Password, String URL, String HomepageUrl, String BusinessName,
			String Alias, String ProfileName, String IndustryName, String Username1, String FirstName, String LastName,
			String Role) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		LoginPg LP = new LoginPg(driver);
		LP.getUsername().sendKeys(prop.getProperty("username"));
		LP.getPassword().sendKeys(prop.getProperty("password"));
		LP.getSignIn().click();
		HomePg HP = new HomePg(driver);
		Thread.sleep(5000);
		HP.getSettings().click();
		Thread.sleep(5000);
		User User = new User(driver);
		User.getUserTab().click();
		User.getaddUser().click();
		User.selectBusiness(prop.getProperty("userBusiness"));
		Thread.sleep(10000);
		User.getnewUsername().sendKeys(prop.getProperty("username1"));
		User.getfirstName().sendKeys(prop.getProperty("firstName"));
		User.getlastName().sendKeys(prop.getProperty("lastName"));

		User.getTimeList().click();
		Thread.sleep(5000);
		User.getIndiaTime().click();
		User.selectRole(Role);
		User.getSaveBtn().click();
		Thread.sleep(5000);
		String NewUser = User.getNewUser().getText();
		String NewUser1 = (prop.getProperty("firstName") + " " + prop.getProperty("lastName"));
		Assert.assertEquals(NewUser, NewUser1);
		Thread.sleep(4000);
		driver.close();

	}

	@Test(description = "Verify that user is able to add competitor", dataProvider = "getData")
	public void IAddCompetitor(String Username, String Password, String URL, String HomepageUrl, String BusinessName,
			String Alias, String ProfileName, String IndustryName, String Username1, String FirstName, String LastName,
			String Role) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		LoginPg LP = new LoginPg(driver);
		LP.getUsername().sendKeys(prop.getProperty("username"));
		LP.getPassword().sendKeys(prop.getProperty("password"));
		LP.getSignIn().click();
		HomePg HP = new HomePg(driver);
		Thread.sleep(5000);
		HP.getSettings().click();
		Thread.sleep(5000);
		Profile Profile = new Profile(driver);
		Profile.getProfileTab().click();
		Thread.sleep(5000);
		Profile.selectProfile(prop.getProperty("selProfile"));
		Thread.sleep(5000);
		Profile.geteditProfile().click();
		Thread.sleep(2000);
		Profile.getProfileStng().click();
		Thread.sleep(2000);
		Profile.getProfileCompetitor().click();

		ProfileComp ProfileC = new ProfileComp(driver);
		ProfileC.getAddCompetitor().click();
		Thread.sleep(2000);
		ProfileC.getCompName().sendKeys(prop.getProperty("compName"));
		Thread.sleep(2000);
		ProfileC.getCompDomain().sendKeys(prop.getProperty("compUrl"));
		Thread.sleep(2000);
		ProfileC.getCompStreet1().sendKeys(prop.getProperty("address1"));
		Thread.sleep(2000);
		ProfileC.selectCompCountry(prop.getProperty("address2"));
		Thread.sleep(5000);
		ProfileC.selectCompState(prop.getProperty("state"));
		Thread.sleep(2000);
		ProfileC.getCompCity().sendKeys(prop.getProperty("city"));
		Thread.sleep(2000);
		ProfileC.getCompPostCode().sendKeys(prop.getProperty("zipCode"));
		Thread.sleep(2000);
		ProfileC.getCompPhone().sendKeys(prop.getProperty("phoneNo"));
		Thread.sleep(2000);
		ProfileC.getCompSave().click();
		Thread.sleep(4000);
		ProfileC.assertNewComp(prop.getProperty("compName"));
		Thread.sleep(4000);
		driver.close();
		

	}

	@Test(description = "Verify that user is able to edit profile", dataProvider = "getData")
	public void GEditProfile(String Username, String Password, String URL, String HomepageUrl, String BusinessName,
			String Alias, String ProfileName, String IndustryName, String Username1, String FirstName, String LastName,
			String Role) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		LoginPg LP = new LoginPg(driver);
		LP.getUsername().sendKeys(prop.getProperty("username"));
		LP.getPassword().sendKeys(prop.getProperty("password"));
		LP.getSignIn().click();
		HomePg HP = new HomePg(driver);
		Thread.sleep(5000);
		HP.getSettings().click();
		Thread.sleep(5000);
		Profile Profile = new Profile(driver);
		Profile.getProfileTab().click();
		Profile.selectProfile(prop.getProperty("selProfile"));
		Thread.sleep(5000);
		Profile.geteditProfile().click();
		Profile.getOBusinessName().clear();
		Thread.sleep(2000);
		Profile.getOBusinessName().sendKeys(prop.getProperty("profileName"));
		Profile.selectindustry(prop.getProperty("industry"));
		Thread.sleep(3000);
		Profile.getSaveProfile().click();
		Thread.sleep(5000);
		String NewProfile = Profile.getNewProfile().getText();
		Thread.sleep(2000);
		assertTrue(NewProfile.contains(prop.getProperty("profileName")));
		Thread.sleep(4000);
		driver.close();
	}

	@Test(description = "Verify that user is able to edit user", dataProvider = "getData")
	public void HEditUser(String Username, String Password, String URL, String HomepageUrl, String BusinessName,
			String Alias, String ProfileName, String IndustryName, String Username1, String FirstName, String LastName,
			String Role) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		LoginPg LP = new LoginPg(driver);
		LP.getUsername().sendKeys(prop.getProperty("username"));
		LP.getPassword().sendKeys(prop.getProperty("password"));
		LP.getSignIn().click();
		HomePg HP = new HomePg(driver);
		Thread.sleep(5000);
		HP.getSettings().click();
		Thread.sleep(5000);
		User User = new User(driver);
		User.getUserTab().click();
		User.selectUser(prop.getProperty("selUser"));
		Thread.sleep(10000);
		User.getEditUserBtn().click();
		Thread.sleep(5000);
		User.getfirstName().clear();
		Thread.sleep(5000);
		User.getfirstName().sendKeys(prop.getProperty("userFN"));
		Thread.sleep(5000);
		User.getlastName().clear();
		Thread.sleep(5000);
		User.getlastName().sendKeys(prop.getProperty("userLN"));
		Thread.sleep(5000);
		User.getSaveBtn().click();
		Thread.sleep(5000);
		String NewUser = User.getNewUser().getText();
		String NewUser1 = "Test Name";
		Assert.assertEquals(NewUser, NewUser1);
		Thread.sleep(4000);
		driver.close();

	}

	@Test(description = "Verify that user is able to edit business", dataProvider = "getData")
	public void FEditBusiness(String Username, String Password, String URL, String HomepageUrl, String BusinessName,
			String Alias, String ProfileName, String IndustryName, String Username1, String FirstName, String LastName,
			String Role) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		LoginPg LP = new LoginPg(driver);
		LP.getUsername().sendKeys(prop.getProperty("username"));
		LP.getPassword().sendKeys(prop.getProperty("password"));
		LP.getSignIn().click();
		HomePg HP = new HomePg(driver);
		Thread.sleep(5000);
		HP.getSettings().click();
		Thread.sleep(5000);
		Business Business = new Business(driver);
		Business.getBusinessTab().click();
		Business.selectBusiness(prop.getProperty("businessName"));
		Thread.sleep(5000);
		Business.getEditBusinesBtn().click();
		Thread.sleep(4000);
		Business.getBusinessName().clear();
		Thread.sleep(2000);
		Business.getBusinessName().sendKeys(prop.getProperty("businessName"));
		Thread.sleep(5000);
		Business.getSaveBusiness().click();
		Thread.sleep(5000);
		String NewBusiness = Business.getNewBusiness().getText();
		Assert.assertEquals(NewBusiness, prop.getProperty("businessName"));
		Thread.sleep(4000);
		driver.close();
	}

	@Test(description = "Verify that user is able to delete competitor", dataProvider = "getData")
	public void JDeleteCompetitor(String Username, String Password, String URL, String HomepageUrl, String BusinessName,
			String Alias, String ProfileName, String IndustryName, String Username1, String FirstName, String LastName,
			String Role) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		LoginPg LP = new LoginPg(driver);
		LP.getUsername().sendKeys(prop.getProperty("username"));
		LP.getPassword().sendKeys(prop.getProperty("password"));
		LP.getSignIn().click();
		HomePg HP = new HomePg(driver);
		Thread.sleep(5000);
		HP.getSettings().click();
		Thread.sleep(5000);
		Profile Profile = new Profile(driver);
		Profile.getProfileTab().click();
		Thread.sleep(5000);
		Profile.selectProfile(prop.getProperty("profileName"));
		Thread.sleep(5000);
		Profile.geteditProfile().click();
		Thread.sleep(2000);
		Profile.getProfileStng().click();
		Thread.sleep(2000);
		Profile.getProfileCompetitor().click();
		Thread.sleep(5000);
		ProfileComp ProfileC = new ProfileComp(driver);
		ProfileC.getcheckboxComp().click();
		Thread.sleep(3000);
		ProfileC.getdeleteComp().click();
		Thread.sleep(4000);
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
		data[0][5] = "14569885";
		data[0][6] = "New Hotel Los Gatos";
		data[0][7] = "Auto";
		data[0][8] = "uvw@gmail.com";
		data[0][9] = "AutoFN";
		data[0][10] = "AutoLN";
		data[0][11] = "Accounting";
		return data;

	}
	/*
	@BeforeTest
	public void Initialize() throws IOException
	{
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterTest
	public void TearDown() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.close();
	}
	*/

}