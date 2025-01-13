package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import Utilities.DataProviders;
import pageObjects.DashBoardPage;
import pageObjects.LoginPage;

public class TC006_LoginDDT extends BaseClass{
		
	/* Data is Valid -Login success- test pass -logout
	 * Data is Valid -Login failed- test fail 
	  * Data is InValid -Login un_success- test pass 
	 * Data is InValid -Login success- test fail -logout
	 */
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
public void Verify_loginDDT(String username,String pwd,String exp) throws InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setName(username);
		Thread.sleep(2000);
		lp.setpassword(pwd);
		Thread.sleep(3000);
		lp.setLogin();
		Thread.sleep(5000);
		
		DashBoardPage db=new DashBoardPage(driver);
		boolean target=db.SetVerifyPageTitle();
		
		if(exp.equalsIgnoreCase("valid")) {
			if(target==true) {
				db.setLogOut();
				Thread.sleep(3000);
				Assert.assertTrue(true);
				
			}else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid")) {
			if(target==false) {
				Assert.assertTrue(true);
				Thread.sleep(3000);
			}else {
				db.setLogOut();
				Assert.assertTrue(false);
				
			}
		}
		
		
	}
	
	
	
}
