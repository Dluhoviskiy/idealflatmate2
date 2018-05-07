package uk.co.idealflatmate.tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import uk.co.idealflatmate.appmanager.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;


public class TestBase {

    protected final VerificationHelper verificationHelper = new VerificationHelper();
    protected final AuthorizationHelper authorizationHelper = new AuthorizationHelper();
    protected final PaymentsHelper paymentsHelper = new PaymentsHelper();

    @BeforeMethod
    public void setupClass() {
        ChromeDriverManager.getInstance().setup();
        //FirefoxDriverManager.getInstance().setup();
        Configuration.browser = "chrome";
        //Configuration.browser = "firefox";

        Configuration.timeout = 10000;
        open("https://www.idealflatmate.co.uk/");
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }


    public VerificationHelper getVerificationHelper() {
        return verificationHelper;
    }

    public MessageHepler getMessageHepler() {
        return paymentsHelper.addPropertyHelper.messageHepler;
    }

    public AuthorizationHelper getAuthorizationHelper() {
        return authorizationHelper;
    }

    public AddPropertyHelper getAddPropertyHelper() {
        return paymentsHelper.addPropertyHelper;
    }

    public PaymentsHelper getPaymentsHelper() {
        return paymentsHelper;
    }
}