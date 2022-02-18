package objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath="//a[.='Organizations']")
	private WebElement Organisationlink;
	
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement Contactslink;

	public WebElement getOrganisationlink() {
		return Organisationlink;
	}

	public WebElement getContactslink() {
		return Contactslink;
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutimg;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signoutlink;

	public WebElement getSignoutimg() {
		return signoutimg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	

}
