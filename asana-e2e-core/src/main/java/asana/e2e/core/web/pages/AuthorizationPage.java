package asana.e2e.core.web.pages;

import static asana.e2e.core.web.browsers.BrowserConfigProvider.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage {

    @FindBy(className = "TextInputBase")
    private WebElement inputField;

    @FindBy(xpath = "//label[contains(text(),'Email address')]")
    private WebElement emailAddressText;

    @FindBy(xpath = "//body/div[@id='Login-appRoot']/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]")
    private WebElement continueButton;
    @FindBy(xpath = "//div[contains(text(),'Please enter a valid email address.')]")
    private WebElement alertMessage;

    public AuthorizationPage() {
        PageFactory.initElements(driver, this);
    }

    public void setInputField(String input) {
        inputField.sendKeys(input);
    }

    public String inputFieldIsBlank() {
        return inputField.getText();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public String getAlertMessage() {
        return alertMessage.getText();
    }

    public String getEmailAddressText() {
        return emailAddressText.getText();
    }
}
