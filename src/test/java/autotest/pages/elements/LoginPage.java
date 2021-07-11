package autotest.pages.elements;

import autotest.core.annotations.DescriptionOfElement;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonElements{

    @DescriptionOfElement("Email, phone, or username")
    @Getter
    @FindBy(xpath = "//input[@name=\"username\"]")
    private WebElement usernameInput;

    @DescriptionOfElement("Password")
    @Getter
    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement passwordInput;

    @DescriptionOfElement("Log In button")
    @Getter
    @FindBy(xpath = "//*[@id=\"loginForm\"]/div/div[3]/button")
    private WebElement logInButton;

    @DescriptionOfElement("Not now Notification(1)")
    @Getter
    @FindBy(xpath = "//div[@class=\"cmbtv\"]")
    private WebElement notNowNotification1;

    @DescriptionOfElement("Not now Notification(2)")
    @Getter
    @FindBy(xpath = "//button[text() = 'Not Now']")
    private WebElement notNowNotification2;
}
