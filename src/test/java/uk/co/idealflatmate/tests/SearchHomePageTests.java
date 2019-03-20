package uk.co.idealflatmate.tests;

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

    @Test
    public void searchHomeByButton() {
        clearCache();
        searchHelper.searchPropertyHome("PO30 2DN");
        searchHelper.closePopupSignup();

        searchHelper.verificationSearchProperty("Found "+getNumberOfListing() +" room to rent in PO30 2DN");
        helperBase.toHomePage();
    }

    @Test
    public void TestSearchHomeByEnter() {
        clearCache();
        searchHelper.searchPropertyByEnter("Clapham");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchOnFMPage("Found " + getNumberOfListing() + " rooms to rent in Clapham");
        helperBase.toHomePage();
    }
    @Test
    public void searchHomeLocationFromList() {
        clearCache();
        searchHelper.searchPropertyBySelectfromList("Clapham", "Clapham Junction");
        searchHelper.closePopupSignup();

        searchHelper.verificationSearchProperty("Found " + getNumberOfListing() + " rooms to rent in Clapham Junction");
        helperBase.toHomePage();
    }


    //@Test
    public void searchHomeIncorrectData() {
        clearCache();
        searchHelper.searchPropertyHome("ttttttttt");
        searchHelper.verificationSearchHomePage("Location\n" +  "not found. Please try again.\n" +  "");
        helperBase.toHomePage();
    }
    @Test
    public void searchHomePartOfLocationName() {
        searchHelper.searchPropertyHome("wellessbour we");
        searchHelper.closePopupSignup();

        searchHelper.verificationSearchProperty("Found "+ getNumberOfListing() + " room to rent in Wellesbourne West");
        helperBase.toHomePage();
    }
    @Test
    public void searchHomeIDProperty() {
        clearCache();
        searchHelper.searchPropertyHome("#0013119");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchPropertyMap(" London SE6 4RU, UK");
        helperBase.toHomePage();
    }
    @Test
    public void searchHomeNorthLND() {
        clearCache();
        searchHelper.searchPropertyHome("North London");
        sleep(20000);
        searchHelper.closePopupSignup();

        searchHelper.verificationSearchProperty("Found "+ getNumberOfListing() + " rooms to rent in North London");
        //helperBase.toHomePage();
    }


}
