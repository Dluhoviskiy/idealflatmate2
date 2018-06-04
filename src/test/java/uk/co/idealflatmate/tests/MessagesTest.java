package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.MessageHelper;

import static com.codeborne.selenide.Selenide.$;



public class MessagesTest extends TestBase {

   public final MessageHelper messageHelper = new MessageHelper();

    @Test
    public void readMessageByLandlordWithoutSubscription() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen44@gmail.com");
        authorizationHelper.setPassword("123456");
        getMessageHelper().chooseMessageTab();
        verificationHelper.verifyUpgradeButton();
        authorizationHelper.logoutFromApp();
    }



    @Test
    public void answerMessage() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithPremiumFlathunterPackage("cro.gen49@gmail.com");
        authorizationHelper.setPassword("123456");
        messageHelper.chooseMessageTab();
        //paymentsHelper.addPropertyHelper.messageHepler.chooseAnyMessageFromList();
        paymentsHelper.addPropertyHelper.messageHelper.typeAndSendMessage("Test Upgrade");
        verificationHelper.verifyTextMessage();
        authorizationHelper.logoutFromApp();
    }


}
