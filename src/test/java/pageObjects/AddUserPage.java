package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends BasePage {
public AddUserPage(WebDriver driver) {
	super(driver);
}


@FindBy(xpath="//span[text()='Admin']")
WebElement btnAdmin;

@FindBy(xpath="(//div[text()='-- Select --'])[1]")
WebElement RoleType;
@FindBy(xpath="//div[text()='Admin']")
WebElement ClickAdmin;

@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
WebElement ClickAdd;


@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span")
WebElement ClickUserManage;

@FindBy(xpath="//a[text()='Users']")
WebElement ClickUser;


@FindBy(xpath="(//div[text()='-- Select --'])[2]")
WebElement Rolestatus;

@FindBy(xpath="(//div[text()='Enabled'])")
WebElement ClickEnable;

@FindBy(xpath="//input[@placeholder='Type for hints...']")
WebElement txtnewusername;

@FindBy(xpath="//input[@type='password']")
WebElement txtnewPwd;

@FindBy(xpath="//input[@type='password']")
WebElement txtnewConfirmPwd;

@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")
WebElement txtnewemployee;

@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]/text()")
WebElement btnSave;

public void setbtnAdmin() throws InterruptedException {
	btnAdmin.click();
	Thread.sleep(5000);
}

public void setbtnAdd() throws InterruptedException {
	ClickAdd.click();
	//ClickUserManage.click();
	//ClickUser.click();
	Thread.sleep(2000);
}

public void setRoletye() {
	RoleType.click();
	ClickAdmin.click();
}


public void setRolestatus() {
	Rolestatus.click();
	ClickEnable.click();
}

public void SetNewUser(String user) {
	txtnewusername.sendKeys(user);
	
}
public void SetNewpwd(String pwd) {
	txtnewusername.sendKeys(pwd);
	
}
public void SetNewconfirmpwd(String cpwd) {
	txtnewusername.sendKeys(cpwd);
	
}
public void SetEmployee(String emp) {
	txtnewusername.sendKeys(emp);
}

public void setbtnSave() {
	btnSave.click();
}
}




