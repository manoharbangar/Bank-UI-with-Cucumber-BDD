package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DepositPage {
	public DepositPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='accountno']")
	private WebElement accountIdField;

	@FindBy(how = How.XPATH, using = "//input[@name='ammount']")
	private WebElement amountField;

	@FindBy(how = How.XPATH, using = "//input[@name='desc']")
	private WebElement descField;

	@FindBy(how = How.XPATH, using = "//input[@name='AccSubmit']")
	private WebElement submitButton;

	@FindBy(how = How.XPATH, using = "//table[@id='deposit']/tbody/tr[6]/td[2]")
	private WebElement transactionIdText;

	@FindBy(how = How.XPATH, using = "//table[@id='deposit']/tbody/tr[23]/td[2]")
	private WebElement totalBalanceText;

	@FindBy(how = How.XPATH, using = "//a[@href='Managerhomepage.php']")
	private WebElement continueButton;

	public void enterAccountId(String accountNumber) {
		accountIdField.sendKeys(accountNumber);
	}

	public void enterAmount(String amount) {
		amountField.sendKeys(amount);
	}

	public void enterDescription(String descr) {
		descField.sendKeys(descr);
	}

	public void clickOnSubmit() {
		submitButton.click();
	}

	public String getTrxId() {
		return transactionIdText.getText();
	}

	public String getTotalBalance() {
		return totalBalanceText.getText();
	}

	public void clickContinue() {
		continueButton.click();
	}

}
