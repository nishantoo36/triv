package StepFiles;

import PageObject.ContactFormPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberHelper.TestContext;
import org.testng.Assert;

public class ContactFormPageSteps extends Logging {
    TestContext testContext;
    ContactFormPage contactFormPage;

    public ContactFormPageSteps(TestContext context) {
        testContext = context;
        contactFormPage = testContext.getPageObjectManger().getContactFormPage();
    }

    @Then("^current tab should appear as \"([^\"]*)\"$")
    public void currentTabShouldAppearAs(String url)  {
       log("Verify that user is on "+url+" page");
       Assert.assertTrue(contactFormPage.isUserOnContactFormPage(url),"Verification failed, user is not on the "+url);
       log("Verification pass successfully , user is on "+url+" page");
    }

    @When("^user enter value in message text box as \"([^\"]*)\"$")
    public void userEnterValueInMessageTextBoxAs(String message)  {
            log("Enter Message in Contact form as "+message);
            contactFormPage.enterMessageInContactForm(message);
            log(message+ " as Message entered");
    }

    @When("^user enter value in full name text box as \"([^\"]*)\"$")
    public void userEnterValueInFullNameTextBoxAs(String fullName)  {
        log("Enter full name in Contact form as "+fullName);
        contactFormPage.enterFullNameInContactForm(fullName);
        log(fullName+ " as full name entered");
    }

    @When("^user enter value in email text box as \"([^\"]*)\"$")
    public void userEnterValueInEmailTextBoxAs(String email) {
        log("Enter email in Contact form as "+email);
        contactFormPage.enterEmailInContactForm(email);
        log(email+ " as email entered");
    }

    @When("^user check the checkbox for contact form$")
    public void userCheckTheCheckboxForContactForm() {
        log("Select check box in contact form");
        contactFormPage.selectCheckBoxInContactForm();
        log("Check box selected");
    }

    @When("^user click on submit button$")
    public void userClickOnSubmitButton() {
        log("Submit contact form");
        contactFormPage.submitContactForm();
        log("contact form is submitted");
    }

    @Then("^user should get message as \"([^\"]*)\"$")
    public void userShouldGetMessageAs(String feedbackMessage) {
        log("Verify that after submitting contact form user should get message as "+feedbackMessage);
        Assert.assertTrue(contactFormPage.isContactFormSubmittedSuccessFully(feedbackMessage),"Verification failed, Contact form is not submitted");
        log("Verification  pass successfully , getting message "+feedbackMessage+" after contact form submitted");
    }
}
