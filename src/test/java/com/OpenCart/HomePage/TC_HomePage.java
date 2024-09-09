package com.OpenCart.HomePage;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.testng.Assert;
import com.OpenCart.Init.SeleniumInit;

public class TC_HomePage extends SeleniumInit {
	
	@Test(groups= {"Regression", "Master"})
	public void HomePage()
	{
		logger.info("************ Home Page Started ********");
		try {
			
		//Verify Title
		HomePageVerification verification = new HomePageVerification(driver);
		verification.verifyTitle();
		
		//Get element from Home page
		HomePage home = new HomePage(driver); 
		//Verify Nav bar displaying or not
		logger.info("Nav Bar is present");
		Boolean navDisplayed = home.navBar(); 
		Assert.assertTrue(navDisplayed);
		
		// Verifing logo
		logger.info("Logo is available");
		Boolean headerLogo = home.headerLogo();
		Assert.assertTrue(headerLogo);
		
		//very logo url
		logger.info("Verifying logo url");
		home.logoUrl();
		
		String expLogoUrl = "https://demo.opencart.com/en-gb?route=common/home";
		String actLogoUrl = driver.getCurrentUrl();
		
		if(actLogoUrl.equals(expLogoUrl))
		{
			System.out.println("Logo Url is same as expected");
		}else
		{
			System.out.println("Logo Url is not redirect as expected" + expLogoUrl + "But Found" +actLogoUrl);
			Assert.fail();
			
		}
		
		
		
		}
		catch(Exception e)
		{
			System.out.println("Home page exception is " +e);
			Assert.fail();
		}
		
		
		logger.info("************ Home Page Completed ********");
		
	}

}
