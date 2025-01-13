package testCases;

import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.DashBoardPage;

public class VerifyDashboard_002 extends BaseClass{
	@Test()
	public void verifyDashBoad() {
		DashBoardPage db=new DashBoardPage(driver);
		db.SetVerifyPageTitle();
	}

}
