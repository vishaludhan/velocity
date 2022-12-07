package neostoxTest;

import java.io.IOException;

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
import neoStoxUtility.NeoStoxUtility;
import neostoxBase.BaseMethod;
@Listeners(neostoxBase.Listener.class)
public class NeoStoxTest2 extends BaseMethod {
	
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
		  login.enterMobNo(NeoStoxUtility.readDataFromPropertyFile("MOBno"));
		  login.clickOnSignInButton();
		  NeoStoxUtility.Imwait(driver, 2000);
		 
		  Thread.sleep(1000);
		  ps.enterPassword(NeoStoxUtility.readDataFromPropertyFile("password"));
		  ps.clickOnSubmitButton();
		  NeoStoxUtility.Imwait(driver, 5000);
		  ns=new NeostoxNoticePage(driver);
		  ns.handlePopup();
		  NeoStoxUtility.Imwait(driver, 2000);
	}
	
	
	
  @Test
  public void validatigUsename() throws IOException, InterruptedException 
  {
	  hm=new NeoStoxHomePage(driver);
	 String actualUN = hm.getUserName();
	 Assert.assertEquals(actualUN, NeoStoxUtility.readDataFromPropertyFile("Username"));
	 
	 
	   }
  @AfterMethod
  public void logoutFromApp() throws InterruptedException
  {
	  hm.logout(driver);
	  NeoStoxUtility.Imwait(driver, 2000);
	  
  }
  
  
 /* @AfterClass
  public void closeBrowser()
  {
	  driver.close();
  }*/
  
  
}
