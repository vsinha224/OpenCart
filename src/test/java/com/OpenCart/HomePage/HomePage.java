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
	
	
	@FindBy(xpath="(//span[@class='d-none d-md-inline'])[3]")
	WebElement myAccount;
	
	@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Register']")
	WebElement register;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement login;
	
	@FindBy(xpath="//div[@id='carousel-banner-0']")
	WebElement slider;
	
	@FindBy(xpath="//div[@class='row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-xl-4']")
	WebElement featuredList;
	
	@FindBy(xpath="//div[@id='logo']//a")
	WebElement logo;
	
	@FindBy(xpath="//div[@class='row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-xl-4']")
	WebElement buttonsgrp;
	
	@FindBy(xpath="//div[@id='carousel-banner-1']//div[@class='carousel-inner']")
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
