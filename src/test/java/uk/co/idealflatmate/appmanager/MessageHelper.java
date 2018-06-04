package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

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
        $(byXpath("//button[@class='btn btn-primary btn-lg u_m10-bottom u_ed-block']")).waitUntil(visible, 4000).click();
    }


    public void clickFMCardMessageUnlogged() {

        $(byXpath("//div[1]/div/div/a[@class='card-start-chat btn btn-circle']")).click();
        $(byXpath("//div[@class='modal fade in'][1]//a[@class='btn btn-default u_m10-bottom-xs' and contains(text(), 'sign in')]")).waitUntil(visible, 4000).click();

    }

    public void clickFMCardFirstOnPage() {
        $(byXpath("(//div[@class='card card-flatmate cards-container ']/div/div[2]/a[2]/img)[1]")).waitUntil(visible, 4000).click();
    }

    public void clickFMContact() {
        $(byXpath("//button[@class='btn btn-primary btn-lg u_m10-bottom u_ed-block-xs u_ed-block-lg']")).waitUntil(visible, 4000).click();
    }


}
