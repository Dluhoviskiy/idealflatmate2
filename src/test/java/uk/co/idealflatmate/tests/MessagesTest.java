package uk.co.idealflatmate.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.MessageHelper;

import static com.codeborne.selenide.Selenide.$;
import static uk.co.idealflatmate.appmanager.HelperBase.*;
import static uk.co.idealflatmate.appmanager.SearchHelper.getNumberOfListing;


public class MessagesTest extends TestBase {
    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
    }


   public final MessageHelper messageHelper = new MessageHelper();

    @Test
    public void readMessageByLandlWithoutSubsn() {

        authorizationHelper.loginMessage("Live_in_Mes", "passwUniv");
        getMessageHelper().chooseMessageTab("Test Message to Landlord without subscription");
        verificationHelper.verifyUpgradeButton();
        authorizationHelper.logoutFromApp();
    }
    @Test
    public void landlordWithoutSubsToFM() {

        authorizationHelper.loginMessage("Live_in_Mes", "passwUniv");
        homePageHelper.scrollToBlockProperty();
        homePageHelper.clickFM();
        getMessageHelper().clickUpgradeToMessage();
        verificationHelper.paymentPageNotifUpgrade("Now choose the plan that is right for you.");
        authorizationHelper.logoutFromApp();

    }



    @Test
    public void lordWithSubsToFM() {

        authorizationHelper.loginMessage("AgencyPaid", "passwUniv");
        homePageHelper.scrollToBlockProperty();
        homePageHelper.clickFM();
        getMessageHelper().clickFMPageMessage();
        verificationHelper.chatPage();
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void answMesFmWithoutSubsToFM() {

        authorizationHelper.loginMessage("FMwithMatch", "passwUniv");
        messageHelper.chooseMessageTab("FM can answer to FM");
        verificationHelper.noSendDecline();
        //paymentsHelper.addPropertyHelper.messageHepler.chooseAnyMessageFromList();
        paymentsHelper.addPropertyHelper.messageHelper.typeAndSendMessage("FM can answer to FM");
        verificationHelper.verifyTextMessage("FM can answer to FM");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void answMesLandlToPremFHWithoutSubs() {

        authorizationHelper.loginMessage("Liv_out_paid", "passwUniv");
        messageHelper.chooseMessageTab("Landlord Answer to Prem FM");
        //paymentsHelper.addPropertyHelper.messageHepler.chooseAnyMessageFromList();
        messageHelper.sendDecline("Unfortunately this listing is no longer available. Good luck with your search!");//Lord to FH
        messageHelper.typeAndSendMessage("Landlord Answer to Prem FM");
        verificationHelper.verifyTextMessage("Landlord Answer to Prem FM");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void premFmToLandlWithoutSubsWithListFromSearch() {

        authorizationHelper.loginMessage("Prem_FH_paid", "passwUniv");
        searchHelper.searchPropertyHomePostCode("PO30 2DN");
        messageHelper.clickCardMessageLogged();
        //messageHelper.clickPropertyPageMessage();
        verificationHelper.noTextUpgradeToFasterReply();
        verificationHelper.messageGroup("# 0012947 Newport PO30 2DN, UK");
        addPropertyHelper.messageHelper.typeAndSendMessage("Landlord Answer to Prem FM");
        verificationHelper.verifyTextMessage("Landlord Answer to Prem FM");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void fmWithoutSubsToLandlordWithoutSubsWithListFromList() {

        authorizationHelper.loginMessage("FMNotPaid", "passwUniv");

        authorizationHelper.goToPropertyPage();

        searchHelper.priceFilterActive();
        searchHelper.clearFilter();
        searchHelper.clearSearch();
        searchHelper.clickSearchPropPage("PO30 2Dn  ");
        messageHelper.clickCardImgProperty("Newport PO30 2DN, UK");
        messageHelper.clickPropertyContact();
        //messageHelper.clickPropertyPageMessage();
        verificationHelper.upgradeToFasterReply();
        verificationHelper.messageGroup("# 0012947 Newport PO30 2DN, UK");
        messageHelper.sendDecline("Unfortunately I have found a place elsewhere and no longer" + //FH to Lord
                " interested in the room. Good luck finding a flatmate!");
        messageHelper.typeAndSendMessage("Test Message to Landlord without subscription");
        verificationHelper.verifyTextMessage("Test Message to Landlord without subscription");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void fmWithoutSubsTolordWithoutSubsDirectly() {

        String location = "Whitton";
        authorizationHelper.loginMessage("FMNotPaid", "passwUniv");


        searchHelper.searchPropertyHome(location);
        searchHelper.selectRadius("+3 km");

        verificationHelper.searchResultText("Found " + getNumberOfListing() + " room to rent in "+location);

        searchHelper.cardUserClick();

        messageHelper.clickFMPageMessage();

        verificationHelper.upgradeToFasterReply();
        verificationHelper.noSendDecline();
        verificationHelper.messageGroup("No property");
        messageHelper.typeAndSendMessage("Test Message to Landlord without subscription");
        verificationHelper.verifyTextMessage("Test Message to Landlord without subscription");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void spamFmWithoutSubsToFMLink() {

        String name = "Mash";
        pageUrlVerifLiveGoStage();
        clearCache();

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("A current tenant");

        signUpHelper.signListingFM_LiveIn("TenantSpam", "passwUniv",
                "5", "5", "1959", "55555555", "19",
                name, "Professional", "Student");


        addPropertyHelper.saveQuitHeaderMenuListing();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.verifyAddListingPage();
        verificationHelper.verificationUserNameOnHomePage(name);

        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();
        signUpHelper.click1CardMessage("1");
        addPropertyHelper.messageHelper.typeAndSendMessage("https://www.trend.az");

        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();
        signUpHelper.click1CardMessage("2");
        addPropertyHelper.messageHelper.typeAndSendMessage("https://www.trend.az");

        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();
        signUpHelper.click1CardMessage("3");
        addPropertyHelper.messageHelper.typeAndSendMessage("https://www.trend.az");

        verificationHelper.notifSpamer("Message limit reached. Please upgrade to premium flathunter" +
                " or contact help@idealflatmate.co.uk to have your messaging restored.");


        authorizationHelper.removeAnyAccount();

        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

}
