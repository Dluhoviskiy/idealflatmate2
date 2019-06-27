package uk.co.idealflatmate.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.ProfileData;
import utils.ConfData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
//import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
import static uk.co.idealflatmate.appmanager.AuthorHeaderMenuHelper.clickLogInButtonInForm;
import static uk.co.idealflatmate.appmanager.AuthorHeaderMenuHelper.clickSignInButtonInForm;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifStageGoLive;


public class AuthorizationTests extends TestBase {

    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
    }

    @Test
    public void classicLogInOut() {

        authorizationHelper.clickJoinFreeButton();
        clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("FMNotPaid");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();

        verificationHelper.verificationUserNameOnHomePage("Borris");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test
    public void classicResetPassword() {

        authorizationHelper.clickJoinFreeButton();
        clickSignInButtonInForm();
        authorizationHelper.checkResetEmail("FMNotPaid");
        verificationHelper.isResetSuccessful();
    }

    @Test
    public void logInOutOnPropertyPage() {

        authorizationHelper.goToPropertyPage();


        authorizationHelper.clickSignInButtonInPopup();
        authorizationHelper.setLoginAsUserWithoutPackage("FMNotPaid");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();

        verificationHelper.verificationUserNameOnHomePage("Borris");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test
    public void logInOutOnFMPage() {

        authorizationHelper.goToFMpage();
        authorizationHelper.clickSignInButtonInPopup();
        authorizationHelper.setLoginAsUserWithoutPackage("FMNotPaid");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();

        verificationHelper.verificationUserNameOnHomePage("Borris");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test
    public void emailWrongHomePage() {

        //helperBase.pageUrlHomeNew();
        authorizationHelper.clickJoinFreeButton();
        clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("fmNotPaid5");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();

        verificationHelper.passwWrongAlertHome();

        signUpHelper.quit();
    }

    @Test
    public void loginPassWronglogInHomePage() {

        clearCache();
        authorizationHelper.clickJoinFreeButton();
        clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("FMNotPaid");
        authorizationHelper.setPassword("passwWrong");
        authorizationHelper.submitLogin();

        verificationHelper.passwWrongAlertHome();

        signUpHelper.quit();
    }

    @Test
    //Facebook authorization doen`t work on staging
    public void addLogInViaFacebook() {

        pageUrlVerifStageGoLive();
        authorizationHelper.clickJoinFreeButton();
        clickSignInButtonInForm();
        authorizationHelper.clickSignUp_In_WithFacebook();
        authorizationHelper.LoginFacebookWithActiveAccount(ConfData.getData("FB1"), ConfData.getData("passwFB1"));
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test
    public void alogInWithMatchingFB() {

        pageUrlVerifStageGoLive();
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
        clickLogInButtonInForm();
        authorizationHelper.clickSignUp_In_WithFacebook();
        authorizationHelper.LoginFacebookWithActiveAccount(ConfData.getData("FB1"), ConfData.getData("passwFB1"));
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }



    @Test
    public void invalidLoginWithEmptyFields() {

        authorizationHelper.clickJoinFreeButton();
        clickSignInButtonInForm();
        authorizationHelper.submitLogin();
        verificationHelper.VerificationLoginError();
        verificationHelper.VerificationPasswordError();
        signUpHelper.quit();
       //verificationHelper.VerificationMessagesTabIsAbsent();
    }

    @Test
    public void logInMesPropVerifProfilePageFull() {


        searchHelper.searchPropertyByEnter("Hounslow");
        searchHelper.closePopupSignup();
        messageHelper.clickPropertyCardMessageUnlogged(0);
        clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("FMwithoutSub");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();

        verificationHelper.verificationUserNameOnHomePage("FM_Manch_2");
        verificationHelper.verifyPageMessage();

        messageHelper.clickMessageOwnerIcon();
        verificationHelper.profileDisplays(new ProfileData("percentComplete14",  "myProfile14",
                "name14", "age14","lookingFor14", "aboutMe14","rooms14",
                "amountPropCards14"));

        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test
    public void logInContactProperty() {

        searchHelper.searchPropertyByEnter("Hounslow");
        searchHelper.closePopupSignup();

        messageHelper.clickCardImgProperty("80-82 Staines Rd, Hounslow TW3 3LF, UK");
        //authorizationHelper.clickClosePopupSignUp();
        messageHelper.clickPropertyContact();
        clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("FMwithoutSub");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("FM_Manch_2");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test
    public void logInMessageFM() {

        authorizationHelper.goToFMpage();
        authorizationHelper.clickClosePopupSignUp();
        getMessageHelper().clickFMCardMessageUnlogged();
        clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("FMwithoutSub2");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test
    public void logInContactFM() {

        authorizationHelper.goToFMpage();
        authorizationHelper.clickClosePopupSignUp();
        getMessageHelper().clickFMCardFirstOnPage();
        getMessageHelper().clickFMContact();
        clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("FMwithoutSub2");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }
    @Test
    public void logInPhoneReveal() {

        getMessageHelper().clickPropertyCardFirstOnPage();
        getMessageHelper().clickPhoneReveal();
        authorizationHelper.clickSignInButtonInPopupPhone();
        authorizationHelper.setLoginAsUserWithoutPackage("FMwithoutSub2");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

}

