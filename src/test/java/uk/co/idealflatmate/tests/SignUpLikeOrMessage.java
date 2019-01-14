package uk.co.idealflatmate.tests;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;


public class SignUpLikeOrMessage extends TestBase {

   // @Test
    public void messagePropertySignUpHomePage() {
        //newDriverPage();
        clearCache();
        homePageHelper.scrollToBlockProperty();

        String photo1 = $(byXpath("(//div[@class='card-top-profile-img u_p5-right']/img)[3]")).getAttribute("src");
        String name1 = $(byXpath("(//span[@class='card-top-username u_ed-block'])[3]")).text();
        String title1 = $(byXpath("//head/title")).text();
        sleep(2000);
        String postCode = $(byXpath("(//div[@class='owl-item active']//div[@class='card-infos u_ep-relative'])[3]" +
                "//div[@class='card-infos-left']/div")).text();


        signUpHelper.click1PropertyCardMessage();
        signUpHelper.clickEmail();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailBlankAlertMessage();
        verificationHelper.nameFirstBlankAlertMessage();
        verificationHelper.genderBlankAlertMessage();
        verificationHelper.passwordBlankAlertMessage();
        verificationHelper.dateMonthYearPhoneOccupationBlankErrorMessage();


        signUpHelper.setSignUpNameFMessage("Ronald");
        signUpHelper.profileDateBirthAddMessage("5", "2", "1959");
        signUpHelper.setSignEmailMessage("FMnew777@gmail.com");
        signUpHelper.genderFemaleSelectMessageError();
        signUpHelper.setSignPasswordMessage("qqqqqq");
        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailAlreadyExistedAlertMessage();

        signUpHelper.clearEmailMessage();
        signUpHelper.clearFirstnameMessage();
        //signUpHelper.clearGender();
        signUpHelper.clearPasswordMessage();

        signUpHelper.setSignUpNameFMessage("Ronald");
        //signUpHelper.profileDateBirthAddMessage("5", "2", "1959");
        signUpHelper.genderFemaleSelectMessage();
        signUpHelper.setSignEmailMessage("FM51stU@gmail.com");
        signUpHelper.setSignPasswordMessage("qqqqqq");
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
        //messageHelper.messageVerifying(message1);
        messageHelper.propertyPostcodeVerifying(postCode);

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseProfileFromDropDownMenu();
        verificationHelper.verificationDataProfileFMListing("50%");
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("50% complete");
        authorizationHelper.chooseProfileFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();

        verificationHelper.verificationUserIsUnlogged("Join Free");

    }


   // @Test



    public void messageSignUpFMPage() {
        clearCache();
        homePageHelper.scrollToBlockProperty();
        String photo1 = $(byXpath("(//div[@class='card-top-profile-img u_p5-right']/img)[1]")).getAttribute("src");

        homePageHelper.clickFM();
        String name1 = $(byXpath("//h2/strong")).text();
        String title1 = $(byXpath("//head/title")).text();

        messageHelper.clickFMPageMessage();

        signUpHelper.clickEmail();
        signUpHelper.clickYourInformationContinue();

        verificationHelper.emailBlankAlertMessage();
        verificationHelper.nameFirstBlankAlertMessage();
        verificationHelper.genderBlankAlertMessage();
        verificationHelper.passwordBlankAlertMessage();
        verificationHelper.dateMonthYearPhoneOccupationBlankErrorMessage();

        signUpHelper.setSignUpNameFMessage("Ronald");
        signUpHelper.profileDateBirthAddMessage("5", "2", "1959");
        signUpHelper.setSignEmailMessage("FMnew777@gmail.com");
        signUpHelper.genderFemaleSelectMessageError();
        signUpHelper.setSignPasswordMessage("qqqqqq");
        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailAlreadyExistedAlertMessage();

        signUpHelper.clearEmailMessage();
        signUpHelper.clearFirstnameMessage();
        //signUpHelper.clearGender();
        signUpHelper.clearPasswordMessage();

        signUpHelper.setSignUpNameFMessage("Ronaldina");
        //signUpHelper.profileDateBirthAddMessage("5", "2", "1959");
        signUpHelper.genderFemaleSelectMessage();
        signUpHelper.setSignEmailMessage("FMkn154n71a7@gmail.com");
        signUpHelper.setSignPasswordMessage("qqqqqq");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.photoOfOwner(photo1);
        signUpHelper.nameOfOwner(name1);
        //String message1 = $("textarea#messagewritesignupform-message").text();
        signUpHelper.verificationAutoMessageFM(name1);


        signUpHelper.clickYourInformationContinue();
        verificationHelper.checkPhoneAlertMessage("Phone cannot be blank.");

        signUpHelper.profilePhoneMessage("5555555555");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.clickCompleteSearchPref();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.checkLocationBlank();

        signUpHelper.preferredLocation("Watf",  "Watford");
        signUpHelper.preferredLocationButton("North London");
        signUpHelper.preferredLocationButton("Zone 1");
        //String locations = $(byXpath("//ul[@class='js-selected-area u_m0 u_p0']")).getText();
        signUpHelper.preferredLocationButton("Zone 3");
        verificationHelper.areasNumberForSignUp();
        signUpHelper.clickYourInformationContinue();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.budgetError();

        signUpHelper.budgetMin();
        signUpHelper.budgetMax();

        signUpHelper.clickYourInformationContinue();

        signUpHelper.titleOfSearchPage(title1);

        messageHelper.clickMenuMessages();
        messageHelper.photoOfOwnerInMessage(photo1);
        messageHelper.nameOfOwnerInMessage(name1);

        messageHelper.clickMessage1Inbox();
        // messageHelper.messageVerifying(message1);
        messageHelper.verifyNoProperties("No property");

        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("60% complete");
        authorizationHelper.chooseProfileFromDropDownMenu();
        verificationHelper.verificationDataProfileFM("60%");
        verificationHelper.verificationUserNameOnHomePage("Ronaldina");

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseProfileFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();

        verificationHelper.verificationUserIsUnlogged("Join Free");
    }


  //  @Test
    public void signUpLike3rdPageQuit() {
        //newDriverPage();
        clearCache();

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
        verificationHelper.emailBlankAlertMessageLike();


        signUpHelper.quit();
        verificationHelper.PropertyPageNumber(page);
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

   // @Test
    public void signUpLikeHomePage() {
        //newDriverPage();
        clearCache();


        homePageHelper.scrollToBlockProperty();
        sleep(2000);
        String referNumber = $$(byXpath("//div[@class='u_p0-left text-13']")).get(2).getText();
        signUpHelper.clickLikePropertyCardHomePage(2);


        signUpHelper.clickEmail();

        signUpHelper.setSignUpNameF("Ronald");
        signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("Like1901a@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
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
        authorizationHelper.chooseProfileFromDropDownMenu();
        verificationHelper.verificationDataLike("50%");
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        sleep(5000);

        verificationHelper.verificationUserIsUnlogged("Join Free");
        verificationHelper.isHomePage1();

    }
  //  @Test
    public void popupSignUpPropertyPage() {
        //newDriverPage();
        clearCache();
        authorizationHelper.goToPropertyPage();

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("qqqqqq", "Ronald", "FMnew314011@gmail.com");

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
        authorizationHelper.chooseProfileFromDropDownMenu();
        verificationHelper.verificationDataProfileMatching("80%");
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("60% complete");
        authorizationHelper.chooseProfileFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();

        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

   // @Test
    public void popupSignUpWithExistingEmail() {
        //newDriverPage();
        clearCache();
        authorizationHelper.goToFMpage();

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("qqqqqq", "Ronald", "FMnew777@gmail.com");

        verificationHelper.emailAlreadyExistedAlert();

        signUpHelper.quit();
        verificationHelper.isFMPage();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }


  //  @Test
    public void popupSignUpExistingEmailPropertyPage() {
        //newDriverPage();
        clearCache();
        authorizationHelper.FindHomeInMenu();
        authorizationHelper.clickCloseSignUp();

        signUpHelper.clickPropertyCard1();
        String title = $(byXpath("//h1")).getText();
        //System.out.println(title);

        signUpHelper.clickMessageProperty("Request details");
        signUpHelper.clickEmail();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailBlankAlertMessage();
        verificationHelper.nameFirstBlankAlertMessage();
        verificationHelper.genderBlankAlertMessage();
        verificationHelper.passwordBlankAlertMessage();
        verificationHelper.dateMonthYearPhoneOccupationBlankErrorMessage();

        signUpHelper.quit();
        verificationHelper.isPropertyPage(title);
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

   // @Test
    public void popupSignUpWithBlankRequiredFields() {
        //newDriverPage();
        clearCache();
        authorizationHelper.goToFMpage();

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("qqqqqq", "Ronald", "FMnew777@gmail.com");

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
        signUpHelper.setSignEmail("FMnew330696@gmail.com");
        signUpHelper.setSignPassword("qqqqqq");
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

    //@Test
    public void popupSignUpExistingEmailPropertyPhone() {

        //newDriverPage();
        clearCache();
        authorizationHelper.FindHomeInMenu();
        authorizationHelper.clickCloseSignUp();
        searchHelper.moveToPage(3, "3");
        signUpHelper.clickPropertyCard1();
        String searchLocation = $(byXpath("//h1")).getText();
        //System.out.println(title);

        messageHelper.clickPhoneReveal();
        signUpHelper.clickEmailPopup();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailBlankAlertPhone();
        verificationHelper.nameFirstBlankAlertPhone();
        verificationHelper.genderBlankAlertPhone();
        verificationHelper.passwordBlankAlertPhone();
        verificationHelper.dateMonthYearPhoneOccupationBlankErrorPhone();

        signUpHelper.quit();
        verificationHelper.isPropertyPage(searchLocation);
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }
}
