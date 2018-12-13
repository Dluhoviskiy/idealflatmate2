package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

public class SearchHomePageTests extends TestBase {

    @Test(priority = 1)
    public void searchHomeByButton() {
        searchHelper.searchProperty("PO30");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchFromHomeLocation("1 room matched to rent in PO30");
        helperBase.toHomePage();
    }

    //@Test(priority = 2)
    public void TestSearchHomeByEnter() {
        searchHelper.searchPropertyByEnter("Clapham");
        searchHelper.verificationSearchFromHomeLocation("Clapham, London");

    }
    @Test(priority = 2)
    public void searchHomeLocationFromList() {
        searchHelper.searchPropertyBySelectfromList("Clapham");
        searchHelper.verificationSearchFromHomeLocation("0 room matched to rent in Clapham Junction");
        helperBase.toHomePage();
    }


    @Test(priority = 2)
    public void searchHomeIncorrectData() {
        searchHelper.searchProperty("tttt");
        searchHelper.verificationSearchHomePage("Location\n" +  "not found. Please try again.\n" +  "");
        helperBase.toHomePage();
    }
    @Test(priority = 2)
    public void searchHomePartOfLocationName() {
        searchHelper.searchProperty("wes");
        searchHelper.verificationSearchFromHomeLocation("0 room matched to rent in West Bromwich");
        helperBase.toHomePage();
    }
    @Test(priority = 2)
    public void searchHomeIDProperty() {
        searchHelper.searchProperty("#0013119");
        searchHelper.verificationSearchFromHomeLocationProperty("SE6 4RU");
        helperBase.toHomePage();
    }
    @Test(priority = 3)
    public void searchHomeNorthLND() {
        searchHelper.searchProperty("North London");
        searchHelper.verificationSearchFromHomeLocation("North London");
        //helperBase.toHomePage();
    }


}
