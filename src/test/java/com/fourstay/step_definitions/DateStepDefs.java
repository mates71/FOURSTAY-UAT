package com.fourstay.step_definitions;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DateStepDefs {
	WebDriver driver;
	String origin=null;
	boolean adding=false;
	int addDays=0;

@Given("^I am on business calculator application$")
public void i_am_on_business_calculator_application() throws Throwable {
	System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
	driver = new ChromeDriver();

	driver.get("https://www.timeanddate.com/date/weekdayadd.html");

	
	
	
}

@When("^I add (\\d+) days to (\\d+)/(\\d+)/(\\d+)$")
public void i_add_days_to(int numberOfDays, int month, int day, int year) throws Throwable {
    driver.findElement(By.id("m1")).sendKeys(month+"");
    driver.findElement(By.id("d1")).sendKeys(day+"");
    driver.findElement(By.id("y1")).sendKeys(year+"");
    
    driver.findElement(By.id("ad")).sendKeys(numberOfDays+"");
   
    Select select=new Select(driver.findElement(By.id("ach")));
    select.selectByVisibleText("No days");
   
    
    JavascriptExecutor js=(JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0,400)");
	
    driver.findElement(By.id("subbut")).click();
	
	
	
}

@Then("^the date calculator should calculate the days correctly$")
public void the_date_calculator_should_calculate_the_days_correctly() throws Throwable {
   
	String actualResult=driver.findElement(By.xpath("//*[contains(text(),'Results')]")).getText();//h2[contains(text(),'Result')]
	System.out.println("act Day :"+actualResult);
	System.out.println(origin);
	
	// prepres the format which the original string will have
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
			// convert String to LocalDate
			LocalDate localDate = LocalDate.parse(origin, formatter);
			
			System.out.println(localDate);
			if (adding) {
				localDate = localDate.plusDays(addDays);
			} else {
				localDate = localDate.minusDays(addDays);
			}

			System.out.println(localDate);
			
			// Sunday, February 2, 2020
			formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
			String expected = "Result: " + localDate.format(formatter);
			System.out.println("exp " + expected);
			assertEquals(expected, actualResult);
	
}


/*
	
	WebDriver driver;
	String origin = null;
	int addDays = 0;
	boolean adding = false;

	@Given("^I am on business calculator application$")
	public void i_am_on_business_calculator_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.timeanddate.com/date/weekdayadd.html");

	}

	@When("^I add (\\d+) days to (\\d+)/(\\d+)/(\\d+)$")
	public void i_add_days_to(int numberOfdays, int month, int day, int year) throws Throwable {
		origin = month + "/" + day + "/" + year;
		addDays = numberOfdays;
		driver.findElement(By.id("m1")).sendKeys(month + "");
		driver.findElement(By.id("d1")).sendKeys(day + "");
		driver.findElement(By.id("y1")).sendKeys(year + "");
		adding = false;
		driver.findElement(By.id("ad")).sendKeys(numberOfdays + "");
		new Select(driver.findElement(By.id("ach"))).selectByVisibleText("No days");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 400)");
		driver.findElement(By.id("subbut")).click();
	}

	@Then("^the date calculator should calculate the days correctly$")
	public void the_date_calculator_should_calculate_the_days_correctly() throws Throwable {
		Thread.sleep(2000);
		String actual = driver.findElement(By.xpath("//h2[contains(text(), 'Result')]")).getText();
		System.out.println("act " + actual);

		System.out.println(origin);
		System.out.println(addDays);

		// prepres the format which the original string will have
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		// convert String to LocalDate
		LocalDate localDate = LocalDate.parse(origin, formatter);

		System.out.println(localDate);
		if (adding) {
			localDate = localDate.plusDays(addDays);
		} else {
			localDate = localDate.minusDays(addDays);
		}

		System.out.println(localDate);

		// Sunday, February 2, 2020
		formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
		String expected = "Result: " + localDate.format(formatter);
		System.out.println("exp " + expected);
		assertEquals(expected, actual);
	}
*/
}
