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

@FindBy(xpath="//input[@type='submit']")
WebElement txtSubmit;


@FindBy(xpath="//input[@type='password']")
WebElement txtPassword;

@FindBy(xpath="//input[@type='submit']")
WebElement btnLogin;

@FindBy(xpath="//input[@name='DataSourceID']")
WebElement dataSourceID;


@FindBy(xpath="//span[text()='OK']")
WebElement Ok;


public void setName(String name) {
	txtName.sendKeys(name);
}
public void setSubmit() {
	txtSubmit.click();
}
public void setpassword(String pwd) {
	txtPassword.sendKeys(pwd);
}
public void setLogin() {
	btnLogin.click();
}
public void setdatasourceID() {
	dataSourceID.click();
}
public void setProduction(String prodName) {
	dataSourceID.sendKeys(prodName);
}

public void setOk() {
	Ok.click();
}

}
