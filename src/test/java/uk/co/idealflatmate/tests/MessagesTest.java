package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.MessageHelper;

import static com.codeborne.selenide.Selenide.$;



public class MessagesTest extends TestBase {

   public final MessageHelper messageHelper = new MessageHelper();

   // @Test
    public void readMessageByLandlordWithoutSubscription() {

        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen44@gmail.com");
        authorizationHelper.setPassword("123456");
        getMessageHelper().chooseMessageTab();
        verificationHelper.verifyUpgradeButton();
        authorizationHelper.logoutFromApp();
    }

  //  @Test
    public void answerMessageFmWithoutSubscriptionToFM() {

        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithPremiumFlathunterPackage("cro.gen488@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        messageHelper.chooseMessageTab();
        //paymentsHelper.addPropertyHelper.messageHepler.chooseAnyMessageFromList();
        paymentsHelper.addPropertyHelper.messageHelper.typeAndSendMessage("Test Upgrade");
        verificationHelper.verifyTextMessage("Test Upgrade");
        authorizationHelper.logoutFromApp();
    }

  //  @Test
    public void answerMessagePremiumFHtoLandlordWithoutSubscription() {

        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithPremiumFlathunterPackage("cro.gen49@gmail.com");
        authorizationHelper.setPassword("123456");
        messageHelper.chooseMessageTab();
        //paymentsHelper.addPropertyHelper.messageHepler.chooseAnyMessageFromList();
        paymentsHelper.addPropertyHelper.messageHelper.typeAndSendMessage("Test Upgrade");
        verificationHelper.verifyTextMessage("Test Upgrade");
        authorizationHelper.logoutFromApp();
    }

  //  @Test
    public void sendMessageFmWithoutSubscriptionToLandlordWithoutSubscriptionWithListingFromSearch() {

        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithPremiumFlathunterPackage("cro.gen488@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        messageHelper.searchProperty("CO11");
        messageHelper.clickCardMessageLogged();
        //messageHelper.clickPropertyPageMessage();
        verificationHelper.upgradeToFasterReply();
        verificationHelper.messageGroup("# 0016189 A137, Manningtree CO11, UK");
        paymentsHelper.addPropertyHelper.messageHelper.typeAndSendMessage("Test Message to Landlord without subscription");
        verificationHelper.verifyTextMessage("Test Message to Landlord without subscription");
        authorizationHelper.logoutFromApp();
    }
  //  @Test
    public void sendMessageFmWithoutSubscriptionToLandlordWithoutSubscriptionWithListingFromListing() {

        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithPremiumFlathunterPackage("cro.gen488@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        messageHelper.searchProperty("CO11");
        //messageHelper.clickCardMessageLogged();
        messageHelper.clickPropertyCardPagelogged();
        messageHelper.clickPropertyPageMessage();
        verificationHelper.upgradeToFasterReply();
        verificationHelper.messageGroup("# 0016189 A137, Manningtree CO11, UK");
        paymentsHelper.addPropertyHelper.messageHelper.typeAndSendMessage("Test Message to Landlord without subscription");
        verificationHelper.verifyTextMessage("Test Message to Landlord without subscription");
        authorizationHelper.logoutFromApp();
    }

  //  @Test
    public void sendMessageFmWithoutSubscriptionToLandlordWithoutSubscriptionWithListingFromFMpage() {

        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithPremiumFlathunterPackage("cro.gen488@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        messageHelper.searchProperty("CO11");
        //messageHelper.clickCardMessageLogged();
        messageHelper.clickPropertyCardFMnamePagelogged();
        messageHelper.clickFMPageMessage();
        verificationHelper.upgradeToFasterReply();
        verificationHelper.messageGroup("No property");
        paymentsHelper.addPropertyHelper.messageHelper.typeAndSendMessage("Test Message to Landlord without subscription");
        verificationHelper.verifyTextMessage("Test Message to Landlord without subscription");
        authorizationHelper.logoutFromApp();
    }

}
