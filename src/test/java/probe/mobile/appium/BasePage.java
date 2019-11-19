package probe.mobile.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    private static Logger logger = LoggerFactory.getLogger(BasePage.class);
    protected WebDriverWait wait;
    protected AppiumDriver driver;
    protected List<MobileElement> elements = new ArrayList<MobileElement>();

    public BasePage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void addElement(MobileElement e) {
        elements.add(e);
    }

    // Click on element method
    public void clickOnElement(MobileElement el) {
        wait.until(ExpectedConditions.visibilityOf(el)).click();
    }

    public boolean visualCheck(List<MobileElement> elements) {
        for (MobileElement el : elements) {
            if (!waitForElement(el)) return false;
        }
        return true;
    }

    public boolean elementContainsText(MobileElement el, String text) {
        String elText = getText(el);
        return elText.contains(text);
    }

    public void assertElements() {
        elements.forEach(el -> {
            Assert.assertTrue(!waitForElement(el), "Element: " + el.getTagName() + " not present.");
        });
        logger.info("Asserting elements finished");
    }

    protected boolean waitForElement(MobileElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public String getText(MobileElement el) {
        return wait.until(ExpectedConditions.visibilityOf(el)).getText();
    }

    public void swipeOrScroll(Direction direction) {
        Dimension size = driver.manage().window().getSize();
        TouchAction action = new TouchAction(driver);
        PointOption p1 = new PointOption();
        int startY = 0;
        int startX = 0;
        int endX = 0;
        int endY = 0;
        switch (direction) {
            case RIGHT:
                startY = size.height / 2;
                startX = (int) (size.width * 0.90);
                endX = (int) (size.width * 0.05);
                action.press(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, startY)).release().perform();
                System.out.println("\n Successfully swiped right! \n");
                break;
            case LEFT:
                startY = size.height / 2;
                startX = (int) (size.width * 0.05);
                endX = (int) (size.width * 0.90);
                action.press(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, startY)).release().perform();
                System.out.println("\n Successfully swiped left! \n");
                break;
            case UP:
                endY = (int) (size.height * 0.9);
                startY = (int) (size.height * 0.55);
                startX = size.width / 2;
                action.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(startX, endY)).release().perform();
                System.out.println("\n Successfully scrolled up \n");
                break;
            case DOWN:
                startY = (int) (size.height * 0.90);
                endY = (int) (size.height * 0.30);
                startX = (size.width / 2);
                action.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(startX, endY)).release().perform();
                System.out.println("\n Successfully scrolled down! \n");
                break;
        }
    }

    public boolean isAndroid() {
        return driver instanceof AndroidDriver;
    }

    public boolean isIOS() {
        return driver instanceof IOSDriver;
    }

    public enum Direction {
        RIGHT, LEFT, UP, DOWN
    }
}