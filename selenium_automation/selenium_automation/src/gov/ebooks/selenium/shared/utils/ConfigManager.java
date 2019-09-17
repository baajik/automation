package gov.ebooks.selenium.shared.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager 
{
	private ConfigManager instance;
	
	private ConfigManager()
	{}
	
	public ConfigManager getInstance()
	{
		if(instance!=null)
			instance = new ConfigManager();
		return instance;
	}
	
	public static String GetAppSetting(String key)
	{
		Properties configProperty = new Properties();
		File configFile = new File("Config.properties").getAbsoluteFile();
		InputStream configStream=null;
		String propertyValue =null;
		try 
		{
			configStream = new FileInputStream(configFile);
			configProperty.load(configStream);
			propertyValue= configProperty.getProperty(key);
			return propertyValue;
			
		} 
		catch (IOException ex)
		{
			ex.printStackTrace();
		} 
		finally 
		{
			if (configStream != null) 
			{
				try 
				{
					configStream.close();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return propertyValue;
	}

	public static String Server()
	{
		return GetAppSetting("server");
	}

	public static String ResolveURL(String relativeURL) 
	{
		return Server() + relativeURL;
	}

	public static String HomeURL() 
	{
		return Server();
	}

	public static String DriverPath() 
	{
		return RootPath() + GetAppSetting("driverPath");
	}

	public static String FireFoxBinaryPath() 
	{
		return GetAppSetting("firefoxBinaryPath");
	}
	
	public static String ReportTemplatesPath() 
	{
	 // return RootPath() +GetAppSetting("rptTemplatePath");
		return "/Users/nayana.shivalingappa/selenium_automation/target/src/gov/ebooks/selenium/shared/report";
	}
	
	public static String ReportsPath() 
	{
		return RootPath() +GetAppSetting("rptPath");
	}
	
	public static String DataPath() 
	{
		return RootPath() +GetAppSetting("dataPath");
	}
	
	//this is for Upload from Samples provided in Uploads folder
	public static String Uploads() 
	{
		//return (RootPath() +GetAppSetting("Uploads")).substring(1);
		return (RootPath() +GetAppSetting("uploadsPath"));
	}
	
	public static String RootPath(){
		String rootPath = "";
		try 
		{
			//File root = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI());
			//rootPath = root.getCanonicalPath();
			rootPath = ConfigManager.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			return rootPath;
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return rootPath;
	}
	
	
	public static String AppliedScienceERS()
	{
		return GetAppSetting("AppliedScienceERS");
	}
	
	
	public static String ESTOERS()
	{
		return GetAppSetting("ESTOERS");
	}
	
	public static String ESTOReview()
	{
		return GetAppSetting("ESTOReview");
	}
	
	public static String HECeBooks()
	{
		return GetAppSetting("HECeBooks");
	}
	
	public static String ARTOERS()
	{
		return GetAppSetting("ARTOERS");
	}	
		
	public static String PlanetaryERS()
	{
		return GetAppSetting("PlanetrayERS");
	}
}
