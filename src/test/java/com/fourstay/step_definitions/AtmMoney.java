package com.fourstay.step_definitions;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AtmMoney {
	

	@Given("^Jack has valid credit or debit card$")
	public void jack_has_valid_credit_or_debit_card() throws Throwable {
		
		System.out.println("He has credit card");

	}

	@Given("^His accound balance is \\$(\\d+)$")
	public void his_accound_balance_is_$(int balance) throws Throwable {

		Assert.assertEquals(balance, 500);
		System.out.println("His balance 500");

	}

	@When("^He insert his card$")
	public void he_insert_his_card() throws Throwable {

		System.out.println("He put his card to ATM");

	}

	@When("^witdraw \\$(\\d+)$")
	public void witdraw_$(int amount) throws Throwable {

	int newbalance = 500-amount;
	int witdraw=500-newbalance;
	System.out.println("withDrawAmount :"+witdraw);

	}

	@Then("^ATM should return \\$(\\d+)$")
	public void atm_should_return_$(int arg1) throws Throwable {

	}

	@Then("^Now his balance is \\$(\\d+)$")
	public void now_his_balance_is_$(int newbalance) throws Throwable {

		int newBalance = 500 - 150;
		System.out.println("newBalance :" + newBalance);

	}
}
