package probe.mobile.appium.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import probe.mobile.appium.BasePage;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebsiteCardPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Websites\"]")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Websites\"]")
    private MobileElement websiteTitle;

    @AndroidFindBy(id = "org.openobservatory.ooniprobe:id/run")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Run\"]")
    private MobileElement runTestButton;

    @AndroidFindBy(id = "org.openobservatory.ooniprobe:id/Dashboard_Running_EstimatedTimeLeft")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Estimated time left:\"]")
    private MobileElement etaTimeLeftText;

    @AndroidFindBy(id = "org.openobservatory.ooniprobe:id/log")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Estimated time left:\"]")
    private MobileElement log;

    @AndroidFindBy(id = "org.openobservatory.ooniprobe:id/eta")
    private MobileElement eta;

    public WebsiteCardPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void startTest() {
        waitForElement(runTestButton);
        clickOnElement(runTestButton);

    }

    public boolean CheckLoaderDecreasing(int timefromTest) {
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
