package com.OpenCart.Footer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.OpenCart.Init.AbstractPage;

public class FooterSection extends AbstractPage {

	public FooterSection(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//footer//div[@class='row']//div[1]//ul[1]")
	WebElement information;
	
	@FindBy(xpath="//footer//div[2]//ul[1]")
	WebElement customerservices;
	
	@FindBy(xpath="//footer//div[3]//ul[1]")
	WebElement extra;
	
	@FindBy(xpath="//footer//div[4]//ul[1]")
	WebElement myaccount;
	
	@FindBy(xpath="//a[normalize-space()='OpenCart']")
	WebElement poweredby;
	
	
	
	public void poweredBy()
	{
		poweredby.click();
	}
	

}






