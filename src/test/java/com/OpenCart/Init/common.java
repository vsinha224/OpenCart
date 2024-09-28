package com.OpenCart.Init;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class common {
	
	private static WebDriver driver;
	
	/*
	 * Random number and String generator
	 */
	public static String  randomString()
	{
		String generatedString  = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public static String randomNumber()
	{
		String generatedNumbber = RandomStringUtils.randomNumeric(10);
		return generatedNumbber;
	}
	
	public static String randomAlphaNumeric()
	{
		String generatedString = RandomStringUtils.randomAlphanumeric(5);
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		return(generatedString+"@"+generatedNumber);
	}
	
	/*
	 * Sleep method
	 */
	public static void pause(int sec)
	{
		try {
			Thread.sleep(sec * 1000);
		}
		catch(InterruptedException interruptedException)
		{
			interruptedException.getStackTrace();
//			System.out.println("Pause Exception " + e.getMessage());
		}
	}
	
	/*
	 * Explicit wait
	 */
//	public static void expWait(WebDriver driver, Duration sec, By locator)
//	{
//		try {
//	        WebDriverWait wait = new WebDriverWait(driver, sec);
//	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//	    } 
//		catch (Exception e) 
//		{
//	        e.printStackTrace(); // This will print the stack trace
//	    }
//		
//	}
	
	
	@SuppressWarnings("deprecation")
	public static void wait(String wait)
	{
		try {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}
	
	
	
	//on test fail screenshot 
		// Screenshot method
		
	 // Updated to take driver as an argument and handle the null case
    public String captureScreen( WebDriver driver, String tname) {
        // Check if driver is null
        if (driver == null) {
            System.err.println("WebDriver instance is null! Cannot capture screenshot.");
            throw new RuntimeException("WebDriver instance is null. Unable to take screenshot.");
        }

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);  // Use the driver instance here
        String targetDir = System.getProperty("user.dir") + "/Screenshots/";
        String targetFilePath = targetDir + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        try {
            File screenshotDir = new File(targetDir);
            if (!screenshotDir.exists()) {
                screenshotDir.mkdir();
            }
            FileUtils.copyFile(sourceFile, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return targetFilePath;
    }
    
    
	
	
	
	
}
