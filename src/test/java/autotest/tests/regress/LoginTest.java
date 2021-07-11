package autotest.tests.regress;

import autotest.core.base.BaseTest;
import autotest.core.data.DataProviderClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginTest(){
        super();
    }

    @Test(dataProvider = "usernamePassword", dataProviderClass = DataProviderClass.class)
    public void login(String username, String password){
        loginPageHelper.loginInsta(username, password);
        System.out.println("Авторизация прошло успешно");
    }

    @Test(dependsOnMethods = {"login"})
    public void hideNotification1(){
        loginPageHelper.hideNotification1();
    }

    @Test(dependsOnMethods = {"login"})
    public void hideNotification2(){
        loginPageHelper.hideNotification2();
    }

}