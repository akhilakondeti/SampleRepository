package MyMavenProject.sample;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sample {

	@BeforeMethod
	public void initialize()
	{
		System.out.println("Enter name");
	}
	@Test
	public void testmethod()
	{
		System.out.println("Enter in Method");
	}
	@AfterMethod
	public void teardown()
	{
		System.out.println("In Teardown");
	}
}
