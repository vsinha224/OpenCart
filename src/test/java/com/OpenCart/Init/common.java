package com.OpenCart.Init;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

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
	
	
	//For test fail screenshot 
	// Screenshot method
    public String captureScreen(String tname) 
    {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // Construct the target file path
        String targetDir = System.getProperty("user.dir") + "/Screenshots/";
        String targetFilePath = targetDir + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        try {
            // Create directory if not exists
            File screenshotDir = new File(targetDir);
            if (!screenshotDir.exists()) {
                screenshotDir.mkdir();
            }

            // Copy screenshot to the target location
            FileUtils.copyFile(sourceFile, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return targetFilePath;
    }
	
	
	
	
	
}
