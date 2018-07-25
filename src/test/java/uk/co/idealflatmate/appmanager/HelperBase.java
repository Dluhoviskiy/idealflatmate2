package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class HelperBase {

    public void fillInField(String email, SelenideElement selenideElement, String locator) {
        selenideElement.shouldBe(visible).click();
        $(locator).clear();
        //$(locator).shouldBe(visible);
        sleep(2000);
        $(locator).setValue(email);
    }

    public void gmailLogin(String email, String s, String s2) {
        $(byXpath(s)).waitUntil(appears, 4000).click();
        $(byXpath(s)).waitUntil(appears, 4000);
        $(byXpath(s)).shouldBe(visible);
        $(byXpath(s)).setValue(email);
        $(byXpath(s2)).click();
        sleep(2000);
    }
}
