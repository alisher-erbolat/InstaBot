package autotest.core.data;

import autotest.core.base.BaseTest;
import org.testng.annotations.DataProvider;

/*
* DataProviderClass предоставляет тестовые данные для методов с аннотацией @Test,
* DataProviderClass это возможность фреймворка testng
* в данном примере передается только одно значение, пример приведен для наглядности,
* для эффективности используйте данный класс когда передаете несколько данных,
* название метода в идеале должна намекать на определение тестовых данных
* */
public class DataProviderClass extends BaseTest {
    @DataProvider
    public Object[][] searchData(){
        return new Object[][]{
                {"How to automate site using selenium"}
        };
    }

    @DataProvider
    public Object[][] usernamePassword(){
        Object[][] data = new Object[1][2];
        data[0][0] = "betacareer_engineering";
        data[0][1] = "beta2020career";
        return data;
    }
}
