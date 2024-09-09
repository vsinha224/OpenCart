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
	
	@FindBy(xpath= "//nav[@id='menu']")
	WebElement nav;
	
	@FindBy(xpath="//a[normalize-space()='Desktops']")
	WebElement desktops;
	
	@FindBy(xpath="//a[normalize-space()='Laptops & Notebooks']")
	WebElement laptopsNotebooks;
	
	@FindBy(xpath="//a[normalize-space()='Components']")
	WebElement components;
	
	@FindBy(xpath="//a[normalize-space()='Tablets']")
	WebElement tablets;
	
	@FindBy(xpath="//a[normalize-space()='Software']")
	WebElement software;
	
	@FindBy(xpath="//a[normalize-space()='Phones & PDAs']")
	WebElement phones;
	
	@FindBy(xpath="//a[normalize-space()='Cameras']")
	WebElement cameras;
	
	@FindBy(xpath="//a[normalize-space()='MP3 Players']")
	WebElement mp3players;
	
	//header
	@FindBy(xpath="//img[@title='Your Store']")
	WebElement logo;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement search;
	
	
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
	
	
	public Boolean navBar()
	{
		try {
			return(nav.isDisplayed());
			
		}catch(Exception e)
		{
			return false;
		}
		
	}
	public Boolean desktopsMenu()
	{
		try {
			return(desktops.isDisplayed());
		}catch(Exception e)
		{
			return false;
		}
	}
	
	public Boolean headerLogo()
	{
		try {
			return(logo.isDisplayed());
		}catch(Exception e)
		{
			return false;
		}
	}
	public void logoUrl()
	{
		logo.click();
	}
	

}
