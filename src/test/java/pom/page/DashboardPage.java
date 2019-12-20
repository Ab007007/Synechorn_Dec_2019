package pom.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage {

	
	
	@FindBy(id = "logoutLink")
	WebElement logoutButton;
	
	public DashboardPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogOut()
	{
		logoutButton.click();
	}
	
	public void validateDashboardPageTitle(String actualTitle)
	{
		Assert.assertEquals(actualTitle, "actiTIME - Enter Time-Track");
	}
	
	
}
