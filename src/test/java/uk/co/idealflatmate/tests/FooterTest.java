package uk.co.idealflatmate.tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class FooterTest extends TestBase {

    @Test(priority = 1)
    public void footerHomeLink() {

        footerHelper.footerHome();
        footerHelper.verificationFooterHome();
    }

    @Test(priority = 1)
    public void footerAboutUsLink() {

        footerHelper.footerAboutUs();
        footerHelper.verificationFooterAboutUs();
    }

    @Test(priority = 1)
    public void footerContactLink() {

        footerHelper.footerContact();
        footerHelper.verificationFooterContact();
    }

    @Test(priority = 1)
    public void footerPressLink() {

        footerHelper.footerPress();
        footerHelper.verificationFooterPress();
    }

    @Test(priority = 1)
    public void footerPricingLink() {

        footerHelper.footerPricing();
        footerHelper.verificationFooterPricing();
    }

    @Test(priority = 1)
    public void footerMediaLink() {

        footerHelper.footerMedia();
        footerHelper.verificationFooterMedia();
    }

    @Test(priority = 1)
    public void footerStaySafeLink() {

        footerHelper.footerStaySafe();
        footerHelper.verificationFooterStaySafe();
    }

    @Test(priority = 1)
    public void footerBlogLink() {

        footerHelper.footerBlog();
        homePageHelper.verificationFMBlog();
    }

    @Test(priority = 1)
    public void footerBrowseFlatsharesLink() {
        newDriverPage();
        footerHelper.footerBrowseFlatshares();
        footerHelper.verificationBrowseFlatshares();

    }

    @Test(priority = 1)
    public void footerBrowseHowItWorksLink() {

        footerHelper.footerHowItWorks();
        footerHelper.verificationHowItWorks();
    }

    @Test(priority = 2)
    public void footerBrowseTipsLink() {
        newDriverPage();
        footerHelper.footerTipsWorks();
        footerHelper.verificationTipsWorks();

    }

    @Test(priority = 3)
    public void footerNLALink() {
        newDriverPage();
        footerHelper.footerNLAWorks();
        footerHelper.verificationNLAWorks();

    }

    @Test(priority = 4)
    public void footerFBLink() {
        newDriverPage();
        footerHelper.footerFB();
        footerHelper.verificationFB();

    }

    @Test(priority = 5)
    public void footerTwitterLink() {
        newDriverPage();
        footerHelper.footerTwitter();
        footerHelper.verificationTwitter();

    }

    @Test(priority = 6)
    public void footerInstagramLink() {
        newDriverPage();
        footerHelper.footerInstagram();
        footerHelper.verificationInstagram();

    }

    @Test(priority = 7)
    public void footerYoutubeLink() {
        newDriverPage();
        footerHelper.footerYoutube();
        footerHelper.verificationYoutube();

    }



}
