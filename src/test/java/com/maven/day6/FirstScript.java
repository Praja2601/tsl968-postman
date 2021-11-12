package com.maven.day6;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FirstScript {
	ExtentReports ex;
	WebDriver driver;
  @Test
  public void dropDownExample() {
	  ex = new ExtentReports();
	  ex.attachReporter(new ExtentHtmlReporter("facebook.html"));
	  ExtentTest tc1 = ex.createTest("dropDownExample");
	  tc1.info("Setting implicit wait time");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  tc1.info("Opening Url");
	  driver.get("https://www.facebook.com/");
	  try {
		  Assert.assertEquals(driver.getTitle(),"Facebook – log in or sign up");
		  tc1.pass("Title verified & it is passed");
	  }catch(AssertionError E) {
		  tc1.fail(E.getMessage());
		  Assert.fail(E.getMessage());
	  } 
	  tc1.info("clicking on create new account");
	  driver.findElement(By.linkText("Create New Account")).click();
	  tc1.info("Selecting day of birth");
	  Select day = new Select(driver.findElement(By.name("birthday_day")));
	  day.selectByVisibleText("25");
	  tc1.info("Selecting month of birth");
	  Select month = new Select(driver.findElement(By.name("birthday_month")));
	  month.selectByVisibleText("May");
	  tc1.info("Selecting year of birth");
	  Select year = new Select(driver.findElement(By.name("birthday_year")));
	  year.selectByVisibleText("1988");
	  
	  tc1.pass("Selection from DropDown Completed");
	  //ex.flush();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() throws Exception {
	  ex.flush();
  }

}
