package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class HelperBase {

    public void signIn(String email, SelenideElement selenideElement, String locator) {
        selenideElement.shouldBe(visible).click();
        $(locator).clear();
        //$(locator).shouldBe(visible);
        sleep(2000);
        $(locator).setValue(email);
    }
}
