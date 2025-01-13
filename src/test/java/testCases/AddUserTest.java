package testCases;

import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AddUserPage;

public class AddUserTest extends BaseClass{
	@Test
	public void AdduserDetails() throws InterruptedException {
		
				
		AddUserPage userdetail=new AddUserPage(driver);
		
		userdetail.setbtnAdmin();
		//Log.info("admin page is opened");
		
		userdetail.setbtnAdd();
		userdetail.setRoletye();
		userdetail.setRolestatus();
		userdetail.SetNewUser("TestSam");
		userdetail.SetNewpwd("sam123");
		userdetail.SetEmployee("sam");
		//Log.info("all mandatory field are entered");
		userdetail.setbtnSave();
		//Log.info("user is Saved successful");
	}

}
