package neoStoxPOMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxHomePage 
{
@FindBy(id = "lbl_curbalancetop") private WebElement balance;
@FindBy(id = "lnk_logout") private WebElement log;
@FindBy(id = "lbl_username")private WebElement username;
      
      public NeoStoxHomePage(WebDriver driver)
      {
    	  PageFactory.initElements(driver, this);
      }
      public String getUserName()
      {
    	  String ActUserName = username.getText();
    	  Reporter.log("getting actual username", true);
    	  return ActUserName;
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
      }
      
	 public String getBalance()
	 {
		 String bal = balance.getText();
		 Reporter.log("getting balance", true);
		 return bal;
		 
	 }
     
      
      public void logout(WebDriver driver) throws InterruptedException
      {
    	  
    	  balance.click();
    
    	  log.click();
    	  Reporter.log("loging out", true);
    	  Thread.sleep(100);
    	  
      }
}     
    
