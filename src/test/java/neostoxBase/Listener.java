package neostoxBase;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxUtility.NeoStoxUtility;

public class Listener extends BaseMethod implements ITestListener 
{

	
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("testcase  "+result.getName()+"  is pass", true);
	}
	public void onFinish(ITestContext context)
	{
		Reporter.log("testcase finished", true);
	}
	
	
	public void onTestFailure(ITestResult result) {
		try {
			NeoStoxUtility.takeScreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
