package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class PaymentTests extends TestBase {

    @Test
    public void AbilityToSeePhone() {
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.Premium@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Zlatan");
        searchHelper.searchProperty("#0012906");
        paymentsHelper.verificationPhone("XXXX");
        getMessageHelper().clickPhoneReveal();
        paymentsHelper.verificationPhoneVisible("777777777");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void GoPremiumFHPaymentOnPhone() {
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Borris");
        searchHelper.searchProperty("#0012906");
        paymentsHelper.verificationPhone("XXXX");
        getMessageHelper().clickPhoneReveal();
        paymentsHelper.verificationPremiumPopup("Get access to all properties");
        paymentsHelper.clickUpgradePremiumFH("Upgrade Now");
        paymentsHelper.verificationPaymentPage("Premium Flathunter");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void GoPremiumFHPaymentOnMessage() {
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Borris");
        searchHelper.searchProperty("#0012906");
        getMessageHelper().clickPropertyContact();
        paymentsHelper.clickUpgradePremiumFH("Upgrade to get a faster reply");
        paymentsHelper.clickUpgradePremiumFH("Upgrade Now");
        paymentsHelper.verificationPaymentPage("Premium Flathunter");
        paymentsHelper.verificationPaymentPage("Premium Flathunter");
        authorizationHelper.logoutFromApp();
    }

    @Test (priority = 6)
    public void PremiumFHPaymentWorldPay() {
        authorizationHelper.goToPropertyPage();
        authorizationHelper.clickCloseSignUpFMPage();
        authorizationHelper.clickJoinFreeButton();
        //authorizationHelper.setNewLoginMail("cro.PremFHPayment6@gmail.com");
        //authorizationHelper.setNewLoginPassword("qqqqqq");
        authorizationHelper.setNewLoginNameF("Ronald");
        authorizationHelper.setNewLoginNameL("NewOne");
        authorizationHelper.setPhoneNumberHomePage("777777777");
        verificationHelper.ageConfirmCheckClassicSignUp();
       // authorizationHelper.clickFormSignUpSave();
        //emailHelper.emailVerification();
        authorizationHelper.clickCloseMoreAboutYou();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        paymentsHelper.goToPaymentsTab();
        paymentsHelper.verificationPaymentPage("Premium Flathunter");
        //paymentsHelper.selectPremiumFlathunterPlan();
        paymentsHelper.upgradePremiumFH();
        paymentsHelper.verificationCheckout("£3.99 (week)");
        paymentsHelper.verificationCheckoutTotal("3.99");
        paymentsHelper.checkout();
        paymentsHelper.chooseWorldPay("or Credit / Debit Card");
        paymentsHelper.fillinDebitCardData("Alex", "5454545454545454", "11", "2020", "123");
        verificationHelper.verifyPackagePurchase("Congratulations on choosing our Premium Flathunter plan for the property .\n");
        paymentsHelper.removePackage();
        verificationHelper.verifyPackageCanceled("You are using our Premium Flathunter plan for property .\n" +
                "Your subscription will not renew automatically.");
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }
   // @Test (priority = 8)
    public void LandlordPaymentPayPal() {
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.LandLordPayment@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        paymentsHelper.goToPaymentsTab();
        paymentsHelper.verificationPaymentPageFeatureListing("Premium");
        //paymentsHelper.selectPremiumFlathunterPlan();
        paymentsHelper.selectNLADiscount("NLA15");
        paymentsHelper.verificationPrice("1 week Premium - £12.99");
        paymentsHelper.upgradePremiumListing("Upgrade to Premium");
        paymentsHelper.verificationCheckout("£12.99 (week)");
        paymentsHelper.verificationCheckoutTotal("11.04");
        paymentsHelper.checkout();
        paymentsHelper.choosePayPal();
        paymentsHelper.fillinDebitCardData("Alex", "5454545454545454", "11", "2020", "123");
        verificationHelper.verifyPackagePurchase("Congratulations on choosing our Premium Flathunter plan for the property .\n");
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseAccountFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }

}
