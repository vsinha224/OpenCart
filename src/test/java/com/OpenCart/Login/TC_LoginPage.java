package com.OpenCart.Login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OpenCart.HomePage.HomePage;
import com.OpenCart.Init.SeleniumInit;
import com.OpenCart.Utility.readConfig;

public class TC_LoginPage extends SeleniumInit{
	
	
	readConfig readconfig = new readConfig();
	@Test(groups={"Sanity","Master"})
	public void LoginPage()
	{
		logger.info("************ Login Page Started ************* ");
		try
		{
		HomePage home = new HomePage(driver);
		home.myAccount();
		home.Login();
		
		
		LoginPage login = new LoginPage(driver);
		
		logger.info("Entering login details");
		login.emailInput(readconfig.getUser());
		login.passwordInput(readconfig.getPassword());
		login.clickSubmit();
		
		LoginPageVerification verify = new LoginPageVerification(driver);
		boolean targetPage = verify.isMyAccountPageExist();
		Assert.assertTrue(targetPage);
		
	}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("************ Login Page Test Ended*********8");
		
	}

}
