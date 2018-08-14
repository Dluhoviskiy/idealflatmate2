package uk.co.idealflatmate.appmanager;


import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;


public class HomePageHelper {




    public void clickFM() {
        $(byXpath("(//div[@class='circle-card-img'])[1]")).waitUntil(visible, 4000).click();
    }

    public void verificationFM() {
        $(byXpath("(//h4[@class='u_m0-top u_m20-bottom text-16'])[1]")).waitUntil(visible, 4000).shouldHave(text("About me"));
    }

    public void clickFind() {
        $(byXpath("(//a[@href='/p/how-it-works'])[1]")).waitUntil(visible, 4000).click();
    }

    public void verificationPageLinkHowItWorks() {
        $(byXpath("//title[contains(text(), 'How it works')]")).waitUntil(exist, 6000).should(exist);
    }

    public void clickFindYourNewFM() {
        $(byXpath("//button[@data-target='#matchModal']")).waitUntil(visible, 4000).click();
    }

    public void verificationMatchingStart() {
        $(byXpath("//form[@id='modal-form_2']//h4")).waitUntil(visible, 4000).shouldHave(text("Question 1 of"));

    }

    public void clickAddListing() {
        $(byXpath("(//a[@href='/create'])[3]")).waitUntil(visible, 4000).click();
    }
    public void verificationListingStart() {
        $(byXpath("//h1[@class='list-property-title u_m0-top ']")).waitUntil(visible, 4000).shouldHave(text("Which are you?"));
    }

    public void clickTakeMatching() {
        $(byXpath("//a[@data-target='#matchModal']")).waitUntil(visible, 4000).click();
    }

    public void clickFMBlog() {
        $(byXpath("//a[contains(text(), 'Visit Flatmate HQ')]")).waitUntil(visible, 4000).click();
    }

    public void verificationLandlordBlog() {
        $(byXpath("(//title[contains(text(), 'Landlords HQ')])[1]")).waitUntil(exist, 6000).should(exist);
    }

    public void clickLandlordBlog() {
        $(byXpath("//a[contains(text(), 'Visit Landlord HQ')]")).waitUntil(visible, 4000).click();
    }

    public void verificationFMBlog() {
        $(byXpath("//title[contains(text(), 'Flatmate HQ')]")).waitUntil(exist, 6000).should(exist);
    }

    public void clickLogo() {
        $(byXpath("(//div/a[@class='press-logo'])[1]")).waitUntil(visible, 4000).click();
    }

    public void verificationLogo() {
        switchTo().window(1);
        $(byXpath("html//body//div//div//input[@placeholder='Search City A.M...']")).waitUntil(exist, 5000).should(exist);

    }

    public void clickBlogFMImgLink() {
        $(byXpath("(//div[@class='col-xs-6 u_p5-right-xs u_ed-flex']/div/div/a/img)[1]")).waitUntil(visible, 4000).click();
    }

    public void clickBlogLandlordImgLink() {
        $(byXpath("(//div[@class='col-xs-6 u_p5-right-xs u_ed-flex']/div/div/a/img)[2]")).waitUntil(visible, 4000).click();
    }

    public void clickBlogFMTextLink() {
        $(byXpath("(//div[@class='u_p10-xs u_p15-sm']/a)[1]")).waitUntil(visible, 4000).click();
    }

    public void clickBlogLandlordTextLink() {
        $(byXpath("(//div[@class='u_p10-xs u_p15-sm']/a)[2]")).waitUntil(visible, 4000).click();
    }

    public void amountOfBlogBlocks(int size) {

        $$("div.col-xs-6.u_p5-right-xs.u_ed-flex").shouldHaveSize(size);

    }

    public void amountOfLatestFMblocks(int size) {
        $$("div.circle-card-img").shouldHaveSize(size);

    }
    public void amountOfFeedbackBlocks(int size) {

        $$("#testimonials div.card").shouldHaveSize(size);
    }

    public void amountOfFeaturedRoom(int size) {
        $$(byXpath("//div[@class='hp-featured-properties-container cards-container']/div")).shouldHaveSize(size);
    }
    public void amountOfAreasBlocks(int size) {

        $$("#hp-areas div.card-btr-amenities.text-white").shouldHaveSize(size);

        }
    public void amountOfMatchListRoom(int size) {
        $$(byXpath("//section[@class='homepage-quiz-list col-sm-10 col-sm-offset-1 col-md-12 col-md-offset-0 u_p0 u_ed-flex-sm u_p25-top u_p25-bottom']/div")).shouldHaveSize(size);
    }

    public void TextInAreas() {
        $$("#hp-areas div.owl-stage-outer").shouldHave(texts("Clapham\n" +
                "South London\n" +
                "ZONE 2\n" +
                "Stratford\n" +
                "East London\n" +
                "ZONE 3\n" +
                "Ealing\n" +
                "West London\n" +
                "ZONE 3\n" +
                "Walthamstow\n" +
                "East London\n" +
                "ZONE 4"));
    }



    //private void $$(boolean equals) {

    /*
    public void experimentGetTest() {
        $$(byXpath("//div[@class='owl-item active']")).get();
        Assert

    }*/
}
