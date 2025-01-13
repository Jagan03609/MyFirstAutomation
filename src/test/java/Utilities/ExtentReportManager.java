package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener  {
	
public  static ExtentSparkReporter sparkreporter;
public  static ExtentReports extent;
public static ExtentTest test;
private String  repName;
@Override
public void onStart(ITestContext testcontext){
	String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	repName="Test-Report-"+timeStamp+".html";
		String reportPath="./repots/" + repName;
		File reportDir=new File("./reports");
		
		extent =new ExtentReports();
		sparkreporter=new ExtentSparkReporter(reportPath);
		
	
	sparkreporter.config().setDocumentTitle("ORM Automation Report");
	sparkreporter.config().setReportName("ORM functional report");
	sparkreporter.config().setTheme(Theme.DARK);
	extent.attachReporter(sparkreporter);
	
	
	extent.setSystemInfo("Sum Module","users");
	extent.setSystemInfo("User Name", System.getProperty("user.name"));
	extent.setSystemInfo("Environment", "QA");
	
	
	String os=testcontext.getCurrentXmlTest().getParameter("os");
	extent.setSystemInfo("Operating System", os);
	
	String browser=testcontext.getCurrentXmlTest().getParameter("browser");
	extent.setSystemInfo("Browser", browser);
	
	//List<String> IncludedGroups=testcontext.getCurrentXmlTest().getIncludedGroups();
	//if(!IncludedGroups.isEmpty()) {
		//extent.setSystemInfo("Groups", IncludedGroups.toString());
	//}
}
@Override
public void onTestSuccess(ITestResult result) {
	test=extent.createTest(result.getTestClass().getName()+"_"+result.getMethod().getMethodName());
	test.assignCategory(result.getMethod().getGroups());
	test.log(Status.PASS, result.getName()+"got successfully excuted");
	
}
@Override
public void onTestFailure(ITestResult result){
	
	test=extent.createTest(result.getTestClass().getName()+"_"+result.getMethod().getMethodName());
	test.assignCategory(result.getMethod().getGroups());
	
	test.log(Status.FAIL, result.getName()+ "Got Fail");
	test.log(Status.INFO,"failure reason" + result.getThrowable().getMessage());
	String imgPath=new TestBase.BaseClass().CaptureScreen(result.getName());
	test.addScreenCaptureFromPath(imgPath);
	
	
}
@Override
public void onTestSkipped(ITestResult result) {
	test=extent.createTest(result.getTestClass().getName()+"_"+result.getMethod().getMethodName());
	test.assignCategory(result.getMethod().getGroups());
	
	test.log(Status.FAIL, result.getName()+ "got Skiped");
	test.log(Status.INFO, result.getThrowable().getMessage());
}
@Override
public void onFinish(ITestContext testcontext) {
	
	extent.flush();
	
	
}
}
