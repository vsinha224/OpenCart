package com.OpenCart.Footer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
			
			//JavaScript executor
			JavascriptExecutor js =  (JavascriptExecutor) driver;
			
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
				// Re-Locating webelement to avoid stale exception
				informationLinks = footer.information.findElements(By.tagName("a"));
				WebElement infoLinks = informationLinks.get(i);
				
				//JS to scrollIntoView to webelement
				js.executeScript("arguments[0].scrollIntoView({block : 'center', inline : 'center'})", infoLinks);
							
				//JS to click on every links
				js.executeScript("arguments[0].click()", infoLinks);
				common.pause(1);
				
				verify.currentPageTitle();
				driver.navigate().back();
				common.pause(2);

				
			}
			
			logger.info("Verifying Customer Services link");
			List<WebElement> customerLinks = footer.customerservices.findElements(By.tagName("a"));
			
			int noOfCustomerLinks = customerLinks.size();
			System.out.println("Total no of Customer services links are : " + noOfCustomerLinks);
			
			for(int i = 0; i<noOfCustomerLinks;i++)
			{
				//Re-locating webElement to avoid stale exception
				customerLinks = footer.customerservices.findElements(By.tagName("a"));
				WebElement custLinks = customerLinks.get(i);
				
				//JS to scroll to webelement
				js.executeScript("arguments[0].scrollIntoView({block : 'center', inline :'center'})", custLinks);
				
				//JS to click on every inks
				js.executeScript("arguments[0].click()", custLinks);
				common.pause(1);
				
				verify.currentPageTitle();
				driver.navigate().back();
				common.pause(2);
				
			}
			
			logger.info("Verifying Extras link");
			List<WebElement> extrasLinks = footer.extra.findElements(By.tagName("a"));
			
			int noOfextrasLinks = extrasLinks.size();
			System.out.println("Total no of Customer services links are : " + noOfextrasLinks);
			
			for(int i = 0; i<noOfextrasLinks;i++)
			{
				//Re-locating WebElement to avoid stale exception
				extrasLinks = footer.extra.findElements(By.tagName("a"));
				WebElement footLinks = extrasLinks.get(i);
				
				//JS to scroll to webelement
				js.executeScript("arguments[0].scrollIntoView({block : 'center', inline :'center'})", footLinks);
				
				//JS to click on every inks
				js.executeScript("arguments[0].click()", footLinks);
				
				common.pause(1);
				verify.currentPageTitle();
				driver.navigate().back();
				common.pause(2);
			}
			
			logger.info("Verifying My Account link");
			List<WebElement> myAccountLinks = footer.myaccount.findElements(By.tagName("a"));
			
			int noOfmyAccountLinks = myAccountLinks.size();
			System.out.println("Total no of Customer services links are : " + noOfmyAccountLinks);
			
			for(int i = 0; i<noOfmyAccountLinks;i++)
			{
				//Re-locating webelement
				myAccountLinks = footer.myaccount.findElements(By.tagName("a"));
				WebElement accLinks = myAccountLinks.get(i);
				
				//JS to scroll to webelement
				js.executeScript("arguments[0].scrollIntoView({block : 'center', inline :'center'})", accLinks);
				
				//JS to click on every inks
				js.executeScript("arguments[0].click()", accLinks);
				
				common.pause(1);
			    verify.currentPageTitle();							
				
				driver.navigate().back();
				common.pause(2);
				
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
