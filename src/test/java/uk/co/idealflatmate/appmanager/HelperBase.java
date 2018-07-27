package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class HelperBase {

    public void fillInField(String email, SelenideElement selenideElement, String locator) {
        sleep(1000);
        selenideElement.waitUntil(visible, 20000).click();
        $(locator).clear();
        sleep(1000);
        $(locator).setValue(email);
    }

    public void gmailLogin(String email, String field, String next) {
        $(byXpath(field)).waitUntil(appears, 4000).click();
        $(byXpath(field)).waitUntil(appears, 4000);
        $(byXpath(field)).shouldBe(visible);
        $(byXpath(field)).setValue(email);
        $(byXpath(next)).click();
        sleep(2000);
    }

    protected void fillInField1(String nla, SelenideElement $, SelenideElement $1) {
    }
}
