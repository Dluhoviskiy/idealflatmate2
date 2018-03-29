package uk.co.idealflatmate.tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PremiumFlathunterTests extends TestBase {

    @Test
    public void AbilityToSeePhone() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithPremiumFlathunterPackage();
        authorizationHelper.setPassword();
        $(byXpath("/html/body/header")).hover();
        $(byXpath("/html/body/header/div/ul[2]/li[2]/a")).click();

        $(byXpath("/html/body/header/div/ul[2]/li[2]/ul/li[1]/a")).click();

        $("#select2-property-location-container").click();

        $(".select2-search__field").setValue("SE1");
        $(".select2-results__option.select2-results__option--highlighted").click();
        $(byXpath("//*[@id=\"w0\"]/div[1]/div[6]/div/button[1]")).click();

        $("#property_14506").click();

        $(byXpath("//*[@id=\"property-infos\"]/div/div[2]/div[1]/div")).shouldBe(Condition.text("+4425646 XXXX"));

        $(byXpath("//*[@id=\"property-infos\"]/div/div[2]/div[1]/div/div[2]/button")).click();
        $(byXpath("//*[@id=\"property-infos\"]/div/div[2]/div[1]/div")).waitUntil(Condition.appears, 4000).shouldBe(Condition.text("+44256461312"));
    }





    //@Test
    public void BuyPremiumFlathunterpackage() {
        authorizationHelper.clickSignUpButton();
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
