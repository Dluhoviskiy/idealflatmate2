package uk.co.idealflatmate.tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import uk.co.idealflatmate.appmanager.*;


import java.util.ArrayList;
import java.util.Set;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;


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
    public final AreaPageHelper areaPageHelper = new AreaPageHelper();
    public final SearchHelper searchHelper = new SearchHelper();
    public final HelperBase helperBase = new HelperBase();
    public final SignUpHelper signUpHelper = new SignUpHelper();
    public final SearchHelperFM searchHelperFM = new SearchHelperFM();
    public final BuddyUpHelper buddyUpHelper = new BuddyUpHelper();


    /*@BeforeGroups
    public void setupGroup() {
        ChromeDriverManager.getInstance().setup();
        // FirefoxDriverManager.getInstance().setup();
        // EdgeDriverManager.getInstance().setup();
        //Configuration.browser = "webdriver";
        Configuration.browser = "chrome";
        // Configuration.browser = "firefox";
        //  Configuration.browser = "edge";

        // Configuration.assertionMode = Configuration.AssertionMode.SOFT;

        Configuration.timeout = 10000;
        //open("https://www.idealflatmate.co.uk/");
        HelperBase.closeAdvPopUp();
        //open("http://front.idealflatmate.demo.devplatform2.com");

        open("http://front.idealflatmate4test.demo.devplatform2.com");

    }*/


    @BeforeSuite

    public void setupClass() {
        //ChromeDriverManager.getInstance().setup();
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
       // FirefoxDriverManager.getInstance().setup();
       // EdgeDriverManager.getInstance().setup();
        //Configuration.browser = "webdriver";
        Configuration.browser = "chrome";

        //Configurations.startmaximized=true;
        //Configuration.browser = "firefox";
       // Configuration.browser = "firefox";
      //  Configuration.browser = "edge";

       // Configuration.assertionMode = Configuration.AssertionMode.SOFT;

        Configuration.timeout = 10000;
        //open("https://www.idealflatmate.co.uk/");
        HelperBase.closeAdvPopUp();
        //open("http://front.idealflatmate.demo.devplatform2.com");

        open("http://front.idealflatmate4test.demo.devplatform2.com");

    }




    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();

    }






    @AfterSuite
    public void tearDown() {
        //screenshot("screenshotFail1");
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

    public static void newDriverPage(String relativeOrAbsoluteUrl) {
        closeWebDriver();
        //ChromeDriverManager.getInstance().setup();
        WebDriverManager.chromedriver().setup();
        open(relativeOrAbsoluteUrl);
    }

    public static void newPage(String relativeOrAbsoluteUrl) {

        //ArrayList tabs2 = (ArrayList) getWebDriver().getWindowHandles();//Получение списка табов
        //switchTo().window(String.valueOf(tabs2.get(1)));//Переключение на второй
        close();
        //clearBrowserCache();
        //refresh();
        open(relativeOrAbsoluteUrl);
    }

    public void clearCache() {

        clearBrowserCache();
        refresh();
    }


}