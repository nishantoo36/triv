package StepFiles;
import PageObject.CommonActions;
import cucumber.api.java.en.Given;
import cucumberHelper.TestContext;

public class PreconditionSteps extends Logging {

    TestContext testContext;
    CommonActions commonActions;

    public PreconditionSteps(TestContext context) {
        testContext = context;
        commonActions = testContext.getPageObjectManger().getCommonActionsScreen();
    }

    @Given("User should be on MagazinePage")
    public void userShouldBeOnMagazinePage() {
        log("test");
        commonActions.openMainURL();
        commonActions.setAcceptCookies();
    }
}
