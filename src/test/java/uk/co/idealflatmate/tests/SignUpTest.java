package uk.co.idealflatmate.tests;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SignUpTest extends TestBase {

    @Test
    public void TestSuccessfulClassicSignUp() {

        authorizationHelper.clickSignInButton();
        //authorizationHelper.clickSignUpButtonInForm();
        authorizationHelper.setNewLoginMail("cro.gen7778@gmail.com");
        authorizationHelper.setNewLoginPassword("wwwwww666D");
        authorizationHelper.setNewLoginNameF("Ronald");
        authorizationHelper.setNewLoginNameL("NewOne");
        authorizationHelper.setPhoneNumberHomePage("777777777");
        verificationHelper.ageConfirmCheckClassicSignUp();
        authorizationHelper.clickFormSignUpSave();
        authorizationHelper.clickCloseMoreAboutYou();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }

    @Test
    public void TestClassicSignUpWithExistingEmail() {

        authorizationHelper.clickSignInButton();
        //authorizationHelper.clickSignUpButtonInForm();
        authorizationHelper.setNewLoginMail("cro.gen44@gmail.com");
        authorizationHelper.setNewLoginPassword("123456");
        authorizationHelper.setNewLoginNameF("Ronald");
        authorizationHelper.setNewLoginNameL("NewOne");
        authorizationHelper.setPhoneNumberHomePage("777777777");
        //verificationHelper.ageConfirmCheckClassicSignUp();
        verificationHelper.ageConfirmCheckClassicSignUpIf();
        authorizationHelper.clickFormSignUpSave();
        verificationHelper.emailAlreadyExistedAlert();
     }

    @Test
    public void TestClassicSignUpWithBlankRequiredFields() {

        authorizationHelper.clickSignInButton();
       // authorizationHelper.clickSignUpButtonInForm();
        authorizationHelper.clickFormSignUpSave();
        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlert();
        verificationHelper.nameLastBlankAlert();
        verificationHelper.passwordBlankAlert();
        verificationHelper.checkAgeBlankAlert();
        verificationHelper.checkPhoneAlert();
    }

    @Test
    //Facebook authorization doen`t work on staging

    public void SuccessfulSignUpViaFacebook() {

        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignUpWithFacebook();
        authorizationHelper.LoginFacebookWithNewAccount("ron1991d@gmail.com", "qqqqqq666D");
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }

    @Test
    //Facebook authorization doen`t work on staging

    public void SignUpViaFacebookAgeUnder18() {

        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignUpWithFacebook();
        authorizationHelper.LoginFacebookWithNewAccount("ron666ddd@gmail.com", "qqqqqq666D");
        //verificationHelper.verificationUserNameOnHomePage("Ronald");
        authorizationHelper.acceptFBageRestriction();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }


    @Test
    public void SuccessfulClassicSignUpPropertyPage() {

        authorizationHelper.goToPropertyPage();
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen44@gmail.com");
        authorizationHelper.setPassword("123456");
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void SuccessfulSignUpWithMatchingWithRequiredFields() {

        matchingHelper.clickHomePageMatching();
        matchingHelper.clickContinueMatching1();
        matchingHelper.clickContinueMatching2();
        matchingHelper.clickContinueMatching3();
        matchingHelper.clickContinueMatching4();
        matchingHelper.clickContinueMatching5();
        matchingHelper.clickContinueMatching6();
        authorizationHelper.setNewLoginMailMatching("cro.genNewOneTest1@gmail.com");
        authorizationHelper.setNewLoginPasswordMatching("123456");
        authorizationHelper.setNewLoginNameFMatching("Ronald");
        authorizationHelper.setNewLoginNameLMatching("NewOne");
        authorizationHelper.setPhoneNumber("777777777");
        verificationHelper.ageConfirmCheckMatching();
        matchingHelper.clickContinueMatchingAfterSignUp();
        authorizationHelper.rejectMissedPreferredLocation();
        matchingHelper.clickSkip7stepFromHome();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }

    @Test
    public void SignUpWithMatchingWithBlankRequiredFields() {

        matchingHelper.clickHomePageMatching();
        matchingHelper.clickContinueMatching1();
        matchingHelper.clickContinueMatching2();
        matchingHelper.clickContinueMatching3();
        matchingHelper.clickContinueMatching4();
        matchingHelper.clickContinueMatching5();
        matchingHelper.clickContinueMatching6();
        matchingHelper.clickContinueMatchingAfterSignUp();
        authorizationHelper.rejectMissedPreferredLocation();
        verificationHelper.emailBlankAlertMatching();
        verificationHelper.NameFirstBlankAlertMatching();
        verificationHelper.NameLastBlankAlertMatching();
        verificationHelper.passwordBlankAlertMatching();
        verificationHelper.checkPhoneAlertMatching();
        verificationHelper.checkAgeBlankAlertMatching();
    }

    @Test
    public void SuccessfulSignUpWithMatchingWithAllFields() {

        matchingHelper.clickHomePageMatching();
        matchingHelper.clickContinueMatching1();
        matchingHelper.clickContinueMatching2();
        matchingHelper.clickContinueMatching3();
        matchingHelper.clickContinueMatching4();
        matchingHelper.clickContinueMatching5();
        matchingHelper.clickContinueMatching6();
        authorizationHelper.setNewLoginMail("cro.genNewOneTest3@gmail.com");
        authorizationHelper.setNewLoginPassword("123456");
        authorizationHelper.setNewLoginNameF("Ronald");
        authorizationHelper.setNewLoginNameL("NewOne");
        authorizationHelper.setPhoneNumber("777777777");
        verificationHelper.ageConfirmCheckMatching();


        matchingHelper.clickContinueMatchingAfterSignUp();
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
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }
    @Test
    public void SuccessfulSignUpWithListingWithAllFields() {
        verificationHelper.closeAdvPopUp();
        verificationHelper.ageConfirmCheckMatching();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }



    /*
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
