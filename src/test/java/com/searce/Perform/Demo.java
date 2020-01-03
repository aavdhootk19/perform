package com.searce.Perform;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		System.setProperty("Webdriver.chrome.driver", "/happierPerform/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://test-perform-a7-dot-dev-happierwork.appspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("identifierId")).sendKeys("avdhoot.kulkarni@searcelabs.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.name("password")).sendKeys("searce@123");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		//driver.switchTo().alert().accept();
			Thread.sleep(3000);
		
		
		driver.navigate().to("https://test-perform-a7-dot-dev-happierwork.appspot.com/#/perform/okr/my");

		Thread.sleep(10000);
		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[@aria-label='Create new OKR']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("krTarget_0")).sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);

		driver.findElement(By.id("krTarget_0")).sendKeys("20");
		Thread.sleep(3000);
		driver.findElement(By.id("krActualCompletion_0")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.id("krActualCompletion_0")).sendKeys("10");
		
		

	}

}
