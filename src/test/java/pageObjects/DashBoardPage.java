package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends BasePage {
	
	public DashBoardPage(WebDriver driver) {
		super(driver);
	}
@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']")
WebElement pagetitle;

@FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
WebElement UserDropdown;

@FindBy(xpath="//li//a[text()='Logout']")
WebElement LogoutUser;


public boolean SetVerifyPageTitle() {
	
	String title=pagetitle.getText();
	System.out.println("page title is :"+title);
	try{
		return pagetitle.isDisplayed();
	}catch(Exception e) {
		return false;
		
	}
	
	
}

public void setLogOut() throws InterruptedException {
	Thread.sleep(3000);
	UserDropdown.click();
	Thread.sleep(2000);
	LogoutUser.click();
	System.out.println("Logout success");
}

}
