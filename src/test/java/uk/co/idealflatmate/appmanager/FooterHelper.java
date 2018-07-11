package uk.co.idealflatmate.appmanager;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class FooterHelper {

    public void footerHome() {
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Home')]")).waitUntil(visible, 4000).click();
    }

    public void verificationFooterHome() {
        $(byXpath("//div[@class='homepage-quiz-container container']")).waitUntil(exist, 6000).should(exist);
    }

    public void footerAboutUs() {
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
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Press')]")).waitUntil(visible, 4000).click();
    }

    public void verificationFooterPress() {
        $(byXpath("//title[contains(text(), 'Press')]")).waitUntil(exist, 6000).should(exist);
    }

    public void footerPricing() {
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Pricing')]")).waitUntil(visible, 4000).click();
    }

    public void verificationFooterPricing() {
        $(byXpath("//title[contains(text(), 'Pricing')]")).waitUntil(exist, 6000).should(exist);
    }

    public void footerMedia() {
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Media')]")).waitUntil(visible, 4000).click();
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
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Blog')]")).waitUntil(visible, 4000).click();
    }

    public void footerBrowseFlatshares() {
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Browse Flatshares')]")).waitUntil(visible, 4000).click();
    }

    public void verificationBrowseFlatshares() {
        $(byXpath("(//li/a[contains(text(), 'Barnet')])[1]")).waitUntil(visible, 4000).click();
        $(byXpath("//h1[@class='text-white h2 u_m0-top' and contains(text(), 'Rooms To Rent In Barnet, North London')]")).waitUntil(exist, 6000).should(exist);
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Browse Flatshares')]")).waitUntil(visible, 4000).click();
        $(byXpath("(//li/a[contains(text(), 'Barnet')])[2]")).waitUntil(visible, 4000).click();
        $(byXpath("//h1[@class='text-white h2 u_m0-top' and contains(text(), 'Rooms To Rent In Barnet')]")).waitUntil(exist, 6000).should(exist);
    }

    public void footerHowItWorks() {
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'How it works')]")).waitUntil(visible, 4000).click();
    }

    public void verificationHowItWorks() {
        $(byXpath("//title[contains(text(), 'How it works')]")).waitUntil(exist, 6000).should(exist);
    }

    public void footerTipsWorks() {
        $(byXpath("//div[@class='col-sm-4 col-md-2 u_m20-bottom-xs']/ul/li/a[contains(text(), 'Tips')]")).waitUntil(visible, 4000).click();
    }

    public void verificationTipsWorks() {
        $(byXpath("//title[contains(text(), 'Tips')]")).waitUntil(exist, 6000).should(exist);
    }

    public void footerNLAWorks() {
        $(byXpath("//div[@class='col-md-6 hidden-xs hidden-sm text-right']/a")).waitUntil(visible, 4000).click();
    }

    public void verificationNLAWorks() {
        switchTo().window(0);
        $(byXpath("//a[@class='nav__link-1 has-children' and contains(text(), 'Join the NLA')]")).waitUntil(exist, 6000).should(exist);
    }
}
