package uk.co.idealflatmate.tests;

import com.codeborne.selenide.CollectionCondition;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.seleniumhq.jetty7.util.LazyList.getList;
import static org.testng.Assert.assertEquals;

public class SearchPropertiesPageTests extends TestBase{


    @Test(priority = 1)
    public void propertySearchByDropDown() {

        authorizationHelper.selectAllPropertyInMenu();
        authorizationHelper.clickCloseSignUpFMPage();
        searchHelper.amountPropertyCards(12);
        searchHelper.colivingButtonOnFirstPage();
        searchHelper.firstCardIsColivingAdv();

    }

    @Test(priority = 2)
    public void searchPagination() {

        authorizationHelper.goToPropertyPage();
        //authorizationHelper.clickCloseSignUpFMPage();
        searchHelper.moveToPage(2, "2");
        searchHelper.amountPropertyCards(12);
        searchHelper.moveToPage(3, "3");
        searchHelper.amountPropertyCards(12);
        searchHelper.moveToNext(3);
        searchHelper.amountPropertyCards(12);
        searchHelper.moveToPrevious(3);
        searchHelper.amountPropertyCards(12);
        searchHelper.colivingButton();

    }

    @Test(priority = 3)
    public void searchZone1Pagination() {

        authorizationHelper.goToPropertyPage();
        //authorizationHelper.clickCloseSignUpFMPage();
        searchHelper.zone1();
        searchHelper.colivingButton();

    }

    @Test(priority = 4)
    public void searchEastLDNPagination() {

        authorizationHelper.goToPropertyPage();
        //authorizationHelper.clickCloseSignUpFMPage();
        searchHelper.EastLDN1();
        searchHelper.firstCardIsColivingAdv();

    }

    @Test(priority = 4)
    public void applyFilters() {

        authorizationHelper.goToPropertyPage();
        //authorizationHelper.clickCloseSignUpFMPage();
        searchHelper.clickApplyFilters();
        searchHelper.active3Fiters(3,"Budget Max: 2500 £ ", "Search Radius: 1 miles ", "Available From:");

    }
    @Test(priority = 4)
    public void applyAdvancedFiltersDefault() {

        authorizationHelper.goToPropertyPage();
        //authorizationHelper.clickCloseSignUpFMPage();
        searchHelper.clickAdvancedFilter();
        searchHelper.clickAdvancedFilterApply();
        searchHelper.active7Fiters(7, "Budget Max: 2500 £ ", "Age Min: 18 ", "Age Max: 100 ",
                "Rooms number: 1 ", "Search Radius: 1 miles ", "Available From: ", "Total rooms: 10 ");

    }

    @Test(priority = 4)
    public void sortListingWith2Rooms() {

        authorizationHelper.goToPropertyPage();
       // authorizationHelper.clickCloseSignUpFMPage();
        searchHelper.clickAdvancedFilter();
        searchHelper.clickAvailablePlus("Rooms number: 2 ");
        // No "1 rooms available" after sorting
        searchHelper.cardsWith2roomsAvailable(11, "\n" + "1 rooms available\n" + " ");

    }

    @Test(priority = 4)
    public void sortListingByBudget() {

        authorizationHelper.goToPropertyPage();
        authorizationHelper.clickCloseSignUpFMPage();
        //Lowest budget
        searchHelper.clickHighestPrice(3);
        sleep(5000);

        int cardsBudgetText = 0;
        String[] texts = $$(String.format("div.card-infos-left", cardsBudgetText)).getTexts();



        Arrays.sort(texts);

        $$(String.format("div.card-infos-left", cardsBudgetText)).shouldHave(CollectionCondition.texts(texts));

       // searchHelper.verifySortingByBudget();

    }
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
