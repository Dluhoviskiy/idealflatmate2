package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

public class ZEmailTests extends TestBase {


    @Test
    public void zSuccesEmailReceivingWelcomeListingMessageSubscriptionCancSub() {
        emailHelper.openGmailPage();
        emailHelper.setLoginAsUserEmail("cro.gen.idealflatmate@gmail.com");
        emailHelper.setLoginAsUserPassword("qqqqqq666D");
        //emailHelper.enterEmail();
        emailHelper.enterInbox();
        //emailHelper.verificationWelcome();
        //emailHelper.verificationListingisLive();
       // emailHelper.verificationMessage();
        emailHelper.tipCheckboxWelcome();
        emailHelper.tipCheckboxListingisLive();
        emailHelper.tipCheckboxMessage();
        emailHelper.tipCheckboxEnquiry();
        emailHelper.tipCheckboxPremiumFHSubscription();
        emailHelper.tipCheckboxPremiumFHSubscriptionCanceled();
        emailHelper.tipCheckboxSubs();
        emailHelper.tipCheckboxCancelSubs();
        emailHelper.tipCheckboxPending();
        emailHelper.removeAllEmails();
        emailHelper.verificationNoWelcome();
        emailHelper.verificationNoListingisLive();
        emailHelper.verificationNoMessageEmail();

    }
}
