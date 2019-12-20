package pom.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage 
{
	
	@FindBy(id = "username")
	WebElement usernameTextBox;
	
	@FindBy(name = "pwd")
	WebElement passwordTextBox;
	
	@FindBy(id = "loginButton")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public void enterUserName(String...strings )
	{
		System.out.println("Entering username...");
		if(strings.length > 0)
		{
			usernameTextBox.sendKeys(strings[0]);
		}
		else
		{
			usernameTextBox.sendKeys("admin");
		}
	}
	
	
	public void enterPassword(String...strings)
	{
		System.out.println("Entering Password...");
		if(strings.length > 0)
		{
			passwordTextBox.sendKeys(strings[0]);
		}
		else
		{
			passwordTextBox.sendKeys("manager");
		}
	}
	
	public void clicOnLoginButton()
	{
		System.out.println("Clicking on Login Button");
		loginButton.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void validateLoginPageTitle(String actualTitle)
	{
		Assert.assertEquals(actualTitle, "actiTIME - Login");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
