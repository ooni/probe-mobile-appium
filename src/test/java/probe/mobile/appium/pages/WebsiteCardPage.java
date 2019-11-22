package probe.mobile.appium.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindBy;
import probe.mobile.appium.BasePage;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebsiteCardPage extends BasePage {

    @FindBy(xpath = "//android.widget.Button[@text=\"Choose websites\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Websites\"]")
    private MobileElement chooseWebsite;

    @FindBy(id = "org.openobservatory.ooniprobe:id/run")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Run\"]")
    private MobileElement runTestButton;

    @FindBy(id = "org.openobservatory.ooniprobe:id/Dashboard_Running_EstimatedTimeLeft")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Estimated time left:\"]")
    private MobileElement etaTimeLeftText;

    @FindBy(id = "org.openobservatory.ooniprobe:id/log")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Estimated time left:\"]")
    private MobileElement log;

    @FindBy(id = "org.openobservatory.ooniprobe:id/eta")
    private MobileElement eta;

    public WebsiteCardPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void startTest() {
        waitForElement(chooseWebsite);
        clickOnElement(runTestButton);

    }

    public boolean CheckLoaderDecreasing(int timefromTest) {
        waitForElement(eta);
        waitForElement(log);
        elements.add(eta);
        elements.add(log);
        visualCheck(elements);

        int timeOnLoader = numberParser();
        return timeOnLoader < timefromTest;
    }


    private int numberParser() {
        String et = eta.getText();
        et = et.replaceAll("\\D+", "");
        int result = Integer.parseInt(et);
        System.out.println(result);
        return result;
    }
}
