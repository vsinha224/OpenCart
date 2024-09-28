package com.OpenCart.Header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.OpenCart.Init.AbstractPage;

public class HeaderSection extends AbstractPage{

	public HeaderSection(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="(//li[@class='nav-item dropdown'])[1]")
	WebElement desktop;
	
	@FindBy(xpath="(//li[@class='nav-item dropdown'])[2]")
	WebElement laptops;
	
	@FindBy(xpath="(//li[@class='nav-item dropdown'])[3]")
	WebElement components;
	
	@FindBy(xpath="(//li[@class='nav-item'])[1]")
	WebElement tablets;
	
	@FindBy(xpath="(//li[@class='nav-item'])[2]")
	WebElement software;
	
	@FindBy(xpath="(//li[@class='nav-item'])[3]")
	WebElement phone;
	
	@FindBy(xpath="(//li[@class='nav-item'])[4]")
	WebElement camera;
	
	@FindBy(xpath="(//li[@class='nav-item dropdown'])[4]")
	WebElement mp3Player;

}
