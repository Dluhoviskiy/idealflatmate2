package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static groovy.xml.dom.DOMCategory.setValue;

public class PaymentsHelper extends HelperBase {

    public final AddPropertyHelper addPropertyHelper = new AddPropertyHelper();

    public void fillinDebitCardData(String name, String cardNumber, String month, String year, String cvc) {
        switchTo().frame("_iframe_holder");
        $(byXpath("//div[@id='_el_input_nameoncard']/input")).waitUntil(visible, 10000).click();
        $(byXpath("//div[@id='_el_input_nameoncard']/input")).clear();
        $(byXpath("//div[@id='_el_input_nameoncard']/input")).setValue(name);
        $(byXpath("//div[@id='_el_input_cardnumber']/input")).setValue(cardNumber);
        $(byXpath("//div[@id='_el_input_expirationmonth']/input")).setValue(month);
        $(byXpath("//div[@id='_el_input_expirationyear']/input")).setValue(year);
        $(byXpath("//div[@id='_el_input_cvc']/input")).setValue(cvc);
        addPropertyHelper.messageHelper.click(byXpath("//div[@id='_el_button_save']/button"));
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
        addPropertyHelper.messageHelper.click(byXpath("/html/body/header/div/ul[1]/li/a/img"));
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
        $(byXpath("//h2[@class='h3 u_m0-top-xs u_m20-top-sm u_m5-bottom']")).waitUntil(visible, 10000).shouldHave(text(text));
    }
    public void verificationPaymentPageFeatureListing(String text) {
        $(byXpath(" //h2[@class='h3 u_m0-top-xs u_m60-top-sm u_m5-bottom']")).waitUntil(visible, 10000).shouldHave(text(text));
    }


    public void verificationCheckout(String text) {
        $(byXpath("(//td[@class='u_p20-top text-primary'])[1]")).waitUntil(visible, 10000).shouldHave(text(text));
    }

    public void verificationCheckoutTotal(String text) {
        $(byXpath("//span[@id='total-price']")).waitUntil(visible, 10000).shouldHave(text(text));
    }

    public void selectNLADiscount(String NLA) {

        fillInField1(NLA, $(byXpath("(//input[@id='paymentform-discount'])[1]")), $(byXpath("(//input[@id='paymentform-discount'])[1]")));

    }

    public void upgradePremiumListing(String text) {
        $(byXpath("//button[@class='btn btn-block btn-primary'])[1]")).waitUntil(visible, 10000).shouldHave(text(text));

    }


    public void verificationPrice(String text) {
        $(byXpath("(//select[@id='paymentform-type_id'])[1]")).waitUntil(visible, 10000).shouldHave(text(text));

    }

    public void choosePayPal() {
        $(byXpath("//div[@class='panel-list-property_item panel-list-property_text u_p20-top u_p10-bottom']/img")).waitUntil(appears, 4000).click();
    }

    public void removePackage() {
        $(byXpath("(//a[contains(text(), 'Cancel')])[2]")).waitUntil(appears, 4000).click();
        $(byXpath("(//input[@type='radio'])[2]")).waitUntil(appear, 4000).selectRadio("1");
        $(byXpath("//button[@type='submitLogin' and contains(text(), 'Cancel')]")).waitUntil(Condition.appears, 4000).click();
    }
}
