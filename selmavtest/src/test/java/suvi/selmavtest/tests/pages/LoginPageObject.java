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
public class LoginPageObject extends PageObject {

	@FindBy(xpath="//img[@alt='Mercury Tours']")
	WebElement mercury_tours_image;
	
	@FindBy(xpath="//table/tbody/tr[2]/td[1]/font[contains(text(), 'Name:')]")
	WebElement font_user_name;
	
	@FindBy(xpath="//table/tbody/tr[3]/td/font[contains(text(), 'Password:')]")
	WebElement font_password;
	
	@FindBy(xpath="//input[@name='userName']")
	WebElement input_user_name;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement input_password;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement submit_signin;
	
	
	public LoginPageObject(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean checkElement(String elementName) {
		if (elementName.equals("MercuryTours")) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(mercury_tours_image));
			if (mercury_tours_image.isDisplayed()) {
				return true;
			}
		}
		else if (elementName.equals("User Name:")) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(font_user_name));
			if (font_user_name.isDisplayed()) {
				String text = font_user_name.getText();
				System.out.println(text);
				return text.contains("Name:");
			}
		}
		else if (elementName.equals("Password:")) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(font_password));
			if (font_password.isDisplayed()) {
				String text = font_password.getText();
				System.out.println(text);
				return text.contains("Password:");
			}
		}
		
		return false;
	}

	public void enterData(String elementName, String data) {
		if (elementName.equals("username")) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(input_user_name));
			if (input_user_name.isDisplayed()) {
				input_user_name.sendKeys(data);
			}
		}
		else if (elementName.equals("password")) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(input_password));
			if (input_password.isDisplayed()) {
				input_password.sendKeys(data);
			}
		}
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException ex) {
			
		}
	}
	
	public void clickButton(String buttonName) {
		if (buttonName.equals("Sign-In")) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(submit_signin));
			if (submit_signin.isDisplayed()) {
				submit_signin.click();
			}
		}
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException ex) {
			
		}
	}
}
