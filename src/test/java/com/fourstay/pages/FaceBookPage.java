package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class FaceBookPage {

	public FaceBookPage(){
		PageFactory.initElements(Driver.getInstance(), this);
		
		
		
	}
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="pass")
	public WebElement psw;
	

	@FindBy(id="u_0_2")
	public WebElement login;
	
	
	
}
