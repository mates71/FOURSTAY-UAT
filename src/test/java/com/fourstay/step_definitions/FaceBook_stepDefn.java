package com.fourstay.step_definitions;

import com.fourstay.pages.FaceBookPage;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FaceBook_stepDefn {
	FaceBookPage faceBookPage;
	
	@Given("^user navigates to Facebook$")
	public void user_navigates_to_Facebook() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("urlFB"));
		
	}

	@When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void i_enter_Username_as_and_Password_as(String email, String psw) throws Throwable {
		faceBookPage.email.sendKeys(email);
		faceBookPage.psw.sendKeys(psw);
		faceBookPage.login.click();
		
	}

	@Then("^login should be unsuccessful$")
	public void login_should_be_unsuccessful() throws Throwable {
		
		
		
	}

}
