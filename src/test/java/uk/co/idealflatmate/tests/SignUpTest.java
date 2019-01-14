package uk.co.idealflatmate.tests;
import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.HelperBase;

import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifStageGoLive;


public class SignUpTest extends TestBase {

    //@Test
    public void SignUpBlankFieldsPropAddRentBlock() {
        pageUrlVerifLiveGoStage();
        paymentsHelper.addPropertyHelper.pressAddListingNotLoggedBlock();
        addPropertyHelper.selectTypeUser( "A current tenant");

        signUpHelper.clickEmail();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailBlankAlertMessageLike();
        verificationHelper.nameFirstBlankAlert();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");


    }

   // @Test
    public void SignUpBlankFieldsPropAddWorkBlock() {
        //helperBase.closeOpen("http://front.idealflatmate4test.demo.devplatform2.com/");
        pageUrlVerifLiveGoStage();
        paymentsHelper.addPropertyHelper.pressAddListingNotLoggedBlock1();
        addPropertyHelper.selectTypeUser( "A current tenant");

        signUpHelper.clickEmail();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailBlankAlertMessageLike();
        verificationHelper.nameFirstBlankAlert();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");


    }

   // @Test
    public void headerRoomSignUpHomePageTenant() {

        pageUrlVerifLiveGoStage();

        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickRoom();

        signUpHelper.backFromEmailToRoom();

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("qqqqqq", "Ronaldina", "Tenant53@gmail.com");

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
        verificationHelper.verificationDataTenant1("80%");


        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

   // @Test
    public void headerSignUpHomePageFMSearchLiv_inWithoutAbout() {
        //helperBase.closeOpen("http://front.idealflatmate4test.demo.devplatform2.com/");
        pageUrlVerifLiveGoStage();

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();

        addPropertyHelper.selectTypeUser("Live-in landlord");

        signUpHelper.clickEmail();

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
        verificationHelper.verificationDataLive_in("60%");

        matchingHelper.closePopupMatching();

        //signUpHelper.verificationDataProfileNameUser("live-in landlord");

        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("60% complete");
        authorizationHelper.chooseProfileFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

   // @Test
    public void headerSignUpWithExistingEmail() {
        //helperBase.closeOpen("http://front.idealflatmate4test.demo.devplatform2.com/");
        pageUrlVerifLiveGoStage();
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();

        addPropertyHelper.selectTypeUser("Live-out landlord");

        signUpHelper.clickEmail();
        signUpHelper.setSignUpNameF("Ronald");

        verificationHelper.verificationFieldLenth(460);

        //signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("cro30456yyy@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailAlreadyExistedAlert();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");
     }

    //@Test
    public void headerSignUpWithBlankRequiredFieldsYourInf() {
        //helperBase.closeOpen("http://front.idealflatmate4test.demo.devplatform2.com/");
        pageUrlVerifLiveGoStage();
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("A current tenant");

        signUpHelper.clickEmail();
        signUpHelper.clickYourInformationContinue();

        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlert();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }
    //@Test
    public void headerSignUpWithBlankRequiredFieldsMoreAboutYou() {
        //helperBase.closeOpen("http://front.idealflatmate4test.demo.devplatform2.com/");
        pageUrlVerifLiveGoStage();
        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickFM();

        addPropertyHelper.selectTypeUser("A current tenant");

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("qqqqqq", "Ronald", "FMnew233@gmail.com");

        signUpHelper.clickYourInformationContinue();
        verificationHelper.dateMonthYearPhoneOccupationBlankError();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    //@Test
    public void headerSignUpWithBlankRequiredFieldsLocation() {
        //helperBase.closeOpen("http://front.idealflatmate4test.demo.devplatform2.com/");
        pageUrlVerifLiveGoStage();
        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickRoom();

        signUpHelper.backFromEmailToRoom();
        signUpHelper.clickEmail();

        signUpHelper.yourInformation("qqqqqq", "Ronald", "FMnew33674@gmail.com");

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

   // @Test
    public void headerSignUpWithBlankRequiredFieldsBudget() {
        //helperBase.closeOpen("http://front.idealflatmate4test.demo.devplatform2.com/");
        pageUrlVerifLiveGoStage();
        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickRoom();

        signUpHelper.backFromEmailToRoom();
        signUpHelper.clickEmail();

        signUpHelper.yourInformation("qqqqqq", "Ronald", "FMnew3399@gmail.com");

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



   // @Test
    //Facebook authorization doen`t work on staging

    public void headerSignUpViaFacebook() {
        pageUrlVerifStageGoLive();
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom();
        authorizationHelper.clickSignUpWithFacebook();
        //authorizationHelper.LoginFacebookWithNewAccount("ron1991d@gmail.com", "qqqqqq666D");
        authorizationHelper.LoginFacebookWithNewAccount("proideal@ukr.net", "qqqqqq666D");

        //signUpHelper.genderMaleSelect();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.profileDateBirthAdd("5", "2", "1959");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("20");
        //signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.preferredLocation("Watf","Watford");
        signUpHelper.preferredLocationButton("North London");
        signUpHelper.preferredLocationButton("Zone 1");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.budgetMin();
        signUpHelper.budgetMax();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verificationUserNameOnHomePage("Francine");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseProfileFromDropDownMenu();
        //matchingHelper.closePopupMatching();
        verificationHelper.verificationDataProfileFB("70%", "Francine");
        signUpHelper.verificationDataProfileFotoDashboard();


        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseProfileFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();

        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

   // @Test
    //Facebook authorization doen`t work on staging

    public void SignUpViaFacebookAgeUnder18() {
        pageUrlVerifStageGoLive();
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom();
        authorizationHelper.clickSignUpWithFacebook();
        authorizationHelper.LoginFacebookWithNewAccount("ron666ddd@gmail.com", "qqqqqq666D");
        //verificationHelper.verificationUserNameOnHomePage("Ronald");
        authorizationHelper.acceptFBageRestriction();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }







    //@Test
    public void SuccessfulSignUpWithListingWithAllFields() {
        HelperBase.closeAdvPopUp();
        verificationHelper.ageConfirmCheckMatching();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseProfileFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

   // @Test
    public void ListingSignUpHeader() {
        pageUrlVerifLiveGoStage();
        //helperBase.closeOpen("http://front.idealflatmate4test.demo.devplatform2.com/");
        addPropertyHelper.bottomAddListing();
        addPropertyHelper.selectTypeUser("Live-out landlord");

        signUpHelper.clickEmail();
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
        verificationHelper.verificationDataProfileLiveOut("50%");


        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("50% complete");
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();

        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

  //  @Test
    public void ListingSignUpFromHomepage() {
        //helperBase.closeOpen("http://front.idealflatmate4test.demo.devplatform2.com/");
        pageUrlVerifLiveGoStage();
        addPropertyHelper.pressAddListingNotLogged();
        addPropertyHelper.selectTypeUser("Live-in landlord"); //LiveInLord

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("qqqqqq", "Ronald", "LiveInNewo141a2@gmail.com");

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
        matchingHelper.closePopupMatching();
        verificationHelper.verificationDataLive_in1("80%");

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();

        verificationHelper.verificationUserIsUnlogged("Join Free");
    }


}
