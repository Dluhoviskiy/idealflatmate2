package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PremiumFlathunterTests extends TestBase {

    //@Test
    public void BuyPremiumFlathunterpackage() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage2(authorizationHelper);
        authorizationHelper.setPassword();
        paymentsHelper.goToPaymentsTab();
        paymentsHelper.selectPremiumFlathunterPlan();
        paymentsHelper.startCheckout();
        paymentsHelper.chooseWorldPay();
        $(byXpath("//*[@id=\"_el_input_nameoncard\"]")).setValue("Alex");
        paymentsHelper.fillinDebitCardData();
        verificationHelper.verifyPackagePurchase();

    }


}
