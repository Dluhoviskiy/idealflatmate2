package uk.co.idealflatmate.appmanager;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class EmailHelper {

    public void openGmailPage() {
        if($(byXpath("//div[@class='ub-emb-iframe-wrapper ub-emb-visible']")).is(exist)) {
            //sleep(4000);
            $(byXpath("(//button[@class='ub-emb-close'])[1]")).waitUntil(appears, 4000).click();
            // sleep(4000);
            open("https://mail.google.com/");
        }else {
            open("https://mail.google.com/");
        }
    }
    public void setLoginAsUserEmail(String email) {
        $(byXpath("//input[@type='email']")).waitUntil(appears, 4000).click();
        $(byXpath("//input[@type='email']")).waitUntil(appears, 4000);
        $(byXpath("//input[@type='email']")).shouldBe(visible);
        $(byXpath("//input[@type='email']")).setValue(email);
        $(byXpath("(//content[@class='CwaK9'])[3]/span")).click();
        sleep(2000);
    }
    public void setLoginAsUserPassword(String password) {
        $(byXpath("//input[@type='password']")).waitUntil(appears, 4000).click();
        $(byXpath("//input[@type='password']")).waitUntil(appears, 4000);
        $(byXpath("//input[@type='password']")).shouldBe(visible);
        $(byXpath("//input[@type='password']")).setValue(password);
        $(byXpath("(//content[@class='CwaK9'])[1]/span")).click();
        sleep(2000);
    }

    public void enterEmail() {
        $(byXpath("(//content[@class='CwaK9'])[2]/span")).waitUntil(visible, 6000).click();
    }
    public void enterInbox() {
        $(byXpath("(//span[starts-with(@class, 'nU ')])[1]")).waitUntil(visible, 6000).click();
    }

    public void verificationWelcome() {
        $(byXpath("(//tbody)[5]/tr[td/span[contains (text(), ':')]]")).shouldHave((text("Welcome to Ideal Flatmate!")));

    }
    public void verificationListingisLive() {
        $(byXpath("(//tbody)[5]/tr[td/span/b[contains (text(), ':')]]")).shouldHave((text("Congratulations! Your listing on Ideal Flatmate is live!")));
    }
    public void verificationMessage() {
        $(byXpath("(//tbody)[5]/tr[td/span/b[contains (text(), ':')]]")).shouldHave((text("You have a new message!")));
    }

    public void verificationNoListingisLive() {
        $(byXpath("(//tbody)[5]")).shouldNotHave((text("Congratulations! Your listing on Ideal Flatmate is live!")));
    }
    public void verificationNoWelcome() {
        $(byXpath("(//tbody)[5]")).shouldNotHave((text("Welcome to Ideal Flatmate!")));
    }
    public void verificationNoMessageEmail() {
        $(byXpath("(//tbody)[5]")).shouldNotHave((text("You have a new message!")));
    }

    public void tipCheckboxWelcome() {
        $(byXpath("//b[contains(text(), ':')]//ancestor::tr//div[span[contains(text(), 'Welcome')]][1]//ancestor::tr//td/div[@role='checkbox']")).waitUntil(visible, 6000).click();
    }
    public void tipCheckboxListingisLive() {
        $(byXpath("//b[contains(text(), ':')]//ancestor::tr//td//div//span[contains(text(), 'Congratulations')]//ancestor::tr//td/div[@role='checkbox']")).waitUntil(visible, 6000).click();
    }

    public void tipCheckboxMessage() {
        $(byXpath("//span/b[contains(text(), ':')]//ancestor::tr//div//span/b[contains(text(), 'You have')]//ancestor::tr//td/div[@role='checkbox']")).waitUntil(visible, 6000).click();
    }

    public void removeEmail() {
        $(byXpath("//div[@class='ar9 T-I-J3 J-J5-Ji']")).waitUntil(visible, 6000).click();
    }



}
