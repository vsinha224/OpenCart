package com.OpenCart.HomePage;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OpenCart.Init.common;
import com.OpenCart.Init.SeleniumInit;

public class TC_HomePage extends SeleniumInit {
	
	@Test
	public void HomePage()
	{
		HomePage home = new HomePage(driver);
		
		String expectedTitle = "Your Store";
		String actTitle = driver.getTitle();
		
		if(actTitle.equalsIgnoreCase(expectedTitle))
		{
			
			Assert.assertTrue(true, "Title matched");
			
		}
		else
		{
			Assert.assertFalse(false, "Title not matched ");
			
		}
		
//		home.myAccount();
//		common.pause(1);
//		home.Login();
//		home.register();
		
		
		
		
		
		
	}

}
