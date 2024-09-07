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
	
	

}
