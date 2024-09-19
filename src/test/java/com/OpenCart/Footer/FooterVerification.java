package com.OpenCart.Footer;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.OpenCart.Init.AbstractPage;

public class FooterVerification extends AbstractPage{

	public FooterVerification(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
		public boolean currentPageTitle()
		{
			int count = 0;
			String pageTitle = driver.getTitle();
			
			if(pageTitle.contains("Page not found"))
			{
				count++;
//				logger.error("Test Failed Expected Links not found");
				
				Assert.fail("Broken links are there ");
				return false;
			}
			else {
				System.out.println("All links are working fine");
				return true;
			}
		}
	
		
	
	
	
	
	
}
