package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.Alert;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import managers.WebDriverManager;
import pageObjects.CustomerHomePage;
import pageObjects.LoginPage;

public class LoginPageSteps {
	WebDriverManager webDriverManager;
	FileReaderManager fileReaderManager;

	@Given("^user launches URL for Guru Bank login$")
	public void user_launches_URL_for_Guru_Bank_login() throws Throwable {
		webDriverManager = new WebDriverManager();
		fileReaderManager = new FileReaderManager();
		webDriverManager.getDriver();
		webDriverManager.driver.get(fileReaderManager.getConfigReader().getBaseURL());
	}

	@Given("^user is on Login Page$")
	public void user_is_on_Login_Page() {
		System.out.println("Page Title:- " + webDriverManager.driver.getTitle());
	}

	@Given("^login to Guru Bank page is displayed$")
	public void login_to_Guru_Bank_page_is_displayed() {
		System.out.println("Page Title:- " + webDriverManager.driver.getTitle());
	}

	@When("^user enters invalid login details as \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_invalid_login_details_as_and(String userName, String password) {
		LoginPage loginPage = new LoginPage(webDriverManager.driver);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
	}

	@When("^click on login button$")
	public void click_on_login_button() {
		LoginPage loginPage = new LoginPage(webDriverManager.driver);
		loginPage.clickLoginButton();
	}

	@Then("^alert message as \"([^\"]*)\" is displayed$")
	public void alert_message_as_is_displayed(String message) throws InterruptedException {
		Thread.sleep(4000);
		Alert alrt = webDriverManager.driver.switchTo().alert();
		String actualMessage = alrt.getText();
		Assert.assertEquals("", message, actualMessage);
		alrt.accept();
	}

	@When("^user enters valid login details as \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_valid_login_details_as_and(String userName, String password) throws Throwable {
		LoginPage loginPage = new LoginPage(webDriverManager.driver);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
	}

	@Then("^home page is displayed for Manager$")
	public void home_page_is_displayed_for_Manager() {
		CustomerHomePage customerHomePage = new CustomerHomePage(webDriverManager.driver);
		String actualMessage = customerHomePage.getWelcomeMessage();
		Assert.assertEquals("", "Welcome To Manager's Page of Guru99 Bank", actualMessage);
	}

	@After
	public void closeDriver() {
		webDriverManager.driver.close();
	}

}
