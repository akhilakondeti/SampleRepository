package reports;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporter {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void gettingReports()
	{
      
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String timestamp = dateFormat.format(date);
		String fileName="Report"+timestamp+".html";
		
		String destinationPath = "Reports"+"\\"+fileName;
		htmlReporter = new ExtentHtmlReporter(destinationPath);
		extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
	}
	
	public static void closingExtentReports()
	{
		extent.flush();
	   
	}
}
