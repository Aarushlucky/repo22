package Pomtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pompages.CLSEbayObjects;
import Pompages.Driverfactory;

public class POMEbaycatserachtest {
  @Test
  public void Catserach() 
  
  {
	  WebDriver driver = Driverfactory.startbrowser("chrome", "https://ebay.com");
	  
	  CLSEbayObjects obj = new CLSEbayObjects(driver);
		
		obj.fncatsearch("Cameras & Photo", "Sony");
		  
	    
	    Reporter.log("ebay earch test is successful :", true);
	  
	  
  }
}
