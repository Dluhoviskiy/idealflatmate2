package uk.co.idealflatmate.tests;


import org.testng.annotations.Test;
import utils.ConfData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class MatchingTests extends TestBase {

    @Test
    public void fullMenuNewUserWithVerifPerc() {

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom1();

        signUpHelper.signListingFM_LiveIn("fmMatch", "passwUniv", "2",
                                          "6", "2000", "85296200", "19", "Ronaldina");

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

        authorizationHelper.login("passwUniv",  "FMMatch3");
        authorizationHelper.goToPropertyPage();

        searchHelper.clearLocation();
        searchHelper.selectSearchPropPage("SW3");


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
