package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountingPeriodPage extends BasePage {
	public AccountingPeriodPage(WebDriver driver) {
		super(driver);
	}
	String sdate;
	String smonth;
	String syear;
	
	@FindBy(xpath="/html/body/div[2]/div[3]/div/div/div[12]/div[1]/div/div/div[2]/img")
	WebElement MaintenanceButton;
	
	@FindBy(xpath="//span[text()='Period Control']")
	WebElement accountperiodBtn;
	
	@FindBy(xpath="(//table/tbody//tr/td[5]//div)[7]")
	WebElement SelectCurrentOpen;
	
	@FindBy(xpath="//div[text()='30']")
	WebElement nextmonthDate;
	
	@FindBy(xpath="//input[@name='PeriodEndDate']")
	WebElement ClkPeriodEnddate;
	
	@FindBy(xpath="//*[@id='datefield-1510-trigger-picker']")
	WebElement calender; 
	
	@FindBy(xpath="//*[@id='splitbutton-1513-btnInnerEl']")
	WebElement DatePickerheader;  //*[@id="ext-element-15"]  //*[@id='splitbutton-1513-btnInnerEl']
	
	@FindBy(xpath="//div[@title='Next Month (Control+Right)']")
	WebElement ClkNextMonth;
	
	@FindBy(xpath="xpathname")
	WebElement Selectday;
	
	
	
	@FindBy(xpath="//span[text()='Save']")
	WebElement ClkSave;
	
	public void PeriodControl() throws InterruptedException {
		MaintenanceButton.click();
		Thread.sleep(5000);
		accountperiodBtn.click();
		Thread.sleep(10000);
		SelectCurrentOpen.click();
		Thread.sleep(3000);
		ClkPeriodEnddate.click();
		Thread.sleep(3000);
		calender.click();
		CanlederPeriodDate(sdate="27",smonth="January",syear="2025");
		}

	
	public void CanlederPeriodDate(String date,String month,String year) throws InterruptedException {
		//DatePickerheader.click();
		String yearmonthval=DatePickerheader.getText();
		System.out.println(yearmonthval);
		String cmonth=yearmonthval.split(" ")[0].trim();
		System.out.println(cmonth);
		Thread.sleep(3000);
		String cyear=yearmonthval.split(" ")[1].trim();
		System.out.println(cyear);
		while(!(cmonth.equals(smonth) && cyear.equals(syear))) {
			Thread.sleep(3000);
			ClkNextMonth.click();
			yearmonthval=DatePickerheader.getText();
			System.out.println(yearmonthval);
			cmonth=yearmonthval.split(" ")[0].trim();
			cyear=yearmonthval.split(" ")[1].trim();
		}
		
		String xpathname="//div[text()=\'"+sdate+"']";
		driver.findElement(By.xpath(xpathname)).click();
		Thread.sleep(3000);		
		ClkSave.click();
				
	}

}
