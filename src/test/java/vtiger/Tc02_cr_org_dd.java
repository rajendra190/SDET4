package vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

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

import com.vtiger.FileUtils;
import com.vtiger.IAutoconstants;
import com.vtiger.JavaUtil;
import com.vtiger.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepo.Createorgpage;
import objectrepo.HomePage;
import objectrepo.LoginPage;
import objectrepo.OrgInfoPage;

public class Tc02_cr_org_dd {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(IAutoconstants.profilepath);
		Properties prop = new Properties();
		prop.load(fis);
		WebDriver driver;
		FileUtils fu=new FileUtils();
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


		LoginPage login=new LoginPage(driver);

		login.getUsernametxtfld().sendKeys(fu.Readdatafromprop("UN"));
		login.getPasswordtxtfld().sendKeys(fu.Readdatafromprop("PW"));
		login.getLoginbtn().click();

		HomePage HP =new HomePage(driver);
		HP.getOrganisationlink().click();

		OrgInfoPage OIF= new OrgInfoPage(driver);
		OIF.getCreateorgimg().click();

		FileInputStream fisex=new FileInputStream(IAutoconstants.excelpath);
		Workbook bis =WorkbookFactory.create(fisex);
		
		JavaUtil jv = new JavaUtil();
		int company=jv.generateRandomNumber();
		
		String s=bis.getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
		String orgname =s+company;
        Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		Thread.sleep(2000);
		
		Createorgpage cop = new Createorgpage(driver);
		
		WebElement Element = cop.getIndtypedd();
		wl.Selectfromdd(Element,"Hospitality");

		WebElement Element1 = cop.getRatetypedd();
		wl.Selectfromdd(2,Element1);
		
		WebElement Element2 = cop.getAccounttypedd();
		wl.Selectfromdd("Integrator",Element2);
		
		cop.getOrgSavebutton().click();
		
		Thread.sleep(3000);
		HP.getOrganisationlink().click();
		Thread.sleep(4000);
		OIF.getSearchtxtbox().sendKeys(orgname);
		WebElement sm = OIF.getOrgtypesdd();
		wl.Selectfromdd(sm, "Organization Name");

		OIF.getSearchorgbtn().click();
		Thread.sleep(4000);
		String value=	driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		System.out.println(value);
		if(value.equals(orgname))
		{
			System.out.println("Tc pass");
		}
		else {
			System.out.println("Tc fail");
		}

		WebElement ss=HP.getSignoutimg();
		wl.movetolement(driver, ss);
		HP.getSignoutlink().click();
		driver.close();

	}}