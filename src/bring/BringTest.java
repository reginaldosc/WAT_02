package bring;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.FlightPage;
import pageObjects.HomePage;
import pageObjects.Login;
import pageObjects.OverviewPage;
import pageObjects.Passenger;
import pageObjects.SeatPage;

public class BringTest {

	// Declaring the web driver object
	private WebDriver driver;
	// Declaring Explicit wait timeout
	WebDriverWait wait;
	// Instance of home PO
	HomePage home;
		
	// Method used to initialize everything before test
	@Before
	public void setUpTest() throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver", "../Project1/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		// Setting the driver timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		// Maximizing the browser screen
		driver.manage().window().maximize();
				
		// Getting to the Home page
		home = new HomePage(driver, wait);
		home.loadPage();
				
		// I agree with terms
		home.acceptCookies();
				
	}
		
	// Method used to finish the test, closing the driver instance
	@After
	public void tearDownTest() throws Exception
	{
		driver.quit();
	}
	// Search for a trip
	@Test
	public void searchForTrip() 
	{
		// instance of page objects
		FlightPage fPage = new FlightPage(driver, wait);
		Login login = new Login(driver);
		Passenger passenger = new Passenger(driver, wait);
		SeatPage seatPage = new SeatPage(driver, wait);
		OverviewPage overViewPage = new OverviewPage(wait);
		
		// creating array of passengers
		ArrayList<String> passengers = new ArrayList<>();
		passengers.add("Mrs,Sonia,Pereira");
		passengers.add("Mr,Diogo,Bettencourt");
		passengers.add(",Inês,Marçal");
		
		// set departure
		assertTrue(home.setFromSearch("Lisbon"));
		// set destination
		assertTrue(home.setToSearch("Paris Beauvais"));
		// set departure date
		assertTrue(home.setDate("Dec", "6"));
		// set return date
		assertTrue(home.setDate("Jan", "2"));
		// setting the passengers
		assertTrue(home.setPassengers());
		// check if flight page its opened
		assertNotNull(fPage.checkPageLoaded());						
		// accepting Departure flight
		assertTrue(fPage.selectFlight("Lisbon"));
		// accepting Destination flight
		assertTrue(fPage.selectFlight("Paris Beauvais"));		
		// continue without login
		assertTrue(login.loginLater());		
		// fill passengers info
		assertTrue(passenger.setPassengersInfo(passengers));
		// submit passengers info
		assertTrue(passenger.submit());
		// check if seat select page its opened
		assertNotNull(seatPage.checkPageLoaded());
		// select the 1st departure seat
		assertTrue(seatPage.selectSeat(passengers.get(0), "03D"));
		// select the 2nd departure seat
		assertTrue(seatPage.selectSeat(passengers.get(1), "03E"));
		// select the 3rd departure seat
		assertTrue(seatPage.selectSeat(passengers.get(2), "03F"));
		// click next button
		assertTrue(seatPage.nextFlight());
		// select the 1st return seat
		assertTrue(seatPage.selectSeat(passengers.get(0), "03D"));
		// select the 2nd return seat
		assertTrue(seatPage.selectSeat(passengers.get(1), "03E"));
		// select the 3rd return seat
		assertTrue(seatPage.selectSeat(passengers.get(2), "03F"));
		// click next button
		assertTrue(seatPage.nextFlight());
		// click to avoid track
		assertTrue(seatPage.avoidTrack());
		// set baggage type
		assertTrue(fPage.setBaggage());
		// click submit button
		assertTrue(fPage.submit());
		// click submit button
		assertTrue(fPage.submit());
		// check if Overview page was loaded
		assertNotNull(overViewPage.checkPageLoaded());	
				
	}
	
	

}
