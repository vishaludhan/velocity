package neoStoxPOMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeostoxNoticePage {
	 @FindBy(xpath = "(//div[@class='modal-header theme-bg'])[7]/child::button/span")private WebElement OKButton;
     @FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement closeB;
     
     
     public NeostoxNoticePage(WebDriver driver)
     {
     	
     	PageFactory.initElements(driver, this);
     	
     }
     
     
     public void handlePopup() throws InterruptedException 
     {
    	 if(OKButton.isDisplayed())
    	 {
    		 OKButton.click();
    		 Thread.sleep(500);
    		 closeB.click();
    		 Reporter.log("handling popup", true);
    		 
    		 
    	 }
    	 else
    	 {
    		 Reporter.log("there is no popup", true);
    	 }
    	 
    	 
     }
     
     
     
   
}
