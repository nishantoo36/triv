package cucumberHelper;

import com.sun.media.sound.InvalidFormatException;
import manager.DriverFactory;
import manager.PageObjectManger;

import java.io.IOException;

public class TestContext {

	private PageObjectManger pageObjectManger;
	private DriverFactory driverFactory;
	public ScenarioContext scenarioContext;

	public TestContext() throws InvalidFormatException, IOException {
		driverFactory = new DriverFactory();
		pageObjectManger = new PageObjectManger(driverFactory.getDriver());
		scenarioContext = new ScenarioContext();
	}

	public DriverFactory getDriverFactory() {
		return driverFactory;
	}

	public PageObjectManger getPageObjectManger() {
		return pageObjectManger;
	}

	public ScenarioContext getScenarioContext() {
		 return scenarioContext;
		 }
}
