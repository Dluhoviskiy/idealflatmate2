package uk.co.idealflatmate.appmanager;

import net.bytebuddy.asm.Advice;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class SearchHelper extends HelperBase {

    public void searchProperty(String location) {

        $("input#property-location").waitUntil(visible, 4000).click();
        $("input#property-location").waitUntil(empty, 4000).setValue(location);
        sleep(2000);
        $(byXpath("//button[@class='btn btn-primary u_p60-left-sm u_p60-right-sm js-search-submit']")).waitUntil(visible, 10000).click();
    }

    public void searchPropertyByEnter(String location) {

        $("input#property-location").waitUntil(visible, 4000).click();
        $("input#property-location").waitUntil(empty, 10000).setValue(location);
        $(byXpath("//div[@class='ui-menu-item-wrapper' and contains(text(), 'Clapham, London')]")).waitUntil(exist, 4000).pressEnter();
        //$(byXpath("//button[@class='btn btn-primary u_p60-left-sm u_p60-right-sm js-search-submit']")).waitUntil(visible, 10000).click();
        //$(byText("COMPOSE")).click();


    }
    public void searchPropertyBySelectfromList(String location) {

        $("input#property-location").waitUntil(visible, 4000).click();
        $("input#property-location").waitUntil(empty, 10000).setValue(location);
        sleep(1000);
        $(byXpath("//div[@class='ui-menu-item-wrapper' and contains(text(), 'Clapham, London')]")).waitUntil(visible, 4000).click();

    }

    public void searchPropertyIncorrectFirstfromList(String location) {

        $("input#property-location").waitUntil(visible, 4000).click();
        $("input#property-location").waitUntil(empty, 10000).setValue(location).pressEnter();

    }

    public void verificationSearchFromHome(String location) {
        $(byXpath("//div[@class='row cards-container']")).waitUntil(visible, 4000).shouldHave(text(location));
    }
    public void verificationSearchFromHomeLocation(String location) {
        $(byXpath("//h1[@class='h3 u_m0-top u_m0-bottom']")).waitUntil(visible, 10000).shouldHave(text(location));
    }

    public void verificationSearchHomePage(String alert) {
        $(byXpath("//div[@class='js-no-location no-location u_p10-top text-center text-white']")).waitUntil(visible, 10000).shouldHave(text(alert));
    }

    public void verificationSearchFromHomeLocationProperty(String location) {
        $(byXpath("//div[@class='u_p10-bottom u_m30-bottom u_b-bottom']")).waitUntil(visible, 10000).shouldHave(text(location));
    }

    public void amountPropertyCards(int size) {

        $$(byXpath("//div[@class='row  cards-container']/div")).shouldHaveSize(size);
    }

    public void firstCard() {

        $$(byXpath("//div[@class='row  cards-container']/div")).first().shouldHave(text("Co-living,"));
    }
}
