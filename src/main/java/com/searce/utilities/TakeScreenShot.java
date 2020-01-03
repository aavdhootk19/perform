package com.searce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class TakeScreenShot {

	public static String takeScreenshot(WebDriver driver, String testCaseName) throws IOException
    {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            SimpleDateFormat sd = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
            String DateStr = sd.format(new Date());
            String imageName = testCaseName+"_screenshot"+DateStr+".png";
            String imagePath=System.getProperty("user.dir")+"/reports/screenshots/"+imageName;
            FileUtils.copyFile(scrFile, new File(imagePath)); // C:\DEEPALI\IMG.JPS

            return imagePath.concat(imageName) ;

    }

	
}
