package com.searce.utilities;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;




public class Driver {

	
	
	 private static WebDriver driver;

	    //private static Logger LOGGER = Logger.getLogger(Driver.class.getName());
	    private static long timeout=10;
	    public enum DriverTypes {
	        INTERNETEXPLORER,FIREFOX,CHROME,GHOST

	    }
	    public static DriverTypes defaultDriver = DriverTypes.FIREFOX;
	    /*  private static FirefoxProfile profile = new FirefoxProfile();
	      private static ChromeOptions options = new ChromeOptions();
	  */
	    public static WebDriver getDriver(DriverTypes d)
	    {
	        if(driver==null)
	        {
	            switch(d)
	            {
	                case INTERNETEXPLORER:
	                    System.setProperty("webdriver.ie.driver", "C:\\Users\\idnkiw\\bin\\IEDriverServer_64.exe");
	                    driver = new InternetExplorerDriver();
	                    break;
	                case CHROME:
	                    System.setProperty("WebDriver.chrome.driver", System.getProperty("user.dir")+"/newInvoice/drivers/chromedriver.exe");
	                    driver = new ChromeDriver();
	                    break;
	                    //"/Users/avdhoot.kulkarni/eclipse-workspace/newInvoice/drivers/chromedriver.exe"
	                    
	                    
	                case FIREFOX:
	                    driver = new FirefoxDriver();
	                    break;
	              /*  case GHOST:
	                    Capabilities caps = new DesiredCapabilities();
	                    ((DesiredCapabilities) caps).setJavascriptEnabled(true);                //< not really needed: JS enabled by default
	                    ((DesiredCapabilities) caps).setCapability("takesScreenshot", true);    //< yeah, GhostDriver haz screenshotz!
	                    ((DesiredCapabilities) caps).setCapability(
	                            PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
	                            "C:\\DEV\\ghostDriver\\phantomjs-1.9.7-windows\\phantomjs.exe"
	                    );
	                    driver = new PhantomJSDriver(caps);
	                    break;*/
	            }
	            defaultDriver = d;
	           // LOGGER.debug("Setting Browser to " + d);
	            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	           // LOGGER.debug("Setting Driver Time Out to 20 Seconds");
	            driver.manage().window().maximize();
	           // LOGGER.debug("Maximising Browser Window");
	        }
	        timeout=10;
	        //  SetBrowserLanguage(l);
	        return driver;
	    }

	    
		public static void SelectDate(WebElement calender,String year, String month, String dd) throws InterruptedException
		{
			driver.findElement(By.xpath("//button[@aria-label='Choose month and year']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[text()='"+year+"']")).click();
			Thread.sleep(1000);
			month.toUpperCase();
			driver.findElement(By.xpath("//div[text()='"+month+"']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[text()='"+dd+"']")).click();
			Thread.sleep(1000);	
			
		}
	    
}
