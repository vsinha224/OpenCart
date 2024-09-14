package com.OpenCart.Init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
	
	public WebDriver driver;
	public Logger logger;
	
	public AbstractPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		logger=LogManager.getLogger(this.getClass()); //log 4j manager
		
	}

}
