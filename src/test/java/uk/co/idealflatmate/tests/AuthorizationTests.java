package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AuthorizationTests extends TestBase {

    @Test(priority = 1)
    public void SuccessClassicLogInLogout() {

        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Borris");
        authorizationHelper.logoutFromApp();
    }

    @Test(priority = 1)
    public void SuccessClassiclogInOnPropertyPage() {
        newDriverPage();
        authorizationHelper.goToPropertyPage();
       // authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Borris");
        authorizationHelper.logoutFromApp();
    }

    @Test(priority = 1)
    public void SuccessClassiclogInOnFMPage() {

        authorizationHelper.goToFMpage();
       // authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Borris");
        authorizationHelper.logoutFromApp();
    }

    @Test(priority = 2)
    public void EmailWronglogInHomePage() {

        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FHq@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.emailWrongAlertHome();
    }

    @Test
    public void PasswordWronglogInHomePage() {

        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq1");
        verificationHelper.emailWrongAlertHome();
    }

    @Test
    //Facebook authorization doen`t work on staging
    public void SuccessLogInViaFacebook() {
        open("https://www.idealflatmate.co.uk/");
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.clickSignInWithFacebook();
        authorizationHelper.LoginFacebookWithActiveAccount("aleksandr.serdiuk@gmail.com", "Apple210189");
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
        newDriverPage();
    }

    @Test
    //Facebook authorization doen`t work on staging
    public void SuccessSignInViaFacebook() {
        open("https://www.idealflatmate.co.uk/");
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.clickSignInWithFacebook();
        authorizationHelper.LoginFacebookWithActiveAccount("aleksandr.serdiuk@gmail.com", "Apple210189");
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
        newDriverPage();
    }

    @Test
    public void SuccessLogInWithMatchingFB() {
        open("https://www.idealflatmate.co.uk/");
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
        newDriverPage();
    }

    @Test
    public void InvalidAuthorizationWithEmptyFields() {
        newDriverPage();
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.clickLoginSubmitButton();
        verificationHelper.VerificationLoginError();
        verificationHelper.VerificationPasswordError();
       // verificationHelper.VerificationMessagesTabIsAbsent();
    }

    @Test
    public void SuccessLogInMessageProperty() {

        getMessageHelper().clickPropertyCardMessageUnlogged();
        //authorizationHelper.clickFormSignInPropertyContact();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Borris");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void SuccessLogInContactProperty() {

        getMessageHelper().clickPropertyCardFirstOnPage();
        //authorizationHelper.clickCloseSignUp();
        getMessageHelper().clickPropertyContact();
        authorizationHelper.clickFormSignInPropertyContact();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Borris");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void SuccessLogInMessageFM() {
        newDriverPage();
        authorizationHelper.goToFMpage();
        authorizationHelper.clickCloseSignUpFMPage();
        getMessageHelper().clickFMCardMessageUnlogged();
     //   authorizationHelper.clickFormSignInFMmessage();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Borris");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void SuccessLogInContactFM() {

        authorizationHelper.goToFMpage();
        authorizationHelper.clickCloseSignUpFMPage();
        getMessageHelper().clickFMCardFirstOnPage();
        getMessageHelper().clickFMContact();
        authorizationHelper.clickFormSignInContact();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Borris");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
    }
    @Test
    public void SuccessLogInPhoneReveal() {

        getMessageHelper().clickPropertyCardFirstOnPage();
        getMessageHelper().clickPhoneReveal();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Borris");
        authorizationHelper.logoutFromApp();
    }

}

