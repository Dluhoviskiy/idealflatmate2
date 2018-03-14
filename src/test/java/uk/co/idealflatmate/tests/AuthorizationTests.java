package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AuthorizationTests extends TestBase {

    @Test
    public void SuccessfulClassicSignIn() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage();
        authorizationHelper.setPassword();
        verificationHelper.verificationAlexNameOnHomePage();
        authorizationHelper.logoutFromApp();
    }

    @Test
    //Facebook authorization doen`t work on staging
    public void SuccessfulSignInViaFacebook() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.ClickLoginWithFacebook();
        authorizationHelper.setLoginAndPasswordOnFacebook();
        verificationHelper.verificationAleksandrNameOnHomePage();
    }

    @Test
    public void InvalidAuthorizationWithEmptyFields() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.clickLoginSubmitButton();
        verificationHelper.VerificationLoginError();
        verificationHelper.VerificationPasswordError();
        verificationHelper.VerificationMessagesTabIsAbsent();
    }


}

