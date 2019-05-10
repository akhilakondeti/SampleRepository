package tests;
import applicationLibrary.AppLib;
import objects.AppObjects;
import publicLibrary.PublicLib;
import reports.Reporter;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

public class CurisHealth extends Reporter{
	 
	
	@BeforeTest
	public void setUp()
	{
		Reporter.gettingReports();
	}
	@BeforeMethod
	public void testIntialize()
	{
		 PublicLib.launchBrowser();
		 AppLib.excelData(this.getClass().getSimpleName());
	}
	@Test(priority = 1)
	public void patientRegistration()
	{
		try{
		 String methodname=new Thread().currentThread().getStackTrace()[1].getMethodName().toString();
	     test = extent.createTest(methodname, "Patient, Details");
	     test.log(Status.INFO, "Starting of testcase");
	     test.info("Login Operation");
	     AppLib.login();
	     test.info("Navigating to patient registration page");
	     PublicLib.clickOnLeftMenu(AppObjects.patientLeftMenu,AppObjects.pateintMenu, null);
	     test.info("Enter details in patient registration page");
	     AppLib.enterPatientRegistrationDetails();
	     test.info("Switch to parent window");
		 PublicLib.swithToWindow(0);
		 test.info("Verying validation msg");
		 PublicLib.verifyingMsg(AppObjects.validationMsg, "Patient registered successfully. Registration number");
		 PublicLib.clickOnElement(AppObjects.closepopupbtn);
		 test.info("Click on confirmbuttonno Button");
	     PublicLib.clickOnElement(AppObjects.confirmbuttonno);
	     Thread.sleep(2000);
		 test.info("Logout");
		 AppLib.logout();
	
		}
		catch(Exception e)
		{
			 try {
				 test.fail("Failed",MediaEntityBuilder.createScreenCaptureFromPath("../"+PublicLib.captureScreenshot("failed")).build());
				} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
		 }
		}
	
@Test(priority = 2)
	public void doctorAppointment() throws Exception
	{ 
		try
	   {
		String methodname=new Thread().currentThread().getStackTrace()[1].getMethodName().toString();
	    test = extent.createTest(methodname, "Selecting avaible slot");
			   
	    test.log(Status.INFO, "Starting of testcase");
		test.info("Login Operation");
		AppLib.login();
		test.info("Navigating to doctor appointment page");
		PublicLib.clickOnLeftMenu(AppObjects.appointment, AppObjects.appdoctorappointment, null);
		test.info("Enter valid details");
		AppLib.enterDoctorAppointmentDetailsPage();
		AppLib.selectAvailableSlot();
		test.info("Logout");
		AppLib.logout();
	   }
		catch(Exception e){
			 			 try {
				 test.fail("Failed",MediaEntityBuilder.createScreenCaptureFromPath("../"+PublicLib.captureScreenshot("failed")).build());
				} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		  }
	}
  @Test(priority = 3)
	public void billingDeposit() throws Exception
	{
    	try
    	{
        String methodname=new Thread().currentThread().getStackTrace()[1].getMethodName().toString();
		test = extent.createTest(methodname, "Calculating Amount");
		   
		test.log(Status.INFO, "Starting of testcase");
		test.info("Login Operation");
		AppLib.login();
		test.info("Navigating to billing deposit page");
		PublicLib.clickOnLeftMenu(AppObjects.billing, AppObjects.billingdeposits, null);
		AppLib.searchRegistrationNumber();
	    AppLib.enterAmountDetails();
		test.info("Logout");
        AppLib.logout();
    	}
    	catch(Exception e)
    	{
    		 	try {
				 test.fail("Failed",MediaEntityBuilder.createScreenCaptureFromPath("../"+PublicLib.captureScreenshot("failed")).build());
				} catch (IOException e1) {
				
				e1.printStackTrace();
			}
    		 	throw new Exception(e.toString());
 	    }
    	
	}
	@AfterMethod
	public void testCleanUp()
	{
		 PublicLib.closeBrowser();
	}
	@AfterTest
	public void tearDown()
	{
		Reporter.closingExtentReports();
	}
}
