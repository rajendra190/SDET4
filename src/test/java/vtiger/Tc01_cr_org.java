package vtiger;

import java.io.FileInputStream;

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

import com.vtiger.ExcelUtils;
import com.vtiger.FileUtils;
import com.vtiger.IAutoconstants;
import com.vtiger.JavaUtil;
import com.vtiger.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepo.Createorgpage;
import objectrepo.HomePage;
import objectrepo.LoginPage;
import objectrepo.OrgInfoPage;



public class Tc01_cr_org {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver;
		FileUtils fu=new FileUtils();
		
		String Browser = fu.Readdatafromprop("Browser");
		if(Browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		else if(Browser.equalsIgnoreCase("Firefox")){
			driver= new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
		}
		else if(Browser.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
			WebDriverManager.edgedriver().setup();
		}
		else{
			driver=new FirefoxDriver();
		}
		
		driver.get(fu.Readdatafromprop("URL"));
		driver.manage().window().maximize();
		WebDriverUtility wl= new WebDriverUtility();
		wl.pageloadtimeout(driver);
		  
		LoginPage login=new LoginPage(driver);
		
		login.getUsernametxtfld().sendKeys(fu.Readdatafromprop("UN"));
		login.getPasswordtxtfld().sendKeys(fu.Readdatafromprop("PW"));
		login.getLoginbtn().click();
		HomePage HP =new HomePage(driver);
		HP.getOrganisationlink().click();
		OrgInfoPage OIF= new OrgInfoPage(driver);
		OIF.getCreateorgimg().click();
		
		JavaUtil jv = new JavaUtil();
//		String s=jv.fakeCompanyName();
		String s="hddjhfksdkjfh";
		Thread.sleep(2000);
		Createorgpage cp=new Createorgpage(driver);
		cp.getOrgname().sendKeys(s);
		cp.getOrgSavebutton().click();
		Thread.sleep(3000);
		HP.getOrganisationlink().click();


		OIF.getSearchtxtbox().sendKeys(s);
		
		Thread.sleep(2000);
		
		WebElement element = OIF.getOrgtypesdd();
		wl.Selectfromdd(element, "Organization Name");
//		
		
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(2000);
		String sen = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		
		System.out.println(sen);
	
		if(sen.equals(s))
		{
			System.out.println("Tc pass");
		}
		else {
			System.out.println("Tc fail");
		}
         Thread.sleep(2000);
		
		WebElement path = HP.getSignoutimg();
		wl.movetolement(driver, path);
		HP.getSignoutlink().click();

        driver.close();
	}

}





