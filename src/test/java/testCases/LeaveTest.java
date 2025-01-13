package testCases;

import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.LeavePage;

public class LeaveTest extends BaseClass {
	@Test()
	public void Test003LeaveComment() throws InterruptedException {
		LeavePage lp=new LeavePage(driver);
		lp.setLeave();
		Thread.sleep(2000);
		lp.setRecordsLeave();
		Thread.sleep(2000);
		lp.setAddcomments();
		Thread.sleep(2000);
		lp.setcomments();
		Thread.sleep(2000);
		lp.setSave();
	}
	@Test()
	public void Test004ViewLeaveDetails() throws InterruptedException {
		LeavePage lp=new LeavePage(driver);
		lp.setLeave();
		Thread.sleep(2000);
		lp.setRecordsLeave();
		Thread.sleep(2000);
		lp.setViewLeaveDetails();
		
	}

}
