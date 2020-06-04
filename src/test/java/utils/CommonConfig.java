package utils;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


import org.aspectj.util.FileUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidKeyCode;



public class CommonConfig extends AppiumService{
	public void minWait() throws InterruptedException{
		Thread.sleep(1500);
	}
	public void clearRecentApps() throws InterruptedException, IOException {			 			
		
		Runtime.getRuntime().exec("adb  shell input keyevent 3"); 
	
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
			 	
				 	
	}
	public  void executeShellCommands(int input,String URL,String pkgName,String activityName ) throws IOException {

		switch(input) {		  
		case 1:
			String cmd1 = "adb shell am start -a android.intent.action.VIEW -d "+URL+"";
			Process p1 = Runtime.getRuntime().exec(cmd1);
			break;

		case 2:
			String  cmd2 = "adb shell am start -n "+pkgName+"/"+activityName+"";
			Process p2 = Runtime.getRuntime().exec(cmd2); 
			break;
		}		
	}	
	
	public boolean clickBtn(WebElement e) {
		try {
			e.click();
			return true;
		} catch (NoSuchElementException s) {
			return false;
		}
	}
	public boolean clickBtn(io.appium.java_client.android.AndroidElement e) {
		try {
			e.click();
			return true;
		} catch (NoSuchElementException s) {
			return false;
		}
	}
	public boolean longpress(int keyCode){
		try {
			driver.longPressKeyCode(keyCode);
			return true;
		} catch (NoSuchElementException s) {
			return false;
		}
	}
	public void launchAppThroughABD(String adbCommand) throws InterruptedException, IOException {
		minWait();
		Runtime.getRuntime().exec(adbCommand);
		minWait();		
	}
	
	public void selectCheckbox(WebElement e) {
		if (!e.isSelected()) {
			e.click();
		}
	}
	
	public void selectCheckbox(io.appium.java_client.android.AndroidElement e) {
		if (!e.isSelected()) {
			e.click();
		}
	}
	public void deSelectCheckbox(WebElement e) {
		if (e.isSelected()) {
			e.click();
		}
	}
	public void deSelectCheckbox(io.appium.java_client.android.AndroidElement e) {
		if (e.isSelected()) {
			e.click();
		}
	}	
	public boolean enterTextToInputField(WebElement e, String text) throws InterruptedException {
		if (e == null) {
			return false;
		} else {
			if (e.isDisplayed()) {
				Thread.sleep(300);
				e.clear();
				e.click();
				Thread.sleep(300);
				e.sendKeys(text);
				return true;
			} else {
				return false;
			}
		}
	}
	
	public boolean enterTextToInputField(io.appium.java_client.android.AndroidElement e, String text) throws InterruptedException {
		if (e == null) {
			return false;
		} else {
			if (e.isDisplayed()) {
				Thread.sleep(300);
				
				e.click();
				e.clear();
				e.sendKeys(text); 
				
				return true;
			} else {
				
				return false;
			}
		}
	}
	public boolean clearInputField(WebElement e) throws InterruptedException {
		if (e == null) {

			return false;
		} else {
			if (e.isDisplayed()) {
				Thread.sleep(500);
				e.clear();
				Thread.sleep(500);
				return true;
			} else {
				
				return false;
			}
		}
	}
	public boolean clearInputField(io.appium.java_client.android.AndroidElement e) throws InterruptedException {
		if (e == null) {

			return false;
		} else {
			if (e.isDisplayed()) {
				Thread.sleep(500);
				e.clear();
				Thread.sleep(500);
				return true;
			} else {
				
				return false;
			}
		}}
	public boolean hoverOverElement(WebElement el) {
		Actions actions = new Actions(driver);
		actions.moveToElement(el).build().perform();
		return false;
	}
	
	public boolean hoverOverElement(io.appium.java_client.android.AndroidElement el) {
		Actions actions = new Actions(driver);
		actions.moveToElement(el).build().perform();
		return false;
	}
	public String getCurrentTimeStamp() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		return format.format(new Date()).toString();
	}
	public void selectDropDownByValue(WebElement e, String value) {

		Select dropdown = new Select(e);
		dropdown.selectByValue(value);
	}
	public void selectDropDownByValue(io.appium.java_client.android.AndroidElement e, String value) {

		Select dropdown = new Select(e);
		dropdown.selectByValue(value);
	}
	public void selectDropDownByText(WebElement e, String text) {

		Select dropdown = new Select(e);
		dropdown.selectByVisibleText(text);
	}
	public void selectDropDownByText(io.appium.java_client.android.AndroidElement e, String text) {

		Select dropdown = new Select(e);
		dropdown.selectByVisibleText(text);
	}
	public void selectDropDownsByText(WebElement e, String text) {
		Select dropdown = new Select(e);
		if (dropdown.isMultiple()) 
		{
			dropdown.deselectAll();
			dropdown.selectByVisibleText(text);

		}
		else 
		{
			dropdown.selectByVisibleText(text);
		}	
	}
	public void selectDropDownsByText(io.appium.java_client.android.AndroidElement e, String text) {
		Select dropdown = new Select(e);
		if (dropdown.isMultiple()) 
		{
			dropdown.deselectAll();
			dropdown.selectByVisibleText(text);

		}
		else 
		{
			dropdown.selectByVisibleText(text);
		}	
	}
	
	
	public void selectDropDownValueByIndex(WebElement e, int index) {
		Select dropdown = new Select(e);
		dropdown.selectByIndex(index);
	}
	public void selectDropDownValueByIndex(io.appium.java_client.android.AndroidElement e, int index) {
		Select dropdown = new Select(e);
		dropdown.selectByIndex(index);
	}
	
	public String getSelectedDropDownOptionText(WebElement e) {
		Select dropdown = new Select(e);
		return dropdown.getFirstSelectedOption().getText();
	}
	public String getSelectedDropDownOptionText(io.appium.java_client.android.AndroidElement e) {
		Select dropdown = new Select(e);
		return dropdown.getFirstSelectedOption().getText();
	}

	public boolean isElementPresent(String csslocator) {
		if (driver.findElements(By.cssSelector(csslocator)).size() == 0)
			return false;
		else
			return true;
	}
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;

		} catch (NoAlertPresentException ex) {
			return false;
		}
	}
	public Alert getAlertbox() {

		try {
			return driver.switchTo().alert();

		} catch (NoAlertPresentException ex) {
			return null;
		}
	}
	public void waituntilnew(WebElement e, int timeinSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeinSeconds);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	public void waituntilnew(io.appium.java_client.android.AndroidElement e, int timeinSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeinSeconds);
		wait.until(ExpectedConditions.visibilityOf(e));
		//wait.until(equals(aDriver.switchTo().alert().accept()));

	}
	public void waituntilnewElementtobeClickable(WebElement e, int timeinSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeinSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	public void waituntilnewElementtobeClickable(io.appium.java_client.android.AndroidElement e, int timeinSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeinSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	public void dragAndDrop(WebElement source, WebElement target) {
		(new Actions(driver)).dragAndDrop(source, target).perform();
	}
	public void dragAndDrop(io.appium.java_client.android.AndroidElement source, io.appium.java_client.android.AndroidElement target) {
		(new Actions(driver)).dragAndDrop(source, target).perform();
	}
	public boolean isElementExist(WebElement e) {
		boolean isPresent = false;
		try {
			isPresent = e.isDisplayed();
		} catch (NoSuchElementException nse) {
			isPresent = false;
		} catch (NullPointerException npe) {
			isPresent = false;
		}
		return isPresent;
	}
	
	public boolean isElementExist(io.appium.java_client.android.AndroidElement e) {
		boolean isPresent = false;
		try {
			isPresent = e.isDisplayed();
		} catch (NoSuchElementException nse) {
			isPresent = false;
		} catch (NullPointerException npe) {
			isPresent = false;
		}
		return isPresent;
	}
	
	public boolean isElementNull(WebElement e) {
		boolean isNull = false;
		if (e.getText() == null) {
			isNull = true;
		}
		return isNull;
	}
	public boolean isElementNull(io.appium.java_client.android.AndroidElement e) {
		boolean isNull = false;
		if (e.getText() == null) {
			isNull = true;
		}
		return isNull;
	}
	public void maxWait() throws InterruptedException{
		Thread.sleep(12000);

	}
	

//	public static void customWait(long secs) throws InterruptedException{
//		Thread.sleep(secs) ;
//	}
//
//	public void softAssert_true(boolean check, String message){
//		
//		Soft
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertTrue(check, message); 
//	}
//
//	public void softAssert_false(){
//		SoftAssert softAssertFail = new SoftAssert();
//		softAssertFail.fail();
//	}		 
//
//	public void softAssert_equals(String actual, String expected){
//		SoftAssert softAssertFail = new SoftAssert();
//		softAssertFail.assertEquals(actual, expected);
//	}

	public void scrollAlittle() throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		minWait();
	}
	public void scrollToElement(WebElement e) throws InterruptedException{
		minWait();
		WebElement element = e;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		minWait();
	}
	public void scrollToElement(io.appium.java_client.android.AndroidElement e) throws InterruptedException{
		minWait();
		WebElement element = e;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		minWait();
	}
	public void javaScriptScroll(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	}
	public static void startAdbLog(String fileName) throws AWTException, InterruptedException, IOException {

		Thread.sleep(1000);
		String path = "src/test/resources/adbLogs/"+fileName+".txt";

		try {
			Runtime.getRuntime().exec("adb logcat -c");
			Thread.sleep(1000);
			Runtime.getRuntime().exec("cmd /C \"adb logcat -v time>"+path);
			Thread.sleep(2000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void stopAdbLog(String TCName) throws InterruptedException, AWTException, IOException {
		Thread.sleep(1000);
		Runtime.getRuntime().exec("taskkill /IM cmd.exe");
		/*
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		 */
	}	
//	public static String captureScreenshot(String methodName) throws IOException{
//
//		Calendar cal = new GregorianCalendar();
//		int month = cal.get(Calendar.MONTH);
//		int year = cal.get(Calendar.YEAR);
//		int sec = cal.get(Calendar.SECOND);
//		int min = cal.get(Calendar.MINUTE);
//		int date = cal.get(Calendar.DATE);
//		int day = cal.get(Calendar.HOUR_OF_DAY);
//		String mailscreenshotpath = null;
//
//		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		try {
//			mailscreenshotpath = System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\"+methodName+"_"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpg";
//			
//			FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return mailscreenshotpath;
//	}
	
	//till correct
	
	public boolean scrollToText(String text) {
		  /*
		    Method used to select an element on the page by scrolling the Scroll View/List View
		   */

		  boolean check = false;
		  try {  
		   String scrollable = "new UiScrollable(new UiSelector().scrollable(true))";
		   String textElement = ".scrollIntoView(new UiSelector().text(\""+ text +"\"))";
		   driver.findElementByAndroidUIAutomator(scrollable+textElement).click();
		   check = true;
		   return check;
		  }
		  catch(NoSuchElementException e) {
		   return check;
		  }
		 }
//	public String Verify(io.appium.java_client.android.AndroidElement driver) {
//
//		String result = null;
//		File scrFile = driver.getScreenshotAs(OutputType.FILE);
//		ITesseract instance = new Tesseract();
//		try {
//			result = instance.doOCR(scrFile);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return result;
//	}
//	public String takeScreenShot() {
//
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
//
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
//
//		new File(scrShotDir).mkdirs(); // Create folder under project with name
//		// "screenshots" if doesn't exist
//		destFile = dateFormat.format(new Date()) + ".png"; // Set file name
//		// using current
//		// date time.
//		try {
//			FileUtils.copyFile(scrFile, new File(scrShotDir + "/" + destFile)); // Copy
//			// paste
//			// file
//			// at
//			// destination
//			// folder
//			// location
//		} catch (IOException e) {
//			APP_LOGS.info("Image not transfered to screenshot folder");
//			e.printStackTrace();
//		}
//		return destFile;
//	}
	public void scroll() {
		try {
			org.openqa.selenium.Dimension size =driver.manage().window().getSize();
			System.out.println(size);
			int x=size.getWidth()/2;
			int starty=(int)(size.getHeight()*0.60);
			int endy=(int)(size.getHeight()*0.10);
			driver.swipe(x, starty, x, endy, 2000);
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}
	public boolean scrollTo(String phoneNum) {
		/*

		  Method used to select an element on the page by scrolling the Scroll View/List View
		 */

		boolean check = false;
		try {  
			String scrollable = "new UiScrollable(new UiSelector().scrollable(true))";
			String textElement = ".scrollIntoView(new UiSelector().text(\""+ phoneNum +"\"))";
			driver.findElementByAndroidUIAutomator(scrollable+textElement);
			check = true;
			return check;
		}
		catch(NoSuchElementException e) {
			return check;
		}}
	
	public boolean scrollToTextContains(String text) {
		/*
		  Method used to select an element on the page by scrolling the Scroll View/List View
		 */
		boolean check = false;
		try {  
			String scrollable = "new UiScrollable(new UiSelector().scrollable(true))";
			String textElement = ".scrollIntoView(new UiSelector().textContains(\""+ text +"\"))";
			driver.findElementByAndroidUIAutomator(scrollable+textElement).click();
			check = true;
			return check;
		}
		catch(NoSuchElementException e) {
			return check;
		}
	}
	public void scrollToElements(WebElement e) throws InterruptedException {
		minWait();
		/*  WebElement element = e;
		   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);*/

		for(int i=1; i<=4;i++)
		{
			if(isElementExist(e)) {
				minWait();
				break;
			}
			else {
				scroll();
				continue;
			}
		}
	}
	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		return dateFormat.format(date);
	}
	
	public static String getCurrentTime() {
		
		  Date date = new Date();
		    String strDateFormat = "hh-mm-ss";
		    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		    String formattedDate= dateFormat.format(date);
		    System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate);
		return formattedDate;
		
	}
	
}
