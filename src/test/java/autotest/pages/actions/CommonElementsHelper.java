package autotest.pages.actions;


import autotest.core.base.BasePage;
import autotest.core.base.Page;
import autotest.core.base.SuiteConfiguration;
import autotest.pages.elements.CommonElements;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class CommonElementsHelper extends BasePage {
    private final CommonElements commonElements = new CommonElements();
    public CommonElementsHelper() {
        super();
    }

}
