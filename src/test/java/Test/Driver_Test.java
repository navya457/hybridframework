package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import utils.Driver_Utils;
import utils.Locator_Driver;





public class Driver_Test extends Driver_Utils {
	
	public ExtentReports extent=null;
	public ExtentTest test =null;
	@BeforeSuite
	public void m1()
	{
		
		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(new File("src/test/resources/extentreport/Driver.html"));
		  extent = new ExtentReports();
		 extent.attachReporter(htmlReporter);
		 extent.setSystemInfo("OS", "MacBook");
			
	}
	@BeforeMethod
	public void m2(Method method)
	{
		test=extent.createTest(this.getClass()+"::"+method.getName(),method.getName());
		test.assignAuthor("navya");
	}

	@AfterMethod()
	public void tearDown() throws IOException, InterruptedException
	{
		
		test.log(Status.FAIL, "fail");
	
		extent.flush();
	}
	@BeforeTest
	public void setupSys() throws MalformedURLException, InterruptedException, FileNotFoundException, AWTException{
	Locator_Driver driverapp=new Locator_Driver(driver);
	PageFactory.initElements(new AppiumFieldDecorator(driver), driverapp.getClass());
		
	}
	@Test
	public void register_DriverApplication() throws InterruptedException
	{
		Driver_Utils a=new Driver_Utils();
		System.out.println("ENTER THE TEST METHOD");
		io.appium.java_client.TouchAction ta=new io.appium.java_client.TouchAction(driver);
		minWait();
		ta.tap(driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"))).perform();
		
//		clickOnRegister();
//		register_Page();
	}

}
