package pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Constants;

public class HomePage 
{
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public HomePage(WebDriver driver, WebDriverWait wait) 
	{
		this.driver = driver;
		this.wait = wait;
	}
	
	public void loadPage() 
	{
		
		driver.get(Constants.mainUrl);
		
		assertTrue(checkPageLoaded());
	}
	
	// Used to click and accept cookies
	public void acceptCookies( ) 
	{
		driver.findElement(By.xpath(Constants.yesIagreeButton)).click();
	}
	
	// Fill the FROM input for searching
	public boolean setFromSearch(String place)
	{
		WebElement departure = driver.findElement(By.id(Constants.inputButtonDeparture));
		departure.click();		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(Constants.airportsCountries)));
		departure.clear();
		departure.sendKeys(place);
		departure.sendKeys(Keys.TAB);
		return true;
	}
	
	// Fill the TO input for searching
	public boolean setToSearch(String place)
	{
		WebElement destination = driver.findElement(By.id(Constants.inputButtonDestination));
		destination.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(Constants.airportsCountries)));
		destination.clear();
		destination.sendKeys(place);
		destination.sendKeys(Keys.TAB);
		return true;
	}
	
	public boolean setDate(String month, String day)
	{		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(Constants.mToggleMonth)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Constants.getMonthPath(month))));
		driver.findElement(By.xpath(Constants.getMonthPath(month))).click();
		WebElement datePicker = driver.findElement(By.className(Constants.datepickerCalendar));
		List<WebElement> rows = datePicker.findElements(By.className(Constants.calendarBody));
		
		for (WebElement cell: rows)
		{
			if (cell.getText().equals(day))
			{
				cell.click();
				return true;
			}
		}
		return false;
	}
	
	// set Passengers
	public boolean setPassengers()
	{
		try {
			driver.findElement(By.xpath(Constants.inputButtonPassengers)).click();
			driver.findElement(By.cssSelector(Constants.childPassenger)).click();
			driver.findElement(By.cssSelector(Constants.adultPassenger)).click();
			driver.findElement(By.className(Constants.doneButton)).click();
			driver.findElement(By.className(Constants.searchButton)).click();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	// Check the title of the webpage
	private boolean checkPageLoaded()
	{				
		try 
		{
			assertEquals(Constants.title, driver.getTitle());
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(Constants.searchWidgetTabsButton)));
		} catch (Exception e) {
			return false; 
		}
		return true;
	}
	
	
		

}
