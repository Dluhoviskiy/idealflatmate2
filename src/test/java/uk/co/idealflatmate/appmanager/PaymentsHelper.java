package uk.co.idealflatmate.appmanager;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PaymentsHelper {

    public final AddPropertyHelper addPropertyHelper = new AddPropertyHelper();

    public void fillinDebitCardData(String name, String cardNumber, String month, String year, String cvc) {
        $(byXpath("//*[@id=\"_el_input_nameoncard\"]/input")).setValue(name);
        $(byXpath("//*[@id=\"_el_input_cardnumber\"]/input")).setValue(cardNumber);
        $(byXpath("//*[@id=\"_el_input_expirationmonth\"]/input")).setValue(month);
        $(byXpath("//*[@id=\"_el_input_expirationyear\"]/input")).setValue(year);
        $(byXpath("//*[@id=\"_el_input_cvc\"]/input")).setValue(cvc);
        addPropertyHelper.messageHelper.click(byXpath("//*[@id=\"_el_button_save\"]/button"));
    }

    public void chooseWorldPay() {
        addPropertyHelper.messageHelper.click(byXpath("/html/body/div[3]/div/div[2]/div[3]/a[1]/div[1]"));
    }

    public void startCheckout() {
        addPropertyHelper.messageHelper.click(byXpath("//*[@id=\"paymentForm\"]/div[2]/div[2]/button"));
    }

    public void selectPremiumFlathunterPlan() {
        addPropertyHelper.messageHelper.click(byXpath("//*[@id=\"ProfessionalPaymentForm\"]/div/table/tbody/tr[4]/td/button"));
    }

    public void goToPaymentsTab() {
        addPropertyHelper.messageHelper.click(byXpath("/html/body/header/div/ul[1]/li/a/img"));
        addPropertyHelper.messageHelper.click(byXpath("/html/body/header/div/ul[1]/li/ul/li[11]/a"));
    }
}
