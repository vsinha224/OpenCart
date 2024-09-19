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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumInit {

    readConfig readconfig = new readConfig();
    public static WebDriver driver;  
    public Logger logger;

    @BeforeClass(groups = {"Regression", "Sanity", "Master"})
    @Parameters({"os", "browser"})
    public void setup(String os, String browser) throws MalformedURLException {
        logger = LogManager.getLogger(this.getClass());

        if (readconfig.getEnvironment().equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            } else if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WINDOWS);
            } else if (os.equalsIgnoreCase("linux")) {
                capabilities.setPlatform(Platform.LINUX);
            } else {
                System.out.println("No matching OS found....");
                return;
            }

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
                default:
                    System.out.println("No matching browser found...");
                    return;
            }

            driver = new RemoteWebDriver(new URL("http://192.168.1.3:4444"), capabilities);
        } else if (readconfig.getEnvironment().equalsIgnoreCase("local")) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("Invalid Browser selected...");
                    return;
            }
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(readconfig.getURL());

        // Add a check to ensure driver is not null
        if (driver == null) {
            throw new RuntimeException("WebDriver initialization failed.");
        }
    }

    @AfterClass(groups = {"Regression", "Sanity", "Master"})
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
