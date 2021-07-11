package autotest.tests.regress;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    public boolean retry(ITestResult result) {
        return true;
    }
}