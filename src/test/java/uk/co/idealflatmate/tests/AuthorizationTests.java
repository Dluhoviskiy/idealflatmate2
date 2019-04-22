package uk.co.idealflatmate.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
//import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
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
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("FMNotPaid");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();

        verificationHelper.verificationUserNameOnHomePage("Borris");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
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
        authorizationHelper.clickSignInButtonInForm();
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
        authorizationHelper.clickSignInButtonInForm();
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
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.clickLoginWithFacebook1();
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

        authorizationHelper.clickLoginWithFacebook();
        authorizationHelper.LoginFacebookWithActiveAccount(ConfData.getData("FB1"), ConfData.getData("passwFB1"));
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }



    @Test
    public void invalidLoginWithEmptyFields() {

        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.submitLogin();
        verificationHelper.VerificationLoginError();
        verificationHelper.VerificationPasswordError();
        signUpHelper.quit();
       //verificationHelper.VerificationMessagesTabIsAbsent();
    }

    @Test
    public void logInMesPropVerifProfilePageFull() {
        String location1 = "Crewe";
        String location2 = "Crofton Park";
        String location3 = "South London";
        String location4 = "Notting Hill";
        String location5 = "West London";
        String location6 = "Ealing";
        String location7 = "Nottingham";
        String location8 = "Hounslow";
        String location9 = "West Hounslow";
        String name = "Property1";
        String age = "22";

        searchHelper.searchPropertyByEnter("Hounslow");
        searchHelper.closePopupSignup();
        messageHelper.clickPropertyCardMessageUnlogged(0);
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("FMwithoutSub");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();

        verificationHelper.verificationUserNameOnHomePage("FM_Manch_2");
        verificationHelper.verifyPageMessage();

        messageHelper.clickMessageOwnerIcon();
        verificationHelper.profileDisplays("70%\n" + "complete",
                "User Type\n" + "Personal Details\n" +  "Your ideal flatmate",
                 name, age, "I have a room available",
                "About me\n" + name +", "+age+" is a male professional looking for flatmates in" +
                        " "+location1+" or "+location2+", "+location3+" or "+location4+", "+location5+" or" +
                        " "+location6+", "+location5+" or "+location7+" or "+location8+", "+location9+".",
                " Weston Rd, "+location1+" CW1 6NA, UK\n" + " "+location2+", SE4 2BY\n" +
                        " "+location4+", W11 4UL\n" + " "+location6+", W13 0DD\n" +
                        " Upper Parliament Street (Stop U1), "+location7+" NG1 6LD, UK\n" + " "+location8+", TW3 3LF",
                6);

        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test
    public void logInContactProperty() {

        searchHelper.searchPropertyByEnter("Hounslow");
        searchHelper.closePopupSignup();

        messageHelper.clickCardImgProperty("80-82 Staines Rd, Hounslow TW3 3LF, UK");
        //authorizationHelper.clickCloseSignUp();
        messageHelper.clickPropertyContact();
        authorizationHelper.clickFormSignInContact();
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
        authorizationHelper.clickCloseSignUp();
        getMessageHelper().clickFMCardMessageUnlogged();
        authorizationHelper.clickFormSignInContact();
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
        authorizationHelper.clickCloseSignUp();
        getMessageHelper().clickFMCardFirstOnPage();
        getMessageHelper().clickFMContact();
        authorizationHelper.clickFormSignInContact();
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

