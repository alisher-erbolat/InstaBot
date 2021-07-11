package autotest.core.base;

import autotest.core.manager.ChromeWebDriver;
import autotest.core.business.User;
import autotest.pages.actions.CommonElementsHelper;
import autotest.pages.actions.LoginPageHelper;
import autotest.pages.actions.LogoutPageHelper;
import autotest.pages.actions.MainPageHelper;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/*
* BaseTest - базовый класс для всех Test классов описанных в пакете tests
* BaseTest класс применяет конфигурацию SuiteConfiguration,
* объявляет driver который получает все свои настройки от ChromeDriver класса со static метода getInstance(),
* config описан в папке resources в файле ConfigProperties
* реализованы before/after аннотации тестового фреймворка testng
* */
public class BaseTest {
    private static SuiteConfiguration config;
    @Getter
    private static WebDriver driver;

    // страниц действий
    public CommonElementsHelper commonElementsHelper;
    public MainPageHelper mainPageHelper;
    public LoginPageHelper loginPageHelper;
    public LogoutPageHelper logoutPageHelper;

    public BaseTest(){
        commonElementsHelper = PageFactory.initElements(BasePage.getWebDriver(), CommonElementsHelper.class);
        mainPageHelper = PageFactory.initElements(BasePage.getWebDriver(), MainPageHelper.class);
        loginPageHelper = PageFactory.initElements(BasePage.getWebDriver(), LoginPageHelper.class);
        logoutPageHelper = PageFactory.initElements(BasePage.getWebDriver(), LogoutPageHelper.class);

    }

    public static WebDriver instantiateDriver() {
        try{
            if (driver == null) config = new SuiteConfiguration();
            if (config.getProperty("browser").equalsIgnoreCase("chrome")) driver = ChromeWebDriver.getInstance();
        }catch (IOException ex){
            System.out.println(ex);
        }

        return driver;
    }

    //Входные данные
    @Getter
    private User addUserName = new User("someEmailForTesting", "somePasswordForTesting");


    @BeforeSuite
    public void setUp(){
        if (driver!=null) driver.get(config.getProperty("url"));
        if (driver!=null) driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitlyWait")), TimeUnit.SECONDS);
    }

    @BeforeClass
    public void setUpClass(){
        String className = this.getClass().getName();
        Page.logger.info("RUN class: "+ className);
    }

    @BeforeMethod
    public static void setUpMethod(Method method){
        String testName = method.getName();
        Page.logger.info("RUN test method: "+ testName);
    }

    @AfterSuite
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }

        Page.logger.info("test execution completed.");

    }


}
