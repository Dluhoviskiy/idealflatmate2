package uk.co.idealflatmate.tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.ProfileData;
import uk.co.idealflatmate.appmanager.PropertyData;
import uk.co.idealflatmate.appmanager.SearchHelper;
import utils.ConfDataProperty;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static uk.co.idealflatmate.appmanager.HelperBase.cardsOnThePage;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
import static uk.co.idealflatmate.appmanager.SearchHelper.cardProp_Image;
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
        String name = "Trouble";
        String location = "Leeds";
        String age = "60";
        //String property_id = "18868";

        searchHelper.searchPropertyBySelectfromList(location, location);//input field, name in drop-down
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchPropertyMes("location1", "index1");

        String photo1 = SearchHelper.getPropertyImage("property_id1");
        String name1 = SearchHelper.getPropertyOwner("property_id1");
        String title1 = SearchHelper.getPropertyTitle();
        sleep(2000);
        String postCode = SearchHelper.getPropertyPostCode("property_id1");


        signUpHelper.click1PropCardMes("property_id1");
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
        verificationHelper.profileDisplays(new ProfileData("percentComplete1",  "myProfile1",
                "name1", "age1","lookingFor1", "aboutMe1","rooms1",
                "amountPropCards1"));
        verificationHelper.verificationUserNameOnHomePage(name);

        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("50% complete");
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        authorizationHelper.chooseTabFromInnerMenuDashboard("Settings");
        authorizationHelper.removeAccount();

        verificationHelper.verificationUserIsUnlogged("Join Free");

    }


    @Test
    public void signUpLike3rdPageQuit() {


        authorizationHelper.goToPropertyPage();
        authorizationHelper.clickClosePopupSignUp();

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
        String age = "19";
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

        addPropertyHelper.mySavedPropertiesMenu();
        verificationHelper.savedProperties(referNumber);
        signUpHelper.removeLike();
        verificationHelper.cardIsUnliked();


        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("70% complete");
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        verificationHelper.profileDisplays(new ProfileData("percentComplete2",  "myProfile2",
                        "name2", "age2","lookingFor2", "aboutMe2","rooms2",
                        "amountPropCards2"));
        authorizationHelper.chooseTabFromInnerMenuDashboard("Settings");
        authorizationHelper.removeAccount();
        sleep(5000);

        verificationHelper.verificationUserIsUnlogged("Join Free");
        verificationHelper.isHomePage1();

    }
    @Test
    public void popupPropertyPage() {
        String name = "Ronald";
        String location = "Watford";
        String age = "19";
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
        //signUpHelper.clickYourInformationContinue();
        //verificationHelper.budgetError();
        //signUpHelper.budgetMax();

        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.toMoveCheckboxEnabled();
        signUpHelper.selectMoveDate("8", "8", "2019");
        signUpHelper.selectHappyReceiveNews();
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verifySearchListingPage();
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        verificationHelper.profileDisplays(new ProfileData("percentComplete3",  "myProfile3",
                "name3", "age3","lookingFor3", "aboutMe3","rooms3",
                "amountPropCards3"));
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
        authorizationHelper.clickClosePopupSignUp();

        searchHelper.searchPropertyByEnter("Catford");
        signUpHelper.clickPropertyCard1(2);
        String title = $(byXpath("//h1")).getText();
        //System.out.println(title);

        signUpHelper.clickMessageProperty("Message the advertiser");
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

        //signUpHelper.clickYourInformationContinue();
        //verificationHelper.budgetError();

        //signUpHelper.budgetMin();
        //signUpHelper.budgetMax();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.toMoveCheckboxEnabled();

        signUpHelper.quit();
        verificationHelper.toHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test
    public void popupExistingEmailPropertyPhone() {

        authorizationHelper.FindHomeInMenu();
        authorizationHelper.clickClosePopupSignUp();
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
