package utils;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class DriverUtils extends CommonConfig {
	Boolean check=false;
	
	public void clickOnAllowbtn()
	{
		try {
			maxWait();
			System.out.println("allow");
			io.appium.java_client.TouchAction ta=new io.appium.java_client.TouchAction(driver);
			ta.tap(driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"))).perform();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickOnRegister()
	{
		try
		{
			if(isElementExist(Locator_Driver.register_btn))
			{
				clickBtn(Locator_Driver.register_btn);
			}
			else
			{
				Assert.fail();
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void registerPage()
	{
		try {
			enterTextToInputField(Locator_Driver.first_Name, "navya");
			enterTextToInputField(Locator_Driver.last_Name, "shree");
			enterTextToInputField(Locator_Driver.mobile_Number, "8900123890");
			enterTextToInputField(Locator_Driver.Email_Id, "navi@gmail.com");
			
		}
		catch (Exception e) {
			
		}
	}

}
