package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AuthorizationTests extends TestBase {

    @Test
    public void SuccessfulClassicLogIn() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen44@gmail.com");
        authorizationHelper.setPassword("123456");
        verificationHelper.verificationAlexNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
    }


    @Test
    public void SuccessfulClassiclogInPropertyPage() {
        authorizationHelper.goToPropertyPage();
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen44@gmail.com");
        authorizationHelper.setPassword("123456");
        verificationHelper.verificationAlexNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
    }

    @Test
    //Facebook authorization doen`t work on staging
    public void SuccessfulLogInViaFacebook() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInWithFacebook();
        authorizationHelper.setLoginAndPasswordOnFacebook("aleksandr.serdiuk@gmail.com", "Apple210189");
        verificationHelper.verificationUserNameOnHomePage("Alex");
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
    public void SuccessfulLogInMessageProperty() {
        getMessageHepler().clickPropertyCardMessage();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen666D@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Adam");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
    }
    @Test
    public void SuccessfulLogInContactProperty() {
        getMessageHepler().clickPropertyCard();
        getMessageHepler().clickPropertyContact();
        authorizationHelper.clickFormSignInPropertyContact();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen666D@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Adam");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();

    }
    /*
        @Test
    public void SuccessfulLogInMessageFM() {
        getMessageHepler().clickCardMessage();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen666D@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Adam");
        verificationHelper.verifyUpgradeButton();
        authorizationHelper.logoutFromApp();

    }
    @Test
    public void SuccessfulLogInContactFM() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen44@gmail.com");
        authorizationHelper.setPassword("123456");
        verificationHelper.verificationAlexNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();


    }
    */


}

