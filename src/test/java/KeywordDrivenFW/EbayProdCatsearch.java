package KeywordDrivenFW;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EbayProdCatsearch 
{
	public WebDriver driver;
	
	
	@Test
  public void Prodcatsearch() throws Exception
  {
	  XSSFWorkbook wb = new XSSFWorkbook("C:\\Selenium\\Keywords.xlsx");
	  XSSFSheet ws = wb.getSheet("Sheet1");
	  int rows = ws.getPhysicalNumberOfRows();
	   for(int i=1;i<rows;i++)
	   {
		   
		 String CTestCase = ws.getRow(i).getCell(0).getStringCellValue();
		 String CLocType = ws.getRow(i).getCell(1).getStringCellValue();
		 String CLocValue = ws.getRow(i).getCell(2).getStringCellValue();
		 String CTestData = ws.getRow(i).getCell(3).getStringCellValue();
		 
		 //if we have multiple choices to select choice and  the satements under that choice has to be executed
		 
		 switch(CTestCase)
		 {
		 case "Open_Browser":
			if(CTestData.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().version("98").setup();
				
				driver = new ChromeDriver();
			}
				else if(CTestData.equalsIgnoreCase("Firefox"))
				{
					WebDriverManager.firefoxdriver().version("97").setup();
					
					driver = new FirefoxDriver();
					
				}
			
			driver.manage().window().maximize();
			
			 
			 break;
		 	 
		 case "Enter_Url":
			 
			 driver.get(CTestData);
			 
			 Thread.sleep(3000);
			 
			 break; 
			 
			 
		 case "Select_Dropdown":
			
			WebElement dd = driver.findElement(locatorInfo(CLocType,CLocValue));
			 Select cat = new Select(dd);
			 cat.selectByVisibleText(CTestData);
			 
			 break;
			 
		 case "Enter_Text":
			 
			 WebElement txt = driver.findElement(locatorInfo(CLocType,CLocValue));
			 txt.sendKeys(CTestData);
			 
			 
			 break;
			 
		 case "click_Button":
			 WebElement btn = driver.findElement(locatorInfo(CLocType,CLocValue));
			 btn.click();
			 
			 break;	 
			 
			 
		 
		 }
				
		   
	   }
  }

	@Test
	public By locatorInfo(String lType,String lValue)
	{
		
		By b = null;
		
		
		
		
		
			   //creating By type variable and returning the B value
			  
			   
			   
			   
			//8 locators are there,based on the excel file locator type and locator value will be generated and returning to the b calling program
			   switch(lType)
			   {
			   
			   case "id":
				
				   b= By.id(lValue);
				   break;
				   
			   case "name":
					
				   b= By.name(lValue);
				   break;
				   
			   case "className":
					
				   b= By.className(lValue);
				   break;
				   
			   case "xpath":
					
				   b= By.xpath(lValue);
				   break;
				   
			   case "cssSelector":
					
				   b= By.cssSelector(lValue);
				   break;   
				   
			   case "linkText":
					
				   b= By.linkText(lValue);
				   break;
				   
			   case "partiallinkText":
					
				   b= By.partialLinkText(lValue);
				   break;
		
		
	}
			return b;

}
}
	   