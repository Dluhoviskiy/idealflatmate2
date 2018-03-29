package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class MessagesTest extends TestBase {

    @Test
    public void readMessage() {
        authorizationHelper.clickSignUpButton();
        authorizationHelper.setLoginAsUserWithoutPackage();
        authorizationHelper.setPassword();
        getMessageHepler().chooseMessageTab();
        paymentsHelper.addPropertyHelper.messageHepler.chooseAnyMessageFromList();
        verificationHelper.verifyUpgradeButton();
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void answerMessage() {
        authorizationHelper.clickSignUpButton();
        authorizationHelper.setLoginAsUserWithPremiumFlathunterPackage();
        authorizationHelper.setPassword();
        getMessageHepler().chooseMessageTab();
        paymentsHelper.addPropertyHelper.messageHepler.chooseAnyMessageFromList();
        paymentsHelper.addPropertyHelper.messageHepler.typeAndSendMessage();
        verificationHelper.verifyTextMessage();
        authorizationHelper.logoutFromApp();
    }


}
