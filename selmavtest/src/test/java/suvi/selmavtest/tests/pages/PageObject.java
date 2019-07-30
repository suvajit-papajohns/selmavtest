/**
 * 
 */
package suvi.selmavtest.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author suvaj
 *
 */
public class PageObject {

	WebDriver driver;

	public PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToUrl(String url) {
		driver.get(url);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getPageName( ) {
		return driver.getTitle();
	}
	
	public boolean isTitleContains(String matchingText) {
		return getPageName().contains(matchingText);
	}
}
