package autotest.pages.elements;

import autotest.core.annotations.DescriptionOfElement;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends CommonElements{
    @DescriptionOfElement("Profile icon")
    @Getter
    @FindBy(xpath = "(//img[@data-testid=\"user-avatar\"])[2]")
    private WebElement profileIcon;

    @DescriptionOfElement("Logout button")
    @Getter
    @FindBy(xpath = "//div[text() = 'Log Out']")
    private WebElement logoutBtn;
}
