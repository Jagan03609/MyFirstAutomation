package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
public LoginPage(WebDriver driver){
	super(driver);
	
}
@FindBy(xpath="//input[@name='username']")
WebElement txtName;

@FindBy(xpath="//input[@name='password']")
WebElement txtPassword;

@FindBy(xpath="//button[@type='submit']")
WebElement btnLogin;


public void setName(String name) {
	txtName.sendKeys(name);
}
public void setpassword(String pwd) {
	txtPassword.sendKeys(pwd);
}
public void setLogin() {
	btnLogin.click();
}
}
