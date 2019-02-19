package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static uk.co.idealflatmate.appmanager.HelperBase.closeMatchPopUp;

public class PaymentTests extends TestBase {


    @Test
    public void AbilityToSeePhone() {


        authorizationHelper.login("passwUniv", "Prem_FH_paid");
        verificationHelper.verificationUserNameOnHomePage("Zlatan");
        searchHelper.searchPropertyHome("#0012906");
        paymentsHelper.verificationPhone("XXXX");
        getMessageHelper().clickPhoneReveal();

        paymentsHelper.verificationPhoneVisible("777777777");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void GoPremiumFHPaymentOnPhone() {

        authorizationHelper.login("passwUniv", "FMNotPaid");

        verificationHelper.verificationUserNameOnHomePage("Borris");
        searchHelper.searchPropertyHome("#0012906");
        paymentsHelper.verificationPhone("XXXX");
        getMessageHelper().clickPhoneReveal();
        paymentsHelper.verificationPremiumPopup("Get access to all properties");
        paymentsHelper.clickUpgradePremiumFH("Upgrade Now");
        paymentsHelper.verificationPaymentPage("Premium Flathunter");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void GoPremiumFHPaymentOnMessage() {

        authorizationHelper.login("passwUniv", "FMNotPaid");

        verificationHelper.verificationUserNameOnHomePage("Borris");
        searchHelper.searchPropertyHome("#0012906");
        getMessageHelper().clickPropertyContact();
        paymentsHelper.clickUpgradePremiumFH("Upgrade to get a faster reply");
        paymentsHelper.clickUpgradePremiumFH("Upgrade Now");
        paymentsHelper.verificationPaymentPage("Premium Flathunter");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void premiumFHPaymentWorldPay() {

        authorizationHelper.goToPropertyPage();
        authorizationHelper.clickCloseSignUpFMPage();

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom();
        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Ronald", "fmNotPaid3");

        signUpHelper.moreAboutYou("5", "12","1988","77777777", "227","I am a FlatHunter");

        signUpHelper.whereWouldLikeLive("watf", "Watford");

        signUpHelper.budgetMin();
        signUpHelper.budgetMax();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.clickYourInformationContinue();

        //signUpHelper.priceMove("15", "12", "2019");

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        addPropertyHelper.openDropDownMenu();
        paymentsHelper.goToPaymentsTab();

        paymentsHelper.verificationPaymentPage("Premium Flathunter");
        //paymentsHelper.selectPremiumFlathunterPlan();
        paymentsHelper.upgradePremiumFH();
        paymentsHelper.verificationCheckout("£"+"3.99 (week)");
        paymentsHelper.verificationCheckoutTotal("3.99");
        paymentsHelper.checkout();
        paymentsHelper.chooseWorldPay("or Credit / Debit Card");
        paymentsHelper.fillinDebitCardData("Alex", "5454545454545454", "11", "2020", "123");

        verificationHelper.verifyPackagePurchase("Congratulations on choosing our Premium Flathunter plan for the property .");
        paymentsHelper.removePackage();
        verificationHelper.verifyPackageCanceled("Your subscription will not renew automatically.");
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test
    public void lordInWorldPaylistingEssen() {

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("Live-in landlord");

        signUpHelper.signListingFM_LiveIn("live-In1", "passwUniv",
                "5", "5", "1959", "55555555", "39", "Ronald");

        verificationHelper.verificationUserNameOnHomePage("Ronald");

        addPropertyHelper.addListingWithoutPhoto("SE1", "2", "4", "900");

        verificationHelper.verificationUserNameOnHomePage("Ronald");

        paymentsHelper.verificationPaymentPageFeatureListing("Want more from your listing? Upgrade now!");
        //paymentsHelper.selectPremiumFlathunterPlan();
        paymentsHelper.selectNLADiscount("NLA15", "EssentialPaymentForm");
        paymentsHelper.verificationPrice("1 month Essentials - "+"£"+"16.99", "EssentialPaymentForm");
        paymentsHelper.upgradeListing("Upgrade to Essentials", "Upgrade to Essentials");
        paymentsHelper.verificationCheckout("£"+"16.99 (monthly)");
        paymentsHelper.verificationCheckoutTotal("14.44");
        paymentsHelper.checkout();
        //paymentsHelper.choosePayPal();
        paymentsHelper.chooseWorldPay("or Credit / Debit Card");
        paymentsHelper.fillinDebitCardData("Alex", "5454545454545454", "11", "2020", "123");

        verificationHelper.verifyPackagePurchaseList("ideal flatmate Essentials");
        closeMatchPopUp();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.promoteCard();
        verificationHelper.packageOnCard("Essentials listing", "default");

        addPropertyHelper.openDropDownMenu();
        paymentsHelper.goToPaymentsTab();
        paymentsHelper.removePackage();
        verificationHelper.verifyPackageCanceled("Your subscription will not renew automatically.");

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseProfileFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }
    @Test
    public void lordOutWorldPaylistingPrem() {

        authorizationHelper.goToFMpage();

        authorizationHelper.clickCloseSignUp();

        addPropertyHelper.pressAddListingFromHeaderNotLoggedUser();
        addPropertyHelper.selectTypeUser("Live-out landlord");

        signUpHelper.signListingLiveOut("liv-Out1", "passwUniv",
                "2Ronald", "897876567");


        verificationHelper.verificationUserNameOnHomePage("2Ronald");

        verificationHelper.verifyAddListingPage();

        addPropertyHelper.addListingWithoutPhoto("SE1", "2", "3", "900");

        verificationHelper.verificationUserNameOnHomePage("2Ronald");

        addPropertyHelper.openDropDownMenu();
        paymentsHelper.goToPaymentsTab();

        paymentsHelper.verificationPaymentPageFeatureListing("Want more from your listing? Upgrade now!");
        //paymentsHelper.selectPremiumFlathunterPlan();
        paymentsHelper.selectNLADiscount("NLA15", "PremiumPaymentForm");
        paymentsHelper.verificationPrice("1 week Premium - "+"£"+"12.99", "PremiumPaymentForm");
        paymentsHelper.upgradeListing("Upgrade to Premium", "Upgrade to Premium");
        paymentsHelper.verificationCheckout("£"+"12.99 (week)");
        paymentsHelper.verificationCheckoutTotal("11.04");
        paymentsHelper.checkout();
        //paymentsHelper.choosePayPal();
        paymentsHelper.chooseWorldPay("or Credit / Debit Card");
        paymentsHelper.fillinDebitCardData("Alex", "5454545454545454", "11", "2020", "123");
        closeMatchPopUp();
        verificationHelper.verifyPackagePurchaseList("ideal flatmate Premium");

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.packageOnCard("Premium listing", "primary");

        addPropertyHelper.openDropDownMenu();
        paymentsHelper.goToPaymentsTab();
        paymentsHelper.removePackage();
        verificationHelper.verifyPackageCanceled("Your subscription will not renew automatically.");

        verificationHelper.verificationUserNameOnHomePage("2Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseProfileFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }




    @Test
    public void lordInWorldPaidListingProf() {

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();

        addPropertyHelper.selectTypeUser("Live-in landlord");

        signUpHelper.signListingFM_LiveIn("fmNotPaid4", "passwUniv",
                "5", "5", "1959", "55555555", "39", "Ronald");

        verificationHelper.verificationUserNameOnHomePage("Ronald");

        addPropertyHelper.addListingWithoutPhoto("m12", "2", "4", "900");

        verificationHelper.verificationUserNameOnHomePage("Ronald");

        paymentsHelper.verificationPaymentPageFeatureListing("Want more from your listing? Upgrade now!");
        //paymentsHelper.selectPremiumFlathunterPlan();
        paymentsHelper.upgradeListingProf("up to 5");
        paymentsHelper.verificationPrice("1 month - "+"£"+"44.99", "ProfessionalPaymentForm");
        paymentsHelper.upgradeListing("Upgrade to Professional", "Upgrade to Professional");
        paymentsHelper.verificationCheckout("£"+"44.99 (monthly)");
        paymentsHelper.verificationCheckoutTotal("44.99");
        paymentsHelper.checkout();
        //paymentsHelper.choosePayPal();
        paymentsHelper.chooseWorldPay("or Credit / Debit Card");
        paymentsHelper.fillinDebitCardData("Alex", "5454545454545454", "11", "2020", "123");
        closeMatchPopUp();

        verificationHelper.verifyPackagePurchaseList("ideal flatmate Professional");

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.packageOnCard("Free listing", "default");
        paymentsHelper.promoteCardClick("Promote");
        verificationHelper.packageOnCard("Premium listing", "primary");

        addPropertyHelper.openDropDownMenu();
        paymentsHelper.goToPaymentsTab();
        paymentsHelper.removePackage();
        verificationHelper.verifyPackageCanceled("Your subscription will not renew automatically.");

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseProfileFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }



    @Test
    public void agentProfWorldPay() {

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();

        addPropertyHelper.selectTypeUser("An agency");

        signUpHelper.agentSignListing("Ronald", "agent2", "passwUniv",
                "66666666", "Tell us about yourself");

        verificationHelper.verificationUserNameOnHomePage("Ronald");

        addPropertyHelper.openDropDownMenu();
        paymentsHelper.goToPaymentsTab();

        paymentsHelper.upgradeListingProf("1-2");
        paymentsHelper.verificationPrice("1 month - "+"£"+"34.99", "ProfessionalPaymentForm");
        paymentsHelper.selectNLADiscount("NLA15", "ProfessionalPaymentForm");
        paymentsHelper.upgradeListing("Upgrade to", "Professional");
        paymentsHelper.verificationCheckout("£"+"34.99 (monthly)");
        paymentsHelper.verificationCheckoutTotal("29.74");
        paymentsHelper.checkout();
        paymentsHelper.chooseWorldPay("or Credit / Debit Card");
        paymentsHelper.fillinDebitCardData("Alex", "5454545454545454", "11", "2020", "123");
        verificationHelper.verifyPackagePurchaseList("ideal flatmate Professional");
        //paymentsHelper.choosePayPal();

        addPropertyHelper.chooseListLoggedFromHeaderProfile();
        addPropertyHelper.addListingWithoutPhoto("m12", "2", "4", "900");

        addPropertyHelper.finishPropertyAgencyWithSubs("Your listing is now live!");

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.packageOnCard("Premium listing", "primary");
        paymentsHelper.promoteCardClick("Switch to Essentials");
        verificationHelper.packageOnCard("Essentials listing", "default");

        addPropertyHelper.openDropDownMenu();
        paymentsHelper.goToPaymentsTab();
        paymentsHelper.removePackage();
        verificationHelper.verifyPackageCanceled("Your subscription will not renew automatically.");

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseProfileFromDropDownMenu();
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");


    }

}
