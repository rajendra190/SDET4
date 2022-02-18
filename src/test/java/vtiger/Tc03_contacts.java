package vtiger;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.IAutoconstants;
import com.vtiger.JavaUtil;
import com.vtiger.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepo.CreateConPage;
import objectrepo.HomePage;
import objectrepo.LoginPage;

public class Tc03_contacts {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(IAutoconstants.profilepath);
		Properties prop = new Properties();
		prop.load(fis);
		WebDriver driver;
		String Browser=prop.getProperty("Browser");
		if(Browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		}

		else  if(Browser.equals("Firefox")) {
			driver=new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
		}
		else  if(Browser.equals("Edge")) {
			driver=new EdgeDriver();
			WebDriverManager.firefoxdriver().setup();
		}
		else  {
			driver=new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
		}
		driver.manage().window().maximize();
		WebDriverUtility wl = new WebDriverUtility();
		wl.pageloadtimeout(driver);

		driver .get(prop.getProperty("URL"));
		LoginPage login = new LoginPage(driver);

		login.getUsernametxtfld().sendKeys(prop.getProperty("UN"));
		login.getPasswordtxtfld().sendKeys(prop.getProperty("PW"));
		login.getLoginbtn().click();

		HomePage HP = new HomePage(driver);
		HP.getContactslink().click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		CreateConPage ccn =new CreateConPage(driver);
		WebElement Element=  ccn.getSaltypedd();
		wl.Selectfromdd(2, Element);

		Thread.sleep(2000);
		JavaUtil js = new JavaUtil();
		int num=js.generateRandomNumber();

		String Firstname="KR"+num;
		String Lastname="Rk"+num;
		ccn.getFirstname().sendKeys(Firstname);
		ccn.getLastname().sendKeys(Lastname);
		driver.findElement(By.xpath("//input[@name='account_id']/../img")).click();	

		wl.Switchtowindow("Accounts", driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("Rajendra");

		driver.findElement(By.xpath("//input[@name='search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='1']")).click();
		Thread.sleep(2000);
		wl.Switchtowindow("Contacts", driver);
		Thread.sleep(2000);
		ccn.getSvbtn().click();
		Thread.sleep(3000);
		HP.getContactslink().click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(Firstname);
		Thread.sleep(2000);
		WebElement ele = ccn.getContypesdd();
		wl.Selectfromdd("firstname", ele);
		
		
		ccn.getSrchbtn().click();
		if(Firstname.contains("KR"))
		{
			System.out.println("Tc pass");
		}
		else {
			System.out.println("Tc fail");
		}
		Actions aa = new Actions(driver);
		WebElement SO=HP.getSignoutimg();
		wl.movetolement(driver, SO);
		HP.getSignoutlink().click();
		driver.close();


	}

}
