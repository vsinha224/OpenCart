package com.OpenCart.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.OpenCart.Init.AbstractPage;

public class LoginPage extends AbstractPage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	
	
	public void emailInput(String emailInput)
	{
		email.sendKeys(emailInput);
	}
	
	public void passwordInput(String passwordInput)
	{
		password.sendKeys(passwordInput);
	}
	
	public void clickSubmit()
	{
		submit.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
