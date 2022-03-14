package DDFDemos;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class DDFEbayProdcatsearch {
	  @Test(dataProvider = "Ebayprod")
	  public void Prodcatsearch(String cat , String txtvalue) //this method depends on dataprovider
	  {
		  
		  WebDriverManager.chromedriver().version("98").setup();
		  WebDriver driver = new ChromeDriver();
			driver.get("https://ebay.com");
			driver.manage().window().maximize();
			
			WebElement dd = driver.findElement(By.id("gh-cat"));
	    	 Select category = new Select(dd);
	    	 category.selectByVisibleText(cat);
	    	 
	    	 
	    	 
					
		driver.findElement(By.id("gh-ac")).sendKeys(txtvalue);
	    driver.findElement(By.id("gh-btn")).click();
		  
	  
	  Reporter.log("ebay search test is successful :", true);
		  
	  }

	  @DataProvider
	  public Object[][] Ebayprod() throws IOException //Ebayprod is a Obj multidimesional return data type
	  {
		  
		//declaring the multidimensional array mydata 
	      Object[][] mydata =null; 
	      //pulling the data and store the data in the object array in the form of rows and columns
	      
	      XSSFWorkbook wb = new XSSFWorkbook("C:\\Selenium\\Ebay.xlsx");
			
		  XSSFSheet ws = wb.getSheet("Sheet1");
		  
		  int rows = ws.getPhysicalNumberOfRows();//active rows to identify
		  mydata = new Object[rows][2]; //how many rows and columns are there array size,matrix array will  be created
		  for(int i=1;i<rows;i++)
		  {
			  
			 mydata[i][0]= ws.getRow(i).getCell(0).getStringCellValue();
			 mydata[i][1]=ws.getRow(i).getCell(1).getStringCellValue();
		  }
		  
	    	
	     return  mydata;
	    	
	      
	    }
	  }
