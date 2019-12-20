package pom.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.page.DashboardPage;
import pom.page.GlobalVariables;
import pom.page.LoginPage;

public class LoginTest {
	WebDriver driver = null;
	LoginPage login = null;
	DashboardPage dashboard = null;

	@BeforeClass
	public void initilizePageClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		login = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
	}

	@AfterClass
	public void clearObjects()
	{
		driver.close();
		driver = null;
		login = null;
		dashboard = null;
	}
	
	
	@Test
	public void loginWithValidCredentialsTest() {
		driver.get(GlobalVariables.url);

		login.enterUserName();
		login.enterPassword();
		login.clicOnLoginButton();
		dashboard.validateDashboardPageTitle(driver.getTitle());
		
		dashboard.clickOnLogOut();
		login.validateLoginPageTitle(driver.getTitle());
		
	}

	@Test
	public void loginWithInValidCredentialsTest() {

		driver.get(GlobalVariables.url);

		login.enterUserName("abcd");
		login.enterPassword("efgh");
		login.clicOnLoginButton();
		login.validateLoginPageTitle(driver.getTitle());
		
		
	}

}
