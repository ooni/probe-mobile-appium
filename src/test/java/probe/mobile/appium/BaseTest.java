package probe.mobile.appium;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import probe.mobile.appium.utils.appium.AppManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest extends AbstractTestNGCucumberTests {
    private static int appiumPort = 4723;

    private static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    protected AppManager appManager;

    @AfterTest(alwaysRun = true)
    protected void stopApp() {
        appManager.stopApp();
    }

    @BeforeTest(alwaysRun = true)
    @Parameters({"platform"})
    protected synchronized void prepareApp(String platform) throws Exception {
        appManager = new AppManager(platform, appiumPort++);
        appManager.startApp();
    }

    public AppManager getAppManager() {
        return appManager;
    }
}