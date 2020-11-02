package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Constants;

public class Passenger 
{

	private WebDriver driver;
	
	public Passenger(WebDriver driver, WebDriverWait wait) 
	{
		this.driver = driver;
	}
	
	public boolean setPassengerInfo(String title, String name, String surName)	
	{
		WebElement element = driver.findElement(By.xpath(Constants.paxHeaderContainer));
		
		if (!title.isEmpty() || !title.isBlank())
		{
			try {
				
				Select element1 = new Select(element.findElement(By.tagName(Constants.dropdownToggle)));
				element1.selectByVisibleText(title);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		try {
			WebElement firstName = driver.findElement(By.id(Constants.nameId));
			firstName.sendKeys(name);
			WebElement lastName = driver.findElement(By.id(Constants.surNameId));
			lastName.sendKeys(surName);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean setPassengersInfo(List<String> passengers)	
	{
		WebElement element;
		
		try 
		{
			element = driver.findElement(By.xpath(Constants.PassengerPath));
		} catch (Exception e) 
		{
			return false;
		}
		
		for (int i=0; i < passengers.size();i++)
		{
			String[] passengerInfo = passengers.get(i).split(",");
			
			if (!passengerInfo[0].isEmpty() || !passengerInfo[0].isBlank())
			{
				try {
					
					Select element1 = new Select(element.findElement(By.tagName(Constants.titlePath)));
					element1.selectByVisibleText(passengerInfo[0]);
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			
			try {
				WebElement firstName = driver.findElement(By.id(Constants.nameId));
				firstName.sendKeys(passengerInfo[1]);
				WebElement lastName = driver.findElement(By.id(Constants.surNameId));
				lastName.sendKeys(passengerInfo[2]);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		return true;
	}
	
	public boolean submit()
	{
		try {
			driver.findElement(By.className(Constants.continueFlowButton)).click();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
}
