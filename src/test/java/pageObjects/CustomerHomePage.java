package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerHomePage {
	public CustomerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@href='DepositInput.php']")
	private WebElement depositButton;

	@FindBy(how = How.CSS, using = "marquee.heading3")
	private WebElement welcomeMessage;

	public void clickOnDepositButton(WebDriver driver) {
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
//		wait2.until(ExpectedConditions.elementToBeClickable(depositButton));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", depositButton);
	}

	public String getWelcomeMessage() {
		return welcomeMessage.getText();
	}

}
