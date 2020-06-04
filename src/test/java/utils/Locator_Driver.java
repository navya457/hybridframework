package utils;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Locator_Driver {
	private static io.appium.java_client.android.AndroidDriver driver ;
	
	public Locator_Driver(AndroidDriver driver)
	{
		this.driver=driver;
		
	}

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	public static io.appium.java_client.android.AndroidElement allowbtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Register'and @index='0']")
	public static io.appium.java_client.android.AndroidElement register_btn;
	
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='First Name' and @index='0']")
	public static io.appium.java_client.android.AndroidElement first_Name;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Last Name' and @index='0']")
	public static io.appium.java_client.android.AndroidElement last_Name;
	
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Email' and @index='0']")
	public static io.appium.java_client.android.AndroidElement Email_Id;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Mobile Number' and @index='0']")
	public static io.appium.java_client.android.AndroidElement mobile_Number;
	
	
	
}
