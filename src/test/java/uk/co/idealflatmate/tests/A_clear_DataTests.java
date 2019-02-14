package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;
import utils.ConfData;

import static com.codeborne.selenide.Selenide.sleep;
import static uk.co.idealflatmate.appmanager.HelperBase.closeMatchPopUp;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifStageGoLive;

public class A_clear_DataTests extends TestBase {



    @Test
    public void removeAccountBeforeTest() {

        authorizationHelper.loginHeader("passwUniv", "agent");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "fmMatch");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "FMMatch3");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "agent2");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "fmNotPaid3");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "live-In1");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "liv-Out1");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "fmNotPaid4");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "fmNotPaid5");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "mes1Email");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "mes2Email");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "mes3Email");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "mes4Email");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "FMupsBuddy1");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "FMMatch5");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "FMMatch4");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "FMMatch6");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "Tenant1");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "FMnew1");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "FMnew2");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "FMnew3");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "FB2");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "FB3");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "LiveIn2");
        authorizationHelper.removeAccountBeforeTest();

        authorizationHelper.loginHeader("passwUniv", "LiveOut2");
        authorizationHelper.removeAccountBeforeTest();

    }



    @Test
    public void removelistingBeforeTest() {

        authorizationHelper.login("passwUniv", "userNotpaid");
        verifyNoPropertyOrRemove();

        authorizationHelper.login("passwUniv", "agentNotPaid");
        verifyNoPropertyOrRemove();

        authorizationHelper.login("passwUniv", "userTitle");
        closeMatchPopUp();
        verifyNoPropertyOrRemove();
    }

    public void verifyNoPropertyOrRemove() {
        addPropertyHelper.chooseListingsFromDropDownMenu();
        verificationHelper.verifyNoUnfinishedProperty();
        verificationHelper.verifyNoPropertyPending();
        verificationHelper.verifyNoProperty();
        authorizationHelper.logoutFromApp();
        sleep(2000);
        clearCache();
    }

}

