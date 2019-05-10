package applicationLibrary;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

import excelUtility.ExcelReader;
import objects.AppObjects;
import publicLibrary.PublicLib;

public class AppLib extends PublicLib {
	 

	public static Map<String,Object> excelvalues;
	
	 public static void excelData(String classname)
	 {
	 excelvalues=ExcelReader.getExcelData(classname);
	 }
	 public static void login()
		{
			explicitWait(AppObjects.username,10);
			setTextInTextBoxes(AppObjects.username,excelvalues.get("UserName").toString());
			test.info("Enter password");
		    setTextInTextBoxes(AppObjects.password,excelvalues.get("Password").toString());
		    test.info("Click on Login Button");
			clickOnElement(AppObjects.loginBtn);
			explicitWait(AppObjects.patientLeftMenu,10);
			if( VerifyText(AppObjects.header, "Assistant Manager Dashboard"))
			   test.pass("Login performed");
			else
				{
				test.fail("Login not performed");
				}
		
		}
	 public static int getColumnIndex(String colText) 
	 {
			int colnumber = 0;
      	List<WebElement> columns = driver.findElements(By
					.xpath("//div[@id='paymentAmountSummary']//th"));
			for (WebElement text : columns) {
				if (text.getText().contains(colText)) {

					break;
				}
				colnumber++;
			}
			return colnumber;
		}
	  public static void verifyAmountInPaymentSummaryTable(Double amount,String columnname) throws Exception
	  {
		  
		  int colIndex = getColumnIndex(columnname)+1;
		 
		  String text = driver.findElement(By.xpath("//div[@id='paymentAmountSummary']//tbody/tr[1]/td["+colIndex+"]")).getText();
		  Double value = Double.parseDouble(text);
		  if(value.equals(amount))
		      test.pass("Amount is matched");
		  else
			  test.fail("Amount is not matched");
	  }
	  
	  public static void enterPatientRegistrationDetails() throws Exception
	  {
		     PublicLib.moveToElement(AppObjects.registrationtype);
			 PublicLib.setTextInDropdown(AppObjects.registrationtype, excelvalues.get("RegistrationType").toString());
			 PublicLib.setTextInDropdown(AppObjects.userhospitals, excelvalues.get("UserHospitals").toString());
			 PublicLib.setTextInDropdown(AppObjects.gender,excelvalues.get("Gender").toString());
			 PublicLib.setTextInDropdown(AppObjects.salutation,excelvalues.get("Salutation").toString());
			 PublicLib.setTextInDropdown(AppObjects.nationality, excelvalues.get("Nationality").toString());
			 PublicLib.setTextInDropdown(AppObjects.registrationlocation, excelvalues.get("RegLocation").toString());
			 PublicLib.setTextInTextBoxes(AppObjects.firstname, excelvalues.get("FirstName").toString());
			 PublicLib.setTextInTextBoxes(AppObjects.lastname,excelvalues.get("LastName").toString());
			 PublicLib.setDate(excelvalues.get("Dob").toString());
			 PublicLib.setTextInTextBoxes(AppObjects.mobileno,  randomnumber(10));
			 PublicLib.setTextInDropdown(AppObjects.maritalstatus,excelvalues.get("MaritalStatus").toString());
			 PublicLib.setTextInDropdown(AppObjects.ethnicity, excelvalues.get("Ethnicity").toString());
			 PublicLib.setTextInDropdown(AppObjects.paymenttype,excelvalues.get("PaymentType").toString());
			 PublicLib.clickOnElement(AppObjects.communicationtab);
			 PublicLib.setTextInTextBoxes(AppObjects.address,excelvalues.get("Address").toString());
			 PublicLib.setTextInTextBoxes(AppObjects.state, excelvalues.get("State").toString());
			 PublicLib.clickOnElement(AppObjects.statediv);
			 PublicLib.setTextInTextBoxes(AppObjects.city, excelvalues.get("City").toString());
			 PublicLib.clickOnElement(AppObjects.citydiv);
			 PublicLib.clickOnElement(AppObjects.saveBtn);
			 PublicLib.handleLoadingImage(10);
	  }
	  public static void enterDoctorAppointmentDetailsPage() throws Exception
	  {    PublicLib.setTextInDropdown(AppObjects.registrationtypeid, excelvalues.get("RegistrationTypeId").toString());
		   PublicLib.setTextInDropdown(AppObjects.externalsalutation, excelvalues.get("Salutation").toString());
		   PublicLib.setTextInTextBoxes(AppObjects.externalpatientfirstname, excelvalues.get("FirstName").toString());
		   PublicLib.setTextInTextBoxes(AppObjects.externpatientlastname, excelvalues.get("LastName").toString());
		   PublicLib.setTextInDropdown(AppObjects.ethnicity, excelvalues.get("Ethnicity").toString());
		   PublicLib.setTextInTextBoxes(AppObjects.externmobileno, PublicLib.randomnumber(10));
	       PublicLib.setDate(excelvalues.get("Dob").toString());
	       PublicLib.clickOnElement(AppObjects.externsavebtn);
		   PublicLib.setTextInDropdown(AppObjects.appointmenttypeid, excelvalues.get("AppointmentTypeId").toString());
		  
	 }
	  
	  public static void selectAvailableSlot()
	  {
		    test.info("Enter Department name and doctorname");
			PublicLib.setTextInTextBoxes(AppObjects.departmentid, excelvalues.get("DepartmentId").toString());
			PublicLib.clickOnElement(AppObjects.departmentiddiv);
			PublicLib.setTextInTextBoxes(AppObjects.doctorid, excelvalues.get("DoctorId").toString());
			PublicLib.handleLoadingImage(10);
			test.info("Select available slot");
			PublicLib.clickOnElement(AppObjects.availableSlot);
			PublicLib.clickOnElement(AppObjects.bookappointment);
			PublicLib.clickOnElement(AppObjects.closepopupbtn);
	  }
	  public static void searchRegistrationNumber()
	  {   
		  test.info("Enter registration number");
		  PublicLib.moveToElement(AppObjects.registrationno);
		  PublicLib.setTextInTextBoxes(AppObjects.registrationno, excelvalues.get("RegistarationNo").toString());
		  PublicLib.clickOnElement(AppObjects.searchbtn);
	  }
	  public static void logout()
		 {      
			    explicitWait(AppObjects.logoutmainlink,10);
				clickOnElement(AppObjects.logoutmainlink);
				explicitWait(AppObjects.logoutlink,10);
				clickOnElement(AppObjects.logoutlink);
		 }
	public static void enterAmountDetails() throws Exception
	{
		    PublicLib.setTextInDropdown(AppObjects.deposittype, excelvalues.get("DepositType").toString());
			PublicLib.setTextInDropdown(AppObjects.currencycode, excelvalues.get("INRCode").toString());
			PublicLib.setTextInTextBoxes(AppObjects.cashamount, excelvalues.get("INRAmount").toString());
			PublicLib.clickOnElement(AppObjects.addbtn);
		    PublicLib.setTextInDropdown(AppObjects.currencycode, excelvalues.get("USDCode").toString());
			PublicLib.setTextInTextBoxes(AppObjects.cashamount, excelvalues.get("USDAmount").toString());
			PublicLib.clickOnElement(AppObjects.addbtn);
			test.info("Verifying the amount");
			Double amount = Double.parseDouble(excelvalues.get("INRAmount").toString())+Double.parseDouble(excelvalues.get("USDAmount").toString())*60;
			verifyAmountInPaymentSummaryTable(amount, "Cash");
			test.info("Clicking on Card tab");
		    PublicLib.clickOnElement(AppObjects.cardtab);
		    test.info("ADD INR and USD amount");
	        PublicLib.selectCheckBox(AppObjects.cardtypedebit);
		    PublicLib.setTextInDropdown(AppObjects.currencycode, excelvalues.get("INRCode").toString());
		    PublicLib.setTextInTextBoxes(AppObjects.amount, excelvalues.get("INRAmount").toString());
			PublicLib.setTextInDropdown(AppObjects.merchantbank, excelvalues.get("MerchantBank").toString());
			PublicLib.setTextInDropdown(AppObjects.cardtypeid, excelvalues.get("CardTypeId").toString());
			PublicLib.setTextInTextBoxes(AppObjects.cardno, PublicLib.randomnumber(10));
			PublicLib.clickOnElement(AppObjects.addbtn);
			PublicLib.selectCheckBox(AppObjects.cardtypecredit);
			PublicLib.setTextInDropdown(AppObjects.currencycode, excelvalues.get("USDCode").toString());
			PublicLib.setTextInTextBoxes(AppObjects.amount, excelvalues.get("USDAmount").toString());
			PublicLib.setTextInDropdown(AppObjects.merchantbank, excelvalues.get("MerchantBank").toString());
			PublicLib.setTextInDropdown(AppObjects.cardtypeid, excelvalues.get("CardTypeId").toString());
			PublicLib.setTextInTextBoxes(AppObjects.cardno, PublicLib.randomnumber(10));
			PublicLib.clickOnElement(AppObjects.addbtn);
			test.info("Verifying the amount");
			Double totalvalue = Double.parseDouble(excelvalues.get("INRAmount").toString())+Double.parseDouble(excelvalues.get("USDAmount").toString())*60;
	    	Double totalamount = amount+totalvalue;
	    	AppLib.verifyAmountInPaymentSummaryTable(totalamount,"Total");
	    	PublicLib.clickOnElement(AppObjects.billsavebtn);
	        PublicLib.clickOnElement(AppObjects.confirmbuttonyes);
	        PublicLib.clickOnElement(AppObjects.confirmbuttonno);
	}
	
	
}
