package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;

public class PaymentsHelper extends HelperBase {

    public final AddPropertyHelper addPropertyHelper = new AddPropertyHelper();

    public void fillinDebitCardData(String name, String cardNumber, String month, String year, String cvc) {
        switchTo().frame("_iframe_holder");

        //fillInField(name, $(byXpath("//div[@id='_el_input_nameoncard']/input))")));
        $(byXpath("//div[@id='_el_input_nameoncard']/input")).setValue(name);
        sleep(1000);
        $(byXpath("//div[@id='_el_input_cardnumber']/input")).setValue(cardNumber);
        sleep(1000);
        $(byXpath("//div[@id='_el_input_expirationmonth']/input")).setValue(month);
        sleep(1000);
        $(byXpath("//div[@id='_el_input_expirationyear']/input")).setValue(year);
        sleep(1000);
        $(byXpath("//div[@id='_el_input_cvc']/input")).setValue(cvc);
        sleep(1000);
        addPropertyHelper.messageHelper.click(byXpath("//div[@id='_el_button_save']/button"));
        sleep(3000);
    }

    public void chooseWorldPay(String text) {
        $(byText(text)).click();
    }

    public void upgradePremiumFH() {
        addPropertyHelper.messageHelper.click(byXpath("//button[contains(text(), 'Upgrade to Premium Flathunter')]"));
    }

    public void checkout() {
        addPropertyHelper.messageHelper.click(byXpath("//button[contains(text(), 'Check out')]"));
    }

    public void selectPremiumFlathunterPlan() {
        addPropertyHelper.messageHelper.click(byXpath("//*[@id=\"ProfessionalPaymentForm\"]/div/table/tbody/tr[4]/td/button"));
    }

    public void goToPaymentsTab() {

        addPropertyHelper.messageHelper.click(byXpath("//span[contains(text(), ' Payments')]"));
    }

    public void verificationPhone(String text) {
        $(byXpath("//section[@id='property-infos']//span[@class='property-phone_hide js-phone-box']")).waitUntil(visible, 10000).shouldHave(text(text));
    }

    public void verificationPremiumPopup(String text) {
        $(byXpath("//h4[@class='modal-title']")).waitUntil(visible, 10000).shouldHave(text(text));
    }

    public void closePremiumPopup() {

        $(byXpath("(//button[@class='btn btn-sm btn-close close'])[3]")).waitUntil(appears, 4000).click();
    }

    public void verificationPhoneVisible(String number) {
        $(byXpath("(//span[@class='property-phone_reveal']/a)[2]")).waitUntil(visible, 10000).shouldHave(text(number));

    }

    public void clickUpgradePremiumFH(String text) {
        $(byText(text)).click();

    }

    public void verificationPaymentPage(String text) {
        $(byXpath("//h3[@class='text-18 u_m0 ']")).waitUntil(visible, 10000).shouldHave(text(text));
    }

    public void verificationPaymentPageFeatureListing(String text) {
        $(byXpath("//h2[@class='text-18 u_m0-top u_m30-bottom']")).waitUntil(visible, 10000).shouldHave(text(text));
    }


    public void verificationCheckout(String text) {
        $(byXpath("(//td[@class='u_p20-top text-primary'])[1]")).getText().contentEquals(text);
    }

    public void verificationCheckoutTotal(String text) {
        $(byXpath("//span[@id='total-price']")).waitUntil(visible, 10000).shouldHave(text(text));
    }

    public void verificationCheckoutNewTotal(String price) {
        $(byXpath("//p/strong[contains(.,'"+price+"')]")).should(exist);
    }

    public void selectNLADiscount(String NLA, String payment) {

        fillInField(NLA, $(byXpath("//form[@id='" + payment + "']//input[@id='paymentform-discount']")));

    }

    public void upgradeListing(String text, String upgradeTo) {
        $(byXpath("//button[contains(.,'" + upgradeTo + "')]")).waitUntil(visible, 10000).shouldHave(text(text)).click();
        sleep(3000);
    }

    public void upgradeListingProfNew(String option) {
        $(byXpath("//select[@id='js-professional-properties-list']")).selectOptionContainingText(option);

    }

    public void upgradeListingProfOld(String option) {
        $(byXpath("//select[@class='form-control pro-property-no']")).selectOptionContainingText(option);

    }

    public void priceVerifPaymentSystemPage(final  String priceProfIs) {
        $(byXpath("//span[@id='professional-big-price']")).shouldHave(text(priceProfIs));
    }

    public void promoteCardClick(String text) {
        $(byXpath("//a[contains(.,'" + text + "')]")).click();
    }

    public void choosePrice(String value, String formPayment) {
        $(byXpath("//form[@id='" + formPayment + "']//select[@id='paymentform-type_id']")).waitUntil(visible, 10000).selectOptionByValue(value);


    }

    public void choosePayPal() {
        $(byXpath("//div[@class='panel-list-property_item panel-list-property_text u_p20-top u_p10-bottom']/img")).waitUntil(appears, 4000).click();
    }

    public void removePackage() {
        $(byXpath("(//a[contains(text(), 'Cancel')])[2]")).waitUntil(appears, 4000).click();
        sleep(1000);
        $(byXpath("(//input[@type='radio'])[2]")).waitUntil(appear, 4000).selectRadio("1");
        sleep(1000);
        $(byXpath("//button[@id='btn-cancel-subscription']")).waitUntil(Condition.appears, 10000).click();
        sleep(1000);
    }

    public void clickPlan(final String plan) {
        $(byXpath("//a[@class='js-duration' and contains(.,'"+plan+"')]")).click();

    }

    public void defaultPlanActiveIs(String plan,final String priceEssenIs, final String pricePremIs,
                                         final String priceProfIs) {
        sleep(2000);
        $(byXpath("//a[contains(@class,'js-duration active') and contains(.,'"+plan+"')]")).should(exist);
        $(byXpath("//span[@id='essentials-big-price' and contains(.,'"+priceEssenIs+"')]")).should(exist);
        $(byXpath("//span[@id='premium-big-price' and contains(.,'"+pricePremIs+"')]")).should(exist);
        if($(byXpath("//a[contains(@class,'js-duration active') and contains(.,'Monthly')]")).exists()){
        $(byXpath("//span[@id='professional-big-price' and contains(.,'"+priceProfIs+"')]")).should(exist);}
        else if($(byXpath("//a[contains(@class,'js-duration active') and contains(.,'Weekly')]")).exists()){
            $(byXpath("//form[@id='ProfessionalPaymentForm' and @class='col-sm-4 col-xs-12 js-plan-block" +
                    " plan-block disabled']")).should(exist);}
    }

    public void defaultPlanProf(final String priceProfIs) {
        $(byXpath("//form[@id='PremiumPaymentForm' and @class='col-sm-4 col-xs-12 js-plan-block plan-block disabled']")).should(exist);
        $(byXpath("//form[@id='EssentialPaymentForm' and @class='col-sm-4 col-xs-12 js-plan-block plan-block disabled']")).should(exist);
        $(byXpath("//span[@id='professional-big-price']")).shouldHave(text(priceProfIs));
    }


    public void clickSelectPlan(final String plan, final String tag) {
        $(byXpath("//form[@id='" + plan + "PaymentForm']//" + tag + "[contains(.,'Select plan')]")).click();
    }
}
