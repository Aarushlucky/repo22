package Pomtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ebaysearch {
  @Test
  public void Search()
  {
	  

	  WebDriverManager.chromedriver().version("98").setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://ebay.com");
		driver.manage().window().maximize();
		
				
	driver.findElement(By.id("gh-ac")).sendKeys("Sony");
    driver.findElement(By.id("gh-btn")).click();
	  
    
    Reporter.log("ebay earch test is successful :", true);
	  
  }
}
