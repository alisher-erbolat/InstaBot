package autotest.tests.regress;

import autotest.core.base.BaseTest;
import autotest.core.data.DataProviderClass;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class LogoutTest extends BaseTest {
    LogoutTest(){
        super();
    }

    @Test
    public void clickProfile(){
        logoutPageHelper.clickProfileIcon();
        System.out.println(getDriver().getCurrentUrl());
    }

    @Test(dependsOnMethods = {"clickProfile"})
    public void clickLogout(){
        logoutPageHelper.clickLogout();
        System.out.println(getDriver().getCurrentUrl());
    }
}
