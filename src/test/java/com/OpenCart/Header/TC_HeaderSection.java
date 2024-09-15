package com.OpenCart.Header;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OpenCart.Init.SeleniumInit;
import com.OpenCart.Init.common;

public class TC_HeaderSection extends SeleniumInit {
	
	@Test(groups = {"Master", "Regression"})
	public void headerSection() {
		logger.info("************** Header Section Started *************");
		
		try {
			HeaderSection header = new HeaderSection(driver);
			HeaderVerification verify = new HeaderVerification(driver);
			
			logger.info("Checking all links present in the header");
			
			logger.info("Verifying Desktop links present");
			
			// JavaScript Executor to scroll elements into view
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			// Find links in the desktop dropdown
			List<WebElement> desktopLinks = header.desktop.findElements(By.tagName("a"));
			int noOfDesktopLinks = desktopLinks.size();
			System.out.println("Total number of desktop links: " + noOfDesktopLinks);
			
			//loop to click on every link to very for any broken links
			for(int i=0; i<noOfDesktopLinks; i++)
			{
				//Re-locate the links after every click to avoid stale element exception
				desktopLinks = header.desktop.findElements(By.tagName("a"));
				WebElement links = desktopLinks.get(i);
				
				//Js executor to scroll into view using javaScript
				js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", links);
				
				//click the link by using javaScript
				js.executeScript("arguments[0].click()", links);
				common.pause(1);
				verify.headerVerification();
				
				//Navigate back to the orginal page to avoid stale exception
				driver.navigate().back();
				
				// wait to load the page
				common.pause(1);
				
			}
			
			
		logger.info("verify Laptops and Notebooks links are working");	
		List<WebElement> laptopsLink = header.laptops.findElements(By.tagName("a"));
		
		int noOfLaptopsLink = laptopsLink.size();
		System.out.println("Total number of links present in Laptops and Notebook are : " +noOfLaptopsLink);
		
		//loop to click on all the links present 
		for(int i=0;i<noOfLaptopsLink;i++)
		{
			// Re-locate the WebElement to avoid Stale exception
			laptopsLink = header.laptops.findElements(By.tagName("a"));
			WebElement links = laptopsLink.get(i);
			
			//Js Executor to scroll to view the Web Element
			js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'})", links);
			
			// click the link by javaScript
			js.executeScript("arguments[0].click()", links);
			common.pause(1);
			verify.headerVerification();
			
			driver.navigate().back();
			common.pause(1);
			
		}
		
		logger.info("Verify Components menu links");
		List<WebElement> componentsLink = header.components.findElements(By.tagName("a"));
		int noOfComponentsLink = componentsLink.size();
		System.out.println("Total Number of Components links are : " +noOfComponentsLink);
		
		for(int i=0; i<noOfComponentsLink; i++)
		{
			// Re-locate the webElement to avoid Stale exception
			componentsLink = header.components.findElements(By.tagName("a"));
			WebElement links = componentsLink.get(i);
			
			//JS Executor to scroll to view the WebElement
			js.executeScript("arguments[0].scrollIntoView({block:'center', inline : 'center'})", links);
			
			//clikc the link by using java Script
			js.executeScript("arguments[0].click()", links);
			common.pause(1);
			verify.headerVerification();
			
			// Navigate back to the orginal page to avoid stale exception
			driver.navigate().back();
			common.pause(1);
			
		}
		
		logger.info("Verify tablets menu links");
		List<WebElement> tabletsLink = header.tablets.findElements(By.tagName("a"));
		int noOfTabletsLink = tabletsLink.size();
		System.out.println("Total links are present in Tablet menu are : " +noOfTabletsLink);
		
		// Loop to verify all the links
		for(int i=0; i<noOfTabletsLink; i++)
		{
			// Re-Locate the WebElement to avoid the stale exception
			tabletsLink = header.tablets.findElements(By.tagName("a"));
			WebElement links = tabletsLink.get(i);
			
			//Js to scroll to view the WebElement
			js.executeScript("arguments[0].scrollIntoView({block : 'center', inline : 'center'})", links);
			
			//Js to click on every links present
			js.executeScript("arguments[0].click()", links);
			common.pause(1);
			verify.headerVerification();
			
			// navigate back to the orginal page to avoid stale exceptions
			driver.navigate().back();
			common.pause(1);
		}
		
		logger.info("Verify Software Menu Links");
		List<WebElement> softwareLinks = header.software.findElements(By.tagName("a"));
		int noOfSoftwareLinks = softwareLinks.size();
		System.out.println("Total number of Links are present in Software Menu : " +noOfSoftwareLinks);
		
		//Loop to clivk on every links present in software menus
		
		for(int i=0; i<noOfSoftwareLinks; i++)
		{
			//Re-locate the WebElement to avoid Stale exception
			softwareLinks = header.software.findElements(By.tagName("a"));
			
			WebElement links = softwareLinks.get(i);
			
			//JS to scroll to view the Web Elements
			js.executeScript("arguments[0].scrollIntoView({block : 'center', inline : 'center'})", links);
			
			//Js to clikc on the links
			js.executeScript("arguments[0].click()", links);
			common.pause(1);
			verify.headerVerification();
			
			// Navigate back to the orginal page to avoid stale exception
			driver.navigate().back();
			common.pause(1);
			
			
		}
		
		logger.info("Verify Phones & PDA menu links ");
		List<WebElement> phoneLinks = header.phone.findElements(By.tagName("a"));
		int noOfPhoneLinks = phoneLinks.size();
		
		System.out.println("Total links are present in Phone & PDA are : " +noOfPhoneLinks);
		
		//Loop to click on present menu under phone and pds
		for(int i=0; i<noOfPhoneLinks; i++)
		{
			// Re-locate WebElement to avoid stale exceptopn
			phoneLinks = header.phone.findElements(By.tagName("a"));
			WebElement links = phoneLinks.get(i);
			
			// JS to scroll to view the web Element
			js.executeScript("arguments[0].scrollIntoView({block : 'center', inline : 'center'})", links);
			
			//JS to click on every present links
			js.executeScript("arguments[0].click()", links);
			common.pause(1);
			verify.headerVerification();
			
			// navigate back to the source page to avoid stale exception
			driver.navigate().back();
			common.pause(1);
			
		}
		
		logger.info("Verify camera links");
		List<WebElement> cameraLinks = header.camera.findElements(By.tagName("a"));
		int noOfCameraLinks = cameraLinks.size();
		System.out.println("Total no of camera links are present : " +noOfCameraLinks);
		
		//loop to click on every element
		for(int i=0; i<noOfCameraLinks; i++)
		{
			// Re-locate webElement to avoid stale exception
			cameraLinks = header.camera.findElements(By.tagName("a"));
			WebElement links = cameraLinks.get(i);
			
			//JS to scroll to view
			js.executeScript("arguments[0].scrollIntoView({block : 'center', inline : 'center'})", links);
			
			// JS to click on present links
			js.executeScript("arguments[0].click()", links);
			common.pause(1);
			verify.headerVerification();
			
			// navigate back to orginal page to avoid stale exception
			driver.navigate().back();
			common.pause(1);
			
		}
		
		
		logger.info("Verify links present in MP3 Player Menu");
		
		
		List<WebElement> mp3Links = header.mp3Player.findElements(By.tagName("a"));
		
		common.pause(2); // Give time for the dropdown to open
		
		int noOfMp3Links = mp3Links.size();
		System.out.println("Total links are present in MP3 Player : " +noOfMp3Links);
		
		//Loop to click on present links
		for(int i =0; i<noOfMp3Links; i++)
		{
			// Re-Locate the webelement to avoid stale exception
			mp3Links = header.mp3Player.findElements(By.tagName("a"));
			WebElement links = mp3Links.get(i);
			
			//Js Executor to scroll to view the Web Element
			js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'})", links);
			
			// click the link by javaScript
			js.executeScript("arguments[0].click()", links);
			common.pause(1);
			verify.headerVerification();
			
			driver.navigate().back();
			common.pause(2);
		}
			
		} catch (Exception e) {
			logger.error("Header test cases failed and Exception occurred: " + e.getMessage());
			Assert.fail();
		}
		
		logger.info("************** Header Section Completed *************");
	}
}
