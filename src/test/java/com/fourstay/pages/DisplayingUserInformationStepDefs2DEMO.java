package com.fourstay.pages;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class DisplayingUserInformationStepDefs2DEMO {
	HomePage homepPage = new HomePage();

	@Given("^I am on the fourstay login dialog$")
	public void i_am_on_the_fourstay_login_dialog() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		Driver.getInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}

	@Given("^I enter email \"([^\"]*)\"$")
	public void i_enter_email(String email) throws Throwable {
		
		homepPage.email.sendKeys(email);
		
		
	}

	@Given("^I enter password \"([^\"]*)\"$")
	public void i_enter_password(String password) throws Throwable {
		
		homepPage.password.sendKeys(password);
		
		
	}

	@When("^I click on the login button$")
	public void i_click_on_the_login_button() throws Throwable {
		
		homepPage.loginBtn.click();
		
	}

	@Then("^the user name should be \"([^\"]*)\"$")
	public void the_user_name_should_be(String expectedName) throws Throwable {
		UserAccountPage userAccountPage = new UserAccountPage();
		String actualName=userAccountPage.accountHolder.toString();
		
		Assert.assertEquals(expectedName, actualName);
		
		
	}

	@Given("^I enter school name \"([^\"]*)\"$")
	public void i_enter_school_name(String school) throws Throwable {
		homepPage.schoolName.sendKeys(school);
		
		
	}

	@Given("^I enter dates \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_dates_and(String start, String end) throws Throwable {
		
		homepPage.startDate.sendKeys(start);
		homepPage.endDate.sendKeys(end);
		
	}

	@When("^I click the search button$")
	public void i_click_the_search_button() throws Throwable {
		homepPage.search.click();
		
		
	}

	@Then("^the results should contain$")
	public void the_results_should_contain(List<String> states) throws Throwable {
		SearchResultsPage resultsPage = new SearchResultsPage();
		
		Set<String> actualStates=new HashSet<>();
		
		for(WebElement element :resultsPage.allStates){
			
			actualStates.add(element.getText());
		
			
		}
		Thread.sleep(2000);
		Assert.assertEquals(actualStates, states);

	}

	@When("^I enter this search criteria$")
	public void i_enter_this_search_criteria(List<Map<String, String>> searchCriteria) throws Throwable {
		Map<String, String> input = searchCriteria.get(0);
		
		homepPage.schoolName.sendKeys(input.get("school"));
		homepPage.startDate.sendKeys(input.get("start"));
		homepPage.endDate.sendKeys(input.get("end"));
		
		
		
	}

}