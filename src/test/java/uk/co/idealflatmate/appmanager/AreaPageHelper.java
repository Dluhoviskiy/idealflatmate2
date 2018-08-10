package uk.co.idealflatmate.appmanager;

import org.testng.Assert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class AreaPageHelper {

    public void clickArea() {
        $(byXpath("(//div[@class='item u_p5'])[1]/a")).waitUntil(visible, 4000).click();
    }

    public void clickHeaderItem() {
        switchTo().window(1);
        $(byXpath("//a[@href='#top']")).waitUntil(visible, 5000).click();
        $(byXpath("//h2[contains(text(), 'Overview')]")).shouldBe(visible);

        $(byXpath("//a[@href='#top-spots']")).waitUntil(exist, 5000).click();
        $(byXpath("//h2[contains(text(), 'Top Spots')]")).shouldBe(visible);

        $(byXpath("//a[@href='#rooms']")).waitUntil(exist, 5000).click();
        $(byXpath("//h2[contains(text(), 'Available rooms')]")).shouldBe(visible);

        $(byXpath("//a[@href='#flatmates']")).waitUntil(exist, 5000).click();
        $(byXpath("//h2[contains(text(), 'Flathunters')]")).shouldBe(visible);

        $(byXpath("//a[@href='#explore']")).waitUntil(exist, 5000).click();
        $(byXpath("//h2[contains(text(), 'Explore')]")).shouldBe(visible);
    }

    public void checklinkMap() {
        switchTo().window(1);
        switchTo().frame(0);
        $(byXpath("//a[contains(text(), 'View larger map')]")).waitUntil(appears, 10000).click();
        switchTo().window(2);
        $(byXpath("//link[@title='Google Maps']")).shouldBe(exist);
    }

    public void checklinkNearbyAreas() {
        switchTo().window(1);
        $(byXpath("//a[contains(text(), 'Click to search nearby areas')]")).waitUntil(exist, 5000).click();
        $(byXpath("//div[@class='map-container f-open']")).shouldBe(exist);
        $(byXpath("//h1[@class='text-white h2 u_m0-top']")).shouldHave(text("Rooms To Rent"));
    }

    public void checklinkSeeMoreRooms() {
        switchTo().window(1);
        $(byXpath("//a[contains(text(), 'See more rooms in Clapham')]")).waitUntil(exist, 5000).click();
        $(byXpath("//div[@class='map-container f-open']")).shouldBe(exist);
        $(byXpath("//h1[@class='text-white h2 u_m0-top']")).shouldHave(text("Rooms To Rent"));
    }

    public void checklinkFH() {
        switchTo().window(1);
        $(byXpath("//a[contains(text(), 'See more flathunters')]")).waitUntil(exist, 5000).click();
        sleep(3000);
        $(byXpath("//h1[@class='h3 u_m0-top u_m0-bottom']")).shouldHave(text("We've found"));
    }

    public void checklinkAreaslinkFooter() {
        $(byXpath("(//div[@class='card-btr-amenities text-white'])[1]')]")).waitUntil(exist, 5000).click();
        switchTo().window(1);
        $(byXpath("//h1[@class='splash-title text-white text-center u_m0-top']")).shouldHave(text("Stratford"));

    }
}
