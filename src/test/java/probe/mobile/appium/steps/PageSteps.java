package probe.mobile.appium.steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import probe.mobile.appium.pages.LandingPage;
import probe.mobile.appium.pages.WebsiteCardPage;
import probe.mobile.appium.utils.appium.AppManager;
import org.testng.Assert;

public class PageSteps {
    private LandingPage landingPage = new LandingPage(AppManager.getDriver(), AppManager.getWait());
    private WebsiteCardPage websiteCardPage = new WebsiteCardPage(AppManager.getDriver(), AppManager.getWait());

    @Given("User is navigated to landing page with test cards")
    public void userIsNavigatedToLandingPageWithTestCards() {
        //Commented as the onboarding is not available in testing
        //Assert.assertTrue(landingPage.goToLandingPage());
    }

    @And("Test for {string} are selected")
    public void testForAreSelected(String testCard) {
        landingPage.tabSelect();
    }

    @Then("Check that the estimated time left from eg {int} sec is decreasing for selected test")
    public void checkThatTheEstimatedTimeLeftFromEgSecIsDecreasingForSelectedTest(int maxTime) {
        websiteCardPage.startTest();
        Assert.assertTrue(websiteCardPage.CheckLoaderDecreasing(maxTime));
    }
}