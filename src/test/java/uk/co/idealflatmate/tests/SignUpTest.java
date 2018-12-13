package uk.co.idealflatmate.tests;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class SignUpTest extends TestBase {

    @Test (priority = 1)
    public void SignUpBlankFieldsPropAddRentBlock() {

        paymentsHelper.addPropertyHelper.pressAddListingNotLoggedBlock();
        addPropertyHelper.selectTypeUser( "A current tenant");

        signUpHelper.clickEmailHeader();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailBlankAlertMessageLike();
        verificationHelper.nameFirstBlankAlert();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");


    }

    @Test (priority = 1)
    public void SignUpBlankFieldsPropAddWorkBlock() {

        paymentsHelper.addPropertyHelper.pressAddListingNotLoggedBlock1();
        addPropertyHelper.selectTypeUser( "A current tenant");

        signUpHelper.clickEmailHeader();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailBlankAlertMessageLike();
        verificationHelper.nameFirstBlankAlert();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");


    }

    @Test (priority = 1)
    public void headerRoomSignUpHomePageTenant() {
        clearCache();
        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickRoom();

        signUpHelper.backFromEmailToRoom();

        signUpHelper.clickEmailHeader();

        signUpHelper.setSignUpNameF("Ronaldina");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("Tenant53@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profilePhotoAddPng();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profilePhotoAddJpg();
        signUpHelper.profilePhotoRemove();

        //signUpHelper.profilePhotoAddJpeg10Mb();
        //verificationHelper.profilePhoto10Mb();
        //signUpHelper.profilePhotoAddPdf();
        //verificationHelper.profilePhotoPdf();

        signUpHelper.profileDateBirthAdd("2", "5", "2000");

        verificationHelper.phoneVerification("55555555d", "Phone number is incorrect.");
        signUpHelper.profilePhone("5555555555");

        signUpHelper.occupation("19");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.backLocation();
        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.preferredLocation("Watf", "Watford");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.budgetMin();
        signUpHelper.budgetMax();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.toMoveCheckboxEnabled();
        signUpHelper.selectMoveDate("8", "8", "2019");
        signUpHelper.selectHappyReceiveNews();
        signUpHelper.clickYourInformationContinue();

        authorizationHelper.clickCloseSignUp();

        verificationHelper.verifySearchListingPage();
        verificationHelper.verificationUserNameOnHomePage("Ronaldina");

        getAddPropertyHelper().openDropDownMenu();
       // verificationHelper.verifyProfComplMenu("80% complete");
        authorizationHelper.chooseProfileFromDropDownMenu();
        verificationHelper.verificationDataTenant();


        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test (priority = 2)
    public void headerSignUpHomePageFMSearchLiv_inWithoutAbout() {
        //newDriverPage();
        clearCache();

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();

        addPropertyHelper.selectTypeUser("Live-in landlord");

        signUpHelper.clickEmailHeader();

        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderMaleSelect();
        signUpHelper.setSignEmail("Live_inNew33430@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("5", "2", "1959");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("39");
        //signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verifyAddListingPage();
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseProfileFromDropDownMenu();
        verificationHelper.verificationDataLive_in();

        matchingHelper.closePopup();

        //signUpHelper.verificationDataProfileNameUser("live-in landlord");

        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("60% complete");
        authorizationHelper.chooseProfileFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test (priority = 3)
    public void headerSignUpWithExistingEmail() {
        //newDriverPage();
        clearCache();

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();

        addPropertyHelper.selectTypeUser("Live-out landlord");

        signUpHelper.clickEmailHeader();
        signUpHelper.setSignUpNameF("Ronald");

        verificationHelper.verificationFieldLenth(460);

        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("Live_Out_new777@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailAlreadyExistedAlert();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");
     }

    @Test (priority = 4)
    public void headerSignUpWithBlankRequiredFieldsYourInf() {
        //newDriverPage();
        clearCache();
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("A current tenant");

        signUpHelper.clickEmailHeader();
        signUpHelper.clickYourInformationContinue();

        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlert();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }
    @Test (priority = 5)
    public void headerSignUpWithBlankRequiredFieldsMoreAboutYou() {
        //newDriverPage();
        clearCache();
        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickFM();

        addPropertyHelper.selectTypeUser("A current tenant");

        signUpHelper.clickEmailHeader();
        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("FMnew233@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.dateMonthYearPhoneOccupationBlankError();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test (priority = 2)
    public void headerSignUpWithBlankRequiredFieldsLocation() {
        //newDriverPage();
        clearCache();
        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickRoom();

        signUpHelper.backFromEmailToRoom();
        signUpHelper.clickEmailHeader();

        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("FMnew33674@gmail.com");
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
        signUpHelper.clickYourInformationContinue();
        verificationHelper.checkLocationBlank();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test (priority = 2)
    public void headerSignUpWithBlankRequiredFieldsBudget() {
        //newDriverPage();
        clearCache();
        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickRoom();

        signUpHelper.backFromEmailToRoom();
        signUpHelper.clickEmailHeader();

        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("FMnew3399@gmail.com");
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
        signUpHelper.preferredLocation("Watf", "Watford");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.budgetError();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test (priority = 2)
    //Facebook authorization doen`t work on staging

    public void headerSignUpViaFacebook() {
        open("https://www.idealflatmate.co.uk/");
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom();
        authorizationHelper.clickSignUpWithFacebook();
        //authorizationHelper.LoginFacebookWithNewAccount("ron1991d@gmail.com", "qqqqqq666D");
        authorizationHelper.LoginFacebookWithNewAccount("proideal@ukr.net", "qqqqqq666D");


        signUpHelper.genderMaleSelect();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.profileDateBirthAdd("5", "2", "1959");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("20");
        //signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.preferredLocation("Watf","Watford");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.budgetMin();
        signUpHelper.budgetMax();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verificationUserNameOnHomePage("RonaldRetreive");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseProfileFromDropDownMenu();
        //matchingHelper.closePopup();
        verificationHelper.verificationDataProfileFB();
        signUpHelper.verificationDataProfileFotoDashboard();


        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseProfileFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        //verificationHelper.verifyProfComplMenu("60% complete");
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("RonaldRetreive");
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
        verificationHelper.verificationUserIsUnlogged("Join Free");
        newDriverPage();
    }







    //@Test
    public void SuccessfulSignUpWithListingWithAllFields() {
        verificationHelper.closeAdvPopUp();
        verificationHelper.ageConfirmCheckMatching();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseProfileFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test (priority = 2)
    public void ListingSignUpHeader() {
        //newDriverPage();
        clearCache();
        addPropertyHelper.bottomAddListing();
        addPropertyHelper.selectTypeUser("Live-out landlord");

        signUpHelper.clickEmailHeader();
        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.setSignEmail("LiveOut111r21@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhone("5555555555");
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verifyAddListingPage();
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseProfileFromDropDownMenu();
        verificationHelper.verificationDataProfileLiveOut();


        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("50% complete");
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();

        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test (priority = 2)
    public void ListingSignUpFromHomepage() {
        //newDriverPage();
        clearCache();
        addPropertyHelper.pressAddListingNotLogged();
        addPropertyHelper.selectTypeUser("Live-in landlord"); //LiveInLord

        signUpHelper.clickEmailHeader();
        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("LiveInNewo141a2@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("227");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        verificationHelper.verifyAddListingPage();

        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("80% complete");
        authorizationHelper.chooseProfileFromDropDownMenu();
        matchingHelper.closePopup();
        verificationHelper.verificationDataLive_in1();

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();

        verificationHelper.verificationUserIsUnlogged("Join Free");
    }


}
