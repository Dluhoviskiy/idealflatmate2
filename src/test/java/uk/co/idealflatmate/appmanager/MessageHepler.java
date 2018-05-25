package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MessageHepler {


    public void chooseAnyMessageFromList() {

        //$(".list-group").shouldBe(Condition.visible).click();
        $(byXpath("//p[contains(text(), 'Hi there! It looks great!')]")).waitUntil(Condition.appears, 4000).click();
    }

    public void typeAndSendMessage(String message) {
        $("#conversationmessage-message").setValue(message);
        $(".btn.btn-primary.btn-msg-send").click();
    }

    public void chooseAnyMessageFromPopup() {
        $("#notifications").click();
    }

    public void click(By locator) {
        $(locator).click();
    }

    public void chooseMessageTab() {
        //$(byXpath("/html/body/header/div/ul[2]/li[3]")).waitUntil(Condition.appears, 4000).click();
        $(byXpath("//a[@class='dropdown-toggle' and contains(text(), 'Messages')]")).waitUntil(Condition.appears, 4000).click();
        $(byXpath("//a[@class='text-normal']")).waitUntil(Condition.appears, 4000).click();
        $(byXpath("//p[contains(text(), 'Test Upgrade')]")).waitUntil(Condition.appears, 4000).click();
    }

    public  void clickCardMessage(){

    }

}
