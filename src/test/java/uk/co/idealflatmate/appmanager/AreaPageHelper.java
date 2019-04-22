package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class AreaPageHelper extends HelperBase {
    SelenideElement sortOption = $(byXpath("//select[@id='property-sort']/option[1]"));
    static SelenideElement container = $(byXpath("//div[@class='container text-center u_p20-xs u_p40-sm text-shadow u_ep-relative']"));

    public void clickArea(int number_of_area) {

        $$("#hp-areas div.card-btr-amenities.text-white").get(number_of_area).click();
    }

    public void clickHeaderItem(String select1, String select2, String select3) {


        switchTo().window(1);


        $(byXpath("//a[@href='#top']")).click();
        $(byXpath("//h2[contains(text(), 'Overview')]")).shouldBe(visible);
        sleep(3000);

        container.scrollIntoView(true).$(byXpath("//a[@href='#" + select1 + "']")).click();
        $(byXpath("//h2[contains(text(), 'Top Spots')]")).shouldBe(visible);

        container.scrollIntoView(true).$(byXpath("//a[@href='#" + select2 + "']")).click();
        $(byXpath("//h2[contains(text(), 'Available rooms')]")).shouldBe(visible);
        sleep(3000);

        container.scrollIntoView(true).$(byXpath("//a[@href='#" + select3 + "']")).click();
        $(byXpath("//h2[contains(text(), 'Flathunters')]")).shouldBe(visible);
        sleep(3000);

        container.scrollIntoView(true).$(byXpath("//a[@href='#explore']")).click();
        $(byXpath("//div[@class='scrollspy clearfix scrollspy-horizontal']")).shouldBe(visible);

    }

    public void checklinkMap() {
        switchTo().window(1);
        switchTo().frame(0);
        $(byXpath("//a[contains(text(), 'View larger map')]")).waitUntil(appears, 10000).click();
        switchTo().window(2);
        $(byXpath("//link[@title='Google Maps']")).shouldBe(exist);
    }

    public void clicklinkNearbyAreas() {
        switchTo().window(1);
        sleep(3000);
        $(byXpath("//a[contains(text(), 'Click to search nearby areas')]")).waitUntil(exist, 5000).click();
        sleep(3000);

    }

    public static int numberOfPropAreaPage() {

       int numberOfPropAreaPage = Integer.parseInt($(byXpath("//div[@class='col-sm-5 col-md-4']//span[@class='u_ed-block text-11']")).text().
               replaceAll("[^0-9]", ""));
       return numberOfPropAreaPage;

    }

    public void checklinkNearbyAreas(String area1, final String mapState) {
        closeAdvPopUp();
        $(byXpath("//span[@class='map-toggle-button open-map-button']")).shouldHave(text(mapState));

        String areaNameOnPageH1 = $(byXpath("//h1[@class='h4']")).text();
        System.out.println(areaNameOnPageH1);
        String area2 = (areaNameOnPageH1.substring(0, 24) + " " + area1);
        Assert.assertEquals(areaNameOnPageH1, area2);

    }



    public void checkLinkSeeMoreRooms(String area1) {

        closeAdvPopUp();
        mapAreaPageCheck();

        String areaNameOnPageH1 = $(byXpath("//h1[@class='splash-title text-white text-center u_m0-top']")).text();
        String area2 = (areaNameOnPageH1.substring(0, 17) + " " + area1);
        Assert.assertEquals(areaNameOnPageH1, area2);

        String areaNameOnPageH2 = $(byXpath("//h1[@class='h4']")).text();
        String area3 = (areaNameOnPageH2.substring(0, 24) + " " + area1);
        Assert.assertEquals(areaNameOnPageH2, area3);


    }

    public void mapAreaPageCheck() {
        sleep(2000);
        SelenideElement openMap = $(byXpath("//span[@class='map-toggle-button open-map-button']"));
        SelenideElement hideMap = $(byXpath("//span[@class='map-toggle-button close-map-button']"));

        openMap.click();
        sleep(2000);
        hideMap.shouldHave(text("Hide map"));
        sleep(2000);
        hideMap.click();
        sleep(2000);
        openMap.shouldHave(text("Display map"));
    }

    public void checklinkFH(String area1) {
        switchTo().window(1);

        container.scrollIntoView(true).$(byXpath("//a[@href='#flatmates']")).click();
        $(byXpath("//h2[contains(text(), 'Flathunters')]")).shouldBe(visible);
        sleep(2000);

        $(byXpath("//a[contains(text(), 'See more flathunters')]")).waitUntil(exist, 5000).click();

        String areaNameOnPageH1 = $(byXpath("//h1")).text();
        String area2 = (areaNameOnPageH1.substring(0, 12) + " " + area1);
        Assert.assertEquals(areaNameOnPageH1, area2);

        $(byXpath("//div[@class='search-panel hidden-xs']//input")).shouldHave(value(area1));

        $(byXpath("//h2")).shouldHave(text("We've found "));
    }

    public void checklinkAreaslinkFooter() {
        $(byXpath("(//div[@class='card-btr-amenities text-white'])[1]')]")).waitUntil(exist, 5000).click();
        switchTo().window(1);
        $(byXpath("//h1[@class='splash-title text-white text-center u_m0-top']")).shouldHave(text("Stratford"));

    }

    public void checkAreaName(String area1) {
        //String areaNameOnPageH1 = $("h1.splash-title.text-white.text-center.u_m0-top").text();
        switchTo().window(1);
        String areaNameOnPageH1 = $(byXpath("//h1")).text();
        String area2 = (areaNameOnPageH1.substring(0, 9) + " " + area1);
        Assert.assertEquals(areaNameOnPageH1, area2);
    }

    public void numberPropertiesUnderSearchEqualsCards() {

        String areaNameOnPageH1 = $(byXpath("//h1[@class='h4']")).text().replaceAll("[^0-9]", "");
        //int Properties = Integer.valueOf((areaNameOnPageH1.substring(5, 6)));
        int Properties = Integer.valueOf((areaNameOnPageH1));
        //int PropertiesCard = $$(byXpath("//div[@class='cards-container']/div[@id]")).size();
        int propertiesCard = cardsOnThePage().size();
        Assert.assertEquals(Properties, propertiesCard);


    }

    public void clickMoreRooms() {
        switchTo().window(1);

        container.scrollIntoView(true).$(byXpath("//a[@href='#rooms']")).click();
        $(byXpath("//h2[contains(text(), 'Available rooms')]")).shouldBe(visible);
        sleep(3000);

        $(byXpath("(//a[@class='btn btn-primary'])[1]")).click();
    }

    public void checkSortDropDownFM() {
        checkSortDropDownRoom("5", "Top Matched");

    }

    public void checkSortDropDownRoom(final String expectedValue, final String defaultText) {
        closeAdvPopUp();
        sortOption.shouldHave(value(expectedValue));
        sortOption.shouldHave(text(defaultText));
    }

    public void pagination(final Condition condition) {
        $(byXpath("//ul[@class='pagination']/li/a[@class='btn pagination-button pagination-button--prev btn-lg']")).should(condition);

    }

    public void checkArrowsBrowsAll() {
        SelenideElement arrow = $(byXpath("(//button[@role='presentation' and @class='owl-next'])[3]"));

        switchTo().window(1);
        $(byXpath("//a[@href='#explore']")).click();
        sleep(2000);
        arrow.click();
        sleep(1000);
        arrow.click();
        sleep(1000);
        $(byXpath("//div/a[contains(.,'Browse all areas')]")).click();
    }

    public void checkAllAreas(String City) {
        $$(byXpath("//h2")).shouldHaveSize(6);
        $(byXpath("//div/p[contains(.,'Payment methods we accept:')]")).click();
        //$$(byXpath("//div[@class='page-heading u_nob']//button[@class='area-card--button text-bold']")).shouldHaveSize(6);
        $(byXpath("//div[@class='area-region u_m50-bottom']//button[@class='area-card--button text-bold']")).click();
        $(byXpath("//a[contains(.,'"+City+"')]")).click();
        //switchTo().window(2);

        closeAdvPopUp();

        $(byXpath("//div[@class='search-panel hidden-xs']//input")).shouldHave(value(City));
        $$(byXpath("//a[@class='buddy-star u_ed-inline-block float-right u_m15-right u_m10-top text-26 ']")).shouldHaveSize(11);
    }

    public void areaScroll() {

        $(byXpath("//h2[contains(.,'Explore areas across London')]")).click();
        $(byXpath("//section[@id='press-logos']")).click();
        sleep(2000);
    }
}
