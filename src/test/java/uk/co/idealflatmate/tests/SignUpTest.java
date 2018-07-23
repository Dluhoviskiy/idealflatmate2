package uk.co.idealflatmate.tests;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SignUpTest extends TestBase {

    @Test (priority = 1)
    public void TestSuccessfulClassicSignUp() {

        authorizationHelper.clickSignInButton();
        //authorizationHelper.clickSignUpButtonInForm();
        authorizationHelper.setNewLoginMail("cro.genNewOneTest1@gmail.com");
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

    @Test (priority = 1)
    public void TestClassicSignUpWithExistingEmail() {

        authorizationHelper.clickSignInButton();
        //authorizationHelper.clickSignUpButtonInForm();
        authorizationHelper.setNewLoginMail("cro.gen.Landlord101@gmail.com");
        authorizationHelper.setNewLoginPassword("qqqqqq");
        authorizationHelper.setNewLoginNameF("Ronald");
        authorizationHelper.setNewLoginNameL("NewOne");
        authorizationHelper.setPhoneNumberHomePage("777777777");
        //verificationHelper.ageConfirmCheckClassicSignUp();
        verificationHelper.ageConfirmCheckClassicSignUpIf();
        authorizationHelper.clickFormSignUpSave();
        verificationHelper.emailAlreadyExistedAlert();
     }

    @Test (priority = 1)
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

    @Test (priority = 1)
    //Facebook authorization doen`t work on staging

    public void SuccessfulSignUpViaFacebook() {
        open("https://www.idealflatmate.co.uk/");
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

    @Test (priority = 1)
    //Facebook authorization doen`t work on staging

    public void SignUpViaFacebookAgeUnder18() {
        open("https://www.idealflatmate.co.uk/");
        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignUpWithFacebook();
        authorizationHelper.LoginFacebookWithNewAccount("ron666ddd@gmail.com", "qqqqqq666D");
        //verificationHelper.verificationUserNameOnHomePage("Ronald");
        authorizationHelper.acceptFBageRestriction();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }


    @Test (priority = 1)
    public void SuccessfulClassicSignUpPropertyPage() {

        authorizationHelper.goToPropertyPage();
        authorizationHelper.clickCloseSignUpFMPage();
        authorizationHelper.clickSignInButton();
        authorizationHelper.setNewLoginMail("cro.genNewOneTest1@gmail.com");
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

    @Test (priority = 1)
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

    @Test (priority = 1)
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

    //@Test
    public void SuccessfulSignUpWithMatchingWithAllFields() {

        matchingHelper.clickHomePageMatching();
        matchingHelper.clickContinueMatching1();
        matchingHelper.clickContinueMatching2();
        matchingHelper.clickContinueMatching3();
        matchingHelper.clickContinueMatching4();
        matchingHelper.clickContinueMatching5();
        matchingHelper.clickContinueMatching6();
        authorizationHelper.setNewLoginMailMatching("cro.genNewOneTest3@gmail.com");
        authorizationHelper.setNewLoginPasswordMatching("123456");
        authorizationHelper.setNewLoginNameFMatching("Ronald");
        authorizationHelper.setNewLoginNameLMatching("NewOne");
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
    //@Test
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
