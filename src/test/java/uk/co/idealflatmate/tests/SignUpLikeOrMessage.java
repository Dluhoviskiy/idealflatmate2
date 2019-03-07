package uk.co.idealflatmate.tests;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;


public class SignUpLikeOrMessage extends TestBase {


    @Test
    public void mesPropSignUpHomeStart() {

        homePageHelper.scrollToBlockProperty();

        signUpHelper.click1PropertyCardMessage();
        signUpHelper.clickEmail();
        signUpHelper.clickYourInformationContinue();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }


        @Test
    public void mesPropSignUpNotBuddy_Up() {

        searchHelper.searchPropertyBySelectfromList("Leeds", "Leeds");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchPropertyMes("New York Street (stop K11), Leeds LS2 7DT, UK", 1);

        String photo1 = $$(byXpath("//div[@class='card-top-profile-img u_p5-right']/img")).get(1).getAttribute("src");
        String name1 = $$(byXpath("//span[@class='card-top-username']")).get(1).text();
        String title1 = $(byXpath("//head/title")).text();
        sleep(2000);
        String postCode = $$(byXpath("//div[@class='card-infos-left']/div")).get(1).text();


        signUpHelper.click1PropCardMes(1);
        signUpHelper.nameOfOwnerOnPopup(name1);
        signUpHelper.clickEmail();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlertMessage();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();
        //verificationHelper.passwordBlankAlertMessage();
        verificationHelper.dateMonthYearPhoneOccupationBlankErrorMessage();


        signUpHelper.setSignUpNameFMessage("Ronald");
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

        signUpHelper.setSignUpNameFMessage("Ronald");
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

        messageHelper.clickMenuMessages();
        messageHelper.photoOfOwnerInMessage(photo1);
        messageHelper.nameOfOwnerInMessage(name1);

        messageHelper.clickMessage1Inbox();
        messageHelper.messageVerifying(message1);
        messageHelper.propertyPostcodeVerifMes(postCode);

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        verificationHelper.verificationDataProfileFMListing("50%");
        verificationHelper.verificationUserNameOnHomePage("Ronald");

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
        searchHelper.amountPropertyCards(11);
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

        homePageHelper.scrollToBlockProperty();
        sleep(2000);
        String referNumber = $$(byXpath("//div[@class='u_p0-left text-13']")).get(2).getText();
        signUpHelper.clickLikePropertyCardHomePage(2);


        signUpHelper.clickEmail();

        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("mes2Email");
        signUpHelper.setSignPassword("passwUniv");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("19");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.backToSearch();

        //signUpHelper.clickShowMeMyMatches();
        getAddPropertyHelper().openDropDownMenu();
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        authorizationHelper.savedPropertiesMenuGo();
        verificationHelper.savedProperties(referNumber);
        signUpHelper.removeLike();
        verificationHelper.cardIsUnliked();


        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("70% complete");
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        verificationHelper.verificationDataLike("70%");
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        sleep(5000);

        verificationHelper.verificationUserIsUnlogged("Join Free");
        verificationHelper.isHomePage1();

    }
    @Test
    public void popupPropertyPage() {

        authorizationHelper.goToPropertyPage();

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Ronald", "mes3Email");

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
        verificationHelper.verificationDataProfileMatching("80%");
        verificationHelper.verificationUserNameOnHomePage("Ronald");

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

        signUpHelper.clickPropertyCard1();
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
        verificationHelper.dateMonthYearPhoneOccupationBlankErrorMessage();

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

        signUpHelper.profileDateBirthAdd("5", "2", "1959");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("39");
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
        signUpHelper.clickPropertyCard1();
        String searchLocation = $(byXpath("//h1")).getText();
        //System.out.println(title);

        messageHelper.clickPhoneReveal();
        signUpHelper.clickEmailPopup();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlertPhone();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();
        verificationHelper.dateMonthYearPhoneOccupationBlankErrorPhone();

        signUpHelper.quit();
        verificationHelper.isPropertyPageLocation(searchLocation);
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }
}
