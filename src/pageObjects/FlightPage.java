package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Constants;

public class FlightPage 
{
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public FlightPage(WebDriver driver, WebDriverWait wait) 
	{
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement checkPageLoaded() 
	{
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(Constants.appFlightsSummary)));
		return element;
	}

	public boolean selectFlight(String place)
	{
		try {
			driver.findElement(By.xpath(Constants.getFlightCardPath(place))).click();
			driver.findElement(By.xpath(Constants.continueWithValueFare)).click();
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public boolean setBaggage() 
	{
		try {
			driver.findElement(By.className(Constants.radioCircleButtonLabel)).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean submit()
	{
		try {
			driver.findElement(By.xpath(Constants.continueButton)).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
