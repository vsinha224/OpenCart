package com.OpenCart.HomePage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.OpenCart.Init.AbstractPage;

public class HomePageVerification extends AbstractPage{

	public HomePageVerification(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public Boolean verifyTitle()
	{
		String expectedTitle = "Your Store";
        String actTitle = driver.getTitle();

        if (expectedTitle.equals(actTitle)) {
            // Title matches, no action needed.
            System.out.println("Title matched");
            return true;
        } else {
            // Title does not match, fail the test.
            System.out.println("Title Not matched");
            Assert.fail("Title didn't match as expected: Expected '" + expectedTitle + "', but found '" + actTitle + "'");
            return false;
        }
	
	}
}
