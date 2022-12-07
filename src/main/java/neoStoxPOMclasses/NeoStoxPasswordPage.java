package neoStoxPOMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxPasswordPage 
{

	@FindBy(id = "txt_accesspin") private WebElement pwd;
	@FindBy(id = "lnk_submitaccesspin")private WebElement submit;
	
	
	public NeoStoxPasswordPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterPassword(String pswd)
	{
		pwd.sendKeys(pswd);
		Reporter.log("entering password", true);
	
	}
	
	public void clickOnSubmitButton()
	{
		submit.click();
		Reporter.log("clicking on submit button", true);
		
	}
	
}
