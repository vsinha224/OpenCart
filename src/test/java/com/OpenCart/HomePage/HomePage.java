package com.OpenCart.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.OpenCart.Init.AbstractPage;

public class HomePage extends AbstractPage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(xpath="(//a[contains(text(),'Login')])[1]")
	WebElement login;
	
	@FindBy(xpath="//div[@id='slideshow0']")
	WebElement slider;
	
	@FindBy(xpath="(//div[@class='row'])[3]")
	WebElement featuredList;
	
	@FindBy(xpath="//div[@id='logo']//a")
	WebElement logo;
	
	@FindBy(xpath="(//div[@class='row'])[3]")
	WebElement buttonsgrp;
	
	@FindBy(xpath="(//div[@class='swiper-viewport'])[2]")
	WebElement logoSlider;
	
	/*
	 * create a method for above element
	 */
	
	public void myAccount()
	{
		myAccount.click();
	}
	
	public void register()
	{
		register.click();
	}
	public void Login()
	{
		login.click();
	}
	
	public void clickLogo()
	{
		logo.click();
	}
	

}
