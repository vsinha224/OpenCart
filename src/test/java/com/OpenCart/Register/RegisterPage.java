package com.OpenCart.Register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.OpenCart.Init.AbstractPage;
import com.OpenCart.Init.common;

public class RegisterPage extends AbstractPage{

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	@FindBy(id="input-firstname")
	WebElement fname;
	
	@FindBy(id="input-lastname")
	WebElement lname;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement tel;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement cnfPassword;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement newsletter;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agreeCheck;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueBtn;
	
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	public void fName(String fName)
	{
		fname.sendKeys(fName);
	}
	
	public void lName(String lName)
	{
		lname.sendKeys(lName);
	}
	
	public void Email(String Email)
	{
		email.sendKeys(Email);
	}
	
	public void Tel(String Tel)
	{
		tel.sendKeys(Tel); 
	}
	
	public void Password(String Password)
	{
		password.sendKeys(Password);
	}
	
	public void CnfPassword(String ConfPassword)
	{
		cnfPassword.sendKeys(ConfPassword);
	}
	
	public void Newsletter()
	{
		newsletter.click();
	}
	
	public void AgreeCheck()
	{
		agreeCheck.click();
	}
	
	public void ContinueBtn()
	{
		continueBtn.click();
	}
	
	
	public String getConfirmationMsg()
	{
		try
		{
			return(msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	
	
	
	

}
