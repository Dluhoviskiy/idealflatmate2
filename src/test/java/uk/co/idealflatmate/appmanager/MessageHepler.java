package uk.co.idealflatmate.appmanager;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MessageHepler {


    public void chooseAnyMessageFromList() {
        $(".list-group").click();
    }

    public void typeAndSendMessage() {
        $("#conversationmessage-message").setValue("Hi there! It looks great!");
        $(".btn.btn-primary.btn-msg-send").click();
    }

    public void chooseAnyMessageFromPopup() {
        $("#notifications").click();
    }

    public void click(By locator) {
        $(locator).click();
    }
    public void chooseMessageTab() {
        $(byXpath("/html/body/header/div/ul[2]/li[3]/a")).click();
    }

}
