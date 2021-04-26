package com.Novartis;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class Calculators {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// driver.navigate().to("https://return-order-app.herokuapp.com/");
		driver.get("https://www.mortgageloan.com/calculator");
		driver.findElement(By.xpath("//*[@id=\"svg_bg_ML_ElementSectionCTA3866\"]/span/span")).click();
		driver.findElement(By.cssSelector("input[name='LOAN_AMOUNT']")).clear();
		driver.findElement(By.cssSelector("input[name='LOAN_AMOUNT']")).sendKeys("$200,000");
		Select s = new Select(driver.findElement(By.cssSelector("select[name='TERM']")));
		s.selectByIndex(25);
		driver.findElement(By.cssSelector("input[name='INTEREST_RATE']")).clear();
		driver.findElement(By.cssSelector("input[name='INTEREST_RATE']")).sendKeys("5%");
		System.out.println("done");
		// Verifaying the actual results based on our data
		SoftAssert s1 = new SoftAssert();
		String monthlypayment = driver.findElement(By.id("KJE-MONTHLY_PAYMENT")).getText();
		System.out.println("monthlypayment" + monthlypayment);
		s1.assertEquals(monthlypayment, "$1,073.64");
		String total_Payments = driver.findElement(By.cssSelector("h2[class='KJEGraphTitle']")).getText();
		System.out.println("total_Payments" + total_Payments);
		s1.assertEquals(total_Payments, "$386,513");
		String total_intrest = driver.findElement(By.xpath("//*[@id=\"KJE-C-GRAPH1\"]/div/table/tbody/tr/td[1]/h2/div"))
				.getText();
		System.out.println("total_intrest" + total_intrest);
		s1.assertEquals(total_intrest, "$186,513");
		System.out.println(" your Mortgage Payment Calculator is done");
	}
}
