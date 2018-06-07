package uk.co.idealflatmate.tests;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SignUpTest extends TestBase {

    //@Test
    public void TestSuccessfulClassicSignUp() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignUpButtonInForm();
        authorizationHelper.setNewLoginMail("cro.genNewOneTest@gmail.com");
        authorizationHelper.setNewLoginPassword("123456");
        authorizationHelper.setNewLoginNameF("Ronald");
        authorizationHelper.setNewLoginNameL("NewOne");
        verificationHelper.AgeConfirmCheck();
        authorizationHelper.clickFormSignUp();
        authorizationHelper.clickCloseMoreAboutYou();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }

    //@Test
    public void TestClassicSignUpWithExistingEmail() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignUpButtonInForm();
        authorizationHelper.setNewLoginMail("cro.gen44@gmail.com");
        authorizationHelper.setNewLoginPassword("123456");
        authorizationHelper.setNewLoginNameF("Ronald");
        authorizationHelper.setNewLoginNameL("NewOne");
        verificationHelper.AgeConfirmCheck();
        authorizationHelper.clickFormSignUp();
        verificationHelper.emailAlreadyExistedAlert();
     }

    //@Test
    public void TestClassicSignUpWithBlankRequiredFields() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignUpButtonInForm();
        authorizationHelper.clickFormSignUp();
        verificationHelper.emailBlankAlert();
        verificationHelper.NameFirstBlankAlert();
        verificationHelper.NameLastBlankAlert();
        verificationHelper.passwordBlankAlert();
        verificationHelper.checkAgeBlankAlert();
    }

    /*
    @Test
    public void SuccessfulClassicSignInPropertyPage() {
        authorizationHelper.goToPropertyPage();
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen44@gmail.com");
        authorizationHelper.setPassword("123456");
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
    }

    @Test
    //Facebook authorization doen`t work on staging
    public void SuccessfulSignInViaFacebook() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInWithFacebook();
        authorizationHelper.setLoginAndPasswordOnFacebook("aleksandr.serdiuk@gmail.com", "Apple210189");
        verificationHelper.verificationUserNameOnHomePage("Alex");
    }

    @Test
    public void InvalidSignInWithEmptyFields() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.clickLoginSubmitButton();
        verificationHelper.VerificationLoginError();
        verificationHelper.VerificationPasswordError();
        verificationHelper.VerificationMessagesTabIsAbsent();
    }
     */















}
