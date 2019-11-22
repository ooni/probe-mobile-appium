package probe.mobile.appium.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindBy;
import probe.mobile.appium.BasePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;


public class LandingPage extends BasePage {
    private static Logger logger = Logger.getLogger(LandingPage.class);


    @FindBy(id = "org.openobservatory.ooniprobe:id/master")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Got It\"]")
    private MobileElement gotitButton;

    @FindBy(id = "org.openobservatory.ooniprobe:id/WhatIsOONIProbe_Title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"What is OONI Probe?\"]")
    private MobileElement whatIsOoniText;

    @FindBy(id = "org.openobservatory.ooniprobe:id/master")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"I understand\"]")
    private MobileElement iunderstandButton;

    @FindBy(id = "org.openobservatory.ooniprobe:id/heads_up")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Heads-up!\"]")
    private MobileElement headsUpText;

    @FindBy(id = "org.openobservatory.ooniprobe:id/positive")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"True\"]")
    private MobileElement popQuizPositive;

    @FindBy(id = "org.openobservatory.ooniprobe:id/negative")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"False\"]")
    private MobileElement popQuizNegative;

    @FindBy(id = "org.openobservatory.ooniprobe:id/master")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Let's go\"]")
    private MobileElement letsGoButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Websites\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Websites\"]")
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