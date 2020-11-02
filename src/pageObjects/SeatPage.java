package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Constants;

public class SeatPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public SeatPage(WebDriver driver, WebDriverWait wait) 
	{
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement checkPageLoaded() 
	{
		try {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(Constants.okayGotIt)));
			element.click();
			return wait.until(ExpectedConditions.presenceOfElementLocated(By.className(Constants.pricebandLabel)));
			
		} catch (Exception e) {
			return null;
		}
		
	}


	public boolean selectSeat(String info, String seatNumber)
	{
		String[] textoSeparado = info.split(",");
		try {
			driver.findElement(By.xpath(Constants.getPassengerCarouselPath(textoSeparado[1], textoSeparado[2]))).click();
			driver.findElement(By.xpath(Constants.getSeatPath(seatNumber))).click();			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean nextFlight()
	{
		try {
			driver.findElement(By.xpath(Constants.nextFlight)).click();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public boolean avoidTrack()
	{
		try {
			driver.findElement(By.xpath(Constants.buttonNoThanks)).click();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}
