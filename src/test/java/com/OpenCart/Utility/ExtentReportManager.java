package com.OpenCart.Utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.OpenCart.Init.SeleniumInit;
import com.OpenCart.Init.common;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager extends SeleniumInit implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	
	String reportName;
	
	public void onStart(ITestContext testContext)
	{
		/*
		 SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.mm.ss");
		 Date dt = new Date();
		 String currentdatetimestamp = df.format(dt);
		 */
		 
		 // or can use below single line code instead of above code
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// single line time stamp code
		reportName = " Test-Report-" + timeStamp + ".html"; // report file name
		sparkReporter = new ExtentSparkReporter("./Reports/"+ reportName); // Specify location to save report html
		
		sparkReporter.config().setDocumentTitle("Opencart Automation Report"); // Title of the Report
		sparkReporter.config().setReportName("Opencart Functional Testing"); // Name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Application", "Opencart"); // project level so added harcoded value
		extentReport.setSystemInfo("Module", "Admin"); // project level so added harcoded value
		extentReport.setSystemInfo("Sub Module" , "Customers"); // project level so added harcoded value
		extentReport.setSystemInfo("User Name", System.getProperty("user.name")); // to get details of user who is testing
		extentReport.setSystemInfo("Enviroment", "QA");
		
		String os = testContext.getCurrentXmlTest().getParameter("os"); // Os details will get from xml file testng/groups/parallel xml
		extentReport.setSystemInfo("Operating System", os);
		
		String browser = testContext.getCurrentXmlTest().getParameter("browser"); // browser details will get from xml file testng/groups/parallel xml
		extentReport.setSystemInfo("Browser", browser);
		
		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups(); // groups details will get from groups.xml if rund from groups.xml
		if(!includedGroups.isEmpty())
		{
			extentReport.setSystemInfo("Groups", includedGroups.toString());
		}
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		extentTest = extentReport.createTest(result.getTestClass().getName()); // To display class name of every test cases
		extentTest.assignCategory(result.getMethod().getGroups());  // To display methods and groups of every test cases
		extentTest.log(Status.PASS, result.getName()+" Successfully Executed");
	}
	
	public void onTestFailure(ITestResult result) {
        extentTest = extentReport.createTest(result.getTestClass().getName());
        extentTest.assignCategory(result.getMethod().getGroups());

        extentTest.log(Status.FAIL, result.getName() + " got failed");
        extentTest.log(Status.INFO, result.getThrowable().getMessage());

        try {
            // Pass the WebDriver from SeleniumInit to the captureScreen method
            if (driver == null) {
                System.err.println("WebDriver is null in extentReportManager.");
            } else {
                String imgPath = new common().captureScreen(driver, result.getName()); // Ensure driver is passed here
                extentTest.addScreenCaptureFromPath(imgPath);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

	
	public void onTestSkipped(ITestResult result)
	{
		extentTest = extentReport.createTest(result.getTestClass().getName());
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.log(Status.SKIP, result.getName()+ "Test got Skipped");
		extentTest.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext testContext)
	{
		
		// Finalize the report
	    extentReport.flush();
	    
	    // Get the current project directory and append the report path
	    String reportPath = System.getProperty("user.dir") + "/Reports/" + reportName;  // Use the correct path
	    
	    // Create a file object for the report
	    File extentReportPath = new File(reportPath);
	    
	    // Try to open the report in the default browser
	    try
	    {
	        if (extentReportPath.exists()) {
	            Desktop.getDesktop().browse(extentReportPath.toURI());
	        } else {
	            System.out.println("Report file does not exist: " + extentReportPath);
	        }
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
		
		
		
	
	// After generating a report and send it to the team automatically
	/*
	try
	{
		URL url = new URL(System.setProperty("./Reports", reportName));
		
		// creating an email message
		ImageHtmlEmail email = new ImageHtmlEmail();
		email.setDataSourceResolver(new DataSourceUrlResolver(url));
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("vsinha224@gmail.com", "password"));
		email.setSSLOnConnect(true);
		email.setFrom("vsinha22@gmail.com"); // sender
		email.setSubject("Test Result");
		email.setMsg("PFA Report ....");
		email.addTo("vsinha630@gmail.com"); // receiver mail
		email.attach(url, "extent report", "Pleae check report...");
		email.send(); // send the mail
		
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	

}
