package probe.mobile.appium.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import probe.mobile.appium.BasePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;


public class LandingPage extends BasePage {
    private static Logger logger = Logger.getLogger(LandingPage.class);


    @AndroidFindBy(id = "org.openobservatory.ooniprobe:id/master")
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Got It\"]")
    private MobileElement gotitButton;

    @AndroidFindBy(id = "org.openobservatory.ooniprobe:id/WhatIsOONIProbe_Title")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"What is OONI Probe?\"]")
    private MobileElement whatIsOoniText;

    @AndroidFindBy(id = "org.openobservatory.ooniprobe:id/master")
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"I understand\"]")
    private MobileElement iunderstandButton;

    @AndroidFindBy(id = "org.openobservatory.ooniprobe:id/heads_up")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Heads-up!\"]")
    private MobileElement headsUpText;

    @AndroidFindBy(id = "org.openobservatory.ooniprobe:id/positive")
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"True\"]")
    private MobileElement popQuizPositive;

    @AndroidFindBy(id = "org.openobservatory.ooniprobe:id/negative")
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"False\"]")
    private MobileElement popQuizNegative;

    @AndroidFindBy(id = "org.openobservatory.ooniprobe:id/master")
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Let's go\"]")
    private MobileElement letsGoButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Websites\"]")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Websites\"]")
    private MobileElement websitesTab;


    public LandingPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean goToLandingPage() {
        waitForElement(whatIsOoniText);
        if (!elementContainsText(whatIsOoniText, "")) return false;
        clickOnElement(gotitButton);
        waitForElement(headsUpText);
        if (!elementContainsText(headsUpText, "")) return false;
        waitForElement(iunderstandButton);
        clickOnElement(iunderstandButton);
        waitForElement(popQuizPositive);
        clickOnElement(popQuizPositive);

        waitForElement(popQuizPositive);
        clickOnElement(popQuizPositive);

        waitForElement(letsGoButton);
        clickOnElement(letsGoButton);
        return true;
    }

    public void tabSelect() {
        waitForElement(websitesTab);
        clickOnElement(websitesTab);
    }


}