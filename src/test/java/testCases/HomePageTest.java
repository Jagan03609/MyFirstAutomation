package testCases;

import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;

public class HomePageTest extends BaseClass{
	
	
	@Test(priority=0)
	public void VerifyHomePageLogin() throws InterruptedException {
		HomePage hp=new HomePage(driver);
	hp.HomePageLoginCheck();
	}
	@Test(priority=1)
	public void CheckCurrencyConversion() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.CurrencyConversionCheck();
	}
}
