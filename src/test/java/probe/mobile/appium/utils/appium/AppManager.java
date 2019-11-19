package probe.mobile.appium.utils.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class AppManager {
    private static AppiumDriver<MobileElement> driver;
    private static WebDriverWait wait;
    private static AppiumServer appiumServer;
    private String platform;
    private int port;

    public AppManager(String platform, int port) {
        this.platform = platform;
        this.port = port;
        appiumServer = new AppiumServer();
    }

    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public void startApp() throws Exception {
        startAppiumServers(port);
        buildDriver();
    }

    public void stopApp() {
        appiumServer.stopServer();
        //driver.closeApp();
    }

    private void startAppiumServers(int port) {
        appiumServer.startServer("127.0.0.1", port);
    }

    public String getPlatform() {
        return platform;
    }

    public int getPort() {
        return port;
    }

    private void buildDriver() throws MalformedURLException {
        CapabilityBuilder capabilityBuilder = new CapabilityBuilder();
        DesiredCapabilities capabilities = capabilityBuilder.build(platform);

        if (capabilities.getPlatform().is(Platform.IOS)) {
            driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:" + appiumServer.getPort() + "/wd/hub"),
                    capabilities);
        } else {
            driver = new AndroidDriver<MobileElement>(
                    new URL("http://127.0.0.1:" + appiumServer.getPort() + "/wd/hub"),
                    capabilities);
        }
        wait = new WebDriverWait(driver, 20);
    }

}
