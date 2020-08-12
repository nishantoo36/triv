package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.SeleniumUtility;

public class ContactFormPage extends SeleniumUtility {

    public ContactFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "contact-msg")
    WebElement messageBox;

    @FindBy(xpath = "//div[contains(text(),'Full Name')]/child::input")
    WebElement fullNameField;

    @FindBy(id = "contact-email")
    WebElement emailField;

    @FindBy(id = "confirm")
    WebElement checkBox;

    @FindBy(className = "contact-submit")
    WebElement submit;

    @FindBy(className = "feedback")
    WebElement feedbackMessage;


    public boolean isUserOnContactFormPage(String url){
        return url.equals(getCurrentPageUrl());
    }

    public void enterMessageInContactForm(String message){
        enterValue(messageBox,message,5);
    }

    public void enterFullNameInContactForm(String fullName){
        enterValue(fullNameField,fullName,5);
    }

    public void enterEmailInContactForm(String email){
        enterValue(emailField,email,5);
    }

    public void selectCheckBoxInContactForm(){
        clickOnElement(checkBox,5);
    }

    public void submitContactForm(){
        clickOnElement(submit,5);
    }

    public boolean isContactFormSubmittedSuccessFully(String message){
        return getText(feedbackMessage,20).equals(message);
    }
}

