package com.OpenCart.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {
	
	Properties pro;
	
	public readConfig()
	{
		File src  = new File("./Configuration/config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("File Exception is " + e.getMessage());
		}
	}
	
	
	
	public String getChromePath()
	{
		String chromePath = pro.getProperty("chromepath");
		return chromePath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxPath = pro.getProperty("firefoxpath");
		return firefoxPath;
	}
	
	public String getURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUser()
	{
		String userName = pro.getProperty("userName");
		return userName;
	}
	
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getEnvironment()
	{
		String getEnvironment = pro.getProperty("execution_env");
		return getEnvironment;
	}
	
	
}
