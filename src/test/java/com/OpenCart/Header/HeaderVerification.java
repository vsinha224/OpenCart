package com.OpenCart.Header;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.OpenCart.Init.AbstractPage;

public class HeaderVerification extends AbstractPage{

	public HeaderVerification(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean headerVerification()
	{
		int count = 0;
		String curPageTitle = driver.getTitle();
		if(curPageTitle.contains("Page not found"))
		{
			count++;
			Assert.fail("Broken link found in header");
			return false;
		}
		else
		{
			System.out.println("header links ar fine");
			return true;
		}
	}

}
