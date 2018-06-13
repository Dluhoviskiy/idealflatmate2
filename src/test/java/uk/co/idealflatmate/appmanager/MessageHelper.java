package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.open;

public class MessageHelper {


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

    public void clickPropertyCardMessageUnlogged() {
        $(byXpath("//div[1]/div/div/a[@class='card-start-chat btn btn-circle']")).waitUntil(visible, 4000).click();
        $(byXpath("//div[@class='modal fade in'][1]//a[@class='btn btn-default u_m10-bottom-xs' and contains(text(), 'sign in')]")).waitUntil(visible, 4000).click();

    }

    public  void clickPropertyCardFirstOnPage(){
        $(byXpath("(//div[@class='owl-item active']/a/img)[1]")).waitUntil(visible, 4000).click();
    }

    public  void clickPropertyContact(){
        $(byXpath("//a[@class='btn btn-primary u_ed-block u_m20-top']")).waitUntil(visible, 4000).click();
    }


    public  void clickPropertyPageMessage(){
        $(byXpath("//a[@class='btn btn-primary u_ed-block u_m20-top'  and contains(text(), ' Message ')]")).waitUntil(visible, 4000).click();
    }

    public void clickFMCardMessageUnlogged() {

        $(byXpath("//div[1]/div/div/a[@class='card-start-chat btn btn-circle']")).click();
        $(byXpath("//div[@class='modal fade in'][1]//a[@class='btn btn-default u_m10-bottom-xs' and contains(text(), 'sign in')]")).waitUntil(visible, 4000).click();

    }

    public void clickFMCardFirstOnPage() {
        $(byXpath("((//div[@class='card-img'])[1])//img")).waitUntil(visible, 6000).click();
    }

    public void clickFMContact() {
        $(byXpath("//button[@class='btn btn-primary btn-lg u_m10-bottom u_ed-block-xs u_ed-block-lg']")).waitUntil(visible, 6000).click();
    }


    public void searchProperty(String postcode) {
        //click(byCssSelector("input#property-location"));
        $("input#property-location").waitUntil(visible, 4000).click();
        $("input#property-location").waitUntil(empty, 4000).setValue(postcode);
        sleep(4000);
        $(byXpath("//button[@class='btn btn-primary u_p60-left-sm u_p60-right-sm js-search-submit']")).waitUntil(visible, 4000).click();

    }

    public void clickCardMessageLogged() {
        $(byXpath("//a[@href='/conversation/contact?user_id=40037&property_id=16189']")).waitUntil(visible, 6000).click();

    }

    public void clickPropertyCardPagelogged() {
        $(byXpath("//a[@href='/spare-room/ipswich/property-id16189']")).waitUntil(visible, 6000).click();

    }

    public void clickPropertyCardFMnamePagelogged() {
        $(byXpath("//span[@class='card-top-username u_ed-block' and contains(text(), 'Dora Palmer')]")).waitUntil(visible, 6000).click();

    }

    public void clickFMPageMessage() {
        $(byXpath("//a[contains(text(), ' send message')][1]")).waitUntil(visible, 6000).click();

    }
}
