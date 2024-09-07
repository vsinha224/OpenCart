package com.OpenCart.Login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OpenCart.HomePage.HomePage;
import com.OpenCart.Init.SeleniumInit;
import com.OpenCart.Init.common;
import com.OpenCart.MyAccount.MyAccountPage;
import com.OpenCart.Utility.DataProviders;

public class TC_LoginPageDDT extends SeleniumInit {
    
    @Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven") // Getting data providers class from another class which is in another package
    public void LoginDDT(String email, String pwd, String exp)
    {
        logger.info("********** Started TC_LoginPage DDT Test ***********");
        try {
            
            // Navigate to home page
            HomePage home = new HomePage(driver);
            home.myAccount();	
            home.Login();
            
            // Wait for the login page to load
            LoginPage login = new LoginPage(driver);
            
            logger.info("Entering login details");
            login.emailInput(email);
            login.passwordInput(pwd);
            login.clickSubmit();
            
            // My account page verification
            LoginPageVerification verify = new LoginPageVerification(driver);
            boolean targetPage = verify.isMyAccountPageExist();
            
            
/*
 * 
 * Data is valid  -- login success  -- test pass -- logout
 * Data is valid -- login failed -- test fail
 * 
 * Data is invalid -- login success -- test fail -- logout
 * Data is invalid -- login fail -- test pass
 * 
 * 
 * 
 */ 
                      
          // Validate based on expected result from data provider
            MyAccountPage myaccount = new MyAccountPage(driver);
  
            if(exp.equalsIgnoreCase("Valid"))
             	
            {
            	if(targetPage==true)	 
            	{
            		logger.info("Login successful, logging out...");
            		myaccount.clickLogout();
            		
            		Assert.assertTrue(true);
            	}
            	else
            	{
            		 logger.error("Login failed when valid credentials were expected.");
            		Assert.assertTrue(false);
            	}
            }
            else if(exp.equalsIgnoreCase("Invalid"))
            {
            	if(targetPage==true)
            	{
            		logger.error("Login successful when invalid credentials were expected.");
            		myaccount.clickLogout();
            		
            		Assert.assertTrue(false);
            	}
            	else
            	{
            		logger.info("Login failed as expected with invalid credentials.");
            		Assert.assertTrue(true);
            	}
            }
            
            
        } 
        catch (Exception e) {
            logger.error("Test encountered an exception: " + e.getMessage());
            Assert.fail();
        }
        common.pause(3);
        
        logger.info("********** Completed TC_LoginPage DDT Test ***********");
    }
}
