package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.MessageHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static uk.co.idealflatmate.appmanager.HelperBase.*;


public class MessagesTest extends TestBase {

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
        verificationHelper.paymentPage("Want more from your listing? Upgrade now!");
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
        paymentsHelper.addPropertyHelper.messageHelper.typeAndSendMessage("Landlord Answer to Prem FM");
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
        searchHelper.clickSearchPropPage("PO30 2DN");
        messageHelper.clickCardImgProperty();
        messageHelper.clickPropertyPageMessage();
        verificationHelper.upgradeToFasterReply();
        verificationHelper.messageGroup("# 0012947 Newport PO30 2DN, UK");
        messageHelper.sendDecline("Unfortunately I have found a place elsewhere and no longer" + //FH to Lord
                " interested in the room. Good luck finding a flatmate!");
        messageHelper.typeAndSendMessage("Test Message to Landlord without subscription");
        verificationHelper.verifyTextMessage("Test Message to Landlord without subscription");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void fmWithoutSubsTolordWithoutSubsWithListFromFMpage() {

        //System.out.println("JoinFreeButton");
        authorizationHelper.loginMessage("FMNotPaid", "passwUniv");


        searchHelper.searchPropertyHome("Clapham");


        verificationHelper.searchResultText("6 rooms matched to rent in and around Clapham");
        //searchHelper.clearSearch();


        searchHelper.lastCardClick();//6 cards
        //messageHelper.clickCardMessageLogged();
        //messageHelper.clickPropertyCardFMnamePagelogged();


        messageHelper.clickFMPageMessage();


        verificationHelper.noUpgradeToFasterReply();
        verificationHelper.noSendDecline();
        verificationHelper.messageGroup("No property");
        messageHelper.typeAndSendMessage("Test Message to Landlord without subscription");
        verificationHelper.verifyTextMessage("Test Message to Landlord without subscription");
        authorizationHelper.logoutFromApp();
    }

}
