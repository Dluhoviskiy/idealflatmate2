package uk.co.idealflatmate.tests;
import org.testng.annotations.Test;


public class SignUpMatching extends TestBase {


    @Test (priority = 1)

    public void signUpMatchingWithBlankFirstName() {
        clearCache();
        matchingHelper.clickHomePageMatching();
        matchingHelper.verifyBlankNameMatchSign();
        matchingHelper.quitQuiz();
    }

    @Test (priority = 2)
    public void SignUpMatchingWithRequiredFieldsRoom() {
        //newDriverPage();
        clearCache();
        matchingHelper.clickHomePageMatching();
        matchingHelper.enterFirstName("Donald");
        matchingHelper.clickARoom();

        //matchingHelper.clickAFM();
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

        signUpHelper.clickEmailMatching1();

        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("Matching992o@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("19");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

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
        verificationHelper.verificationDataProfileMatching();

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("70% complete");
        authorizationHelper.chooseProfileFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();

        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test (priority = 3)
    public void SignUpMatchingWithRequiredFieldsFMRoom() {
        //newDriverPage();
        clearCache();
        matchingHelper.clickHomePageMatching();
        matchingHelper.enterFirstName("Donald");
        //matchingHelper.clickARoom();
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

        signUpHelper.clickEmailMatching1();

        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("FMnew111o@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "1978");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("19");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.clickListYourRoomMatching();

        verificationHelper.verifyAddListingPage();
        getAddPropertyHelper().openDropDownMenu();
        verificationHelper.checkMatchingConcurrence("100% complete");
        authorizationHelper.chooseProfileFromDropDownMenu();
       // matchingHelper.closePopup();
        //signUpHelper.verificationDataProfileNameUser("flatmate");
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("70% complete");
        authorizationHelper.chooseProfileFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();

        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test (priority = 4)
    public void SignUpMatchingWithRequiredFieldsFMRoomSearchFM() {
        //newDriverPage();
        clearCache();
        matchingHelper.clickHomePageMatching();
        matchingHelper.enterFirstName("Donald");
        //matchingHelper.clickARoom();
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

        signUpHelper.clickEmailMatching1();
        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("FMnew124o@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "1978");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("19");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.clickSearchFMMatching();
        verificationHelper.verifySearchFMPage();
        //verificationHelper.verifyAddListingPage();

        getAddPropertyHelper().openDropDownMenu();
        verificationHelper.checkMatchingConcurrence("100% complete");
        authorizationHelper.chooseProfileFromDropDownMenu();
       // matchingHelper.closePopup();
        signUpHelper.verificationDataProfileNameUser("Ronald", "40");
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("70% complete");
        authorizationHelper.chooseProfileFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();

        authorizationHelper.removeAccount();

        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }


    @Test (priority = 5)
    public void SignUpWithMatchingWithBlankRequiredFields() {
        //newDriverPage();
        clearCache();
        matchingHelper.clickHomePageMatching();

        matchingHelper.enterFirstName("Donald");
        //matchingHelper.clickARoom();

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
