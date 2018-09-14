package uk.co.idealflatmate.tests;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SignUpTest extends TestBase {

    @Test (priority = 1)
    public void headerRoomSignUpHomePage() {
        newDriverPage();
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom();
        signUpHelper.backFromEmailToRoom();
        signUpHelper.clickEmailHeader();
        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("FMnew314@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.profilePhotoAdd();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilephone("5555555555");
        signUpHelper.occupation("19");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.backLocation();
        signUpHelper.profilePhotoAdd();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.preferredLocation("Watf", "Hackney");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.budget();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.toMoveCheckboxEnabled();
        signUpHelper.selectMoveDate("8", "8", "2019");
        signUpHelper.selectHappyReceiveNews();
        signUpHelper.clickYourInformationContinue();
        verificationHelper.verifySearchListingPage();
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        signUpHelper.verificationDataProfileFull();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }

    @Test (priority = 2)
    public void headerFMSignUpHomePage() {
        newDriverPage();
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("2");
        addPropertyHelper.pressContinue();
        signUpHelper.clickEmailHeader();
        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("FMnew330@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.profilePhotoAdd();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("5", "2", "1959");
        signUpHelper.profilephone("5555555555");
        signUpHelper.occupation("20");
        //signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();
        verificationHelper.verifyAddListingPage();
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        matchingHelper.closePopup();
        signUpHelper.verificationDataProfileRole("live-in landlord");
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }

    @Test (priority = 3)
    public void headerSignUpWithExistingEmail() {
        newDriverPage();
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("2");
        addPropertyHelper.pressContinue();
        signUpHelper.clickEmailHeader();
        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("FMnew777@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailAlreadyExistedAlert();
     }

    @Test (priority = 4)
    public void headerSignUpWithBlankRequiredFieldsYourInf() {
        newDriverPage();
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("2");
        addPropertyHelper.pressContinue();
        signUpHelper.clickEmailHeader();
        signUpHelper.clickYourInformationContinue();

        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlert();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();

    }
    @Test (priority = 5)
    public void headerSignUpWithBlankRequiredFieldsMoreAboutYou() {
        newDriverPage();
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("2");
        addPropertyHelper.pressContinue();
        signUpHelper.clickEmailHeader();
        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("FMnew233@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.clickYourInformationContinue();
        verificationHelper.dateMonthYearPhoneOccupationBlankError();
    }
    @Test (priority = 2)
    public void headerSignUpWithBlankRequiredFieldsLocation() {
        newDriverPage();
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom();
        signUpHelper.backFromEmailToRoom();
        signUpHelper.clickEmailHeader();
        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("FMnew33674@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.profilePhotoAdd();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilephone("5555555555");
        signUpHelper.occupation("19");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.backLocation();
        signUpHelper.profilePhotoAdd();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.clickYourInformationContinue();
        verificationHelper.checkLocationBlank();
    }

    @Test (priority = 2)
    public void headerSignUpWithBlankRequiredFieldsBudget() {
        newDriverPage();
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom();
        signUpHelper.backFromEmailToRoom();
        signUpHelper.clickEmailHeader();
        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("FMnew3399@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.profilePhotoAdd();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilephone("5555555555");
        signUpHelper.occupation("19");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.backLocation();
        signUpHelper.profilePhotoAdd();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.preferredLocation("Watf", "Hackney");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.clickYourInformationContinue();
        verificationHelper.budgetError();
        signUpHelper.quit();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }

    @Test (priority = 2)
    //Facebook authorization doen`t work on staging

    public void headerSignUpViaFacebook() {
        open("https://www.idealflatmate.co.uk/");
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom();
        authorizationHelper.clickSignUpWithFacebook();
        authorizationHelper.LoginFacebookWithNewAccount("ron1991d@gmail.com", "qqqqqq666D");

        signUpHelper.genderMaleSelect();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.profileDateBirthAdd("5", "2", "1959");
        signUpHelper.profilephone("5555555555");
        signUpHelper.occupation("20");
        //signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.preferredLocation("Watf", "Hackney");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.budget();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verificationUserNameOnHomePage("RonaldRetreive");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        //matchingHelper.closePopup();
        signUpHelper.verificationDataProfile();
        signUpHelper.verificationDataProfileFotoDashboard();


        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserNoNameOnHomePage("RonaldRetreive");
        newDriverPage();
    }

    @Test (priority = 2)
    //Facebook authorization doen`t work on staging

    public void SignUpViaFacebookAgeUnder18() {
        open("https://www.idealflatmate.co.uk/");open("https://www.idealflatmate.co.uk/");
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom();
        authorizationHelper.clickSignUpWithFacebook();
        authorizationHelper.LoginFacebookWithNewAccount("ron666ddd@gmail.com", "qqqqqq666D");
        //verificationHelper.verificationUserNameOnHomePage("Ronald");
        authorizationHelper.acceptFBageRestriction();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
        newDriverPage();
    }


   // @Test (priority = 1)
    public void SuccessfulClassicSignUpPropertyPage() {
        newDriverPage();
        authorizationHelper.goToPropertyPage();


    }

 //   @Test (priority = 1)
    public void SuccessfulClassicSignUpFMPage() {
        newDriverPage();
        authorizationHelper.goToFMpage();

    }

    @Test (priority = 2)

    public void signUpMatchingWithBlankFirstName() {

        matchingHelper.clickHomePageMatching();
        matchingHelper.verifBlankName();
    }

    @Test (priority = 2)
    public void SignUpMatchingWithRequiredFieldsRoom() {
        newDriverPage();
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
        signUpHelper.setSignEmail("FMnew310@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.profilePhotoAdd();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilephone("5555555555");
        signUpHelper.occupation("19");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.backLocation();
        signUpHelper.profilePhotoAdd();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.preferredLocation("Watf", "Hackney");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.budget();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.toMoveCheckboxEnabled();
        signUpHelper.selectMoveDate("8", "8", "2019");
        signUpHelper.selectHappyReceiveNews();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.clickShowMeMyMatches();
        verificationHelper.verifySearchListingPage();
        getAddPropertyHelper().openDropDownMenu();
        matchingHelper.veryfyScoresInDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        signUpHelper.verificationDataProfileFull();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }

    @Test (priority = 2)
    public void SignUpMatchingWithRequiredFieldsFMRoom() {
        newDriverPage();
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
        signUpHelper.setSignEmail("FMnew309@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.profilePhotoAdd();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "1978");
        signUpHelper.profilephone("5555555555");
        signUpHelper.occupation("19");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.clickListYourRoomMatching();

        verificationHelper.verifyAddListingPage();
        getAddPropertyHelper().openDropDownMenu();
        matchingHelper.veryfyScoresInDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
       // matchingHelper.closePopup();
        signUpHelper.verificationDataProfileRole("flatmate");
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }

    @Test (priority = 2)
    public void SignUpMatchingWithRequiredFieldsFMRoomSearchFM() {
        newDriverPage();
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
        signUpHelper.setSignEmail("FMnew309@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.profilePhotoAdd();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "1978");
        signUpHelper.profilephone("5555555555");
        signUpHelper.occupation("19");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.clickSearchFMMatching();
        verificationHelper.verifySearchFMPage();
        //verificationHelper.verifyAddListingPage();
        getAddPropertyHelper().openDropDownMenu();
        matchingHelper.veryfyScoresInDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
       // matchingHelper.closePopup();
        signUpHelper.verificationDataProfileRole("flatmate");
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }


    @Test (priority = 1)
    public void SignUpWithMatchingWithBlankRequiredFields() {
        newDriverPage();
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
    }


    @Test (priority = 2)
    public void popupRoomSignUpHomePage() {
        newDriverPage();
        authorizationHelper.goToPropertyPage();
        signUpHelper.clickEmailHeader();
        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("FMnew314@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.profilePhotoAdd();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilephone("5555555555");
        signUpHelper.occupation("19");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.backLocation();
        signUpHelper.profilePhotoAdd();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.preferredLocation("Watf", "Hackney");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.budget();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.toMoveCheckboxEnabled();
        signUpHelper.selectMoveDate("8", "8", "2019");
        signUpHelper.selectHappyReceiveNews();
        signUpHelper.clickYourInformationContinue();
        verificationHelper.verifySearchListingPage();
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        signUpHelper.verificationDataProfileFull();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }


    @Test (priority = 3)
    public void popupSignUpWithExistingEmail() {
        newDriverPage();
        authorizationHelper.goToFMpage();
        signUpHelper.clickEmailHeader();
        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("FMnew777@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailAlreadyExistedAlert();
    }

    @Test (priority = 4)
    public void popupSignUpWithBlankRequiredFields() {
        newDriverPage();
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom();



        signUpHelper.clickEmailHeader();
        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("FMnew777@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailAlreadyExistedAlert();

        signUpHelper.clearEmail();
        signUpHelper.clearFirstname();
        //signUpHelper.clearGender();
        signUpHelper.clearPassword();
        signUpHelper.clickYourInformationContinue();


        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlert();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();

        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderMaleSelectAfterBlank();
        signUpHelper.setSignEmail("FMnew33096@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.dateMonthYearPhoneOccupationBlankError();

        signUpHelper.profileDateBirthAdd("5", "2", "1959");
        signUpHelper.profilephone("5555555555");
        signUpHelper.occupation("20");
        //signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.checkLocationBlank();

        signUpHelper.clickYourInformationContinue();
        signUpHelper.preferredLocation("Watf", "Hackney");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.budgetError();

        signUpHelper.budget();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.toMoveCheckboxEnabled();
        signUpHelper.quit();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");

    }

    //@Test
    public void SuccessfulSignUpWithListingWithAllFields() {
        verificationHelper.closeAdvPopUp();
        verificationHelper.ageConfirmCheckMatching();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }



    /*
    @Test
    public void InvalidSignInWithEmptyFields() {
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickLoginSubmitButton();
        verificationHelper.VerificationLoginError();
        verificationHelper.VerificationPasswordError();
        verificationHelper.VerificationMessagesTabIsAbsent();
    }
     */

}
