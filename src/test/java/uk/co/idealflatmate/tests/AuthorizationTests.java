package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AuthorizationTests extends TestBase {

  //  @Test
    public void SuccessfulClassicLogIn() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen44@gmail.com");
        authorizationHelper.setPassword("123456");
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
    }

   // @Test
    public void SuccessfulClassiclogOnPropertyPage() {
        authorizationHelper.goToPropertyPage();
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen44@gmail.com");
        authorizationHelper.setPassword("123456");
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
    }

  //  @Test
    public void SuccessfulClassiclogOnFMPage() {
        authorizationHelper.goToFMpage();
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen44@gmail.com");
        authorizationHelper.setPassword("123456");
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
    }

    //@Test
    //Facebook authorization doen`t work on staging
    public void SuccessfulLogInViaFacebook() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInWithFacebook();
        authorizationHelper.setLoginAndPasswordOnFacebook("aleksandr.serdiuk@gmail.com", "Apple210189");
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
    }

   // @Test
    public void SuccessfulLogInWithMatchingFB() {
        matchingHelper.clickHomePageMatching();
        matchingHelper.clickContinueMatching();
        matchingHelper.clickContinueMatching3();
        matchingHelper.clickContinueMatching4();
        matchingHelper.clickContinueMatching5();
        matchingHelper.clickContinueMatching6();
        matchingHelper.clickContinueMatching7();
        authorizationHelper.clickSignInWithFacebookMatching();
        authorizationHelper.setLoginAndPasswordOnFacebook("aleksandr.serdiuk@gmail.com", "Apple210189");
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
    }


    //@Test
    public void InvalidAuthorizationWithEmptyFields() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.clickLoginSubmitButton();
        verificationHelper.VerificationLoginError();
        verificationHelper.VerificationPasswordError();
        verificationHelper.VerificationMessagesTabIsAbsent();
    }

   // @Test
    public void SuccessfulLogInMessageProperty() {
        getMessageHelper().clickPropertyCardMessageUnlogged();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen666D@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Adam");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
    }

    //@Test
    public void SuccessfulLogInContactProperty() {
        getMessageHelper().clickPropertyCardFirstOnPage();
        getMessageHelper().clickPropertyContact();
        authorizationHelper.clickFormSignInPropertyContact();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen666D@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Adam");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
    }

    //@Test
    public void SuccessfulLogInMessageFM() {
        authorizationHelper.goToFMpage();
        getMessageHelper().clickFMCardMessageUnlogged();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen666D@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Adam");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
    }

    //@Test
    public void SuccessfulLogInContactFM() {
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

