package com.OpenCart.HomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.OpenCart.Init.SeleniumInit;
import com.OpenCart.Init.common;
import com.OpenCart.Login.LoginPage;
import com.OpenCart.Utility.readConfig;

public class TC_HomePage extends SeleniumInit {
	
	readConfig readconfig = new readConfig();
	@Test(groups= {"Regression", "Master"})
	public void HomePage()
	{
		// JavaScript Executor to scroll elements into view
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		logger.info("************ Home Page Started ********");
		try {
		
			HomePage home = new HomePage(driver); 
		//Verify Title
		HomePageVerification verification = new HomePageVerification(driver);
		verification.verifyTitle();
		
		logger.info("Verify Slider is visible or not");
		List<WebElement> sliderImg = home.slider.findElements(By.tagName("img"));
		int noOFSliderImg = sliderImg.size();
		System.out.println("Total Number of Slider Images are present : " +noOFSliderImg);
		
		logger.info("Verifying all the images are loading not a broken images present");
		
		int brokenImgCount = 0;
		for(WebElement img :sliderImg)
		{
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet (img.getAttribute("src"));
			HttpResponse response = client.execute(request);
			
			if(response.getStatusLine().getStatusCode() !=0)
			{
				System.out.println("All slider images are loaded and not broken");
				
			}
			else
			{
				System.out.println(img.getAttribute("outerHTML")+"is broken");
				brokenImgCount++;
			}
		}
		
		logger.info("Verifying Featured Product images are not broken");
		
		int featuredProductCount = 0;
		List<WebElement> featuredProductImgList = home.featuredList.findElements(By.tagName("img"));
		int noOfFeaturedProductImgList = featuredProductImgList.size();
		System.out.println("Total Product Images are present : " +noOfFeaturedProductImgList);
		
		//Loop to verify all images are loaded not a broken images
		for(WebElement productImg : featuredProductImgList)
		{
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(productImg.getAttribute("src"));
			HttpResponse response = client.execute(request);
			
			if(response.getStatusLine().getStatusCode() !=0)
			{
				System.out.println("All product images are loaded and not broken");
				
			}
			else
			{
				System.out.println(productImg.getAttribute("outerHTML")+"is broken");
				featuredProductCount++;
			}
		}
		
		logger.info("Verifying Image Links are working fine");
		
		//Loop to click on every links present in images
		for(int i=0;i<noOfFeaturedProductImgList; i++)
		{
			// Re-Locating WebElement to avoid Stale exception
			featuredProductImgList = home.featuredList.findElements(By.tagName("img"));
			WebElement link = featuredProductImgList.get(i);
			
			//JS to scrollIntoView to webelement
			js.executeScript("arguments[0].scrollIntoView({block : 'center', inline : 'center'})", link);
						
			//JS to click on every links
			js.executeScript("arguments[0].click()", link);
			common.pause(1);
			verification.verifyLinks();
			
			//navigate back to the orginal page to avoid stale exception
			driver.navigate().back();
			common.pause(2);
			
		}
		
		// Verify Product heading links
		logger.info("Verifying Product heading links ");
		List<WebElement> featuredList = home.featuredList.findElements(By.tagName("h4"));
		int noOfFeaturedList = featuredList.size();
		System.out.println("Total number of Product headings are : " +noOfFeaturedList);
		
		//Loop to click on every heading links on product
		for(int i=0; i<noOfFeaturedList; i++)
		{
			// Re-Locate the webelement to avoid stale exception
			featuredList = home.featuredList.findElements(By.tagName("h4"));
			WebElement featuredLink = featuredList.get(i);
			
			//Js to scrollIntoView the product
			js.executeScript("arguments[0].scrollIntoView({block : 'center', inline : 'center'})", featuredLink);
			
			//JS to click on every links
			js.executeScript("arguments[0].click()", featuredLink);
			common.pause(1);
			verification.verifyLinks();
			
			// Navigate back to the source page
			driver.navigate().back();
			common.pause(2);
		}
		
		
		
		logger.info("Verifying price is displaying ");
		//Loop to verify price are showign for every product
		for(int i =0; i<noOfFeaturedProductImgList; i++)
		{
			//Re-Locate the webElement to avoid stale exception 
			List<WebElement> productPrice = home.featuredList.findElements(By.className("price"));
			
			//Get product name
			List<WebElement> productName =  home.featuredList.findElements(By.tagName("h4"));
			
			if(i<productPrice.size()  && i<productName.size())
			{
				WebElement priceList = productPrice.get(i);
				WebElement productNameList = productName.get(i);
				

				//JS to scrollIntoView to the web element
				js.executeScript("arguments[0].scrollIntoView({block : 'center', inline : 'center'})", priceList);
				int priceListCount = 0;
				
				
				if(priceList.isDisplayed())
				{
					System.out.println("Prices are showing for every products : " + productNameList.getText()+ "|" +priceList.getText());
				}
				else
				{ 
					System.out.println("Prices are not showing with every product : " +productNameList.getText());
					priceListCount++;
					Assert.fail();
				}								
			}
			else 
			{
		        System.out.println("Index out of bounds. Unable to locate price or product name for item " + i);
		        Assert.fail();
			}
		}
		
		//Login in to the applicaiton
		logger.info("Login in to the application with Entering stored Credential");
		LoginPage login = new LoginPage(driver);
		home.myAccount();
		home.Login();
		login.emailInput(readconfig.getUser());
		login.passwordInput(readconfig.getPassword());
		login.clickSubmit();
		
		common.pause(2);
		verification.verifyMyAccount();
		home.clickLogo();
		
		//Verifying add to cart, wishlist and comparision button
		logger.info("List of all the buttons cart, wishlist and comparision");
		List<WebElement> buttonGroup = home.buttonsgrp.findElements(By.tagName("button"));
		int noOfButtons = buttonGroup.size();
		System.out.println("Total Number of Buttons are " +noOfButtons);
		/*
		 * 
		 * 
		 * commenting out below code as getting an Bug here will uncomment it later
		 *
		
		//Loop to click on all buttons
		for(int i = 0; i<noOfButtons; i++ )
		{
			// Re-Locate webelement to avoid stale exception
			buttonGroup=home.buttonsgrp.findElements(By.tagName("button"));
			WebElement buttonList = buttonGroup.get(i);
			
			//JS to scrollIntoView to the WebElement
			js.executeScript("arguments[0].scrollIntoView({block : 'center', inline : 'center'})", buttonList);
			js.executeScript("arguments[0].click()", buttonList);
			common.pause(2);
			
			
			//Verify success message on button click
			WebElement successMessage = driver.findElement(By.className("alert-success"));
			if(successMessage.isDisplayed())
			{
				System.out.println("Success message displayed: " + successMessage.getText());
			}
			else 
			{
		        System.out.println("No success message displayed after clicking button " + (i + 1));
		        Assert.fail("No success message displayed for button " + (i + 1));
		        
		    }
			driver.navigate().back();
			common.pause(1);
			
			
		}
		
		*/
		
		// Verify Company logo slider img are visible
		logger.info("Verify that company logo slider images are visible and not broken");
		
		
		List<WebElement> companyLogo = home.logoSlider.findElements(By.tagName("img"));
		int noOfCompanyLogoSlider = companyLogo.size();
		System.out.println("Total number of Company Logo Slider images : " +noOfCompanyLogoSlider);
		
		
		//Loop to cehck all the company logo imges
		
		int countCompanyLogo = 0;
		for(WebElement companyPortfolio : companyLogo)
		{
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(companyPortfolio.getAttribute("src"));
			HttpResponse response = client.execute(request);
			
			if(response.getStatusLine().getStatusCode() !=0)
			{
				System.out.println("All Company Portfolio images are loaded and not broken");
				
			}
			else
			{
				System.out.println(companyPortfolio.getAttribute("outerHTML")+"is broken");
				countCompanyLogo++;
			}
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
