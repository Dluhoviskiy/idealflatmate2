package uk.co.idealflatmate.tests;

import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerification;


public class AuthorizationTests extends TestBase {



    @Test(priority = 1)
    public void SuccessClassicLogInLogout() {

        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("Borris");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test(priority = 2)
    public void SuccessClassiclogInOnPropertyPage() {

        authorizationHelper.goToPropertyPage();
        authorizationHelper.clickSignInButtonInPopup();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("Borris");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test(priority = 3)
    public void SuccessClassiclogInOnFMPage() {
        clearCache();
        authorizationHelper.goToFMpage();
        authorizationHelper.clickSignInButtonInPopup();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("Borris");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test(priority = 4)
    public void EmailWronglogInHomePage() {

        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FHq@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        verificationHelper.passwWrongAlertHome();
        signUpHelper.quit();
    }

    @Test(priority = 5)
    public void PasswordWronglogInHomePage() {

        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq1");
        authorizationHelper.submitLogin();
        verificationHelper.passwWrongAlertHome();
        signUpHelper.quit();
    }

    @Test (priority = 10)
    //Facebook authorization doen`t work on staging
    public void SuccessLogInViaFacebook() {
        clearCache();
        pageUrlVerification();
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.clickLoginWithFacebook1();
        authorizationHelper.LoginFacebookWithActiveAccount("aleksandr.serdiuk@gmail.com", "Apple210189");
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
        //newDriverPage();
    }

    @Test (priority = 10)
    public void SuccessLogInWithMatchingFB() {
        newDriverPage();
        open("https://www.idealflatmate.co.uk/");
        matchingHelper.clickHomePageMatching();
        matchingHelper.enterFirstName("Donald");
        matchingHelper.clickAFM();

        matchingHelper.clickContinueMatching1();
        matchingHelper.clickContinueMatching2();
        matchingHelper.clickContinueMatching3();
        matchingHelper.clickContinueMatching4();
        matchingHelper.clickContinueMatching5();
        matchingHelper.clickContinueMatching6();
        matchingHelper.clickContinueMatching7();
        matchingHelper.clickContinueMatching8();
        matchingHelper.clickContinueMatching9();
        matchingHelper.clickContinueMatching10();
        matchingHelper.clickContinueMatching11();
        matchingHelper.clickContinueMatching12();
        matchingHelper.clickContinueMatching13();
        matchingHelper.clickContinueMatching14();
        matchingHelper.clickContinueMatching15();
        matchingHelper.clickContinueMatching16();
        matchingHelper.clickContinueMatching17();
        matchingHelper.clickContinueMatching18();
        matchingHelper.clickContinueMatching19();
        matchingHelper.clickContinueMatching20();

        authorizationHelper.clickLoginWithFacebook();
        authorizationHelper.LoginFacebookWithActiveAccount("aleksandr.serdiuk@gmail.com", "Apple210189");
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
        //newDriverPage();
    }

    @Test (priority = 7)
    public void InvalidAuthorizationWithEmptyFields() {
        //newDriverPage();
        clearCache();
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.submitLogin();
        verificationHelper.VerificationLoginError();
        verificationHelper.VerificationPasswordError();
        signUpHelper.quit();
       //verificationHelper.VerificationMessagesTabIsAbsent();
    }

    @Test (priority = 8)
    public void SuccessLogInMessageProperty() {
        clearCache();
        getMessageHelper().clickPropertyCardMessageUnlogged();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("Borris");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test (priority = 9)
    public void SuccessLogInContactProperty() {
        clearCache();
        getMessageHelper().clickPropertyCardFirstOnPage();
        //authorizationHelper.clickCloseSignUp();
        getMessageHelper().clickPropertyContact();
        authorizationHelper.clickFormSignInContact();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("Borris");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test (priority = 9)
    public void SuccessLogInMessageFM() {
        clearCache();
        authorizationHelper.goToFMpage();
        authorizationHelper.clickCloseSignUp();
        getMessageHelper().clickFMCardMessageUnlogged();
        authorizationHelper.clickFormSignInContact();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("Borris");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test (priority = 9)
    public void SuccessLogInContactFM() {
        clearCache();
        authorizationHelper.goToFMpage();
        authorizationHelper.clickCloseSignUp();
        getMessageHelper().clickFMCardFirstOnPage();
        getMessageHelper().clickFMContact();
        authorizationHelper.clickFormSignInContact();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("Borris");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }
    @Test (priority = 1)
    public void SuccessLogInPhoneReveal() {
        clearCache();
        getMessageHelper().clickPropertyCardFirstOnPage();
        getMessageHelper().clickPhoneReveal();
        authorizationHelper.clickSignInButtonInPopupPhone();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("Borris");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

}

