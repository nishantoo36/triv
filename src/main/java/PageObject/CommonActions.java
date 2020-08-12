package PageObject;

import manager.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.SeleniumUtility;

public class CommonActions extends SeleniumUtility {
    public CommonActions(WebDriver driver) {
        super(driver);
    }

    @FindBy  (id = "onetrust-accept-btn-handler")
    WebElement acceptCookies;

    public void openMainURL() {
        openUrl(FileReaderManager.getInstance().getConfigReader().getUrl());
    }

    public void setAcceptCookies() {
        for(int i=0;i<10;i++)
        try {
            clickOnElement(acceptCookies,10);
            return;
        }catch (Exception e){
            if(i==9) {
                throw new RuntimeException("Unable to locate Ok button for accepting cookies");
            }
        }

    }
}
