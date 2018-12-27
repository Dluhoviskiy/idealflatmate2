package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class SearchHomePageTests extends TestBase {

    @Test(priority = 1)
    public void searchHomeByButton() {
        searchHelper.searchProperty("PO30");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchProperty("1 room matched to rent in and around PO30");
        helperBase.toHomePage();
    }

    //@Test(priority = 2)
    public void TestSearchHomeByEnter() {
        searchHelper.searchPropertyByEnter("Clapham");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchOnFMPage("Clapham, London");

    }
    @Test(priority = 2)
    public void searchHomeLocationFromList() {
        searchHelper.searchPropertyBySelectfromList("Clapham");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchProperty("8 rooms matched to rent in and around Clapham Junction");
        helperBase.toHomePage();
    }


    @Test(priority = 3)
    public void searchHomeIncorrectData() {
        searchHelper.searchProperty("tttt");
        searchHelper.verificationSearchHomePage("Location\n" +  "not found. Please try again.\n" +  "");
        helperBase.toHomePage();
    }
    @Test(priority = 4)
    public void searchHomePartOfLocationName() {
        searchHelper.searchProperty("wes");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchProperty("0 room matched to rent in and around Appleby in Westmorland");
        helperBase.toHomePage();
    }
    @Test(priority = 5)
    public void searchHomeIDProperty() {
        searchHelper.searchProperty("#0013119");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchPropertyMap(" London SE6 4RU, UK");
        helperBase.toHomePage();
    }
    @Test(priority = 6)
    public void searchHomeNorthLND() {
        searchHelper.searchProperty("North London");
        sleep(10000);
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchProperty("North London");
        //helperBase.toHomePage();
    }


}
