package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;
import utils.ConfData;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class SignUpBuddy_up extends TestBase {


    //@Test
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

    public void testMessageSignUpFMPageBuddy_Up() {

        searchHelper.searchPropertyBySelectfromList("llanberis", "llanberis");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchPropertyMes("V12 Outdoor, The Old Baptist Chapel, High Street, Llanberis LL55 4EN, United Kingdom");

        String photo1 = $(byXpath("//div[@class='card-top-profile-img u_p5-right']/img")).getAttribute("src");
        //String name1 = $(byXpath("//span[@class='card-top-username']")).text();
        //String title1 = $(byXpath("//head/title")).text();
        sleep(2000);
        String postCode = $(byXpath("//div[@class='card-infos-left']/div")).text();


        signUpHelper.click1PropCardMes();
        verificationHelper.signUpPopupName("Sign up to continue");
        signUpHelper.clickEmail();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlertMessage();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();
        //verificationHelper.passwordBlankAlertMessage();

        signUpHelper.yourInformation("passwUniv", "Ronald", "existingEmail");

        verificationHelper.emailAlreadyExistedAlert();

        signUpHelper.clearEmailMessage();
        signUpHelper.clearFirstnameMessage();
        //signUpHelper.clearGender();
        signUpHelper.clearPasswordMessage();

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMupsBuddy1");
        sleep(2000);

        signUpHelper.clickYourInformationContinue();
        verificationHelper.dateMonthYearPhoneOccupationBlankErrorMessage();

        signUpHelper.moreAboutYou("10", "3", "1955", "58885588", "227", "I want to Buddy_up");

        //signUpHelper.clickBackToSearch();
        messageHelper.closeIntrodGroupsPopup();
        messageHelper.photoOfOwnerInMesBuddy_up(photo1);

        messageHelper.propertyPostcodeVerifying(postCode);

        messageHelper.clickMenuMessages();
        verificationHelper.noConverInbox("0 conversations");

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseProfileFromDropDownMenu();
        verificationHelper.verificationDataProfileFMListing("70%");
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        authorizationHelper.removeAnyAccount();
    }



    @Test
    public void testButtonPropPage() {

        searchHelper.searchPropertyBySelectfromList("llanberis", "llanberis");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchPropertyMes("V12 Outdoor, The Old Baptist Chapel, High Street, Llanberis LL55 4EN, United Kingdom");

        String postCode = $(byXpath("//div[@class='card-infos-left']/div")).text();

        buddyUpHelper.clickCardProperty();
        buddyUpHelper.clickListingPageButton("m interested");
        verificationHelper.signUpPopupName("Sign up to continue");

        signUpHelper.clickEmail();
        signUpHelper.setSignUpNameFMessage("Ronald");
        signUpHelper.setSignEmailMessage("existingEmail");
        signUpHelper.setSignPasswordMessage("passwUniv");

        signUpHelper.quit();

        messageHelper.propertyPostcodeVerifying(postCode);
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }


    @Test
    public void testGroupPropPage() {

        searchHelper.searchPropertyBySelectfromList("llanberis", "llanberis");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchPropertyMes("V12 Outdoor, The Old Baptist Chapel, High Street, Llanberis LL55 4EN, United Kingdom");

        String postCode = $(byXpath("//div[@class='card-infos-left']/div")).text();

        buddyUpHelper.clickCardProperty();

        buddyUpHelper.clickGroupSection();

        buddyUpHelper.clickCreateGroup();


        verificationHelper.signUpPopupName("Sign up to continue");

        signUpHelper.clickEmail();
        signUpHelper.setSignUpNameFMessage("Ronald");
        signUpHelper.setSignEmailMessage("existingEmail");
        signUpHelper.setSignPasswordMessage("passwUniv");

        signUpHelper.quit();

        messageHelper.propertyPostcodeVerifying(postCode);
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }




}
