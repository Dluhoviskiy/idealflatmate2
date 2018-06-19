package uk.co.idealflatmate.tests;


import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;




public class MatchingTests extends TestBase {

    @Test
    public void FullMatchingWithNewUserFromMenu() {
        matchingHelper.clickHomePageMatching();
        matchingHelper.clickContinueMatching1();
        matchingHelper.clickContinueMatching2();
        matchingHelper.clickContinueMatching3();
        matchingHelper.clickContinueMatching4();
        matchingHelper.clickContinueMatching5();
        matchingHelper.clickContinueMatching6();
        authorizationHelper.setNewLoginMailMatching("cro.genNewOneTest@gmail.com");
        authorizationHelper.setNewLoginPasswordMatching("123456");
        authorizationHelper.setNewLoginNameFMatching("Ronald");
        authorizationHelper.setNewLoginNameLMatching("NewOne");
        verificationHelper.AgeConfirmCheckMatching();
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
