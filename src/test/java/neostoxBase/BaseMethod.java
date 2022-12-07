package neostoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxUtility.*;


public class BaseMethod 
{
	  public static WebDriver driver;
		public void launchbrwoser() throws IOException
		{
			System.setProperty("webdriver.chrome.driver", "E:\\myselenium file\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(NeoStoxUtility.readDataFromPropertyFile("url"));
			Reporter.log("launching browser ", true);
		}
		
}
