package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Constants;

public class Login 
{
	
	private WebDriver driver;
	
	public Login(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public boolean loginLater()
	{
		try {
			driver.findElement(By.className(Constants.loginLater)).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
