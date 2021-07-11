package autotest.pages.elements;


import autotest.core.annotations.DescriptionOfElement;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends CommonElements {

    @DescriptionOfElement("See all recommend accounts link")
    @Getter
    @FindBy(xpath = "//div[text()=\"See All\"]")
    private WebElement seeAllLink;

    @Getter
    @DescriptionOfElement("логотип - Instagram")
    @FindBy(xpath = "//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[1]")
    private WebElement logo;

    @Getter
    @DescriptionOfElement("like")
    @FindBy(xpath = "(//*[@aria-label=\"Like\"])[1]")
    private WebElement like;

    @Getter
    @DescriptionOfElement("close post")
    @FindBy(xpath = "(//button)[last()-1]")
    private WebElement close;

    @Getter
    @DescriptionOfElement("Subscribe Button")
    @FindBy(xpath = "//button[text()=\"Follow Back\"]/parent::span")
    private WebElement subscribe;

    @Getter
    @DescriptionOfElement("text with information, how many posts do they have")
    @FindBy(xpath = "//*[@id=\"react-root\"]/section/main/div/header/section/ul/li[1]/span/span")
    private WebElement numOfPhoto;

    @Getter
    @DescriptionOfElement("This Account is Private - text")
    @FindBy(xpath = "//h2[text()=\"This Account is Private\"]")
    private WebElement privateAcc;
}
