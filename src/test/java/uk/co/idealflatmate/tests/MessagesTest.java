package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class MessagesTest extends TestBase {

    @Test
    public void readMessageByLandlordWithoutSubscription() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen44@gmail.com");
        authorizationHelper.setPassword("123456");
        getMessageHepler().chooseMessageTab();
        verificationHelper.verifyUpgradeButton();
        authorizationHelper.logoutFromApp();
    }



    @Test
    public void answerMessage() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithPremiumFlathunterPackage("cro.gen49@gmail.com");
        authorizationHelper.setPassword("123456");
        getMessageHepler().chooseMessageTab();
        //paymentsHelper.addPropertyHelper.messageHepler.chooseAnyMessageFromList();
        paymentsHelper.addPropertyHelper.messageHepler.typeAndSendMessage("Test Upgrade");
        verificationHelper.verifyTextMessage();
        authorizationHelper.logoutFromApp();
    }


}
