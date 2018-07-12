package uk.co.idealflatmate.tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import uk.co.idealflatmate.appmanager.*;
import com.codeborne.selenide.testng.ScreenShooter;



import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;


public class TestBase {

    public final VerificationHelper verificationHelper = new VerificationHelper();
    public final AuthorizationHelper authorizationHelper = new AuthorizationHelper();
    public final PaymentsHelper paymentsHelper = new PaymentsHelper();
    public final AddPropertyHelper addPropertyHelper = new AddPropertyHelper();
    public final MessageHelper messageHelper = new MessageHelper();
    public final MatchingHelper matchingHelper = new MatchingHelper();
    public final EmailHelper emailHelper = new EmailHelper();
    public final HomePageHelper homePageHelper = new HomePageHelper();
    public final FooterHelper footerHelper = new FooterHelper();


    @BeforeMethod
    public void setupClass() {
        ChromeDriverManager.getInstance().setup();
       // FirefoxDriverManager.getInstance().setup();
       // EdgeDriverManager.getInstance().setup();
        //Configuration.browser = "webdriver";
        Configuration.browser = "chrome";
       // Configuration.browser = "firefox";
      //  Configuration.browser = "edge";

        Configuration.timeout = 10000;
        open("https://www.idealflatmate.co.uk/");
        verificationHelper.closeAdvPopUp();
        //open("http://front.idealflatmate.demo.devplatform2.com");

    }

    @AfterMethod
    public void tearDown() {
        screenshot("screenshotFail1");
        closeWebDriver();
    }


    public VerificationHelper getVerificationHelper() { return verificationHelper; }

    public MessageHelper getMessageHelper() { return paymentsHelper.addPropertyHelper.messageHelper;    }

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