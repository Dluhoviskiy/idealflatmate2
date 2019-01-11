package uk.co.idealflatmate.appmanager;

import org.testng.Assert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class FooterHelper {

    public void footerHome() {
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Home')]")).waitUntil(visible, 4000).click();
    }

    public void verificationFooterHome() {
        $(byXpath("//div[@class='homepage-quiz-container container']")).waitUntil(exist, 6000).should(exist);
    }

    public void footerAboutUs() {
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'About us')]")).waitUntil(visible, 8000).hover();
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'About us')]")).waitUntil(visible, 4000).click();
    }

    public void verificationFooterAboutUs() {
        $(byXpath("//title[contains(text(), 'About us')]")).waitUntil(exist, 6000).should(exist);
    }

    public void footerContact() {
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Contact')]")).waitUntil(visible, 4000).click();
    }

    public void verificationFooterContact() {
        $(byXpath("//title[contains(text(), 'Contact')]")).waitUntil(exist, 6000).should(exist);
    }

    public void footerPress() {
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Press')]")).waitUntil(visible, 8000).hover();
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Press')]")).waitUntil(visible, 4000).click();
    }

    public void verificationFooterPress() {
        $(byXpath("//title[contains(text(), 'Press')]")).waitUntil(exist, 6000).should(exist);
    }

    public void footerPricing() {
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Pricing')]")).waitUntil(visible, 10000).hover();
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Pricing')]")).waitUntil(visible, 10000).click();
    }

    public void verificationFooterPricing() {
        $(byXpath("//title[contains(text(), 'Pricing')]")).waitUntil(exist, 8000).should(exist);
    }

    public void footerMedia() {
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Media')]")).waitUntil(visible, 8000).hover();
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Media')]")).waitUntil(visible, 8000).click();
    }

    public void verificationFooterMedia() {
        $(byXpath("//title[contains(text(), 'Media')]")).waitUntil(exist, 6000).should(exist);
    }

    public void footerStaySafe() {
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Stay safe')]")).waitUntil(visible, 4000).click();
    }

    public void verificationFooterStaySafe() {
        $(byXpath("//title[contains(text(), 'Security warning')]")).waitUntil(exist, 6000).should(exist);
    }

    public void footerBlog() {

        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Blog')]")).waitUntil(visible, 10000).hover();
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Blog')]")).waitUntil(exist, 10000).click();
    }

    public void footerBrowseFlatshares() {
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Browse Flatshares')]")).waitUntil(visible, 4000).hover();
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Browse Flatshares')]")).waitUntil(visible, 4000).click();
    }

    public void verificationBrowseFlatshares(String location) {
        $(byXpath("//button[contains(., '" + location + "')]")).waitUntil(visible, 10000).click();
        $(byXpath("(//li/a[contains(text(), 'Brent Park')])[1]")).waitUntil(visible, 4000).click();
        switchTo().window(1);
        if($(byXpath("(//h4[contains(text(), 'Sign up to find flatmates')])[1]")).is(visible)){
            $(byXpath("(//button[@class='btn btn-sm btn-close close'])[3]")).waitUntil(appears, 4000).click();
            $(byXpath("//h1[@class='h4']")).waitUntil(exist, 6000).shouldHave(text("0 room matched to rent in and around Brent Park"));
        }else {
            $(byXpath("//h1[@class='h4']")).waitUntil(exist, 6000).shouldHave(text("0 room matched to rent in and around Brent Park"));
        }
    }

    public void footerHowItWorks() {
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'How it works')]")).waitUntil(visible, 4000).click();
    }

    public void verificationHowItWorks() {
        $(byXpath("//h2")).waitUntil(visible, 8000).shouldHave(text("How Ideal Flatmate Works"));
    }

    public void footerTipsWorks() {
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Tips')]")).waitUntil(visible, 8000).hover();
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Tips')]")).waitUntil(visible, 8000).click();
    }

    public void verificationTipsWorks() {
        $(byXpath("//title[contains(text(), 'Tips')]")).waitUntil(exist, 6000).should(exist);
    }

    public void footerNLAWorks() {
        $(byXpath("//div[@class='payment-logos']")).waitUntil(visible, 10000).hover();
        $(byXpath("//div[@class='payment-logos']")).waitUntil(visible, 10000).click();
        $(byXpath("//div[@class='row']//div[@class='col-md-6 hidden-xs hidden-sm text-right']//img")).hover();
        $(byXpath("//div[@class='row']//div[@class='col-md-6 hidden-xs hidden-sm text-right']//img")).waitUntil(visible, 8000).click();
    }

    public void verificationNLAWorks() {
        switchTo().window(0);
        $(byXpath("(//ul/li/a[contains(text(), 'Join the NLA')])[1]")).waitUntil(visible, 10000).hover();
        $(byXpath("(//ul/li/a[contains(text(), 'Join the NLA')])[1]")).waitUntil(visible, 10000).should(exist);
        sleep(3000);
    }

    public void footerFB() {
        $(byXpath("//img[@alt='Facebook']")).waitUntil(visible, 4000).hover();
        $(byXpath("//img[@alt='Facebook']")).waitUntil(visible, 4000).doubleClick();

    }

    public void verificationFB() {
        switchTo().window(1);
        String urlNla= url();
        String urlCurrent = "https://www.facebook.com/idealflatmate/";
        Assert.assertEquals(urlCurrent, urlNla);
        //$(byXpath("//a[@class='_64-f' and @href='https://www.facebook.com/idealflatmate/']")).shouldBe(visible);
        close();


    }

    public void footerTwitter() {
        $(byXpath("//img[@alt='Twitter']")).waitUntil(visible, 4000).click();
    }

    public void verificationTwitter() {
        switchTo().window(1);
        $(byXpath("//img[@class='ProfileAvatar-image ' and @alt='ideal flatmate']")).waitUntil(exist, 6000).should(exist);
        close();
    }

    public void footerInstagram() {
        $(byXpath("//img[@alt='Instagram']")).waitUntil(visible, 4000).click();
    }

    public void verificationInstagram() {
        switchTo().window(1);
        $(byXpath("(//h1)[1]")).waitUntil(exist, 6000).shouldHave(text("idealflatmate"));
        close();
    }

    public void footerYoutube() {
        $(byXpath("//img[@alt='YouTube']")).waitUntil(visible, 4000).click();
    }

    public void verificationYoutube() {
        switchTo().window(1);
        $(byXpath("//span[@id='channel-title' and contains(text(), 'ideal flatmate')]")).waitUntil(exist, 6000).should(exist);
        close();
    }

    public void footerAskLandlord() {
        $(byXpath("//a[@class='u_ed-block u_p5-top u_p5-bottom' and contains(., '#AskTheLandlord')]")).waitUntil(appear, 6000).click();
        $(byXpath("//a[@class='u_ed-block u_p5-top u_p5-bottom' and contains(., '#AskTheLandlord')]")).waitUntil(visible, 6000).click();

    }

    public void verificationAskLandlord() {
        switchTo().window(1);
        $(byXpath("//h1[contains(., '#AsktheLandlord')]")).should(exist);
        close();

    }

    public void footerModern() {
        sleep(5000);
        $(byXpath("//a[@class='u_ed-block u_p5-top u_p5-bottom' and contains(., 'Modern Living Index')]")).waitUntil(visible, 8000).hover();
        $(byXpath("//a[@class='u_ed-block u_p5-top u_p5-bottom' and contains(., 'Modern Living Index')]")).waitUntil(appear, 8000).click();

    }

    public void verificationModern() {
        switchTo().window(1);
        $(byXpath("//h1[contains(., 'Modern Living Index')]")).should(exist);
    }
}