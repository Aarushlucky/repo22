package Pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory 

{
  public static WebDriver driver;
  
  public static WebDriver startbrowser (String browser,String url) 
  
  {
	  
	  if(browser.equalsIgnoreCase("chrome"))
	  {
		  WebDriverManager.chromedriver().version("98").setup();
		  driver = new ChromeDriver();
	  }
	  else if(browser.equalsIgnoreCase("firefox"))
	  {
	   WebDriverManager.firefoxdriver().version("97").setup();
	   driver = new FirefoxDriver();
	  }
	  
	  driver.get(url);
	  driver.manage().window().maximize();
	return driver;
	  
	  
  }


}

