package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.SeleniumUtility;

import java.util.List;


public class MagazinePage extends SeleniumUtility {

    public MagazinePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "search-icon")
    WebElement searchIcon;

    @FindBy(xpath = "//input[@class = 'input search-input']")
    WebElement searchInput;

    @FindBy(xpath = "//div[@class = 'search-results']//child::div[contains(@class,'article-card')]//child::span[contains(@class,'destination')]")
    List<WebElement> searchResultsDestinations;

    @FindBy(xpath = "//a[text()='Contact']")
    WebElement contactLink;

    @FindBy(xpath = "//div[@class='newsletter-email']/child::input")
    WebElement newsLetterEmailField;

    @FindBy(xpath = "//div[@class='newsletter-submit']/child::button")
    WebElement submitNewsLetterButton;

    @FindBy(xpath = "//p[@class= 'submitted h1']")
    WebElement successMessageForNewsLetter;

    public void clickOnSearchIcon() {
        clickOnElement(searchIcon,5);
    }

    public boolean isSearchTextBoxDisplayed() {
        return isElementAvailable(searchInput, 10);
    }

    public void enterTextInSearchFieldAndPressEnter(String value) {
        enterValue(searchInput, value,5);
        pressKeyBoardEnter(searchInput);
    }

    public String[] getSearchResultLocationText() {
        String[] searchResults = new String[searchResultsDestinations.size()];
        for (int i = 0; i < searchResults.length; i++) {
            searchResults[i] = getText(searchResultsDestinations.get(i),5);
        }
        return searchResults;
    }

    public boolean isAllSearchResultDestination(String destination) {
        String[] val = getSearchResultLocationText().clone();
        for (int i = 0; i < val.length; i++) {
            if (!val[i].equalsIgnoreCase(destination)) {
                return false;
            }
        }
        return true;
    }

    public void clickOnContactLinkAndNavigateToContactFormTab() {
        scrollToElement(contactLink);
        clickOnElement(contactLink,5);
        switchToNewlyOpenTap();
    }

    public void scrollToNewsLetterSection(){
        scrollToElement(newsLetterEmailField);
    }

    public boolean isNewsLetterSectionAppear(){
       return isElementClickAble(submitNewsLetterButton,10);
    }

    public void enterEmailAddressInNewsLetterEmailField(String email){
        enterValue(newsLetterEmailField,email,1);
    }

    public void submitNewsLetter(){
        clickOnElement(submitNewsLetterButton,10);
    }

    public boolean isNewsLetterSubmittedSuccessFully(String message){
        return getText(successMessageForNewsLetter,20).equals(message);
    }

}
