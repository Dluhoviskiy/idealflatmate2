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
        pageUrlVerifLiveGoStage();
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.Landlord101@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        closeListRenewPopUp();
        closeMatchPopUp();
        getMessageHelper().chooseMessageTab("Test Message to Landlord without subscription");
        verificationHelper.verifyUpgradeButton();
        authorizationHelper.logoutFromApp();
    }
    @Test
    public void landlordWithoutSubsToFM() {
        clearCache();
        pageUrlVerifLiveGoStage();
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.Landlord101@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        closeListRenewPopUp();
        closeMatchPopUp();
        homePageHelper.scrollToBlockProperty();
        homePageHelper.clickFM();
        getMessageHelper().clickUpgradeToMessage();
        verificationHelper.paymentPage("Want more from your listing? Upgrade now!");
        authorizationHelper.logoutFromApp();
        sleep(5000);
    }

    @Test
    public void landlWithSubsToFM() {
        clearCache();
        pageUrlVerifLiveGoStage();
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.AgencyPaid@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        closeListRenewPopUp();
        homePageHelper.scrollToBlockProperty();
        homePageHelper.clickFM();
        getMessageHelper().clickFMPageMessage();
        verificationHelper.chatPage();
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void answMesFmWithoutSubsToFM() {
        clearCache();
        pageUrlVerifLiveGoStage();
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FHMatching@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        messageHelper.chooseMessageTab("FM can answer to FM");
        verificationHelper.noSendDecline();
        //paymentsHelper.addPropertyHelper.messageHepler.chooseAnyMessageFromList();
        paymentsHelper.addPropertyHelper.messageHelper.typeAndSendMessage("FM can answer to FM");
        verificationHelper.verifyTextMessage("FM can answer to FM");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void answMesLandlToPremFHWithoutSubs() {
        clearCache();
        pageUrlVerifLiveGoStage();
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("newLiveOut1@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        closeListRenewPopUp();
        closeMatchPopUp();
        messageHelper.chooseMessageTab("Landlord Answer to Prem FM");
        //paymentsHelper.addPropertyHelper.messageHepler.chooseAnyMessageFromList();
        messageHelper.sendDecline("Unfortunately this listing is no longer available. Good luck with your search!");//Lord to FH
        messageHelper.typeAndSendMessage("Landlord Answer to Prem FM");
        verificationHelper.verifyTextMessage("Landlord Answer to Prem FM");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void premFmToLandlWithoutSubsWithListFromSearch() {
        clearCache();
        pageUrlVerifLiveGoStage();
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.Premium@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        searchHelper.searchPropertyHome("PO30");
        messageHelper.clickCardMessageLogged();
        //messageHelper.clickPropertyPageMessage();
        verificationHelper.noTextUpgradeToFasterReply();
        verificationHelper.messageGroup("# 0012947 Newport PO30 2DN, UK");
        paymentsHelper.addPropertyHelper.messageHelper.typeAndSendMessage("Landlord Answer to Prem FM");
        verificationHelper.verifyTextMessage("Landlord Answer to Prem FM");
        authorizationHelper.logoutFromApp();
    }
    @Test
    public void FmWithoutSubsToLandlordWithoutSubsWithListFromList() {
        clearCache();
        pageUrlVerifLiveGoStage();
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        authorizationHelper.goToPropertyPage();
        searchHelper.priceFilterActive();
        searchHelper.clearFilter();
        searchHelper.clickSearchPropPage("PO30");
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
        clearCache();
        pageUrlVerifLiveGoStage();
        System.out.println("JoinFreeButton");
        authorizationHelper.clickJoinFreeButton();

        System.out.println("SignInButton");
        authorizationHelper.clickSignInButtonInForm();

        System.out.println("LoginAsUserWithoutPackage");
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");

        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();

        System.out.println("searchPropertyHome");
        searchHelper.searchPropertyHome("Clapham");

        System.out.println("Verif searchResultText");
        verificationHelper.searchResultText("6 rooms matched to rent in and around Clapham");
        //searchHelper.clearSearch();

        System.out.println("lastCardClick");
        searchHelper.lastCardClick();//6 cards
        //messageHelper.clickCardMessageLogged();
        //messageHelper.clickPropertyCardFMnamePagelogged();

        System.out.println("clickFMPageMessage");
        messageHelper.clickFMPageMessage();


        verificationHelper.noUpgradeToFasterReply();
        verificationHelper.noSendDecline();
        verificationHelper.messageGroup("No property");
        messageHelper.typeAndSendMessage("Test Message to Landlord without subscription");
        verificationHelper.verifyTextMessage("Test Message to Landlord without subscription");
        authorizationHelper.logoutFromApp();
    }

}
