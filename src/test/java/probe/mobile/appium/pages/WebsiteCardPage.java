package probe.mobile.appium.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import probe.mobile.appium.BasePage;

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
        waitForElement(etaTimeLeftText);
        elements.add(eta);
        elements.add(log);
        visualCheck(elements);

        int timeOnLoader = numberParser();
        return timeOnLoader < timefromTest;
    }


    private int numberParser() {
        waitForElement(eta);
        String et = getText(eta);
        while (et.equals("") || et.contains("120")) {
            et = getText(eta);
        }
        et = et.replaceAll("\\D+", "");
        int result = Integer.parseInt(et);
        System.out.println(result);
        return result;
    }
}
