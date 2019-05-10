
package objects;

import org.openqa.selenium.By;

public class AppObjects {

	public static By username = By.id("appUsername");
	public static By password = By.id("curisPwd");
	public static By loginBtn = By.id("loginMe");
	public static By patientLeftMenu = By.id("curis.patient");
	public static By pateintMenu = By.id("curis.patient.registernew");
	public static By salutation = By.id("dlSalutation");
	public static By gender = By.id("dlGender");
	public static By registrationlocation = By.id("dlRegistrationLocation");
	public static By firstname = By.id("txtPatientFirstName");
	public static By dob = By.id("txtPatientDob");
	public static By mobileno = By.id("txtPatientMobileNumber1");
	public static By paymenttype = By.id("dlPatientPaymentType");
	public static By ethnicity = By.id("dlEthnicity");
	public static By nationality = By.id("ddlNationality");
	public static By userhospitals = By.id("dluserHospitals");
	public static By age = By.id("txtPatientAge");
	public static By ageunits = By.id("ddlAgeUnits");
	public static By lastname = By.id("txtPatientLastName");
	public static By maritalstatus = By.id("dlMaritalStatus");
	public static By registrationtype = By.id("ddlRegistrationType");
	public static By saveBtn = By.id("saveRegistrationBtn");
	public static By address = By.id("txtCommunicationPresentAddress1");
	public static By country = By.id("presentCountry");
	public static By state = By.id("presentState");
	public static By statediv = By.cssSelector("#presentState + ul a[title = 'Andhra Pradesh']");
	public static By citydiv = By.cssSelector("#presentCity+ ul a[title = 'Kadapa']");
	public static By city = By.id("presentCity");
	public static By communicationtab = By.id("anCommunicationTab");
	public static By validationMsg = By.xpath("//div[@class='toast-message']");
	public static By closepopupbtn = By.xpath("//button[@class='close ng-scope']");
	public static By lodingimage = By.id("spinner");
	public static By mergeduplicates = By.id("curis.patient.mergeduplicate");
	public static By mobilenumReg = By.id("lblMobile");
	public static By searchBtn  = By.id("searchBtn");
	public static By registrationNum = By.id("searchRegisterno");
	public static By regsearchBtn = By.id("searchRegistrationBtn");
	public static By blocklistreason = By.id("blockListReason");
	public static By blocklistcheckbox = By.id("chkBlackList");
	public static By updatebtn = By.id("updateRegistrationBtn");
	public static By headerTest =By.xpath("//span//img[@title='Curis Health'])[2]");
	public static By confirmbuttonno =By.id("confirmButtonNo");
	public static By dobmonth =By.cssSelector(".ui-datepicker-month");
	public static By dobyear =By.cssSelector(".ui-datepicker-year");
	public static By header = By.cssSelector("#content_frame h1");
	public static By logoutmainlink = By.xpath("(//a[@class='dropdown-toggle'])[2]");
	public static By logoutlink = By.xpath("//a[contains(text(),'Logout ')]");
	public static By registrationtypeid = By.id("registrationTypeId");
	public static By externalsalutation = By.id("dlExternalSalutation");
	public static By externgender = By.id("ddlExternGender");
	public static By externalpatientfirstname = By.id("txtExternalPatientFirstName");
	public static By externpatientlastname = By.id("txtExternalPatientLastName");
	public static By externmobileno = By.id("txtPatientMobileNumber");
	public static By externsavebtn = By.xpath("//button//span[contains(text(),'Save')]");
	public static By externclosebtn = By.xpath("//button[@title='close']");
	public static By departmentid = By.id("departmentId");
	
	public static By departmentiddiv = By.cssSelector("#departmentId + ul a[title = 'Cosmetic Surgery']");
	public static By doctorid = By.id("doctorId");
	public static By doctoriddiv = By.cssSelector("#doctorId+ ul a[title = 'Dr. Vivin Anto']");
	public static By registrationno = By.id("registrationNo");
	public static By appointmenttypeid = By.xpath("//select[@id='appointmentTypeId']");
	public static By bookappointment = By.id("bookAppointment");
	public static By appointment = By.xpath("//a[@id='curis.appointment']");
	public static By appdoctorappointment = By.xpath("//a[@id='curis.appointment.doctorAppointment']");
	public static By availableSlot = By.xpath("(//td[@class='tableWhiteBorder ng-scope availableSlot'])[1]");
	
	public static By billing = By.xpath("//a[@id='curis.billing']");
	public static By billingdeposits = By.xpath("//a[@id='curis.billing.deposits']");
	public static By deposittype = By.xpath("//select[@id='depositType']");
	public static By currencycode = By.xpath("//select[@name='currencyCode']");
	public static By cashamount = By.xpath("//input[@id='cashAmount']");
	public static By addbtn = By.xpath("(//button[contains(text(),'Add')])[1]");
	public static By paymenttable = By.xpath("//div[@id='paymentAmountSummary']//th");
	public static By cardtab = By.xpath("//a[contains(text(),'Card(Credit/Debit)')]");
	public static By cardtypedebit = By.id("cardTypeDebit");
	public static By cardtypecredit = By.xpath("//input[@id='cardTypeCredit']");
	public static By merchantbank = By.name("merchantBank");
	public static By cardtypeid = By.id("cardTypeId");
	public static By cardno = By.name("cardNumber");
	public static By searchbtn = By.xpath("(//button[contains(text(),'Search')])[1]");
	public static By amount = By.xpath("//input[@name='amount']");
	public static By billsavebtn = By.cssSelector("button#depositSave");
	public static By confirmbuttonyes = By.id("confirmButtonYes");
	public static By appmaster = By.xpath("//a[@id='curis.appointment.master']");
	public static By appconsultanttype = By.xpath("(//a[@id='curis.appointment.consultationtype'])[1]");
	public static By consultanttype = By.xpath("(//input[@name='consultationType'])[1]");
	public static By consultanttypepopup = By.xpath("(//input[@name='consultationType'])[2]");
	public static By savebutton = By.xpath("//button[contains(text(),'Save')]");
	public static By updatebutton = By.xpath("//button[contains(text(),'Update')]");
	public static By delete = By.xpath("//button[contains(text(),'Delete')]");
	public static By deletereason = By.xpath("//textarea[@name='comment']");
	
	
}