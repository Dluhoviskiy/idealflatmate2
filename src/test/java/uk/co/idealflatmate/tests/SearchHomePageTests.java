package uk.co.idealflatmate.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.SearchHelper;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
import static uk.co.idealflatmate.appmanager.SearchHelper.getNumberOfListing;

public class SearchHomePageTests extends TestBase {

    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
    }
    @AfterMethod

    public void goHomePage() {
        helperBase.toHomePage();
    }


    @Test
    public void searchHomeByButton() {

        searchHelper.searchPropertyHome1("PO30 2DN");
        searchHelper.closePopupSignup();

        searchHelper.verificationSearchProperty("Found "+getNumberOfListing() +" room to rent in PO30 2DN");

    }

    @Test
    public void TestSearchHomeByEnter() {

        searchHelper.searchPropertyByEnter("Clapham");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchOnFMPage("Found " + getNumberOfListing() + " rooms to rent in Clapham");

    }
    @Test
    public void searchHomeLocationFromList() {

        searchHelper.searchPropertyBySelectfromList("Clapham", "Clapham Junction");
        searchHelper.closePopupSignup();

        searchHelper.verificationSearchProperty("Found " + getNumberOfListing() + " rooms to rent in Clapham Junction");

    }


    //@Test
    public void searchHomeIncorrectData() {

        searchHelper.searchPropertyHome("ttttttttt");
        searchHelper.verificationSearchHomePage("Location\n" +  "not found. Please try again.\n" +  "");

    }
    @Test
    public void searchHomePartOfLocationName() {

        searchHelper.searchPropertyHome("wellessbour we");
        searchHelper.closePopupSignup();

        searchHelper.verificationSearchProperty("Found "+ getNumberOfListing() + " room to rent in Wellesbourne West");

    }
    @Test
    public void searchHomeIDProperty() {

        searchHelper.searchPropertyHome("#0013119");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchPropertyMap(" London SE6 4RU, UK");

    }
    @Test
    public void searchHomeNorthLND() {

        searchHelper.searchPropertyHome("North London");
        sleep(20000);
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchProperty("Found "+ getNumberOfListing() + " rooms to rent in North London");
    }


}
