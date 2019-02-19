package uk.co.idealflatmate.tests;
import org.testng.annotations.Test;

import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;


public class SignUpMatching extends TestBase {


    @Test

    public void signUpMatchingWithBlankFirstName() {

        matchingHelper.clickHomePageMatching();
        matchingHelper.verifyBlankNameMatchSign();
        matchingHelper.quitQuiz();
    }

    @Test
    public void SignUpMatchingWithRequiredFieldsRoom() {

        matchingHelper.clickHomePageMatching();
        matchingHelper.enterFirstName("Donald");
        matchingHelper.clickARoom();

        //matchingHelper.clickAFM();
        matchingHelper.matchingTests();

        signUpHelper.clickEmailMatching1();

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMMatch5");
        signUpHelper.moreAboutYou("15","2","1977","45656776","19","Tell us about yourself");

        signUpHelper.backLocation();
        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.preferredLocation( "watf", "Watford");
        signUpHelper.clickYourInformationContinue();


        signUpHelper.budgetMax();
        signUpHelper.clickYourInformationContinue();
        verificationHelper.budgetError();


        signUpHelper.budgetMin();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.toMoveCheckboxEnabled();
        signUpHelper.selectMoveDate("8", "8", "2019");
        signUpHelper.selectHappyReceiveNews();
        signUpHelper.clickYourInformationContinue();

        //signUpHelper.clickShowMeMyMatches();
        verificationHelper.verifySearchListingPageMatching();

        getAddPropertyHelper().openDropDownMenu();
        verificationHelper.checkMatchingConcurrence("100% complete");
        matchingHelper.chooseMatchingFromDropDownMenu();
        matchingHelper.verificationResultOfMatching();

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseProfileFromDropDownMenu();
        verificationHelper.verificationDataProfileMatching("80%");

        verificationHelper.verificationUserNameOnHomePage("Ronald");

        authorizationHelper.removeAnyAccount();
    }


    @Test
    public void SignUpMatchingWithRequiredFieldsFMRoom() {

        matchingHelper.clickHomePageMatching();
        matchingHelper.enterFirstName("Donald");
        //matchingHelper.clickARoom();

        matchingHelper.clickAFM();
        matchingHelper.matchingTests();

        signUpHelper.clickEmailMatching1();

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMMatch4");
        signUpHelper.moreAboutYou("15","2","1977","45656776","19","Tell us about yourself");

        signUpHelper.clickListYourRoomMatching();

        verificationHelper.verifyAddListingPage();
        addPropertyHelper.openDropDownMenu();
        verificationHelper.checkMatchingConcurrence("100% complete");
        authorizationHelper.chooseProfileFromDropDownMenu();
       // matchingHelper.closePopupMatching();
        //signUpHelper.verificationDataProfileNameUser("flatmate");
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        authorizationHelper.removeAnyAccount();
    }

    @Test
    public void SignUpMatchingWithRequiredFieldsFMRoomSearchFM() {

        matchingHelper.clickHomePageMatching();
        matchingHelper.enterFirstName("Donald");
        //matchingHelper.clickARoom();

        matchingHelper.clickAFM();
        matchingHelper.matchingTests();

        signUpHelper.clickEmailMatching1();

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMMatch6");
        signUpHelper.moreAboutYou("15","2","1977","45656776","19","Tell us about yourself");

        signUpHelper.clickSearchFMMatching();
        verificationHelper.verifySearchFMPage();
        //verificationHelper.verifyAddListingPage();

        getAddPropertyHelper().openDropDownMenu();
        verificationHelper.checkMatchingConcurrence("100% complete");
        authorizationHelper.chooseProfileFromDropDownMenu();
       // matchingHelper.closePopupMatching();
        signUpHelper.verificationDataProfileNameUser("Ronald", "42");
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        authorizationHelper.removeAnyAccount();
    }


    @Test
    public void SignUpWithMatchingWithBlankRequiredFields() {
        pageUrlVerifLiveGoStage();
        clearCache();
        matchingHelper.clickHomePageMatching();

        matchingHelper.enterFirstName("Donald");
        //matchingHelper.clickARoom();

        matchingHelper.clickAFM();
        matchingHelper.matchingTests();

        signUpHelper.clickEmailMatching1();

        signUpHelper.clickYourInformationContinue();

        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlert();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

}
