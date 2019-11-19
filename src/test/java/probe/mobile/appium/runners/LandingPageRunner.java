package probe.mobile.appium.runners;


import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import probe.mobile.appium.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/reports/landing.json",
                "html:target/reports/landing",

        },
        monochrome = true,
        features = "src/test/resources/features/landing.feature",
        dryRun = false,
        strict = true,
        glue = "probe.mobile.appium.steps")

public class LandingPageRunner extends BaseTest {

    private TestNGCucumberRunner landingRunner;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception {
        landingRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable {
        // the 'featureWrapper' parameter solely exists to display the feature file in a test report
        landingRunner.runScenario(pickleWrapper.getPickleEvent());
    }

    @DataProvider
    public Object[][] scenarios() {
        return landingRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        landingRunner.finish();
    }
}