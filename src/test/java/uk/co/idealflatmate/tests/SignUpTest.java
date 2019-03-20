package uk.co.idealflatmate.tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.HelperBase;

//import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifStageGoLive;


public class SignUpTest extends TestBase {
    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
    }

    @Test
    public void testSignUpBlankFieldsPropAddRentBlock() {
        pageUrlVerifLiveGoStage();
        clearCache();
        addPropertyHelper.pressAddListingNotLoggedBlock();
        addPropertyHelper.selectTypeUser( "A current tenant");

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

    @Test
    public void testSignUpBlankFieldsPropAddWorkBlock() {
        pageUrlVerifLiveGoStage();
        clearCache();
        addPropertyHelper.pressAddListingNotLoggedBlock1();
        addPropertyHelper.selectTypeUser( "A current tenant");

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

    @Test
    public void testHeaderRoomSignUpHomePageTenant() {
        pageUrlVerifLiveGoStage();
        clearCache();

        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickRoom();

        signUpHelper.backFromEmailToRoom();

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Ronaldina", "Tenant1");

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

        signUpHelper.occupation("19", "Professional", "Student");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.backClick();
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
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        verificationHelper.verificationDataTenant1("80%");

        authorizationHelper.removeAnyAccount();
    }

    @Test
    public void testHeaderSignUpHomePageFMSearchLiv_inWithoutAbout() {
        pageUrlVerifLiveGoStage();
        clearCache();

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("Live-in landlord");

        signUpHelper.signListingFM_LiveIn("LiveIn2", "passwUniv",
                                        "5", "5", "1959", "55555555", "39", "Ronald");

        verificationHelper.verifyAddListingPage();
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        verificationHelper.verificationDataLive_in("60%");

        matchingHelper.closePopupMatching();

        //signUpHelper.verificationDataProfileNameUser("live-in landlord");

        authorizationHelper.removeAnyAccount();
    }



    @Test
    public void testHeaderSignUpWithExistingEmail() {
        pageUrlVerifLiveGoStage();
        clearCache();

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();

        addPropertyHelper.selectTypeUser("Live-out landlord");

        signUpHelper.clickEmail();
        signUpHelper.setSignUpNameF("Ronald");

        verificationHelper.verificationFieldLenth(460);

        //signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("agency3");
        signUpHelper.setSignPassword("passwUniv");
        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailAlreadyExistedAlert();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");
     }

    @Test
    public void testHeaderSignUpWithBlankRequiredFieldsYourInf() {
        pageUrlVerifLiveGoStage();
        clearCache();
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
    @Test
    public void testHeaderSignUpWithBlankRequiredFieldsMoreAboutYou() {

        pageUrlVerifLiveGoStage();
        clearCache();
        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickFM();

        addPropertyHelper.selectTypeUser("A current tenant");

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMnew1");

        signUpHelper.clickYourInformationContinue();
        verificationHelper.dateMonthYearPhoneOccupationBlankError();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test
    public void testHeaderSignUpWithBlankRequiredFieldsLocation() {
        //helperBase.closeOpen("http://front.idealflatmate4test.demo.devplatform2.com/");
        pageUrlVerifLiveGoStage();
        clearCache();
        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickRoom();

        signUpHelper.backFromEmailToRoom();
        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMnew2");

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("19", "Professional", "Student");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.backClick();
        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.clickYourInformationContinue();
        verificationHelper.checkLocationBlank();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test
    public void testHeaderSignUpWithBlankRequiredFieldsBudget() {
        pageUrlVerifLiveGoStage();
        clearCache();

        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickRoom();

        signUpHelper.backFromEmailToRoom();
        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMnew3");

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("19", "Professional", "Student");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.backClick();
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



    @Test
    //Facebook authorization doen`t work on staging

    public void testHeaderSignUpViaFacebook() {

        pageUrlVerifStageGoLive();
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom();
        authorizationHelper.clickSignUpWithFacebook();
        //authorizationHelper.LoginFacebookWithNewAccount("ron1991d@gmail.com", "qqqqqq666D");
        authorizationHelper.LoginFacebookWithNewAccount("FB2", "passwFB2");

        //signUpHelper.genderMaleSelect();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.profileDateBirthAdd("5", "2", "1959");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("20", "Professional", "Freelancer/self employed");
        //signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.preferredLocationButton("Zone 1");
        signUpHelper.preferredLocation("Watf","Watford");
        signUpHelper.preferredLocationButton("North London");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.budgetMin();
        signUpHelper.budgetMax();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verificationUserNameOnHomePage("Francine");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        //matchingHelper.closePopupMatching();
        verificationHelper.verificationDataProfileFB("70%", "Francine");
        signUpHelper.verificationDataProfileFotoDashboard();


        authorizationHelper.removeAnyAccount();

    }

    @Test
    //Facebook authorization doen`t work on staging

    public void testSignUpViaFBlistingAgent() {

        pageUrlVerifStageGoLive();
        addPropertyHelper.pressAddListingFromHeaderNotLoggedUser();
        addPropertyHelper.selectTypeUser( "An agency");

        authorizationHelper.clickSignUpWithFB_ListFlow();


        authorizationHelper.LoginFacebookWithNewAccount("FB3", "passwFB2");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.aboutAgency("I am an agent", "About your agency");
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verificationUserNameOnHomePage("Kron");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        //matchingHelper.closePopupMatching();
        verificationHelper.verifDataProfFBAgent("75%", "I am an agent");
        signUpHelper.verificationDataProfileFotoDashboard();


        authorizationHelper.removeAnyAccount();
    }

    //@Test
    public void SuccessfulSignUpWithListingWithAllFields() {
        HelperBase.closeAdvPopUp();
        verificationHelper.ageConfirmCheckMatching();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test
    public void testListingSignUpHeader() {

        //helperBase.closeOpen("http://front.idealflatmate4test.demo.devplatform2.com/");
        addPropertyHelper.bottomAddListing();
        addPropertyHelper.selectTypeUser("Live-out landlord");

        signUpHelper.clickEmail();
        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.setSignEmail("LiveOut2");
        signUpHelper.setSignPassword("passwUniv");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhone("5555555555");
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verifyAddListingPage();
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        verificationHelper.verificationDataProfileLiveOut("50%");


        authorizationHelper.removeAnyAccount();
    }

    @Test
    public void testListingSignUpFromHomepage() {

        addPropertyHelper.pressAddListingNotLogged();
        addPropertyHelper.selectTypeUser("Live-in landlord"); //LiveInLord

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Ronald", "liveIn1");

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("227", "Professional", "Other");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        verificationHelper.verifyAddListingPage();

        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("80% complete");
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        matchingHelper.closePopupMatching();
        verificationHelper.verificationDataLive_in1("80%");

        authorizationHelper.removeAnyAccount();
    }


}
