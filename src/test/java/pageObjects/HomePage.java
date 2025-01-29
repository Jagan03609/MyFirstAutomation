package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
public HomePage(WebDriver driver) {
	super(driver);
	
}

@FindBy(xpath="//a[@data-qtip='Preferences']")
WebElement Preferences;

@FindBy(xpath="(//input[@type='button'])[3]")
WebElement ChkboxCurrencyConversion;

@FindBy(xpath="//span[text()='Save']")
WebElement SaveCurrencyConversion;

@FindBy(xpath="//a[@data-qtip='Logout']")
WebElement Logout;

@FindBy(xpath="")
WebElement ClkPernddate;

@FindBy(xpath="")
WebElement calender; 

@FindBy(xpath="")
WebElement Dackerheader; 

@FindBy(xpath="")
WebElement ClkNextMh;

@FindBy(xpath="")
WebElement Selectday;

public void CurrencyConversionCheck() throws InterruptedException {
	
	Preferences.click();
	Thread.sleep(3000);
	ChkboxCurrencyConversion.click();
	Thread.sleep(3000);
	SaveCurrencyConversion.click();
	
}
public boolean HomePageLoginCheck() throws InterruptedException {
	Thread.sleep(15000);
	Logout.isDisplayed();
	return true;
	
	
}

}
