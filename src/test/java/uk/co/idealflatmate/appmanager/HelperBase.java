package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HelperBase {

    public void signIn(String email, SelenideElement selenideElement, String locator) {
        selenideElement.waitUntil(visible, 8000).click();
        $(locator).waitUntil(appears, 4000).clear();
        $(locator).shouldBe(visible);
        $(locator).setValue(email);
    }
}
