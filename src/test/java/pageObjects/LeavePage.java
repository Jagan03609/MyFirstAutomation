package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeavePage extends BasePage{
	
	public LeavePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[text()='Leave']")
	WebElement btnLeave;

	@FindBy(xpath="(//i[@class='oxd-icon bi-three-dots-vertical'])[1]")
	WebElement RecordsLeave;
	@FindBy(xpath="//ul/li//p[text()='Add Comment']")
	WebElement Addcomment;

	@FindBy(xpath="//textarea[@placeholder='Comment here']")
	WebElement Commentshere;


	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement btnSave;

	@FindBy(xpath="//ul/li//p[text()='View Leave Details']")
	WebElement Leavedetails;


	@FindBy(xpath="")
	WebElement atus;

	public void setLeave() {
		btnLeave.click();
	}
public void setRecordsLeave() {
	RecordsLeave.click();
}
public void setAddcomments() {
	Addcomment.click();
}
public void setcomments() {
	Commentshere.sendKeys("due to home town");;
}
public void setSave() {
	btnSave.click();
}
public void setViewLeaveDetails() {
	Leavedetails.click();
}
}
