package uk.co.idealflatmate.tests;


import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;




public class MatchingTests extends TestBase {

    @Test (priority = 1)
    public void CompleteMatchingFromMenuWithNewUserWithVerifyingPercent() {
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom1();
        signUpHelper.clickEmail();

        signUpHelper.setSignUpNameF("Ronaldina");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("FMnewl199@gmail.com");
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
    }


    @Test (priority = 2)
    public void StartMatchingOnFMSearchPage() {
        authorizationHelper.goToFMpage();
        authorizationHelper.clickCloseSignUpFMPage();
        matchingHelper.clickTakeTheMatchTestFMscreen();
        matchingHelper.quitQuiz();
        verificationHelper.isFMPage();
    }

    //@Test
    public void StartMatchingByStartQuizOnPropertyCard() {
        matchingHelper.clickHomePageMatching();
        matchingHelper.clickContinueMatching1();
    }


}
