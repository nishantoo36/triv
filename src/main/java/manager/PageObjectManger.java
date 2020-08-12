package manager;


import PageObject.CommonActions;
import PageObject.ContactFormPage;
import PageObject.MagazinePage;
import org.openqa.selenium.WebDriver;
public class PageObjectManger {

	public WebDriver driver;
	public MagazinePage magazinePage;
	public CommonActions commonActions;
	public ContactFormPage contactFormPage;


	public PageObjectManger(WebDriver driver) {
		this.driver = driver;
	}

	public CommonActions getCommonActionsScreen() {
		return (commonActions == null) ? commonActions = new CommonActions(driver) : commonActions;
	}
	public MagazinePage getMagazineScreen() {
		return (magazinePage == null) ? magazinePage = new MagazinePage(driver) : magazinePage;
	}
	public ContactFormPage getContactFormPage() {
		return (contactFormPage == null) ? contactFormPage = new ContactFormPage(driver) : contactFormPage;
	}

}


