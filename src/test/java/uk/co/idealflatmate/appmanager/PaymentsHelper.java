package uk.co.idealflatmate.appmanager;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PaymentsHelper {

    public final AddPropertyHelper addPropertyHelper = new AddPropertyHelper();

    public void fillinDebitCardData() {
        $(byXpath("//*[@id=\"_el_input_nameoncard\"]/input")).setValue("Alex");
        $(byXpath("//*[@id=\"_el_input_cardnumber\"]/input")).setValue("4444333322221111");
        $(byXpath("//*[@id=\"_el_input_expirationmonth\"]/input")).setValue("11");
        $(byXpath("//*[@id=\"_el_input_expirationyear\"]/input")).setValue("2020");
        $(byXpath("//*[@id=\"_el_input_cvc\"]/input")).setValue("123");
        addPropertyHelper.messageHepler.click(byXpath("//*[@id=\"_el_button_save\"]/button"));


    }

    public void chooseWorldPay() {
        addPropertyHelper.messageHepler.click(byXpath("/html/body/div[3]/div/div[2]/div[3]/a[1]/div[1]"));
    }

    public void startCheckout() {
        addPropertyHelper.messageHepler.click(byXpath("//*[@id=\"paymentForm\"]/div[2]/div[2]/button"));
    }

    public void selectPremiumFlathunterPlan() {
        addPropertyHelper.messageHepler.click(byXpath("//*[@id=\"ProfessionalPaymentForm\"]/div/table/tbody/tr[4]/td/button"));
    }

    public void goToPaymentsTab() {
        addPropertyHelper.messageHepler.click(byXpath("/html/body/header/div/ul[1]/li/a/img"));
        addPropertyHelper.messageHepler.click(byXpath("/html/body/header/div/ul[1]/li/ul/li[11]/a"));
    }
}
