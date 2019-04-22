package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static uk.co.idealflatmate.appmanager.SearchHelper.getNumberOfListing;

public class FooterHelper extends HelperBase{


    public void verificationFooterHome() {
        $(byXpath("//div[@class='homepage-quiz-container container']")).waitUntil(exist, 6000).should(exist);
    }

    public void verificationBrowseFlatshares(String location, String area, final String searchText, final String text, final String rooms) {
        $(byXpath("//a/strong[contains(., '"+location+"')]")).click();
        $(byXpath("//a/strong[contains(., '"+area+"')]")).click();

        clickButton(searchText, "a");
        closeAdvPopUp();
        //switchTo().window(1);
        $(byXpath("//h1[@class='h4']")).shouldHave(text(text + getNumberOfListing() + rooms + area));


    }
    public static int propertyCardOnPage() {
        int propertyCardOnPage = $$(byXpath("//div[@class='cards-container']/div[@id]")).size();
        return propertyCardOnPage;
    }


    public void verificationHowItWorks() {
        $(byXpath("//h2")).waitUntil(visible, 10000).shouldHave(text("How Ideal Flatmate Works"));
    }

    public SelenideElement verificationHowItWorks1(String text) {
        return $(byXpath("//h2")).waitUntil(visible, 8000).shouldHave(text(text));

    }

    public void verificationTipsWorks() {
        $(byXpath("//title[contains(text(), 'Tips')]")).waitUntil(exist, 6000).should(exist);
    }

    public void footerNLAWorks() {

        hoverClick("//div[@class='payment-logos']");
        hoverClick("//div[@class='row']//div[@class='col-md-6 hidden-xs hidden-sm text-right']//img");

    }

    public void verificationNLAWorks() {
        switchTo().window(0);
        hoverCShouldExist("(//ul/li/a[contains(text(), 'Join the NLA')])[1]");

        sleep(3000);
    }

    public void footerFB() {

        hoverClick("//img[@alt='Facebook']");

    }

    public void verificationFB() {
        switchTo().window(1);
        String urlNla= url();
        String urlCurrent = "https://www.facebook.com/idealflatmate/";
        Assert.assertEquals(urlCurrent, urlNla);
        //$(byXpath("//a[@class='_64-f' and @href='https://www.facebook.com/idealflatmate/']")).shouldBe(visible);
        toHomePage();


    }

    public void footerTwitter() {
        $(byXpath("//img[@alt='Twitter']")).waitUntil(visible, 4000).click();
    }

    public void verificationTwitter() {
        switchTo().window(1);
        $(byXpath("//img[@class='ProfileAvatar-image ' and @alt='ideal flatmate']")).waitUntil(exist, 30000).should(exist);
    }

    public void footerInstagram() {
        $(byXpath("//img[@alt='Instagram']")).waitUntil(visible, 4000).click();
    }

    public void verificationInstagram() {
        switchTo().window(1);
        $(byXpath("(//h1)[1]")).waitUntil(exist, 30000).shouldHave(text("idealflatmate"));

    }

    public void footerYoutube() {
        $(byXpath("//img[@alt='YouTube']")).waitUntil(visible, 4000).click();
    }

    public void verificationYoutube() {
        switchTo().window(1);
        $(byXpath("//span[@id='channel-title' and contains(text(), 'ideal flatmate')]")).waitUntil(exist, 30000).should(exist);

    }


    public void verificationAskLandlord() {
        switchTo().window(1);
        $(byXpath("//h1[contains(., '#AsktheLandlord')]")).should(exist);


    }

    public void verificationModern() {
        switchTo().window(1);
        $(byXpath("//h1[contains(., 'Modern Living Index')]")).should(exist);

    }

    public void footerClick(String item) {

        sleep(2000);
        hoverClick("//a[@class='u_ed-block u_p5-top u_p5-bottom' and contains(., '" + item + "')]");

    }

    public void verificationFooter(String titleItem) {
        $(byXpath("//title[contains(text(), '" + titleItem + "')]")).waitUntil(exist, 10000).should(exist);
    }
//pageobject
    /*
    public SelenideElement verificationHowItWorks1(String text) {
        return $(byXpath("//h2")).waitUntil(visible, 8000).shouldHave(text(text));

    }*/
}