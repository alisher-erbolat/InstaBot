package autotest.pages.actions;

import autotest.core.base.BasePage;
import autotest.pages.elements.LoginPage;

public class LoginPageHelper extends BasePage {
    private final LoginPage loginPage = new LoginPage();

    public LoginPageHelper() {
        super();
    }

    public void loginInsta(String username, String password){
        waitForElementVisibility(loginPage.getUsernameInput());
        loginPage.getUsernameInput().sendKeys(username);
        waitForElementVisibility(loginPage.getPasswordInput());
        loginPage.getPasswordInput().sendKeys(password);

        waitForElementToBeClickable(loginPage.getLogInButton());
        loginPage.getLogInButton().click();
        sleep(2000);
    }

    //скрыть уведомление(1) инстаграма
    public void hideNotification1(){
        waitForElementToBeClickable(loginPage.getNotNowNotification1());
        loginPage.getNotNowNotification1().click();
        sleep(2000);
    }

    //скрыть уведомление(2) инстаграма
    public void hideNotification2(){
        waitForElementToBeClickable(loginPage.getNotNowNotification2());
        loginPage.getNotNowNotification2().click();
        sleep(2000);
    }
}
