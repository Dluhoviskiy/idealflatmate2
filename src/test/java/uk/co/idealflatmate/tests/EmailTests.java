package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

public class EmailTests extends TestBase {


   // @Test
    public void TestSuccessfulEmailReceivingWelcomeAndListing() {
        emailHelper.openGmailPage();
        emailHelper.setLoginAsUserEmail("cro.gen777@gmail.com");
        emailHelper.setLoginAsUserPassword("wwwwww666D");
        //emailHelper.enterEmail();
        emailHelper.enterInbox();
        emailHelper.verificationWelcome();
        emailHelper.verificationListingisLive();
        emailHelper.tipCheckboxWelcome();
       emailHelper.tipCheckboxListingisLive();
        emailHelper.removeEmail();
        emailHelper.verificationNoWelcome();
        emailHelper.verificationNoListingisLive();

    }
}
