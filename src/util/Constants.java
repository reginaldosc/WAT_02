package util;

public class Constants {
	
	public static String mainUrl = "http://www.ryanair.com/gb/en";
	public static String title = "Official Ryanair website | Book direct for the lowest fares | Ryanair.com";
	
	// Home Page
	public static String inputButtonDeparture = "input-button__departure";
	public static String searchWidgetTabsButton = "search-widget-tabs__button";
	public static String airportsCountries = "airports__countries";
	public static String inputButtonDestination = "input-button__destination";	
	public static String monthPath;
	public static String datepickerCalendar = "datepicker__calendar";
	public static String calendarBody = "calendar-body__cell-wrap";
	public static String mToggleMonth = "m-toggle__month";
	public static String inputButtonPassengers = "//div[@class='input-button__label b3'][contains(.,'Passengers')]";
	public static String childPassenger = "#ry-tooltip-9 > div.tooltip-inner > hp-app-controls-tooltips > fsw-controls-tooltips-container > fsw-controls-tooltips > fsw-passengers-container > fsw-passengers > fsw-passengers-picker-container > fsw-passengers-picker > ry-counter:nth-child(5) > div.counter > div.counter__button-wrapper--enabled";
	public static String adultPassenger = "#ry-tooltip-9 > div.tooltip-inner > hp-app-controls-tooltips > fsw-controls-tooltips-container > fsw-controls-tooltips > fsw-passengers-container > fsw-passengers > fsw-passengers-picker-container > fsw-passengers-picker > ry-counter:nth-child(3) > div.counter > div.counter__button-wrapper--enabled";
	public static String doneButton = "passengers__confirm-button";
	public static String searchButton = "flight-search-widget__start-search";
	public static String yesIagreeButton = "//button[@class='cookie-popup__button'][contains(.,'Yes, I agree')]";
		
	// Flight Page
	public static String appFlightsSummary = "app-flights-summary";
	public static String flightCardPath;
	public static String continueWithValueFare = "//span[contains(.,'Continue with Value fare')]";
	public static String radioCircleButtonLabel = "ry-radio-circle-button__label";
	public static String continueButton = "//button[contains(.,'Continue')]";
	
	//Login
	public static String loginLater = "login-touchpoint__login-later";
	
	//Passenger
	public static String PassengerPath = "//div[@class='pax-header-container'][contains(.,'Passenger')]";
	public static String titlePath = "dropdown__toggle";
	public static String nameId = "formState.passengers.ADT-0.name";
	public static String surNameId = "formState.passengers.ADT-0.surname";
	public static String paxHeaderContainer = "//div[@class='pax-header-container'][contains(.,'Passenger 1  Adult')]";
	public static String dropdownToggle = "dropdown__toggle";
	public static String continueFlowButton = "continue-flow__button";
	
	
	// Seat
	public static String okayGotIt = "seats-modal__cta";
	public static String passengerCarousel;
	public static String pricebandLabel = "priceband__label";
	public static String seatPath;
	public static String nextFlight = "//button[contains(.,'Next flight')]";
	public static String buttonNoThanks = "//button[@color='anchor-blue'][contains(.,'No, thanks')]";
	
	//Overview Page
	public static String addCarHire = "//div[@class='pillar-card__wrapper-content ng-trigger ng-trigger-opacityAnimation'][contains(.,'Add car hire  Other transfers available')]";

	
	public static String getMonthPath(String month)
	{
		monthPath = String.format("//div[@class='m-toggle__month m-toggle__month--after-selected'][contains(.,'%s')]", month); 
		return monthPath;
	}
	
	public static String getFlightCardPath(String place)
	{
		flightCardPath = String.format("//div[@class='card-info__cols-container'][contains(.,'%s')]", place);
		return flightCardPath;
	}
	
	public static String getPassengerCarouselPath(String name, String lastName)
	{
		passengerCarousel = String.format("//div[@class='passenger-carousel__pax'][contains(.,'%s %s')]", name, lastName);
		return passengerCarousel;
	}
	
	public static String getSeatPath(String seat)
	{
		seatPath = String.format("//button[contains(.,'%s')]", seat);
		return seatPath;
	}
}
