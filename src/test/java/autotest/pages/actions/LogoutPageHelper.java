package autotest.pages.actions;

import autotest.core.base.BasePage;
import autotest.pages.elements.LogoutPage;
import autotest.pages.elements.MainPage;

public class LogoutPageHelper extends BasePage {
    private final LogoutPage logoutPage = new LogoutPage();

    public LogoutPageHelper() {
        super();
    }

    public void clickProfileIcon(){
        waitForElementVisibility(logoutPage.getProfileIcon());
        logoutPage.getProfileIcon().click();
        sleep(2000);
    }

    public void clickLogout(){
        waitForElementVisibility(logoutPage.getLogoutBtn());
        logoutPage.getLogoutBtn().click();
        sleep(2000);
    }
}
