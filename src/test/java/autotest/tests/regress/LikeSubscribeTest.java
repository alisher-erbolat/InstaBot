package autotest.tests.regress;

import autotest.core.base.BaseTest;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LikeSubscribeTest extends BaseTest {
    public LikeSubscribeTest(){
        super();
    }

    @Test(retryAnalyzer = Retry.class)
    public void likeAndSubscribe(){
        int people = 5;
        for (int i=0; i<people; i++){
            mainPageHelper.searchPeople();
            boolean isPrivateAcc = mainPageHelper.isPrivateAcc();

            //перезапустить метод
            if(isPrivateAcc){
                mainPageHelper.goMainPage();
                System.out.println("Это закрытый аккаунт, перезапускаем тест");
                Assert.assertEquals(0,1);
            }
            mainPageHelper.likingProcess();
            if(i!=people-1){
                mainPageHelper.goMainPage();
            }
        }
    }
}
