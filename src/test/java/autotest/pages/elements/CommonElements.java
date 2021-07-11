package autotest.pages.elements;

import autotest.core.annotations.DescriptionOfElement;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static autotest.core.base.BaseTest.instantiateDriver;

/*
* Класс CommonElements хранит общие вебэлементы для всех страниц
* */
public class CommonElements {

    public CommonElements() {
        PageFactory.initElements(instantiateDriver(), this);
    }

}
