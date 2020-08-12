package StepFiles;

import PageObject.MagazinePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberHelper.TestContext;
import org.testng.Assert;

import static utility.ConstantVars.*;

public class MagazinePageSteps extends Logging {
    TestContext testContext;
    MagazinePage magazinePage;

    public MagazinePageSteps(TestContext context) {
        testContext = context;
        magazinePage = testContext.getPageObjectManger().getMagazineScreen();
    }

    @When("^user click on search icon$")
    public void userClickOnSearchIcon() {
        log("Click on Search icon");
        magazinePage.clickOnSearchIcon();
        log("Clicked on search icon");
    }


    @Then("^user should see the search field$")
    public void userShouldSeeTheSearchField() {
        log("Verify that search text box is displayed or not");
        Assert.assertTrue(magazinePage.isSearchTextBoxDisplayed(),"Verification failed , Search textBox is not displayed");
        log("Verification pass , Search textBox is displayed");
    }

    @When("^user enter value in search box as \"([^\"]*)\" and search$")
    public void userEnterValueInSearchBoxAs(String value) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        log("Enter value in search textBox as "+value+ " and press Enter");
        magazinePage.enterTextInSearchFieldAndPressEnter(value);
        log(value+" entered in search text box and pressed Enter ");
    }

    @Then("^user should see all search result for \"([^\"]*)\"$")
    public void userShouldSeeAllSearchResultFor(String searchText) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        log("Verify that all search result should appear for "+  searchText +" location ");
        Assert.assertTrue(magazinePage.isAllSearchResultDestination(searchText),"Verification failed, All search result is not having search value as "+searchText);
        log("Verification pass , All search result is having search value as "+searchText);
    }

    @When("^user click on contact link and navigate to contact form$")
    public void userClickOnContactLink() {
        log("Click on contact link and navigate to contact form page");
        magazinePage.clickOnContactLinkAndNavigateToContactFormTab();
        log("Clicked on contact page and navigated to contact form page");
    }


    @When("^user scroll down and navigate to news letter section$")
    public void userScrollDownAndNavigateToNewsLetterSection() {
        log("Scroll to the news letter section");
        magazinePage.scrollToNewsLetterSection();
    }

    @Then("^user should see news letter section$")
    public void userShouldSeeNewsLetterSection() {
        log("Verify that news letter section is appear");
        Assert.assertTrue(magazinePage.isNewsLetterSectionAppear(),"Verification failed, Newsletter section is not appearing");
        log("Verification passed, News letter section is appearing");
    }

    @When("^user enter random email address$")
    public void userEnterRandomEmailAddress() {
        log("Enter Email address as "+randomEmail);
        magazinePage.enterEmailAddressInNewsLetterEmailField(randomEmail);
        log(randomEmail+" email is entered");
    }

    @When("^user click on Inspire Me button$")
    public void userClickOnInspireMeButton() {
        log("Submit News letter");
        magazinePage.submitNewsLetter();
        log("News  letter submitted");
    }

    @Then("^user should get the \"([^\"]*)\"$")
    public void userShouldGetThe(String message) {
      log("Verify that after submitting news letter "+message+" appear");
      Assert.assertTrue(magazinePage.isNewsLetterSubmittedSuccessFully(message),"Verification failed, "+message+" is not appearing after submitting news letter");
      log("Verification passed, "+message+" is appearing after submitting news letter");
    }


}
