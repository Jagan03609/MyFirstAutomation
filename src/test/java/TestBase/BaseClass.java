package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.LoginPage;

public class BaseClass {

	       public Logger logger;	
		   public static WebDriver driver;
		   public Properties p;
			
			@BeforeClass()
			@Parameters({"browser","os"})
			public void Setup(String browser,String os) throws IOException, InterruptedException {
				FileReader file=new FileReader(".//src//test//resources//config.properties");
				p=new Properties();
				p.load(file);
			logger=LogManager.getLogger(this.getClass());
			
			/*switch (br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver();break;
			case "IE":driver=new InternetExplorerDriver();break;
			case "Edge":driver=new EdgeDriver();break;
			default : System.out.println("Invalid browser name...."); return;
			}*/
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.get(p.getProperty("url"));
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().window().maximize();
			
			LoginPage lp=new LoginPage(driver);
			lp.setName(p.getProperty("username"));
			Thread.sleep(2000);
			logger.info("log in user");
			lp.setSubmit();
			Thread.sleep(20000);
			lp.setpassword(p.getProperty("password"));
			logger.info("user password successful");
			Thread.sleep(10000);
			lp.setLogin();
			Thread.sleep(40000);
			logger.info("CPAS App login success");
			lp.setdatasourceID();
			Thread.sleep(5000);
			lp.setProduction(p.getProperty("production"));
			Thread.sleep(15000);
			lp.setOk();
			Thread.sleep(25000);
			}
			
			@AfterClass
			public void tearDown() {
				//driver.quit();
			}
			
			public String Randomstring() {
				String RandomgeneratedString=RandomStringUtils.randomAlphabetic(5);
				return RandomgeneratedString;
			}
			
			public String AlphaNumeric() {
				String RandomgeneratedAlphaNumeric=RandomStringUtils.randomAlphanumeric(6, 12);
				return RandomgeneratedAlphaNumeric;
			}
			
			public String CaptureScreen(String tName) {
				
				String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				TakesScreenshot takescreenshot=(TakesScreenshot)driver;
				File sourcefilepath=takescreenshot.getScreenshotAs(OutputType.FILE);
				String targetfilepath=System.getProperty("user.dir")+"\\screenShots\\"+tName+ "_"+timeStamp+ ".png";
				File targetfile=new File(targetfilepath);
				sourcefilepath.renameTo(targetfile);
				return targetfilepath;
			}
		}




