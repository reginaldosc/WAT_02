package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Constants;

public class OverviewPage {

	private WebDriverWait wait;
	
	public OverviewPage(WebDriverWait wait) 
	{
		this.wait = wait;
	}
	
	public WebElement checkPageLoaded() 
	{
		try 
		{
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(Constants.addCarHire)));
			return element;
		} catch (Exception e) 
		{
			return null;
		}
		
	}
}
