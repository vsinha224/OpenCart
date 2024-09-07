package com.OpenCart.MyAccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.OpenCart.Init.AbstractPage;

public class MyAccountPage extends AbstractPage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="(//a[contains(text(),'Logout')])[2]")
	WebElement logout;
	
	
	
	public void clickLogout()
	{
		logout.click();
	}

}
