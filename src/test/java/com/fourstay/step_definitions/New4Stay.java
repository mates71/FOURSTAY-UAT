package com.fourstay.step_definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.New4StayPage;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class New4Stay {
	
	New4StayPage new4StayPage;

	@Given("^I am on the fourstay login dialog$")
	public void i_am_on_the_fourstay_login_dialog() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		Thread.sleep(3000);
		//new4StayPage.ariaLabel.click();
		
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 60);

		wait.until(ExpectedConditions.invisibilityOfElementLocated((By) new4StayPage.picture));
			new4StayPage.loginLink.click();
		}
	

	@Given("^I enter email \"([^\"]*)\"$")
	public void i_enter_email(String arg1) throws Throwable {

	}

	@Given("^I enter password \"([^\"]*)\"$")
	public void i_enter_password(String arg1) throws Throwable {

	}

	@When("^I click on the login button$")
	public void i_click_on_the_login_button() throws Throwable {

	}

	@Then("^the user name should be \"([^\"]*)\"$")
	public void the_user_name_should_be(String arg1) throws Throwable {

	}

}
