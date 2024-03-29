package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactory.Guru99HomePage;
import PageFactory.Guru99Login;

public class Test99GuruLoginWithPageFactory {
	WebDriver driver;
	Guru99Login objLogin;
	Guru99HomePage objHomePage;
	@BeforeTest
	public void settup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/");
	}
	/**
	 * This test to go http://demo.guru99.com/V4/
	 * Verify login page title as guru99 bank
	 * Login to application
	 * Verify the home page using Dashboard message
	 */
	@Test(priority=0)
	public void test_Home_Page_Appear_Correct() {
	//Create Login Page Object
	objLogin = new Guru99Login(driver);
	//Verify login page title
	String loginPageTitle = objLogin.getLoginTitle();
	Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
	//Login to HomePage
	objLogin.loginToGuru99("mngr219953", "zYtejYb");
	//Go the next page
	objHomePage = new Guru99HomePage(driver);
	//Verify home page
	Assert.assertTrue(objHomePage.getHomePageDashBoardUserName().toLowerCase().contains("mngr219953"));
	}
}
