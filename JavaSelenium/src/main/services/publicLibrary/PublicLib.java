package publicLibrary;
import globalConstants.Constants;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import objects.AppObjects;
import reports.Reporter;


public class PublicLib extends Reporter
{   
	public static WebDriver driver;
	
	public  static void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver",Constants.driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://ggk-wrl-cs-2:8095/ehr-webapp/#/login");
		
	}
	
	public static WebElement getLocator(By locator)
	{
		explicitWait(locator,10);
		return driver.findElement(locator);
	}
	public static void clickOnElement(By locator)
	{ 
		explicitWait(locator,10);
		getLocator(locator).click();
	}
	public static void setTextInTextBoxes(By locator,String text)
	{
		explicitWait(locator,10);
		getLocator(locator).sendKeys(text);
		
	}
	public static void setTextInDropdown(By locator,String text)
	{
		explicitWait(locator,10);
		Select ele = new Select(getLocator(locator));
		ele.selectByVisibleText(text);
	}
	
	public static void closeBrowser()
	{
		driver.close();
	}
	public static void moveToElement(By locator)
	{  
		explicitWait(locator,10);
		WebElement ele = getLocator(locator);
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		
	}
	public static void explicitWait(By locator,int waitTimeInSeconds)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
     	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
       
	}
	public static void clearText(By locator)
	{ 
		explicitWait(locator,10);
		getLocator(locator).clear();
		
	}
	public static void selectCheckBox(By locator)
	{ 
		driver.findElement(locator).click();
	}
   public static void swithToWindow(int windowno)
	{
		Set<String> windows = driver.getWindowHandles();
		List<String> stringsList = new ArrayList<String>(windows);
		String handler = stringsList.get(windowno);
		driver.switchTo().window(handler);
	}
	public static void verifyingMsg(By locator,String message)
	{
		explicitWait(locator,10);
		String text = getLocator(locator).getText();
		String[] arrSplit = text.split(":");
	    System.out.println(arrSplit[0]);
		Assert.assertEquals(arrSplit[0].trim(), message.trim());
			
	}
	public static List<WebElement> getListOfWebElements(By locator)
	{
		explicitWait(locator,10);
		List<WebElement> elements = driver.findElements(locator);
		return elements;
	}
	public static void handleLoadingImage(int waitTimeInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(getLocator(AppObjects.lodingimage)));
	}
	
	public static String randomName(String sname)
	{
		LocalDateTime now = LocalDateTime.now();
		int year = now.getYear();
		String yearInString = String.valueOf(year);
		int month = now.getMonthValue();
		String monthInString = String.valueOf(month);
		int day = now.getDayOfMonth();
		String dayInString = String.valueOf(day);
		
		int minute = now.getMinute();
		String minuteInString = String.valueOf(minute);
		String rname = sname+yearInString+monthInString+dayInString+minuteInString;
		System.out.println(rname);
		return rname;
	}
	public static String randomnumber(int limit)
	{
		String rand = "";
		Random objGenerator = new Random();
	    for (int iCount = 0; iCount< limit; iCount++){
	      int randomNumber = objGenerator.nextInt(10);
	      rand=rand+Integer.toString(randomNumber);
	     
	    }
	      return rand;
	}
	public static boolean VerifyText(By locator,String text)
	{
		explicitWait(locator,10);
		String value = getLocator(locator).getText();
		if(value.equals(text))
			return true;
		else
			return false;
    }
	public static void fluentWait(final By locator, int timeout) {
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeout, TimeUnit.SECONDS)
					.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String captureScreenshot(String stepName)
	{
		String destinationPath = "";
		try
		{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		
		//String path = System.getProperty("user.dir");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String timestamp = dateFormat.format(date);
		String fileName=stepName+timestamp+".jpg";
		
		destinationPath = "Reports\\Screenshots"+"\\"+fileName;
		
		FileUtils.copyFile(source,new File(destinationPath));
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return destinationPath;
	}
	
	 public static void setDate(String dateOfBirth) throws Exception 
	 {
	 	String currentDateString = dateOfBirth;
	 	SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
	 	Date currentDate = sd.parse(currentDateString);
	 	Date date = currentDate; 
	 	Calendar cal = Calendar.getInstance();
	 	cal.setTime(date);
	 	int year = cal.get(Calendar.YEAR);
	 	String yearInString = String.valueOf(year);
	 	int day = cal.get(Calendar.DAY_OF_MONTH);
	 	sd = new SimpleDateFormat("MMM");
	 	String month = sd.format(date);
	 	clickOnElement(AppObjects.dob);
	 	PublicLib.setTextInDropdown(AppObjects.dobyear,yearInString );
	 	PublicLib.setTextInDropdown(AppObjects.dobmonth,month );
	 	driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td//a[contains(text(),'"+day+"')]")).click();
		
	 }
	 public static void clickOnLeftMenu(By mainMenu, By subMenu, By menu)
	 {
		explicitWait(mainMenu,10);
		moveToElement(mainMenu);
		clickOnElement(mainMenu);
		explicitWait(subMenu,10);
		moveToElement(subMenu);
		clickOnElement(subMenu);
		if(menu != null)
		{
			moveToElement(menu);
			clickOnElement(menu);
		}
	}
	
	  public static void drawHighLight(By locator)
		{
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');",getLocator(locator));
		}
	
}
