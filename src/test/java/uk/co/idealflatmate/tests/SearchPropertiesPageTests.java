package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$$;
import static org.seleniumhq.jetty7.util.LazyList.getList;
import static org.testng.Assert.assertEquals;

public class SearchPropertiesPageTests extends TestBase{


    @Test(priority = 1)
    public void propertySearchByDropDown() {

        authorizationHelper.selectAllPropertyInMenu();
        searchHelper.closePopupSignup();
        searchHelper.amountPropertyCards(11);
        searchHelper.colivingButtonOnFirstPage();
        searchHelper.firstCardIsColivingAdv();
        helperBase.toHomePage();

    }

    @Test(priority = 2)
    public void searchPagination() {

        authorizationHelper.goToPropertyPage();
        searchHelper.closePopupSignup();
        searchHelper.moveToPage(2, "2");
        searchHelper.amountPropertyCards(11);
        searchHelper.colivingButtonOnFirstPage();
        searchHelper.moveToPage(3, "3");
        searchHelper.amountPropertyCards(11);
        searchHelper.colivingButtonOnFirstPage();
        searchHelper.moveToNext(4);
        searchHelper.amountPropertyCards(11);
        searchHelper.colivingButtonOnFirstPage();
        searchHelper.moveToPrevious(3);
        searchHelper.amountPropertyCards(11);
        searchHelper.colivingButtonOnFirstPage();
        searchHelper.colivingButton();
        helperBase.toHomePage();
    }

    @Test(priority = 3)
    public void searchZone1Pagination() {

        authorizationHelper.goToPropertyPage();
        searchHelper.closePopupSignup();
        searchHelper.zone1();
        searchHelper.colivingButton();
        helperBase.toHomePage();
    }

    @Test(priority = 4)
    public void searchEastLDNPagination() {

        authorizationHelper.goToPropertyPage();
        searchHelper.closePopupSignup();
        searchHelper.EastLDN1();
        searchHelper.firstCardIsColivingAdv();
        helperBase.toHomePage();
    }

    @Test(priority = 5)
    public void applyFilters() {

        authorizationHelper.goToPropertyPage();
        searchHelper.closePopupSignup();
        searchHelper.clickApplyFilters();
        searchHelper.noActiveFilters();
        //searchHelper.active3Fiters(3,"Budget Max: 2500 £ ", "Search Radius: 1 miles ", "Available From:");
        searchHelper.clickMoreFilterApply();
        searchHelper.clickApply();
        searchHelper.VerifyMoreFilters();
        helperBase.toHomePage();
    }
    @Test(priority = 6)
    public void applyAdvancedFiltersDefault() {

        authorizationHelper.goToPropertyPage();
        searchHelper.closePopupSignup();
        searchHelper.clickSearchPropPage("London");
        searchHelper.noActiveFilters();
       // searchHelper.clickAdvancedFilter();
        searchHelper.active7Fiters(7, "Budget Max: 2500 £ ", "Age Min: 18 ", "Age Max: 100 ",
                "Rooms number: 1 ", "Search Radius: 1 miles ", "Available From: ", "Total rooms: 10 ");
        helperBase.toHomePage();
    }

    @Test(priority = 7)
    public void sortListingWith2Rooms() {

        authorizationHelper.goToPropertyPage();
        searchHelper.closePopupSignup();
        searchHelper.clickAdvancedFilter();
        searchHelper.clickAvailablePlus("Rooms number: 2 ");
        // No "1 rooms available" after sorting
        searchHelper.cardsWith2roomsAvailable(11, "\n" + "1 rooms available\n" + " ");
        helperBase.toHomePage();
    }

    /*@Test(priority = 4)
    public void sortListingByBudget() {

        authorizationHelper.goToPropertyPage();
        helperBase.toHomePage();
        //Lowest budget
        searchHelper.clickHighestPrice(3);
        sleep(5000);

        int cardsBudgetText = 0;
        String[] texts = $$(String.format("div.card-infos-left", cardsBudgetText)).getTexts();



        Arrays.sort(texts);

        $$(String.format("div.card-infos-left", cardsBudgetText)).shouldHave(CollectionCondition.texts(texts));

       // searchHelper.verifySortingByBudget();
        helperBase.toHomePage();
    }*/
    /*@Test
    public void userCanSortProductsByNameinList()   {


        // get list with product names
        ArrayList expectedBudget = getList(java.util.Optional.of(".//*[@class='product-name']/a"));

        // sort() will return this list sorted in ascending order
        Collections.sort(expectedBudget);


        // get another list with product names
        ArrayList actualBudget = getList(".//*[@class='product-name']/a");

        // compare lists
        assertEquals(actualNames, expectedBudget, "Not sorted by name.");

    }*/


}
