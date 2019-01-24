package uk.co.idealflatmate.tests;


import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;


public class MatchingTests extends TestBase {

    @Test
    public void completeMatchingFromMenuWithNewUserWithVerifyingPercent() {
        pageUrlVerifLiveGoStage();
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom1();
        signUpHelper.clickEmail();

        signUpHelper.setSignUpNameF("Ronaldina");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("FMnewlq10@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("19");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.preferredLocation("Watf", "Watford");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.budgetMin();
        signUpHelper.budgetMax();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verificationUserNameOnHomePage("Ronaldina");
        getAddPropertyHelper().openDropDownMenu();
        verificationHelper.checkMatchingConcurrence("NOT taken!");

        matchingHelper.chooseMatchingFromDropDownMenu();
        matchingHelper.clickContinueMatching1();
        matchingHelper.clickContinueMatching2();
        matchingHelper.clickContinueMatching3();
        matchingHelper.clickContinueMatching4();
        matchingHelper.clickContinueMatching5();
        matchingHelper.clickContinueMatching6();
        matchingHelper.clickSkip7step();

        verificationHelper.checkMatchingConcurrence("30% complete");
        matchingHelper.chooseMatchingFromDropDownMenu();
        matchingHelper.verificationResultOfSixMatching();
        matchingHelper.endQuizGo();
        //getAddPropertyHelper().openDropDownMenu();
        verificationHelper.checkMatchingConcurrence("100% complete");

        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
        helperBase.toHomePage();
    }


    @Test
    public void startMatchingOnFMSearchPage() {
        pageUrlVerifLiveGoStage();
        authorizationHelper.goToFMpage();
        authorizationHelper.clickCloseSignUp();
        matchingHelper.clickMatchBanner();
        matchingHelper.quitQuiz();
        verificationHelper.isFMPage();
        helperBase.toHomePage();
        matchingHelper.clickHomePageMatching();
        matchingHelper.quitQuiz();

        verificationHelper.verificationUserIsUnlogged("Join Free");
        helperBase.toHomePage();
    }

    @Test
    public void startMatchingQuizPropertyPage() {
        pageUrlVerifLiveGoStage();
        authorizationHelper.goToPropertyPage();
        authorizationHelper.clickCloseSignUp();
        matchingHelper.clickMatchBanner();
        matchingHelper.enterFirstName("Reno");
        matchingHelper.clickARoom();
        matchingHelper.clickContinueMatching1();
        matchingHelper.quitQuiz();
        helperBase.toHomePage();
    }

    @Test
    public void startMatchingOnPropertyCard() {
        pageUrlVerifLiveGoStage();
        authorizationHelper.login("TerezaHQ@gmail.com", "qqqqqq");
        authorizationHelper.goToPropertyPage();

        searchHelper.clearLocation();
        searchHelper.clickSearchPropPage1("sw3", "SW3");


        addPropertyHelper.clickCardWithMatch();
        matchingHelper.clickContinueMatching1();
        matchingHelper.quitQuiz();
        verificationHelper.isPropertyPage();
        helperBase.toHomePage();
        matchingHelper.clickHomePageMatching();
        matchingHelper.quitQuiz();

        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
        helperBase.toHomePage();
    }
}
