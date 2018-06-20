package uk.co.idealflatmate.tests;


import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;




public class MatchingTests extends TestBase {

    @Test
    public void CompleteMatchingFromMenuWithNewUserWithVerifyingPercent() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignUpButtonInForm();
        authorizationHelper.setNewLoginMail("cro.genNewOneTest4@gmail.com");
        authorizationHelper.setNewLoginPassword("123456");
        authorizationHelper.setNewLoginNameF("Ronald");
        authorizationHelper.setNewLoginNameL("NewOne");
        verificationHelper.AgeConfirmCheckClassicSignUp();
        authorizationHelper.clickFormSignUpSave();
        authorizationHelper.clickCloseMoreAboutYou();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        verificationHelper.checkMatchingConcurrence("NOT taken!");
        matchingHelper.chooseMatchingFromDropDownMenu();
        matchingHelper.clickContinueMatching1();
        matchingHelper.clickContinueMatching2();
        matchingHelper.clickContinueMatching3();
        matchingHelper.clickContinueMatching4();
        matchingHelper.clickContinueMatching5();
        matchingHelper.clickContinueMatching6();
        matchingHelper.clickSkip7step();
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        verificationHelper.checkMatchingConcurrence("30% complete");
        matchingHelper.chooseMatchingFromDropDownMenu();
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
        verificationHelper.checkMatchingConcurrence("100% complete");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }


    //@Test
    public void StartMatchingOnFMSearchPage() {
        matchingHelper.clickHomePageMatching();
        matchingHelper.clickContinueMatching1();
    }

    //@Test
    public void StartMatchingByStartQuizOnPropertyCard() {
        matchingHelper.clickHomePageMatching();
        matchingHelper.clickContinueMatching1();
    }

    //@Test
    public void StartMatchingByStartQuizOnFMCard() {
        matchingHelper.clickHomePageMatching();
        matchingHelper.clickContinueMatching1();
    }


}
