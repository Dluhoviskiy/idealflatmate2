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
        String location1 = "Watford";
        String name = "Ronaldina";
        pageUrlVerifLiveGoStage();
        clearCache();

        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickRoom();

        signUpHelper.backFromEmailToRoom();

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", name, "Tenant1");

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
        signUpHelper.preferredLocation("Watf", location1);
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
        verificationHelper.verificationUserNameOnHomePage(name);

        getAddPropertyHelper().openDropDownMenu();
       // verificationHelper.verifyProfComplMenu("80% complete");
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        verificationHelper.profileDisplays("80%\n" + "complete",
                                            "User Type\n" + "Personal Details\n" +
                                            "Property Preferences\n" + "Budget & Availability\n" +
                                            "Your ideal flatmate",
                                            name, "18",
                                            "I'm looking for a room",
                                            "Tell us about yourself\n" + "Maximum budget: £1250/month\n" +
                                            "Ready to move in: 08-08-2019\n" + "Looking for a room in\n" + location1,
                                            "no rooms", 0);


        authorizationHelper.removeAnyAccount();
    }

    @Test
    public void testHeaderSignUpHomePageFMSearchLiv_inWithoutAbout() {
        String name = "Ronald";
        pageUrlVerifLiveGoStage();
        clearCache();

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("Live-in landlord");

        signUpHelper.signListingFM_LiveIn("LiveIn2", "passwUniv",
                                        "5", "5", "1959", "55555555", "19",
                                        name, "Professional", "Student");

        verificationHelper.verifyAddListingPage();
        verificationHelper.verificationUserNameOnHomePage(name);

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        verificationHelper.profileDisplays("60%\n" + "complete",
                                            "User Type\n" + "Personal Details\n" + "Your ideal flatmate",
                                            name, "59",
                                            "I have a room available",
                                            "Ronald, 59 is a male student looking for a room.",
                                            "no rooms", 0);

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
        String location1 = "Zone 1";
        String location2 = "Watford";
        String location3 = "North London";
        String name = "Francine";
        String age = "60";

        pageUrlVerifStageGoLive();
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom();
        authorizationHelper.clickSignUpWithFacebook();
        //authorizationHelper.LoginFacebookWithNewAccount("ron1991d@gmail.com", "qqqqqq666D");
        authorizationHelper.LoginFacebookWithNewAccount("FB2", "passwFB2");
        signUpHelper.setSignPassword("passwUniv");
        //signUpHelper.genderMaleSelect();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.profileDateBirthAdd("5", "2", "1959");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("20", "Professional", "Freelancer/self employed");
        //signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.preferredLocationButton(location1);
        signUpHelper.preferredLocation("Watf",location2);
        signUpHelper.preferredLocationButton(location3);
        signUpHelper.clickYourInformationContinue();

        signUpHelper.budgetMin();
        signUpHelper.budgetMax();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verificationUserNameOnHomePage(name);
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        //matchingHelper.closePopupMatching();
        verificationHelper.profileDisplays("70%\n" + "complete",
                                            "User Type\n" + "Personal Details\n" +
                                            "Property Preferences\n" + "Budget & Availability\n" +
                                            "Your ideal flatmate",
                                            name, age, "I'm looking for a room",
                                            "About me\n" + name +", "+age+" is a female freelancer/self employed" +
                                                    " looking for a room in "+location1+" or "+location2+" or "+location3+
                                                    ".\n" + "Maximum budget: £1250/month\n" +
                                                    "Ready to move in: Immediately\n" +
                                                    "Looking for a room in\n" + " "+location1+"\n" +" "+location2+"\n" +
                                                    " " + location3,
                                            "no rooms", 0);
        signUpHelper.verificationDataProfileFotoDashboard();


        authorizationHelper.removeAnyAccount();

    }

    @Test
    //Facebook authorization doen`t work on staging

    public void testSignUpViaFBlistingAgent() {
        String name = "Kron";
        pageUrlVerifStageGoLive();
        addPropertyHelper.pressAddListingFromHeaderNotLoggedUser();
        addPropertyHelper.selectTypeUser( "An agency");

        authorizationHelper.clickSignUpWithFB_ListFlow();


        authorizationHelper.LoginFacebookWithNewAccount("FB3", "passwFB2");
        signUpHelper.setSignPassword("passwUniv");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.profilePhone("5555555555");
        signUpHelper.aboutAgency("I am an agent", "About your agency");
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verificationUserNameOnHomePage(name);
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        //matchingHelper.closePopupMatching();
        verificationHelper.profileDisplays("75%\n" + "complete",
                                            "User Type\n" + "Personal Details\n" + "Your ideal tenant",
                                            name, "no age", "Check out our available rooms.",
                                            "About us\n" + "I am an agent",
                                            "no rooms", 0);
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
        String name = "Kron";
        //helperBase.closeOpen("http://front.idealflatmate4test.demo.devplatform2.com/");
        addPropertyHelper.bottomAddListing();
        addPropertyHelper.selectTypeUser("Live-out landlord");

        signUpHelper.clickEmail();
        signUpHelper.setSignUpNameF(name);
        signUpHelper.setSignEmail("LiveOut2");
        signUpHelper.setSignPassword("passwUniv");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhone("5555555555");
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verifyAddListingPage();
        verificationHelper.verificationUserNameOnHomePage(name);

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        verificationHelper.profileDisplays("50%\n" + "complete",
                                            "User Type\n"+"Personal Details\n"+"Your ideal tenant",
                                            name, "no age",
                                            "I have a room available",
                                            "About me\n" +name+" is a live-out landlord looking for a room.",
                                            "no rooms", 0);
        authorizationHelper.removeAnyAccount();
    }

    @Test
    public void testListingSignUpFromHomepage() {
        String name = "Kron";
        String age = "18";

        addPropertyHelper.pressAddListingNotLogged();
        addPropertyHelper.selectTypeUser("Live-in landlord"); //LiveInLord

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", name, "liveIn1");

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("227", "Professional", "Other");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verificationUserNameOnHomePage(name);
        verificationHelper.verifyAddListingPage();

        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("80% complete");
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        matchingHelper.closePopupMatching();
        verificationHelper.profileDisplays("80%\n" + "complete",
                                            "User Type\n" + "Personal Details\n" +"Your ideal flatmate",
                                            name, age,
                                            "I have a room available",
                                            "About me\n" + "Tell us about yourself",
                                            "no rooms", 0);
        authorizationHelper.removeAnyAccount();
    }


}
