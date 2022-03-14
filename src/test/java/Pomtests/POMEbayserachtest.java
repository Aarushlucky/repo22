package Pomtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pompages.CLSEbayObjects;
import Pompages.Driverfactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class POMEbayserachtest {
  @Test
  public void Ebayserach() 
  
  {
	  
	 
	WebDriver driver = Driverfactory.startbrowser("chrome", "https://ebay.com");	
				
	CLSEbayObjects obj = new CLSEbayObjects(driver);
	obj.fnsearch("Sony");
	
	  
  
  Reporter.log("ebay earch test is successful :", true);
	  
  }
}
