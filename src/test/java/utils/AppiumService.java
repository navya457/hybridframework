package utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumService {
	public DesiredCapabilities cap=null;
	public AppiumServiceBuilder builder =null;
	public static AndroidDriver driver;
	
	@BeforeSuite
	public void startServer() throws InterruptedException, IOException, ParseException
	{
		System.out.println("APPIUM START");
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		
		builder.usingDriverExecutable(new File("/usr/local/bin/node"));
		builder.withAppiumJS(new File("/usr/local/bin/appium")); 
		builder.withIPAddress("0.0.0.0");
		builder.usingPort(4733);
		AppiumDriverLocalService local= AppiumDriverLocalService.buildService(builder);
                local.start();
                URL url = local.getUrl();
                System.out.println(url);   
	        DesiredCapabilities cap = new DesiredCapabilities();
 		cap.setCapability("platformName", ReadData.JSonFileReader("platformName"));
 		cap.setCapability("platformVersion", ReadData.JSonFileReader("platforVersion"));
 		cap.setCapability("deviceName", ReadData.JSonFileReader("devicename"));
 		cap.setCapability("UDID",ReadData.JSonFileReader("UDID"));
 		//cap.setCapability("autoGrantPermissions", "true");
		cap.setCapability("appPackage", ReadData.JSonFileReader("appPackage"));	
 		cap.setCapability("appActivity", ReadData.JSonFileReader("appActivity"));
// 		cap.setCapability("noSign", "true");
 		cap.setCapability("automationName", "appium");
 	        System.out.println("stop");
 		 driver=new AndroidDriver(url, cap);		
	        System.out.println("register");
 		Thread.sleep(10000);
	 
	}

}
