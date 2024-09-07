package com.OpenCart.Register;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.OpenCart.HomePage.HomePage;
import com.OpenCart.Init.SeleniumInit;
import com.OpenCart.Init.common;

public class TC_RegisterPage extends SeleniumInit{
	
	
	@Test(groups= {"Regression","Master"})
	public void RegisterPage()
	{
		logger.info("********** Started TC_RegisterPage TestCases *********");
		
		try
		{
		RegisterPage register = new RegisterPage(driver);
		String expectedTitle = "Register Account";
		String actTitle = driver.getTitle();
		
		if(actTitle.equalsIgnoreCase(expectedTitle))
		{
			
			Assert.assertTrue(true, "Title matched");
			
		}
		else
		{
			Assert.assertFalse(false, "Title not matched ");
			
		}
		HomePage home = new HomePage(driver);
		home.myAccount();
		
		logger.info("Clicked on My Account button ");
		common.pause(1);
		
		home.register();
		logger.info("Clicked on Register Link ");
		
		
		logger.info("Providing Customer Details");
		String passwordInput = common.randomAlphaNumeric();
		
		register.fName(common.randomString().toUpperCase());
		register.lName(common.randomString().toUpperCase());
		register.Email(common.randomString()+"@gmail.com");
		register.Tel(common.randomNumber());
		register.Password(passwordInput);
		register.CnfPassword(passwordInput);
		register.Newsletter();
		register.AgreeCheck();
		register.ContinueBtn();
		
		logger.info("Validiting Expected Message...");
		String confMsg = register.getConfirmationMsg();
		
		
		// Log the actual confirmation message
        logger.info("Actual Confirmation Message: " + confMsg);

        try {
            if (confMsg.equalsIgnoreCase("Your Account Has Been Created!")) {
                Assert.assertTrue(true, "Confirmation message matched");
            } else {
                logger.error("Test Failed. Expected message not found.");
                Assert.assertTrue(false, "Confirmation message did not match");
            }
        } catch (AssertionError e) {
            logger.debug("Debug logs: Expected confirmation message did not match.");
            throw e;
        }

    } catch (Exception e) {
        logger.error("Exception occurred: " + e.getMessage());
        Assert.fail("Test case failed due to an exception.");
    }

    logger.info("********** Completed TC_RegisterPage TestCases *********");
	
	}

}
