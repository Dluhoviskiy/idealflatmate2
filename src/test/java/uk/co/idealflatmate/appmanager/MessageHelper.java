package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class MessageHelper extends HelperBase {


    public void chooseAnyMessageFromList() {

        //$(".list-group").shouldBe(Condition.visible).click();
        $(byXpath("//p[contains(text(), 'Hi there! It looks great!')]")).waitUntil(Condition.appears, 4000).click();
    }

    public void typeAndSendMessage(String message) {
        SelenideElement submit = $(byXpath("//button[@type='submit' and@class='btn btn-success btn-msg-send']"));

        $("textarea.form-control.msgbox").shouldBe(visible).setValue(message);

        if ($(byXpath("//img[@id='imgSrc']")).is(exist)) {
            $(byXpath("(//p[contains(text(), 'See the newest London')])[1]")).shouldBe(appear).hover();
            $(byXpath("//div[@id='idclose-headsup']")).shouldBe(visible).click();
            submit.shouldBe(visible).click();
        } else {
            submit.shouldBe(visible).click();
        }


    }

    public void chooseAnyMessageFromPopup() {
        $("#notifications").click();
    }

    public void click(By locator) {
        $(locator).click();
    }

    public void chooseMessageTab(final String massage) {
        //$(byXpath("/html/body/header/div/ul[2]/li[3]")).waitUntil(Condition.appears, 4000).click();
        $(byXpath("//a[@class='dropdown-toggle' and contains(text(), 'Messages')]")).waitUntil(Condition.appears, 4000).click();
            if ($(byXpath("//div[contains(text(), 'New messages')]")).isDisplayed()) {
                $(byXpath("//a[contains(text(), 'View all')]")).waitUntil(Condition.appears, 4000).click();
                $(byXpath("//p[contains(text(), '" + massage + "')]")).waitUntil(Condition.appears, 8000).click();
                    if ($(byXpath("//li/a[@page='2']")).isDisplayed()) {
                        $(byXpath("//li/a[@page='2']")).waitUntil(Condition.appears, 8000).click();
                        sleep(5000);
                        $(byXpath("//p[contains(text(), '" + massage + "')]")).waitUntil(Condition.appears, 8000).click();
                }
        }else{$(byXpath("//p[contains(text(), '" + massage + "')]")).waitUntil(Condition.appears, 8000).click();}
   }

    public void clickPropertyCardMessageUnlogged() {
        $(byXpath("(//h2)[4]")).hover();
        $$("a.card-start-chat.btn.btn-circle").get(3).click();

    }

    public  void clickPropertyCardFirstOnPage(){
        sleep(5000);
        $(byXpath("(//h2)[5]")).hover();
        sleep(1000);
        $(byXpath("(//div[@class='card-infos-left'])[1]")).click();

    }

    public  void clickPropertyContact(){
        sleep(2000);
        click(By.xpath("//li[@class='active']//a"));
        //$(byXpath("//section[@id='property-infos']//div[@id='fixed-sidebar']")).click();

        hoverClick("//section[@id='property-infos']//a[@class='btn btn-success u_ed-block u_m10-top text-18']");

    }


    public  void clickPropertyPageMessage(){
        sleep(2000);
        $(byXpath("//section[@id='property-infos']//" +
                "a[@class='btn btn-success u_ed-block u_m10-top text-18' and contains(., 'Request details')]")).waitUntil(visible, 4000).click();
    }

    public void clickFMCardMessageUnlogged() {

        $(byXpath("//div[1]/div/div/a[@class='card-start-chat btn btn-circle']")).shouldBe(visible).click();

    }

    public void clickFMCardFirstOnPage() {

        $(byXpath("((//div[@class='card-img'])[1])//img")).click();
    }

    public void clickFMContact() {
        $(byXpath("//a[starts-with(@class, 'btn btn-success')]")).waitUntil(visible, 6000).click();
    }




    public void clickCardMessageLogged() {
        $(byXpath("//div[contains(text(), 'Newport PO30 2DN, UK')]/../../../../a[@class='card-start-chat btn btn-circle']")).waitUntil(visible, 6000).click();

    }

    public void clickCardImgProperty() {
        sleep(3000);
        $(byXpath("//div[contains(text(), 'Newport PO30 2DN, UK')]/../../../../../..//picture/img")).click();
    }

    public void clickPropertyCardFMnamePagelogged() {
        $(byXpath("//span[@class='card-top-username u_ed-block' and contains(text(), 'Jason, 40')]")).waitUntil(visible, 6000).click();

    }

    public void clickFMPageMessage() {
        $(byXpath("//div[@class='col-sm-4 u_m20-bottom-xs']//a[contains(., 'Message')]")).waitUntil(visible, 6000).click();

    }

    public void clickUpgradeToMessage() {
        $(byXpath("//a[contains(text(), 'Upgrade to message')]")).waitUntil(visible, 6000).click();
    }

    public void clickPhoneReveal() {
        sleep(2000);
        click(By.xpath("//li[@class='active']//a"));
        //$(byXpath("//section[@id='property-infos']//div[@id='fixed-sidebar']")).click();
        $(byXpath("//section[@id='property-infos']//span[contains(text(), 'Reveal')]")).click();
        sleep(2000);
    }

    public void clickMessage(String text) {
         $(byText(text)).click();
    }

    public void clickMenuMessages() {
        $(byXpath("//span/a[contains(., 'Messages')]")).click();
    }

    public void photoOfOwnerInMessage(String photo1) {
        if (photo1.endsWith("no-image-initial.jpg")) {
            String photo2 = photo1.substring(0, 64);
            String messagePhoto = $(byXpath("//div[@class='circle-card-img']/ img")).getAttribute("src").substring(0, 64);
            Assert.assertEquals(photo2, messagePhoto);
        } else {
            String photo2 = photo1.substring(0, 73);
            String messagePhoto = $(byXpath("//div[@class='circle-card-img']/ img")).getAttribute("src").substring(0, 73);
            Assert.assertEquals(photo2, messagePhoto);

        }
    }

    public void photoOfOwnerInMesBuddy_up(String photo1) {
        if (photo1.endsWith("no-image-initial.jpg")) {
            String photo2 = photo1.substring(0, 64);
            String messagePhoto = $(byXpath("//section[@id='property-infos']//div[@id='fixed-sidebar']//a/ img")).getAttribute("src").substring(0, 64);
            Assert.assertEquals(photo2, messagePhoto);
        } else {
            String photo2 = photo1.substring(0, 73);
            String messagePhoto = $(byXpath("//section[@id='property-infos']//div[@id='fixed-sidebar']//a/ img")).getAttribute("src").substring(0, 73);
            Assert.assertEquals(photo2, messagePhoto);

        }
    }

        public void nameOfOwnerInMessage (String name1){
            String name2 = (name1.split(","))[0].replaceAll("/,",  "");

            String nameInMessage = $(byXpath("//span/strong")).getText();
            String nameInMessage1 = (nameInMessage.split("\\|"))[0].replaceAll("\\|",  "");
            //String nameInMessage1 = (nameInMessage.replaceAll("\\|",  ""));
            Assert.assertEquals(name2, nameInMessage1);

        }

    public void messageVerifying(String message1) {
        //String messagePlaceholder = $("textarea#messagewritesignupform-message").text();
        //String name2 = (name1.substring(0, 1).toUpperCase() + name1.substring(1));
        //String name3 =(name2.split(","))[0].replaceAll("/,",  "");
        String messageInbox = $(byXpath("//div[@class='msg-body']")).text();
        Assert.assertEquals(message1, messageInbox);
    }

    public void clickMessage1Inbox() {
        $(byXpath("//div[@class='text-14 u_m15-left u_m5-top-sm u_m10-top-lg'][1]")).click();
    }

    public void propertyPostcodeVerifying(String postCode) {
        String messageInbox = $(byXpath("//section//div[h2[contains(.,'Location')]]//p")).text();
        messageInbox.endsWith(postCode);
    }

    public void propertyPostcodeVerifMes(String postCode) {
        String messageInbox = $(byXpath("//select[@id='property-select']//optgroup/option")).text();
        //Assert.assertEquals(messageInbox, postCode);
        messageInbox.endsWith(postCode);
    }

    public void verifyNoProperties(String text) {
        $(byXpath("//select[@id='property-select']/option")).shouldHave(text(text));
    }


    public void sendDecline(String text) {
        $(byXpath("//button[@class='btn-cancel']")).click();
        $(byXpath("//button[@class='btn btn-success']")).click();
        sleep(5000);
        $(byXpath("(//div[@class='msg msg-host msg-sent'][last()]//span[last()])[2]")).shouldHave(text(text)).click();
        sleep(6000);
    }

    public void closeIntrodGroupsPopup() {
        $(byXpath("//div[@id='introducingBuddyUpGroupModal']//div[@class='btn btn-sm close']")).click();
    }
}