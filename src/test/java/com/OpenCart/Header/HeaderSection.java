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
	
	@FindBy(xpath="(//li[@class='dropdown'])[2]")
	WebElement desktop;
	
	@FindBy(xpath="(//li[@class='dropdown'])[3]")
	WebElement laptops;
	
	@FindBy(xpath="(//li[@class='dropdown'])[4]")
	WebElement components;
	
	@FindBy(xpath="//nav[@id='menu']/div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul[@class='nav navbar-nav']/li[4]")
	WebElement tablets;
	
	@FindBy(xpath="//nav[@id='menu']/div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul[@class='nav navbar-nav']/li[5]")
	WebElement software;
	
	@FindBy(xpath="//nav[@id='menu']/div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul[@class='nav navbar-nav']/li[6]")
	WebElement phone;
	
	@FindBy(xpath="//nav[@id='menu']/div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul[@class='nav navbar-nav']/li[7]")
	WebElement camera;
	
	@FindBy(xpath="//nav[@id='menu']/div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul[@class='nav navbar-nav']/li[8]")
	WebElement mp3Player;

}
