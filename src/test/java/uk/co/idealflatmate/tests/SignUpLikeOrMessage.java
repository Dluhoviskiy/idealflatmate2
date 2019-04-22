package uk.co.idealflatmate.tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static uk.co.idealflatmate.appmanager.HelperBase.cardsOnThePage;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
import static uk.co.idealflatmate.appmanager.SignUpHelper.userName;


public class SignUpLikeOrMessage extends TestBase {
    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
    }


    @Test
    public void mesPropSignUpHomeStart() {

        homePageHelper.scrollToBlockProperty();

        signUpHelper.click1CardMessage("3");
        signUpHelper.clickEmail();
        signUpHelper.clickYourInformationContinue();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }


    @Test
    public void mesPropSignUpNotBuddy_Up() {
        String name = "Ronald";
        String location = "Leeds";
        String age = "61";

        searchHelper.searchPropertyBySelectfromList(location, location);//input field, name in drop-down
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchPropertyMes("New York Street (stop K11), "+location+" LS2 7DT, UK", 2);

        String photo1 = $$(byXpath("//div[@class='card-top-profile-img u_p5-right']/img")).get(2).getAttribute("src");
        String name1 = $$(byXpath("//span[@class='card-top-username']")).get(2).text();
        String title1 = $(byXpath("//head/title")).text();
        sleep(2000);
        String postCode = $$(byXpath("//div[@class='card-infos-left']/div")).get(2).text();


        signUpHelper.click1PropCardMes(2);
        signUpHelper.nameOfOwnerOnPopup(name1);
        signUpHelper.clickEmail();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlertMessage();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();
        //verificationHelper.passwordBlankAlertMessage();
        verificationHelper.dateMonthYearBlankErrorMessage();


        signUpHelper.setSignUpNameFMessage(name);
        signUpHelper.profileDateBirthAddMessage("5", "2", "1959");
        signUpHelper.setSignEmailMessage("existingEmail");
        signUpHelper.genderFemSelectAfterMesError();
        signUpHelper.setSignPasswordMessage("passwUniv");
        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailAlreadyExistedAlert();

        signUpHelper.clearEmailMessage();
        signUpHelper.clearFirstnameMessage();
        //signUpHelper.clearGender();
        signUpHelper.clearPasswordMessage();

        signUpHelper.setSignUpNameFMessage("Trouble");
        //signUpHelper.profileDateBirthAddMessage("5", "2", "1959");
        signUpHelper.genderFemaleSelectMessage();
        signUpHelper.setSignEmailMessage("mes1Email");
        signUpHelper.setSignPasswordMessage("passwUniv");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.photoOfOwner(photo1);
        signUpHelper.nameOfOwner(name1);
        signUpHelper.verificationAutoMessageProperty(name1);

        String message1 = $("textarea#messagewritesignupform-message").text();


        signUpHelper.clickYourInformationContinue();
        verificationHelper.checkPhoneAlertMessage("Phone cannot be blank.");

        signUpHelper.profilePhoneMessage("5555555555");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.clickBackToSearch();
        signUpHelper.titleOfSearchPage(title1);
        //String userName = $("span.user-welcome--name").text();

        messageHelper.clickMenuMessages();
        messageHelper.nameOfOwnerInMessage(name1, userName());

        messageHelper.clickMessage1Inbox();
        messageHelper.photoOfOwnerInMessage(photo1);
        messageHelper.messageVerifying(message1);
        messageHelper.propertyPostcodeVerifMes(postCode);

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        verificationHelper.profileDisplays("50%\n" + "complete",
                                            "User Type\n" + "Personal Details\n" +
                                            "Property Preferences\n" + "Budget & Availability\n" +
                                            "Your ideal flatmate",
                                            name, age, "I'm looking for a room",
                                            "About me\n" + "Tell us about yourself\n" +
                                            "Maximum budget: £1250/month\n" + "Ready to move in: Immediately\n" +
                                            "Looking for a room in\n" + location,
                                            "no rooms", 0);
        verificationHelper.verificationUserNameOnHomePage(name);

        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("50% complete");
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();

        verificationHelper.verificationUserIsUnlogged("Join Free");

    }


    @Test
    public void signUpLike3rdPageQuit() {


        authorizationHelper.goToPropertyPage();
        authorizationHelper.clickCloseSignUp();

        searchHelper.moveToPage(2, "2");
        cardsOnThePage().shouldHaveSize(11);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.moveToPage(3, "3");

        String page = $(byXpath("//a[@class='undefined']")).getText();

        signUpHelper.clickLikePropertyCard();
        signUpHelper.clickEmail();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailBlankAlert();


        signUpHelper.quit();
        verificationHelper.PropertyPageNumber(page);
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test
    public void signUpLikeHomePage() {
        String name = "Ronald";
        String location = "Leeds";
        String age = "18";
        String about = "Tell us about yourself";

        homePageHelper.scrollToBlockProperty();
        sleep(2000);
        String referNumber = $$(byXpath("//div[@class='u_p0-left text-13']")).get(2).getText();
        signUpHelper.clickLikePropertyCardHomePage(2);


        signUpHelper.clickEmail();

        signUpHelper.setSignUpNameF(name);
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("mes2Email");
        signUpHelper.setSignPassword("passwUniv");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("19", "Professional", "Student");
        signUpHelper.aboutYourself(about);
        signUpHelper.clickYourInformationContinue();

        signUpHelper.backToSearch();

        //signUpHelper.clickShowMeMyMatches();
        getAddPropertyHelper().openDropDownMenu();
        verificationHelper.verificationUserNameOnHomePage(name);

        authorizationHelper.savedPropertiesMenuGo();
        verificationHelper.savedProperties(referNumber);
        signUpHelper.removeLike();
        verificationHelper.cardIsUnliked();


        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("70% complete");
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        verificationHelper.profileDisplays("70%\n" + "complete",
                                            "User Type\n" + "Personal Details\n" +
                                            "Property Preferences\n" + "Budget & Availability\n" +
                                            "Your ideal flatmate",
                                            name, age, "I'm looking for a room",
                                            "About me\n" + about+"\n" +
                                                    "Maximum budget: £2500/month\n" +
                                                    "Ready to move in: Immediately",
                                            "no rooms", 0);
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        sleep(5000);

        verificationHelper.verificationUserIsUnlogged("Join Free");
        verificationHelper.isHomePage1();

    }
    @Test
    public void popupPropertyPage() {
        String name = "Ronald";
        String location = "Watford";
        String age = "18";
        String about = "Tell us about yourself";

        authorizationHelper.goToPropertyPage();

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", name, "mes3Email");

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("19", "Professional", "Student");
        signUpHelper.aboutYourself(about);
        signUpHelper.clickYourInformationContinue();

        signUpHelper.backClick();
        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.preferredLocation("Watf", location);
        signUpHelper.clickYourInformationContinue();

        signUpHelper.budgetMin();
        signUpHelper.clickYourInformationContinue();
        verificationHelper.budgetError();
        signUpHelper.budgetMax();

        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.toMoveCheckboxEnabled();
        signUpHelper.selectMoveDate("8", "8", "2019");
        signUpHelper.selectHappyReceiveNews();
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verifySearchListingPage();
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        verificationHelper.profileDisplays("80%\n" + "complete",
                                            "User Type\n" + "Personal Details\n" +
                                            "Property Preferences\n" + "Budget & Availability\n" +
                                            "Your ideal flatmate",
                                            name, age, "I'm looking for a room",
                                            "About me\n" + "Tell us about yourself\n" +
                                                    "Maximum budget: £1250/month\n" + "Ready to move in: 08-08-2019\n" +
                                                    "Looking for a room in\n"+ location,
                                            "no rooms", 0);
        verificationHelper.verificationUserNameOnHomePage(name);

        authorizationHelper.removeAnyAccount();
    }

    @Test
    public void popupWithExistingEmail() {

        authorizationHelper.goToFMpage();

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Ronald", "existingEmail");

        verificationHelper.emailAlreadyExistedAlert();

        signUpHelper.quit();
        verificationHelper.isFMPage();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }


    @Test
    public void popupExistingEmailPropertyPage() {

        authorizationHelper.FindHomeInMenu();
        authorizationHelper.clickCloseSignUp();

        searchHelper.searchPropertyByEnter("Catford");
        signUpHelper.clickPropertyCard1(2);
        String title = $(byXpath("//h1")).getText();
        //System.out.println(title);

        signUpHelper.clickMessageProperty("Request details");
        signUpHelper.clickEmail();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlertMessage();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();
        //verificationHelper.passwordBlankAlertMessage();
        verificationHelper.dateMonthYearBlankErrorMessage();

        signUpHelper.quit();
        verificationHelper.isPropertyPageLocation(title);
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test
    public void popupWithBlankRequiredFields() {

        authorizationHelper.goToFMpage();

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Ronald", "existingEmail");

        verificationHelper.emailAlreadyExistedAlert();

        signUpHelper.clearEmail();
        signUpHelper.clearFirstname();
        //signUpHelper.clearGender();
        signUpHelper.clearPassword();
        signUpHelper.clickYourInformationContinue();


        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlert();
        //verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();

        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderMaleSelectAfterBlank();
        signUpHelper.setSignEmail("mes4Email");
        signUpHelper.setSignPassword("passwUniv");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.dateMonthYearPhoneOccupationBlankError();
        signUpHelper.backClick();
        signUpHelper.clickYourInformationContinue();

        signUpHelper.profileDateBirthAdd("5", "2", "1959");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("20", "Professional", "Freelancer/self employed");
        //signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.checkLocationBlank();

        signUpHelper.preferredLocation("Watf", "Watford");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.budgetError();

        signUpHelper.budgetMin();
        signUpHelper.budgetMax();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.toMoveCheckboxEnabled();

        signUpHelper.quit();
        verificationHelper.toHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test
    public void popupExistingEmailPropertyPhone() {

        authorizationHelper.FindHomeInMenu();
        authorizationHelper.clickCloseSignUp();
        searchHelper.moveToPage(3, "3");
        signUpHelper.clickPropertyCard1(2);
        String searchLocation = $(byXpath("//h1")).getText();
        //System.out.println(title);

        messageHelper.clickPhoneReveal();
        signUpHelper.clickEmailPopup();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlertPhone();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();
        verificationHelper.dateMonthYearPhoneBlankErrorPhone();

        signUpHelper.quit();
        verificationHelper.isPropertyPageLocation(searchLocation);
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }
}
