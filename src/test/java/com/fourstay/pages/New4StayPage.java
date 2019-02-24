package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class New4StayPage {


	public New4StayPage(){
		PageFactory.initElements(Driver.getInstance(), this);
	}

	
	@FindBy(xpath = "//div[@class='navbar-nav pull-right ']//li[2]")
	public WebElement loginLink;
	
	
	
	@FindBy(css ="https://d3guu5uu0s6zk1.cloudfront.net/assets/_restyle/holydays/thanks-giving-7fe031e14f911189741d2bd9892f1ef0b36073ca20c480790945426cbd2986d0.jpg")
	public WebElement picture;
	
	@FindBy(xpath = "//button[@aria-label='Close']")
	public WebElement ariaLabel;
	
	
}
