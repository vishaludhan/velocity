package neoStoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityMethods
{

	
		public static void takeScreenShot(WebDriver driver,String name) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File des=new File("D:\\Screendhots\\"+name+".png");
		FileHandler.copy(src, des);
		Reporter.log("taking screenshot", true);
		
	}


	public static java.lang.String getExcellSheetData(int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		File myfile=new File("D:\\Screendhots\\myfile.xlsx");
		
		Sheet mySheet = WorkbookFactory.create(myfile).getSheet("Sheet2");
		String value = mySheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}

	public static void scrollToElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	public static void Imwait(WebDriver driver,int timeMs)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(timeMs));
	}


	public static String readDataFromPropertyFile(String value) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream myfile=new FileInputStream("C:\\Users\\udhan\\eclipse-workspace\\9ThJuly\\Neostox.properties");
	    prop.load(myfile);
	    
	     String val = prop.getProperty(value);
	     return val;
	}

	
	
	
}
