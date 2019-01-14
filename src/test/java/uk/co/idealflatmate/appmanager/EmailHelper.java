package uk.co.idealflatmate.appmanager;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class EmailHelper extends HelperBase {

    public final VerificationHelper verificationHelper = new VerificationHelper();

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
        gmailLogin(email, "//input[@type='email']", "//span[@class='RveJvd snByac' and contains(.,'Далі')]");
    }

    public void setLoginAsUserPassword(String password) {
        gmailLogin(password, "//input[@type='password']", "(//content[@class='CwaK9'])[1]/span");
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
        $(byXpath("//span[contains(text(), 'AM') or contains(text(), 'PM')]//ancestor::tr//div[span[contains(text(), 'Welcome')]][1]//ancestor::tr//td/div[@role='checkbox']")).waitUntil(visible, 6000).click();
        sleep(2000);
    }
    public void tipCheckboxListingisLive() {
        $(byXpath("//span[contains(text(), 'AM') or contains(text(), 'PM')]//ancestor::tr//td//div//span[contains(text(), 'Congratulations')]//ancestor::tr//td/div[@role='checkbox']")).waitUntil(visible, 6000).click();
        sleep(2000);
    }

    public void tipCheckboxMessage() {
        $(byXpath("//span[contains(text(), 'AM') or contains(text(), 'PM')]//ancestor::tr//div//div//span[contains(text(), 'You have a new message!')]//ancestor::tr//td/div[@role='checkbox']")).waitUntil(visible, 6000).click();
        sleep(2000);
    }

    public void tipCheckboxEnquiry() {
        $(byXpath("//span[contains(text(), 'AM') or contains(text(), 'PM')]//ancestor::tr//div//div//span[contains(text(), 'You have a new enquiry!')]//ancestor::tr//td/div[@role='checkbox']")).waitUntil(visible, 6000).click();
        sleep(2000);
    }

    public void tipCheckboxPremiumFHSubscription() {
        $(byXpath("//span[contains(text(), 'AM') or contains(text(), 'PM')]//ancestor::tr//div//span[contains(text(), 'Premium Flathunter Subscription created')]//ancestor::tr//td/div[@role='checkbox']")).waitUntil(visible, 6000).click();
        sleep(2000);
    }
    public void tipCheckboxPremiumFHSubscriptionCanceled() {
        $(byXpath("//span[contains(text(), 'AM') or contains(text(), 'PM')]//ancestor::tr//div//span[contains(text(), 'Premium Flathunter Subscription cancelled')]//ancestor::tr//td/div[@role='checkbox']")).waitUntil(visible, 6000).click();
        sleep(2000);
    }

    public void removeAllEmails() {
        $(byXpath("//div[@class='AO']/..//div[@class='ar9 T-I-J3 J-J5-Ji']")).waitUntil(visible, 15000).click();
        sleep(2000);
    }

    public void verificationPageAfterSignUp() {
        $(byXpath("//h4[contains(text(), 'Please Verify Your Email to Continue')]")).shouldBe(visible);
        $(byXpath("(//button[@class='btn btn-sm btn-close close'])[4]")).waitUntil(visible, 6000).click();
    }
    public void verificationPageAfterSignUpListing() {
        $(byXpath("//div[contains(text(), 'Please check your inbox and follow the instructions.')]")).shouldBe(visible);
    }

    public void accountConfirm() {

        open("https://mail.google.com/");
        setLoginAsUserEmail("cro.gen.idealflatmate@gmail.com");
        setLoginAsUserPassword("qqqqqq666D");
        enterInbox();
        openEmail();
        clickLinkInEmail();
       // tipCheckboxConfirm();
       // removeAllEmails();
    }

    private void tipCheckboxConfirm() {
        $(byXpath("//span/b[contains(text(), ':')]//ancestor::tr//div//span/b[contains(text(), 'Account')]//ancestor::tr//td/div[@role='checkbox']")).waitUntil(visible, 6000).click();
    }

    public void openEmail() {
        $(byXpath("//b[contains(text(), ':')]//ancestor::tr//td//span//b[contains(text(), 'Ideal Flatmate - Account confirmation')]")).waitUntil(visible, 6000).click();
        sleep(2000);
    }

    public void clickLinkInEmail() {
        if($(byXpath(("//div[@data-tooltip='Show trimmed content']"))).is(visible)) {
            $(byXpath(("//div[@data-tooltip='Show trimmed content']"))).waitUntil(visible, 6000).click();
            sleep(2000);
            $(byXpath(("//a[contains(text(), 'Confirm registration')]"))).waitUntil(visible, 6000).click();
            sleep(2000);
        }else {
            $(byXpath(("//a[contains(text(), 'Confirm registration')]"))).waitUntil(visible, 6000).click();
            sleep(2000);
        }


    }
    public void verificationSuccessfulLogin() {
        switchTo().window(1);
        $(byXpath("//div[@id='w0-success-0']")).waitUntil(appear, 6000).shouldHave(text("Email verified successfully!"));
        }

    public void clickContinue() {
        $(byXpath("//a[contains(text(), 'Continue')]")).waitUntil(visible, 6000).click();
        sleep(2000);
    }
    public void emailVerification(String Name) {
        verificationPageAfterSignUp();
        accountConfirm();
        verificationSuccessfulLogin();
        verificationHelper.verificationUserNameOnHomePage(Name);
        clickContinue();
    }


}
