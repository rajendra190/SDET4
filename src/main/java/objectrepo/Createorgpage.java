package objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createorgpage {

	WebDriver driver;
	@FindBy(name="accountname")
	private WebElement Orgname;

	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement OrgSavebutton;

	public WebElement getOrgname() {
		return Orgname;
	}

	public WebElement getOrgSavebutton() {
		return OrgSavebutton;
	}
	

		@FindBy(xpath="//select[@name='industry']")
		private WebElement indtypedd;
		
		@FindBy(xpath="//select[@name='rating']")
		private WebElement ratetypedd;
		
		@FindBy(xpath="//select[@name='accounttype']")
		private WebElement accounttypedd;
	
		public WebElement getIndtypedd() {
			return indtypedd;
		}
	
		public WebElement getRatetypedd() {
			return ratetypedd;
		}
	
		public WebElement getAccounttypedd() {
			return accounttypedd;

}
		public Createorgpage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);


		}

		
}





