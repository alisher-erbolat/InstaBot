package autotest.pages.actions;

import autotest.core.base.BasePage;
import autotest.core.base.SuiteConfiguration;
import autotest.pages.elements.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class MainPageHelper extends BasePage {
    private final MainPage mainPage = new MainPage();

    public MainPageHelper() {
        super();
    }

    //будем искать рандомного пользователя в рекомендованных аккаунтах
    public void searchPeople() {
        waitForElementVisibility(mainPage.getSeeAllLink());
        mainPage.getSeeAllLink().click();
        sleep(2000);

        //обновим страницу чтобы стереть из рекомендованных уже подписанных людей
        getWebDriver().navigate().refresh();
        sleep(5000);

        System.out.println("Ищем рандомного пользователя");
        int randomAcc = (int) (Math.random() * 6) + 1;
        WebElement suggestedAcc = getWebDriver().findElement(By.xpath
                ("/html/body/div[1]/section/main/div/div[2]/div/div/div[" + randomAcc + "]/div[2]/div[1]/div/span/a"));
        waitForElementVisibility(suggestedAcc);

        //подписываемся и откроем профиль
        WebElement followBtn = getWebDriver().findElement(By.xpath
                ("//*[@id=\"react-root\"]/section/main/div/div[2]/div/div/div[" + randomAcc + "]/div[3]"));
        waitForElementVisibility(followBtn);
        followBtn.click();
        suggestedAcc.click();
        System.out.println("вы подписались на аккаунт: " + getWebDriver().getCurrentUrl());
        sleep(2000);
    }

    public void likingProcess() {
        //проверяем есть ли у аккаунта актуальные сторисы
        //это влияет на локатора фото, создавая дополнительный div
        int div = checkStories();

        //проверяем сколько фото у аккаунта
        //если текст возвращает цифр с запятой, это значит у пользователя фото>1000
        int numOfPhoto = 10;
        if (!mainPage.getNumOfPhoto().getText().contains(",")) {
            numOfPhoto = Math.min(Integer.parseInt(mainPage.getNumOfPhoto().getText()), 10);
        }
        for (int i = 1; i <= numOfPhoto; i++) {
            if (i % 3 == 0) {
                openPost((int) Math.ceil(i / 3.0), 3, div);
            } else {
                openPost((int) Math.ceil(i / 3.0), i % 3, div);
            }
            System.out.println("Liked " + i + " photo");
        }
    }

    //если у аккаунта есть актуальные сторизы, метод возвращает 3, иначе 2
    public int checkStories() {
        int div = -1;
        try {
            WebElement post = getWebDriver().findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/div[3]"));
            waitForElementVisibility(post);
            div = 3;
        } catch (NoSuchElementException e) {
            div = 2;
        }
        return div;
    }

    //откроем пост аккаунта, и лайкаем
    //индексы для того, чтобы открыть постов по порядку
    public void openPost(int index1, int index2, int div) {
        WebElement post = getWebDriver().findElement(By.xpath
                ("//*[@id=\"react-root\"]/section/main/div/div[" + div + "]/article/div/div/div[" + index1 + "]/div[" + index2 + "]"));
        waitForElementVisibility(post);
        post.click();
        like();
        closePost();
    }

    public void like() {
        try {
            waitForElementVisibility(mainPage.getLike());
            mainPage.getLike().click();
        } catch (TimeoutException e) {
            System.out.println("Already Liked");
        }
    }

    public void closePost() {
        waitForElementToBeClickable(mainPage.getClose());
        mainPage.getClose().click();
        sleep(2000);
    }


    public void goMainPage() {
        waitForElementVisibility(mainPage.getLogo());
        mainPage.getLogo().click();
        sleep(3000);
    }

    //ищем текст("This Account is Private")
    public boolean isPrivateAcc() {
        try {
            waitForElementVisibility(mainPage.getPrivateAcc());
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
