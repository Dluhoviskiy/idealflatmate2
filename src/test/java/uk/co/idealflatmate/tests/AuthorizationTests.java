package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AuthorizationTests extends TestBase {

    @Test
    public void SuccessClassicLogIn() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen44@gmail.com");
        authorizationHelper.setPassword("123456");
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void SuccessClassiclogInOnPropertyPage() {
        authorizationHelper.goToPropertyPage();
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen44@gmail.com");
        authorizationHelper.setPassword("123456");
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void SuccessClassiclogInOnFMPage() {
        authorizationHelper.goToFMpage();
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen44@gmail.com");
        authorizationHelper.setPassword("123456");
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
    }

    @Test
    //Facebook authorization doen`t work on staging
    public void SuccessLogInViaFacebook() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInWithFacebook();
        authorizationHelper.LoginFacebookWithActiveAccount("aleksandr.serdiuk@gmail.com", "Apple210189");
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
    }

   @Test
    public void SuccessLogInWithMatchingFB() {
        matchingHelper.clickHomePageMatching();
        matchingHelper.clickContinueMatching1();
        matchingHelper.clickContinueMatching2();
        matchingHelper.clickContinueMatching3();
        matchingHelper.clickContinueMatching4();
        matchingHelper.clickContinueMatching5();
        matchingHelper.clickContinueMatching6();
        authorizationHelper.clickSignInWithFacebookMatching();
        authorizationHelper.LoginFacebookWithActiveAccount("aleksandr.serdiuk@gmail.com", "Apple210189");
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
    }


    @Test
    public void InvalidAuthorizationWithEmptyFields() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.clickLoginSubmitButton();
        verificationHelper.VerificationLoginError();
        verificationHelper.VerificationPasswordError();
        verificationHelper.VerificationMessagesTabIsAbsent();
    }

    @Test
    public void SuccessLogInMessageProperty() {
        getMessageHelper().clickPropertyCardMessageUnlogged();
        //authorizationHelper.clickFormSignInPropertyContact();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen666D@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Adam");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void SuccessLogInContactProperty() {
        getMessageHelper().clickPropertyCardFirstOnPage();
        getMessageHelper().clickPropertyContact();
        authorizationHelper.clickFormSignInPropertyContact();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen666D@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Adam");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void SuccessLogInMessageFM() {
        authorizationHelper.goToFMpage();
        getMessageHelper().clickFMCardMessageUnlogged();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen666D@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Adam");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void SuccessLogInContactFM() {
        authorizationHelper.goToFMpage();
        getMessageHelper().clickFMCardFirstOnPage();
        getMessageHelper().clickFMContact();
        authorizationHelper.clickFormSignInPropertyContact();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen666D@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Adam");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
    }


}

