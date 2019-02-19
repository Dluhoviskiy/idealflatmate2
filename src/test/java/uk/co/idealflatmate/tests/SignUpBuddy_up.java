package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifStageGoLive;


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
        buddyUpHelper.closeIntrodGroupsPopup();
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

    @Test
    public void testCardChatSignUpViaFB() {

        pageUrlVerifStageGoLive();
        searchHelper.searchPropertyBySelectfromList("Crew", "Crewe");
        searchHelper.closePopupSignup();

        String postCode = $(byXpath("//div[@id='property_card_39120']//div[@class='card-infos-left']/div")).text();

        signUpHelper.click1PropCardIDMes("39120");

        authorizationHelper.clickSignUpWithFBBuddy_up();
        //authorizationHelper.LoginFacebookWithNewAccount("ron1991d@gmail.com", "qqqqqq666D");
        authorizationHelper.LoginFacebookWithNewAccount("FB2", "passwFB2");

        //signUpHelper.genderMaleSelect();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.profileDateBirthAdd("5", "2", "1959");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("20");
        //signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        buddyUpHelper.closeIntrodGroupsPopup();

        messageHelper.propertyPostcodeVerifying(postCode);

        messageHelper.clickMenuMessages();
        verificationHelper.noConverInbox("0 conversations");

        verificationHelper.verificationUserNameOnHomePage("Francine");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseProfileFromDropDownMenu();
        //matchingHelper.closePopupMatching();
        verificationHelper.verificationDataProfileFBBuddy_UP("60%", "Francine");
        signUpHelper.verificationDataProfileFotoDashboard();


        authorizationHelper.removeAnyAccount();

    }

    @Test
    //Facebook authorization doen`t work on staging
    public void addLogInViaFBBuddy_up() {

        pageUrlVerifStageGoLive();
        searchHelper.searchPropertyBySelectfromList("Crew", "Crewe");
        searchHelper.closePopupSignup();

        String postCode = $(byXpath("//div[@id='property_card_39120']//div[@class='card-infos-left']/div")).text();

        signUpHelper.click1PropCardIDMes("39120");

        authorizationHelper.clickSignUpWithFBBuddy_up();
        //authorizationHelper.LoginFacebookWithNewAccount("ron1991d@gmail.com", "qqqqqq666D");
        authorizationHelper.LoginFacebookWithNewAccount("FB1", "passwFB1");

        verificationHelper.verificationUserNameOnHomePage("Alex");

        buddyUpHelper.closeIntrodGroupsPopup();

        messageHelper.propertyPostcodeVerifying(postCode);

        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test

    public void testMessageSignUpGroupCreate() {

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

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMupsBuddy2");
        sleep(2000);
        signUpHelper.moreAboutYou("10", "3", "1955", "58885588", "227", "I want to Buddy_up");
        messageHelper.photoOfOwnerInMesBuddy_up(photo1);
        messageHelper.propertyPostcodeVerifying(postCode);

        //signUpHelper.clickBackToSearch();
        buddyUpHelper.goGroupsPopup();
        buddyUpHelper.goPostAGroupPopup();
        //buddyUpHelper.postAGroupPopup();
        buddyUpHelper.postGroup();

        buddyUpHelper.learnMore();
        buddyUpHelper.removeGroup();
        buddyUpHelper.yesRemoveGroup();
        verificationHelper.textNoGroup("This property is available to rent as a whole. Click \"I'm interested\" to start a group and choose your flatmates");

        buddyUpHelper.clickListingPageButton("m interested");
        buddyUpHelper.goGroupsPopup();
        buddyUpHelper.goPostAGroupPopup();
        //buddyUpHelper.postAGroupPopup();
        buddyUpHelper.postGroup();

        //authorizationHelper.removeAnyAccount();
    }

    @Test (dependsOnMethods = { "testMessageSignUpGroupCreate" })

    public void testSignUpGroupJoin() {

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

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMupsBuddy3");
        sleep(2000);
        signUpHelper.moreAboutYou("10", "3", "1955", "58885588", "227", "I want to Buddy_up");
        messageHelper.photoOfOwnerInMesBuddy_up(photo1);
        messageHelper.propertyPostcodeVerifying(postCode);

        //signUpHelper.clickBackToSearch();
        buddyUpHelper.goGroupsPopup();
        buddyUpHelper.requestToGroup();
        buddyUpHelper.seeMoreGroups();
        buddyUpHelper.clickGroupSection();

        buddyUpHelper.learnMore();
        buddyUpHelper.exitGroup();
        buddyUpHelper.confirmLeave();

        buddyUpHelper.clickListingPageButton("m interested");
        buddyUpHelper.goGroupsPopup();
        buddyUpHelper.requestToGroup();
        buddyUpHelper.seeMoreGroups();
        buddyUpHelper.clickGroupSection();

        verificationHelper.nameUserInGroup("Ronald");

        authorizationHelper.removeAnyAccount();
    }


}
