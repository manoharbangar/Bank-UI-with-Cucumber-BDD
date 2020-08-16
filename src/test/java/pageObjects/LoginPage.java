package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@onblur='validateuserid();']")
	private WebElement userNameField;

	@FindBy(how = How.XPATH, using = "//*[@onkeyup='validatepassword();']")
	private WebElement passwordField;

	@FindBy(how = How.NAME, using = "btnLogin")
	private WebElement loginButton;

	@FindBy(how = How.XPATH, using = "//a[@href='Logout.php']")
	private WebElement logoutButton;

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys("aryvusy");
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void clickLogoutButton() {
		logoutButton.click();
	}

}
