/**
 * 
 */
package suvi.selmavtest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * @author suvaj
 *
 */
public class BrowserSession {

	private WebDriver driver;
	private String host;
	private String browser;
	private String platform;
	private String user;
	private String pwd;
	private String browver;
	private boolean isSetup = false; 
	private String currentPage;
	
	/**
	 * @return the currentPage
	 */
	public String getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 
	 */
	public BrowserSession() {
	}

	/**
	 * @param host
	 * @param browser
	 * @param platform
	 * @param user
	 * @param pwd
	 * @param browver
	 */
	public BrowserSession(String host, String browser, String platform, String user, String pwd, String browver) {
		this.host = host;
		this.browser = browser;
		this.platform = platform;
		this.user = user;
		this.pwd = pwd;
		this.browver = browver;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the browser
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * @param browser the browser to set
	 */
	public void setBrowser(String browser) {
		this.browser = browser;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return the browver
	 */
	public String getBrowver() {
		return browver;
	}

	/**
	 * @param browver the browver to set
	 */
	public void setBrowver(String browver) {
		this.browver = browver;
	}

	public void setUp() throws Exception {
		setUp("");
	}
	/**
	 * @throws java.lang.Exception
	 */
	public void setUp(String suiteName) throws Exception {
		// TODO - Check for mandatory fields
		if (isSetup) {
			return;
		}
		
		if (host.equalsIgnoreCase("localhost")) {
			if (browser.equalsIgnoreCase("firefox")) {
				// declaration and instantiation of objects/variables
				/*System.setProperty("webdriver.firefox.marionette", 
						"C:\\Users\\suvaj\\OneDrive - HCL Technologies Ltd\\Project\\Digital\\Selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");
				*/
				System.setProperty("webdriver.gecko.driver", 
						"C:\\Users\\suvaj\\OneDrive - HCL Technologies Ltd\\Project\\Digital\\Selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");
				FirefoxOptions options = new FirefoxOptions();
				//options.setBinary(new File(ApplicationSettings.getFirefoxPath()).getPath());
				options.setCapability("network.http.pipelining", true);
				options.setCapability("network.http.proxy.pipelining", true);
				options.setCapability("network.http.pipelining.maxrequests", 8);
				options.setCapability("dom.disable_window_open_feature.menubar", false);
				
				driver = new FirefoxDriver(options);
			}
			else if (browser.equalsIgnoreCase("chrome")) {
				//comment the above 2 lines and uncomment below 2 lines to use Chrome
			
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\suvaj\\OneDrive - HCL Technologies Ltd\\Project\\Digital\\Selenium\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else {
				
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		else if (host.equalsIgnoreCase("saucelabs")) {
			String URL = "http://" + user + ":" + pwd + "@ondemand.saucelabs.com:80/wd/hub";
            DesiredCapabilities capabilities = null;
            if (browser.equalsIgnoreCase("firefox")) {
            	capabilities = DesiredCapabilities.firefox();
            	/*FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.SetPreference("security.insecure_password.ui.enabled", false);
                firefoxOptions.SetPreference("security.insecure_field_warning.contextual.enabled", false);*/
            	capabilities.setAcceptInsecureCerts(true);
            	capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); 
            	capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            	FirefoxProfile fp = new FirefoxProfile();
            	fp.setPreference("security.insecure_password.ui.enabled", false);
            	fp.setPreference("security.insecure_field_warning.contextual.enabled", false);
            	capabilities.setCapability(FirefoxDriver.PROFILE, fp);
            }
            else if (browser.equalsIgnoreCase("chrome")) {
            	capabilities = DesiredCapabilities.chrome();
            }
        	capabilities.setCapability("version", browver);
            capabilities.setCapability("platform", platform);
            String sName = "";
            if (suiteName == null || suiteName.trim().equals("")) {
            	sName = "SelTest";
            } else {
            	sName = suiteName.trim();
            }
            capabilities.setCapability("name", sName);
            capabilities.setCapability("tags", "Automated-Tests");
            capabilities.setCapability("build", "1.0");
            capabilities.setCapability("screenResolution", "1280x1024");

            try {
                driver = new RemoteWebDriver(new URL(URL), capabilities);
            } catch (MalformedURLException mex) {
                mex.printStackTrace();
            	//logger.error(mex.getMessage());
            } catch (WebDriverException wdex) {
            	wdex.printStackTrace();
                //logger.error(wdex.getMessage());
            }			
		}
		else {
			
		}
		isSetup = true;
    }

	/**
	 * @throws java.lang.Exception
	 */
	public void tearDown() throws Exception {
        //close Fire fox
        driver.quit();
	}
	
	public WebDriver getWebDriver() {
		if (driver == null) {
			try {
				setUp();
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return driver;
	}
}
