/**
 * 
 */
package suvi.selmavtest.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author suvaj
 *
 */
public class FindFlightPageObject extends PageObject {

	@FindBy(xpath="//form[@name='findflight']//table//tbody//tr//td//font//font//b//font//font[contains(text(),'Flight')]")
	WebElement find_a_flight;
	
	
	public FindFlightPageObject(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean checkElement(String elementName) {
		if (elementName.equals("Flight Details")) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(find_a_flight));
			if (find_a_flight.isDisplayed()) {
				return true;
			}
		}
		
		return false;
	}

	
}
