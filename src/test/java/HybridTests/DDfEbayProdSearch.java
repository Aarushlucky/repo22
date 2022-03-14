package HybridTests;

import org.testng.annotations.Test;

import Pompages.CLSEbayObjects;
import Pompages.CLSExceldata;
import Pompages.Driverfactory;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class DDfEbayProdSearch {
	@Test(dataProvider = "Ebayprod")
	  public void Prodsearch(String ddvalue , String Prodname) //this method depends on dataprovider
	  {
		  
		 WebDriver driver = Driverfactory.startbrowser("chrome", "https://ebay.com");
		 
		 CLSEbayObjects obj = new CLSEbayObjects(driver);
		 obj.fnsearch(Prodname);
		 
		  
	  
	  Reporter.log("ebay search test is successful :", true);
		  
	  }

	  @DataProvider
	  public Object[][] Ebayprod() throws Exception
	  {
		  
		//declaring the multidimensional array mydata 
	      Object[][] mydata = CLSExceldata.getExceldata("C:\\Selenium\\Ebay.xlsx");
	    	
	     return  mydata;
	    	
	      
	    }
	  }