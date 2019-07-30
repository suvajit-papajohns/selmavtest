package suvi.selmavtest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features",
        //glue = {"src/test/java/suvi.stepdefs"},
        tags = {"~@Ignore", "@wip"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/json-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun-reports/rerun.txt"
        })
public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;
    private static ThreadLocal<BrowserSession> session = new ThreadLocal<BrowserSession>();
    
    @BeforeClass(alwaysRun = true)
    @Parameters({"envNo"})
    public void setUpClass(@Optional ("1") String envNo, ITestContext context) throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        int env = Integer.parseInt(envNo);
        BrowserSession bs = setUpSession(env);
        session.set(bs);
        String suiteName = context.getSuite().getName();
        bs.setUp(suiteName);
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
    	testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
        
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
    	getBrowserSession().tearDown();
        testNGCucumberRunner.finish();
    }
    
    public static BrowserSession getBrowserSession() {
    	return session.get();
    }
    
    private BrowserSession setUpSession(int environmentNo) {
		// Read properties
		Properties props = new Properties();
		try {
			props.load(getClass().getClassLoader().getResourceAsStream("config/env.properties"));
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		String host = props.getProperty("env."+environmentNo+".host", "localhost");
		String browser = props.getProperty("env."+environmentNo+".browser", "Chrome");
		String platform = props.getProperty("env."+environmentNo+".platform", "Windows 10");
		String user = props.getProperty("env."+environmentNo+".user", "");
		String pwd = props.getProperty("env."+environmentNo+".password", "");
		String browver = props.getProperty("env."+environmentNo+".version", "");
			
		System.out.println("Browser Session created for environment:" + environmentNo);
		return new BrowserSession(host, browser, platform, user, pwd, browver);
    }
}
