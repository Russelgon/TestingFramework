package asana.e2e.core.web.pages;

import static asana.e2e.core.web.browsers.BrowserConfigProvider.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(className = "//header/div[2]/div[1]/div[2]/a[1]")
    private WebElement getStartedButton;
    @FindBy(xpath = "//header/div[2]/div[1]/div[2]/div[4]/a[1]")
    private WebElement logInButton;


    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickGetStartedButton() {
        getStartedButton.click();
    }

    public void clickLogInButton() {
        logInButton.click();
    }
}
