
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestExtentReport {

	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	@BeforeTest

	public void setup() {

		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		driver = new FirefoxDriver();

		report = new ExtentReports("C:\\Users\\KANNA\\eclipse-workspace\\" + "TestExtentReports\\report.html", true);
		test = report.startTest("Extent report demo");

	}

	@Test()
	public void verifyTitle() {

		test.log(LogStatus.INFO, "verifyTitle method is started");
		test.log(LogStatus.PASS, "verifyTitle method is ended");

	}

	@Test()

	public void verifyUrl() {

		test.log(LogStatus.INFO, "verifyUrl method is started");
		test.log(LogStatus.PASS, "verifyUrl method is ended");

	}

//	""
	@Test
	public void verifyGmailLink() throws IOException {
		test.log(LogStatus.INFO, "verifyGmailLink method is started");
		test.log(LogStatus.FAIL, "verifyGmailLink method is ended");
		}

	@Test
	public void skipTest() {
		test.log(LogStatus.INFO, "skipTest method is started");
		test.log(LogStatus.SKIP, "skipTest method is ended");
	}

	@Test
	public void failTest() {
		test.log(LogStatus.INFO, "failTest method is started");
		test.log(LogStatus.FAIL, "failTest method is ended");
	}

	@Test
	public void warningTest() {
		test.log(LogStatus.INFO, "warningTest method is started");
		test.log(LogStatus.WARNING, "warningTest method is ended");
	}

	@Test
	public void errorTest() {
		test.log(LogStatus.INFO, "errorTest method is started");
		test.log(LogStatus.ERROR, "errorTest method is ended");
	}

	@Test()
	public void searchData() {
		test.log(LogStatus.INFO, "searchData method is started");
		test.log(LogStatus.PASS, "searchData method is ended");
	}

	
	@AfterTest
	public void teardown() {

		driver.quit();
		report.endTest(test);
		report.flush();

	}
}
