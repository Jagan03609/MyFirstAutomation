package testCases;

import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AccountingPeriodPage;

public class AccountingPeriodTest extends BaseClass{
	@Test
	public void UpdatePeriodControl() throws InterruptedException {
		AccountingPeriodPage ap=new AccountingPeriodPage(driver);
		ap.PeriodControl();
		
	}

}
