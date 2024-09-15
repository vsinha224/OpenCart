package com.OpenCart.Footer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OpenCart.Init.SeleniumInit;
import com.OpenCart.Init.common;

public class TC_Footer extends SeleniumInit{
	
	@Test(groups= {"Regression", "Master"})
	
	public void footer()
	{
		logger.info("************** Footer Started *************");
		
		try
		{
			FooterSection footer = new FooterSection(driver);
			
			FooterVerification verify = new FooterVerification(driver);
			logger.info("Clicking on every footer links");
			
		/*
		 * 
		 * 
		 * Get the list of all the footer menus
		 * 
		 * 
		 * 	
		 */
		
			logger.info("Verifying Information links");
			List<WebElement> informationLinks = footer.information.findElements(By.tagName("a"));
			
			int noOfInformationLinks = informationLinks.size();
			
			System.out.println("Total no of Information links are : " + noOfInformationLinks);
			
			for(int i = 0; i<noOfInformationLinks; i++)
			{
//				common.screenScroll((WebElement) informationLinks );
				informationLinks.get(i).click();
				common.pause(3);
				verify.currentPageTitle();
				driver.navigate().back();

				
			}
			
			logger.info("Verifying Customer Services link");
			List<WebElement> customerLinks = footer.customerservices.findElements(By.tagName("a"));
			
			int noOfCustomerLinks = customerLinks.size();
			System.out.println("Total no of Customer services links are : " + noOfCustomerLinks);
			
			for(int i = 0; i<noOfCustomerLinks;i++)
			{
//				common.screenScroll((WebElement) customerLinks );
				customerLinks.get(i).click();
				common.pause(3);
				verify.currentPageTitle();
				driver.navigate().back();
				
			}
			
			logger.info("Verifying Extras link");
			List<WebElement> extrasLinks = footer.extra.findElements(By.tagName("a"));
			
			int noOfextrasLinks = extrasLinks.size();
			System.out.println("Total no of Customer services links are : " + noOfextrasLinks);
			
			for(int i = 0; i<noOfextrasLinks;i++)
			{
//				common.screenScroll((WebElement) extrasLinks );
				extrasLinks.get(i).click();
				common.pause(3);
				verify.currentPageTitle();
				driver.navigate().back();
			}
			
			logger.info("Verifying My Account link");
			List<WebElement> myAccountLinks = footer.myaccount.findElements(By.tagName("a"));
			
			int noOfmyAccountLinks = myAccountLinks.size();
			System.out.println("Total no of Customer services links are : " + noOfmyAccountLinks);
			
			for(int i = 0; i<noOfmyAccountLinks;i++)
			{
//				common.screenScroll((WebElement) myAccountLinks );
				myAccountLinks.get(i).click();
				common.pause(3);
			    verify.currentPageTitle();							
				
				driver.navigate().back();
				
			}
			
		
	// verify powered by link
			logger.info("Verify Powered By link");
			footer.poweredBy();
			
			
		}
		catch(Exception e)
		{
			logger.error("Footer test cases failed and Exception occured : " +e.getMessage());
			
			Assert.fail();
		}
		
		
		logger.info("************** Footer Completed *************");
		
	

	}
}
