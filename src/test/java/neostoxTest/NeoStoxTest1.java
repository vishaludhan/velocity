package neostoxTest;

import java.io.IOException;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neoStoxPOMclasses.NeoStoxHomePage;
import neoStoxPOMclasses.NeoStoxLoginPOM;
import neoStoxPOMclasses.NeoStoxPasswordPage;
import neoStoxPOMclasses.NeostoxNoticePage;
import neoStoxUtility.*;
import neostoxBase.BaseMethod;
@Listeners(neostoxBase.Listener.class)
public class NeoStoxTest1 extends BaseMethod{
	
	NeoStoxLoginPOM login;
	NeoStoxPasswordPage ps;
	NeostoxNoticePage ns;
	NeoStoxHomePage hm;
	
	@BeforeClass
	public void LaunchingApp() throws IOException
	{
		launchbrwoser();
	}
	
	
	@BeforeMethod
	public void loginToApp() throws IOException, InterruptedException
	{
		 login=new NeoStoxLoginPOM(driver);
		  ps=new NeoStoxPasswordPage(driver);
		  ns=new NeostoxNoticePage(driver);
		  hm=new NeoStoxHomePage(driver);
		  login.enterMobNo(NeoStoxUtility.readDataFromPropertyFile("MOBno"));
		  login.clickOnSignInButton();
		  NeoStoxUtility.Imwait(driver, 2000);
		 
		  Thread.sleep(1000);
		  ps.enterPassword(NeoStoxUtility.readDataFromPropertyFile("password"));
		  ps.clickOnSubmitButton();
		  NeoStoxUtility.Imwait(driver, 5000);
		  ns.handlePopup();
		 
	}
	
	
	
  @Test
  public void validatingFunds() throws IOException, InterruptedException 
  {
	 
	  
	 
	 
	  NeoStoxUtility.Imwait(driver, 2000);
	 String total = hm.getBalance();
	 System.out.println(total);
	
	 
	 
	   }
  @Test(priority = 1)
 	public void validateUsernamefrom() throws IOException
 	{
 		String UN = hm.getUserName();
 		Assert.assertEquals(UN, NeoStoxUtility.readDataFromPropertyFile("Username"));
 		System.out.println(UN);
 		NeoStoxUtility.Imwait(driver, 2000);
 	}
  @AfterMethod
  public void logoutFromApp() throws InterruptedException
  {   Thread.sleep(1000);
	  hm.logout(driver);
	  NeoStoxUtility.Imwait( driver, 2000);
	  
	  
  }
  
  
  @AfterClass
  public void closeBrowser()
  {
	  driver.quit();
  }
  
  
  
  
}
