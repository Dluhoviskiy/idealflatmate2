package uk.co.idealflatmate.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifStageGoLive;


public class Buddy_up extends TestBase {
    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
    }

    @Test //(priority = 1)
    public void testAaaAddWholeProperty() {

        authorizationHelper.login("passwUniv", "agentBuddyUp");

        //addPropertyHelper.pressAddListingFromHeaderNotLoggedUser();
        //addPropertyHelper.selectTypeUser("An agency");
        //signUpHelper.agentSignListing("Ronald", "agentBuddyUp", "passwUniv", "66666666", "Tell us about yourself");

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        matchingHelper.closePopupMatching();
        addPropertyHelper.closeRenewPopup();

        //getAddPropertyHelper().openDropDownMenu();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.verifyNoProperty();
        addPropertyHelper.pressAddListingFromBody();

        addPropertyHelper.addListingWithoutPhotoBuddyUp("LL55 4TT", "3", "900", "Victoria Terrace, Llanberis, Caernarfon LL55 4TT, UK");

        //addPropertyHelper.finishPropertyAgency();

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.verifyAddedProperty("Victoria Terrace, Llanberis, Caernarfon LL55 4TT, UK Available");

        authorizationHelper.chooseProfileFromHeader();
        verificationHelper.verificationDataAgent("75%");

        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
        clearCache();
    }


    @Test //(priority = 2)

    public void testBbbAaaMessageSignUpFMPageBuddy_Up() {

        searchHelper.searchPropertyBySelectfromList("Caernarfon", "Caernarfon");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchPropertyMes("Victoria Terrace, Llanberis, Caernarfon LL55 4TT, UK", 0);

        String photo1 = $(byXpath("//div[@class='card-top-profile-img u_p5-right']/img")).getAttribute("src");
        //String name1 = $(byXpath("//span[@class='card-top-username']")).text();
        //String title1 = $(byXpath("//head/title")).text();
        sleep(2000);
        String postCode = $(byXpath("//div[@class='card-infos-left']/div")).text();


        signUpHelper.click1PropCardMes(0);
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
        verificationHelper.dateMonthYearBlankErrorMessage();

        signUpHelper.moreAboutYou("10", "3", "1955", "58885588", "20",
                "I want to Buddy_up", "Professional", "Freelancer/self employed");

        //signUpHelper.clickBackToSearch();
        buddyUpHelper.closeIntrodGroupsPopup();
        messageHelper.photoOfOwnerInMesBuddy_up(photo1);

        messageHelper.propertyPostcodeVerifying(postCode);

        messageHelper.clickMenuMessages();
        verificationHelper.noConverInbox("0 conversations");

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        verificationHelper.verificationDataProfileFMListing("70%");
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        authorizationHelper.removeAnyAccount();
    }

    @Test //(priority = 3)
    public void testCccButtonPropPage() {

        searchHelper.searchPropertyBySelectfromList("Caernarfon", "Caernarfon");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchPropertyMes("Victoria Terrace, Llanberis, Caernarfon LL55 4TT, UK", 0);

        String postCode = $(byXpath("//div[@class='card-infos-left']/div")).text();

        buddyUpHelper.clickCardProperty();
        buddyUpHelper.clickBuddy_upButton("m interested");
        verificationHelper.signUpPopupName("Sign up to continue");

        signUpHelper.clickEmail();
        signUpHelper.setSignUpNameFMessage("Ronald");
        signUpHelper.setSignEmailMessage("existingEmail");
        signUpHelper.setSignPasswordMessage("passwUniv");

        signUpHelper.quit();

        messageHelper.propertyPostcodeVerifying(postCode);
        verificationHelper.verificationUserIsUnlogged("Join Free");
        clearCache();
        refresh();
    }


    @Test //(priority = 4)
    public void testDddGroupPropPage() {

        searchHelper.searchPropertyBySelectfromList("LL55 4TT", "LL55 4TT");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchPropertyMes("Victoria Terrace, Llanberis, Caernarfon LL55 4TT, UK", 0);

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
        clearCache();
        refresh();
    }

    @Test //(priority = 5)
    public void testGggCardChatSignUpViaFB() {

        pageUrlVerifStageGoLive();
        searchHelper.searchPropertyBySelectfromList("Crew", "Crewe");
        searchHelper.closePopupSignup();
        searchHelper.selectRadius("+2 km");
        String postCode = $(byXpath("//div[@id='property_card_41688']//div[@class='card-infos-left']/div")).text();

        signUpHelper.click1PropCardIDMes("41688");

        authorizationHelper.clickSignUpWithFBBuddy_up();
        //authorizationHelper.LoginFacebookWithNewAccount("ron1991d@gmail.com", "qqqqqq666D");
        authorizationHelper.LoginFacebookWithNewAccount("FB2", "passwFB2");

        //signUpHelper.genderMaleSelect();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.profileDateBirthAdd("5", "2", "1959");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("19", "Professional", "Student");
        //signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        buddyUpHelper.closeIntrodGroupsPopup();

        messageHelper.propertyPostcodeVerifying(postCode);

        messageHelper.clickMenuMessages();
        verificationHelper.noConverInbox("0 conversations");

        verificationHelper.verificationUserNameOnHomePage("Francine");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        //matchingHelper.closePopupMatching();
        verificationHelper.verificationDataProfileFBBuddy_UP("60%", "Francine");
        signUpHelper.verificationDataProfileFotoDashboard();


        authorizationHelper.removeAnyAccount();

    }

    @Test //(priority = 6)
    //Facebook authorization doen`t work on staging
    public void Z_z_addLogInViaFBBuddy_up() {

        pageUrlVerifStageGoLive();
        searchHelper.searchPropertyBySelectfromList("Crew", "Crewe");
        searchHelper.closePopupSignup();
        searchHelper.selectRadius("+2 km");
        String postCode = $(byXpath("//div[@id='property_card_41688']//div[@class='card-infos-left']/div")).text();

        signUpHelper.click1PropCardIDMes("41688");

        authorizationHelper.clickSignUpWithFBBuddy_up();
        //authorizationHelper.LoginFacebookWithNewAccount("ron1991d@gmail.com", "qqqqqq666D");
        authorizationHelper.LoginFacebookWithNewAccount("FB1", "passwFB1");

        verificationHelper.verificationUserNameOnHomePage("Alex");

        buddyUpHelper.closeIntrodGroupsPopup();

        messageHelper.propertyPostcodeVerifying(postCode);

        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test //(priority = 7)

    public void testR_R_GroupCreate() {
        clearCache();
        refresh();
        searchHelper.searchPropertyBySelectfromList("LL55 4TT", "LL55 4TT");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchPropertyMes("Victoria Terrace, Llanberis, Caernarfon LL55 4TT, UK", 0);

        String photo1 = $(byXpath("//div[@class='card-top-profile-img u_p5-right']/img")).getAttribute("src");
        //String name1 = $(byXpath("//span[@class='card-top-username']")).text();
        //String title1 = $(byXpath("//head/title")).text();
        sleep(2000);
        String postCode = $(byXpath("//div[@class='card-infos-left']/div")).text();


        signUpHelper.click1PropCardMes(0);
        verificationHelper.signUpPopupName("Sign up to continue");
        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMupsBuddy2");
        sleep(2000);
        signUpHelper.moreAboutYou("10", "3", "1955", "58885588", "19", "I want to Buddy_up", "Professional", "Student");
        messageHelper.photoOfOwnerInMesBuddy_up(photo1);
        messageHelper.propertyPostcodeVerifying(postCode);

        buddyUpHelper.clickBuddy_upButton("Choose Your Flatmates");

        buddyUpHelper.popupGroup("Post a group");
        //buddyUpHelper.popupGroup("Create a Group");

        buddyUpHelper.postGroupButton();

        buddyUpHelper.assertNumberOfGroupsPropPage(2);

        messageHelper.clickMenuMessages();
        buddyUpHelper.assertNumberOfMessInbox(2);

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My Group");
        buddyUpHelper.assertNumberOfMyGroups(2);
        buddyUpHelper.clickListingImgGroupCard();
        buddyUpHelper.clickGroupSection();

        buddyUpHelper.learnMore(1);
        buddyUpHelper.removeGroup(1);
        buddyUpHelper.yesRemoveGroup(1);

        buddyUpHelper.learnMore(0);
        buddyUpHelper.removeGroup(0);
        buddyUpHelper.yesRemoveGroup(0);

        verificationHelper.textNoGroup("This property is available to rent as a whole. Click \"I'm interested\" to start a group and choose your flatmates");

        messageHelper.clickMenuMessages();
        buddyUpHelper.assertNumberOfMessInbox(0);

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My Group");
        buddyUpHelper.assertNumberOfMyGroups(0);
        homePageHelper.clickLogo();
        searchHelper.searchPropertyBySelectfromList("LL55 4TT", "LL55 4TT");
        signUpHelper.click1PropCardMes(0);

        buddyUpHelper.closeIntrodGroupsPopup();
        buddyUpHelper.clickGroupSection();

        buddyUpHelper.clickBuddy_upButton("m interested");
        buddyUpHelper.clickBuddy_upButton("Choose Your Flatmates");
        //buddyUpHelper.popupGroup("Create a Group");
        buddyUpHelper.popupGroup("Post a group");
        buddyUpHelper.postGroupButton();

        buddyUpHelper.assertNumberOfGroupsPropPage(2);

        buddyUpHelper.learnMore(1);
        buddyUpHelper.removeGroup(1);
        buddyUpHelper.yesRemoveGroup(1);

        buddyUpHelper.learnMore(0);
        buddyUpHelper.removeGroup(0);
        buddyUpHelper.yesRemoveGroup(0);

        verificationHelper.textNoGroup("This property is available to rent as a whole. Click \"I'm interested\" to start a group and choose your flatmates");

        buddyUpHelper.createPageGroupButton();
        //buddyUpHelper.postGroup();
        buddyUpHelper.postGroupButton();

        buddyUpHelper.learnMore(0);
        buddyUpHelper.closePopupGroup(0);

        buddyUpHelper.createPageGroupButton();
        buddyUpHelper.closeCreateGroup();

        authorizationHelper.logoutFromApp();


        //authorizationHelper.removeAnyAccount();
    }

    @Test //(priority = 8)//(dependsOnMethods = { "testMessageSignUpGroupCreate" })

    public void testT_T_MmmSignUpGroupJoin() {

        searchHelper.searchPropertyBySelectfromList("Caernarfon", "Caernarfon");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchPropertyMes("Victoria Terrace, Llanberis, Caernarfon LL55 4TT, UK", 0);

        String photo1 = $(byXpath("//div[@class='card-top-profile-img u_p5-right']/img")).getAttribute("src");
        //String name1 = $(byXpath("//span[@class='card-top-username']")).text();
        //String title1 = $(byXpath("//head/title")).text();
        sleep(2000);
        String postCode = $(byXpath("//div[@class='card-infos-left']/div")).text();


        signUpHelper.click1PropCardMes(0);
        verificationHelper.signUpPopupName("Sign up to continue");
        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Trump", "FMupsBuddy3");
        sleep(2000);
        signUpHelper.moreAboutYou2("25", "12", "1985", "777777777", "227", "I an interested in Buddy_up", "Professional", "Other");

        messageHelper.photoOfOwnerInMesBuddy_up(photo1);
        messageHelper.propertyPostcodeVerifying(postCode);

        buddyUpHelper.closeIntrodGroupsPopup();

        buddyUpHelper.clickGroupSection();
        buddyUpHelper.learnMore(0);
        buddyUpHelper.requestPageToGroup();
        //buddyUpHelper.clickBuddy_upButton("View more groups");
        buddyUpHelper.chat_MemberClick();
        buddyUpHelper.veryfNumberMember(2);
        buddyUpHelper.closeMemberPopup();

        buddyUpHelper.clickPropImgChat();
        buddyUpHelper.clickGroupSection();

        buddyUpHelper.verifyNumberUser(2);
        verificationHelper.nameUserInGroup("Ronald", 0);
        verificationHelper.nameUserInGroup("Trump", 1);

        buddyUpHelper.learnMore(0);
        buddyUpHelper.clickBuddy_upButton("Exit group");
        buddyUpHelper.clickBuddy_upButton("Confirm leave");
        buddyUpHelper.verifyNumberUser(1);
        verificationHelper.nameUserInGroup("Ronald", 0);

        buddyUpHelper.learnMore(0);
        buddyUpHelper.clickBuddy_upButton("Report group");
        buddyUpHelper.clickBuddy_upButton("Report now");

        buddyUpHelper.clickBuddy_upButton("m interested");
        buddyUpHelper.clickBuddy_upButton("Choose Your Flatmates");
        //buddyUpHelper.arrowPopupNext();

        buddyUpHelper.requestPopupToGroup();
        buddyUpHelper.chat_MemberClick();
        buddyUpHelper.veryfNumberMember(2);
        buddyUpHelper.closeMemberPopup();
        buddyUpHelper.clickPropImgChat();
        buddyUpHelper.clickGroupSection();

        buddyUpHelper.clickBuddy_upButton("m interested");
        buddyUpHelper.clickBuddy_upButton("Choose Your Flatmates");
        buddyUpHelper.popupGroup("Create a Group");
        buddyUpHelper.postGroupButton();
        buddyUpHelper.assertNumberOfGroupsPropPage(3);

        buddyUpHelper.clickBuddy_upButton("m interested");
        buddyUpHelper.clickBuddy_upButton("Choose Your Flatmates");
        //buddyUpHelper.arrowPopupNext();
        //buddyUpHelper.arrowPopupPrevious();
        buddyUpHelper.closePopupLookingGroup();

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My Group");
        buddyUpHelper.assertNumberOfMyGroups(3);
        buddyUpHelper.clickListingImgGroupCard();
        buddyUpHelper.clickGroupSection();

        buddyUpHelper.learnMore(1);
        buddyUpHelper.removeGroup(1);
        buddyUpHelper.yesRemoveGroup(1);

        buddyUpHelper.learnMore(0);
        buddyUpHelper.removeGroup(0);
        buddyUpHelper.yesRemoveGroup(0);

        //buddyUpHelper.learnMore(1);
        //buddyUpHelper.removeGroup(0);
        //buddyUpHelper.yesRemoveGroup(1);

        authorizationHelper.logoutFromApp();

        //authorizationHelper.removeAnyAccount();
    }
    @Test //(priority = 9)

    public void testW_W_MessageLoginGroupFull() {

        searchHelper.searchPropertyBySelectfromList("Caernarfon", "Caernarfon");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchPropertyMes("Victoria Terrace, Llanberis, Caernarfon LL55 4TT, UK", 0);

        String photo1 = $(byXpath("//div[@class='card-top-profile-img u_p5-right']/img")).getAttribute("src");
        //String name1 = $(byXpath("//span[@class='card-top-username']")).text();
        //String title1 = $(byXpath("//head/title")).text();
        sleep(2000);
        String postCode = $(byXpath("//div[@class='card-infos-left']/div")).text();


        signUpHelper.click1PropCardMes(0);
        authorizationHelper.clickFormSignInContact();
        authorizationHelper.loginBuddy_up("passwUniv", "FMwithoutSub3");

        buddyUpHelper.closeIntrodGroupsPopup();

        messageHelper.photoOfOwnerInMesBuddy_up(photo1);
        messageHelper.propertyPostcodeVerifying(postCode);

        buddyUpHelper.clickGroupSection();

        buddyUpHelper.learnMore(0);
        buddyUpHelper.requestPageToGroup();
        //buddyUpHelper.clickBuddy_upButton("View more groups");
        buddyUpHelper.chat_MemberClick();
        buddyUpHelper.veryfNumberMember(3);
        buddyUpHelper.closeMemberPopup();

        //messageHelper.clickMenuMessages();
        messageHelper.backToInbox();
        messageHelper.verifyMemberImgInboxNumber(3);
        messageHelper.clickMessage1Inbox();

        //buddyUpHelper.chat_MemberClick();
        //buddyUpHelper.veryfNumberMember(3);
        //buddyUpHelper.closeMemberPopup();

        buddyUpHelper.messageGroupVerif("Hi, thank you for your interest in this property.",
                "Hi my name is Trump", "Hi my name is Ronald", "Hi my name is Rene");

        buddyUpHelper.clickPropImgChat();

        authorizationHelper.logoutFromApp();
    }

    @Test //(priority = 10)

    public void testY_Y_MessageLoginGroupEditRemove() {

        searchHelper.searchPropertyBySelectfromList("Caernarfon", "Caernarfon");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchPropertyMes("Victoria Terrace, Llanberis, Caernarfon LL55 4TT, UK", 0);

        signUpHelper.click1PropCardMes(0);
        authorizationHelper.clickFormSignInContact();
        authorizationHelper.loginBuddy_up("passwUniv", "FMupsBuddy2");

        buddyUpHelper.closeIntrodGroupsPopup();

        buddyUpHelper.clickGroupSection();

        buddyUpHelper.learnMore(0);
        buddyUpHelper.clickBuddy_upButton("Edit group");

        buddyUpHelper.minBudgetInput("1000");
        addPropertyHelper.periodDateBuddy_up();
        buddyUpHelper.genderBuddy_up("Male");
        buddyUpHelper.ageMin();
        buddyUpHelper.ageMax();
        buddyUpHelper.addTextDescribe("test description");
        buddyUpHelper.postGroupButtonEdit();



        //authorizationHelper.logoutFromApp();

    }


    @Test //(priority = 11)

    public void testZ_Z_ZMessageLoginPropertyRemove() {


        authorizationHelper.login("passwUniv", "agentBuddyUp");
        //closeListRenewPopUp();

        addPropertyHelper.closeRenewPopup();

        messageHelper.chooseMesTabView();
        messageHelper.clickMenuMessages();
        messageHelper.numberConverInbox(3);
        messageHelper.verifyMemberImgInboxNumber(3);
        messageHelper.clickMessage1Inbox();

        buddyUpHelper.chat_MemberClick();
        buddyUpHelper.veryfNumberMember(3);
        buddyUpHelper.closeMemberPopup();

        buddyUpHelper.messageGroupVerif("Hi, thank you for your interest in this property.",
                "Hi my name is Trump", "Hi my name is Ronald", "Hi my name is Rene");

        buddyUpHelper.clickPropImgChat();
        buddyUpHelper.clickGroupSection();

        buddyUpHelper.veryfyGroupEditData("1000", "13th April 2021");

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().RemoveListing();

        messageHelper.clickMenuMessages();
        messageHelper.numberConverInbox(0);

        authorizationHelper.logoutFromApp();

    }

}
