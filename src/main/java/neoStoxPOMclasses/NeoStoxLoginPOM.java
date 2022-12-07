package neoStoxPOMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxLoginPOM 
{                         
            @FindBy(id = "MainContent_signinsignup_txt_mobilenumber")private WebElement mobNo;
            @FindBy(id = "lnk_signup1") private WebElement signInButton;
           
          
            public NeoStoxLoginPOM(WebDriver driver)
            {
            	
            	PageFactory.initElements(driver, this);
            	
            }
            
            public void enterMobNo(String moNO)
            {
            	mobNo.sendKeys(moNO);
            	Reporter.log("entering mobile no", true);
            	
            }
            
            public void clickOnSignInButton()
            {
            	signInButton.click();
            	Reporter.log("clicking on sign in button", true);
            
            }
}
