package Pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CLSEbayObjects

{

	
	public WebDriver driver;
	
	public CLSEbayObjects(WebDriver dd)  //initializing  the values to thge datamems,webdriver variable driver =null initially
	{
		driver = dd;
		
	}
	
	
	
     By txtsearch = By.id("gh-ac");
     By btnsearch = By.id("gh-btn");
     By ddcat = By.id("gh-cat");
     
     public void fnsearch(String Prodname)
     {
    	 
    	 driver.findElement(txtsearch).sendKeys(Prodname);
    	 driver.findElement(btnsearch).click();
    	 
    	  }
     
     public void fncatsearch(String cat,String Prodname) 
     
    {
    	 WebElement dd = driver.findElement(ddcat);
    	 Select category = new Select(dd);
    	 category.selectByVisibleText(cat);
    	 fnsearch(Prodname);
    	 
    	 
    	 
    	 
	}
     
     
}
