package com.OpenCart.HomePage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.OpenCart.Init.AbstractPage;

public class HomePageVerification extends AbstractPage{

	public HomePageVerification(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean verifyTitle()
	{
		String expectedTitle = "Your Store";
        String actTitle = driver.getTitle();

        if (expectedTitle.equals(actTitle)) {
            // Title matches, no action needed.
            System.out.println("Title matched");
            return true;
        } else {
            // Title does not match, fail the test.
            System.out.println("Title Not matched");
            Assert.fail("Title didn't match as expected: Expected '" + expectedTitle + "', but found '" + actTitle + "'");
            return false;
        }
	
	}
	
	public boolean verifyLinks()
	{
		String curPageTitle = driver.getTitle();
		int count = 0;
		
		if(curPageTitle.contains("Page not found"))
		{
			count++;
			Assert.fail("Page redirected to Page not found ");
			return false;
		}
		else
		{
			System.out.println("images link are working fine");
			return true;
		}
	}
	
	public boolean verifyMyAccount()
	{
		String expTitle = "My Account";
		String actTitle = driver.getTitle();
		if(expTitle.equalsIgnoreCase(actTitle))
		{
			System.out.println("My Account Title Passed");
			return true;
		}
		else
		{
			
			Assert.fail("My Account Title not matched");
			return false;
		}
	}
	
	/*
	
	 
	 
	 
	 */
	
	
	
	
	
	
	
	
}
