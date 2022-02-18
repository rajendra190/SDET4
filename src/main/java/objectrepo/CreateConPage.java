package objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateConPage {
	WebDriver driver;
	
	@FindBy(name="salutationtype")
	private WebElement saltypedd;
	
	@FindBy(name="firstname")
	private WebElement Firstname;
	
	@FindBy(name="lastname")
	private WebElement Lastname;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement Svbtn;
	
	@FindBy(name="submit")
	private WebElement srchbtn;
	
	
	public WebElement getSrchbtn() {
		return srchbtn;
	}
	@FindBy(name="search_field")
	private WebElement Contypesdd;
	
	public WebElement getContypesdd() {
		return Contypesdd;
	}

	public WebElement getSvbtn() {
		return Svbtn;
	}

	
	

	public WebElement getSaltypedd() {
		return saltypedd;
	}

	public WebElement getFirstname() {
		return Firstname;
	}

	public WebElement getLastname() {
		return Lastname;
	}
	public CreateConPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

}
