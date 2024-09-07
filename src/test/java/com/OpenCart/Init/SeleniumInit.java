package com.OpenCart.Init;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import com.OpenCart.Utility.readConfig;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager; //log4j mmanager
import org.apache.logging.log4j.Logger;     // log4j

public class SeleniumInit {
	
	readConfig readconfig = new readConfig();
	public static WebDriver driver;
	
	public Logger logger; // log4j
	
	
	@BeforeClass(groups= {"Regression", "Sanity", "Master"})
	@Parameters({"os", "browser"})
	public void setup(String os, String browser) throws MalformedURLException
	{
		logger=LogManager.getLogger(this.getClass()); //log 4j manager
		
		
		if (readconfig.getEnvironment().equalsIgnoreCase("remote"))
		{
		    DesiredCapabilities capabilities = new DesiredCapabilities();
		    
		    // OS from the xml file
		    if (os.equalsIgnoreCase("mac")) {
		        capabilities.setPlatform(Platform.MAC);
		    } else if (os.equalsIgnoreCase("windows")) {
		        capabilities.setPlatform(Platform.WINDOWS);
		    } 
		    else if(os.equalsIgnoreCase("linux"))
		    {
		    	capabilities.setPlatform(Platform.LINUX);
		    }
		    else {
		        System.out.println("No matching OS found....");
		        return;
		    }
		    
		    // Get the browser from xml
		    switch (browser.toLowerCase()) {
		        case "chrome": 
		            capabilities.setBrowserName("chrome"); 
		            break;
		        case "firefox": 
		            capabilities.setBrowserName("firefox"); 
		            break;
		        case "edge": 
		            capabilities.setBrowserName("MicrosoftEdge"); 
		            break;
		        case "safari": 
		            capabilities.setBrowserName("safari"); 
		            break;
		        case "chromium":
		        	capabilities.setBrowserName("chromium"); 
		            break;
		        default: 
		            System.out.println("No matching browser found...");
		            return;
		    }
		    
		    // launch the Remote browser
		    try {
		        driver = new RemoteWebDriver(new URL("http://192.168.1.3:4444"), capabilities);
		    } catch (MalformedURLException e) {
		        e.printStackTrace();
		    }
		}
		// Executing environment is local
		if(readconfig.getEnvironment().equalsIgnoreCase("local"))
		{
			// select browser to open test cases
			switch(browser.toLowerCase()) // to lower case because no mismatch from xml
			{
			case "chrome" :driver = new ChromeDriver(); 
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath()); break;
			case "firefox" :driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath()); break; // change the path and webdriver as per  firefox
			default :System.out.println("Invalid Browser selected...");return;
			}
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(readconfig.getURL());
		
	}
	
	
	
	
	@AfterClass(groups= {"Regression", "Sanity", "Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	

}
