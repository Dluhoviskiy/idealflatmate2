package uk.co.idealflatmate.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;


public class MatchingTests extends TestBase {
    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
    }

    @Test
    public void fullMenuNewUserWithVerifPercent() {

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom();

        signUpHelper.signListingFM_LiveIn("fmMatch", "passwUniv", "2",
                                          "6", "2000", "85296200", "19", "Ronaldina",
                "Professional", "Student");

        signUpHelper.preferredLocation("Watf", "Watford");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.budgetMin();
        //signUpHelper.budgetMax();
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
        matchingHelper.end_Update_Quiz("Update results");
        //getAddPropertyHelper().openDropDownMenu();
        verificationHelper.checkMatchingConcurrence("100% complete");

        authorizationHelper.chooseTabFromInnerMenuDashboard("Settings");
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
        helperBase.toHomePage();
    }


    @Test
    public void startMatchingOnFMSearchPage() {

        authorizationHelper.goToFMpage();
        authorizationHelper.clickClosePopupSignUp();
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

        authorizationHelper.goToPropertyPage();
        authorizationHelper.clickClosePopupSignUp();
        matchingHelper.clickMatchBanner();
        matchingHelper.enterFirstName("Reno");
        matchingHelper.clickARoom();
        matchingHelper.clickContinueMatching1();
        matchingHelper.quitQuiz();
        helperBase.toHomePage();
    }

    @Test
    public void startMatchingOnPropertyCard() {

        authorizationHelper.login("passwUniv",  "FMMatch3");
        authorizationHelper.goToPropertyPage();

        searchHelper.clearLocation();
        searchHelper.clickSearchPropPage("SW3 1hw");


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

    @Test
    public void matchingForLordsIsHidden() {
        clearCache();

        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("FMWithMatching");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();

        verificationHelper.verificationUserNameOnHomePage("FMWithMatching1");

        searchHelper.searchPropertyBySelectfromList("W12 0HS", "W12 0HS");

        searchHelper.closePopupSignup();

        verificationHelper.matchingForLordIsHidden();

        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
        helperBase.toHomePage();
    }
    @Test
    public void matchingOtherUserDisplaying() {
        clearCache();
        authorizationHelper.login("passwUniv", "matching_100");
        authorizationHelper.goToFMpage();
        matchingHelper.matchingOnCardClick();
        verificationHelper.profileHasMatching();

        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
        helperBase.toHomePage();
    }

}
