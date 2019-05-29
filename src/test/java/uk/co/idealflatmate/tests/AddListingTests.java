package uk.co.idealflatmate.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.ProfileData;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
//import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
import static com.codeborne.selenide.Selenide.sleep;
//import static uk.co.idealflatmate.appmanager.AddPropertyHelper.monthAvailableFrom;
import static uk.co.idealflatmate.appmanager.AddPropertyHelper.monthAvailableFrom1;
import static uk.co.idealflatmate.appmanager.AddPropertyHelper.roomAmountIs;
import static uk.co.idealflatmate.appmanager.HelperBase.*;
import static uk.co.idealflatmate.appmanager.SearchHelper.getNumberOfListingFound;

public class AddListingTests extends TestBase {

    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
    }

    @Test
    public void loginStartListing() {

        authorizationHelper.login("passwUniv","userNotpaid1");

        verificationHelper.closeMatchingPopup();

        //verificationHelper.verifyNoProperty();
        paymentsHelper.addPropertyHelper.chooseListingsFromDropDownMenu();
        addPropertyHelper.addListingFromListingPage();
        paymentsHelper.addPropertyHelper.setPostalCode("L11","Liverpool L11 0JA, UK");

        getAddPropertyHelper().pressContinue();

        //paymentsHelper.addPropertyHelper.chooseArea("Elephant and Castle");
        sleep(1000);
        getAddPropertyHelper().pressContinue();
        sleep(1000);
        getAddPropertyHelper().saveQuitHeaderMenuListing();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.finishUnfinished();
        getAddPropertyHelper().saveQuitHeaderMenuListing();
        sleep(1000);
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.removeUnfinishedListing();

        verificationHelper.verifyNoPropertyPending();
        verificationHelper.verificationUserNameOnHomePage("John");

        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test
    public void loginPendingListing() {

        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("userNotpaid");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();

        verificationHelper.closeMatchingPopup();

        addPropertyHelper.chooseListingsFromDropDownMenu();
        verificationHelper.verifyNoProperty();

        addPropertyHelper.chooseListingsFromDropDownMenu();
        addPropertyHelper.addListingFromListingPage();
        paymentsHelper.addPropertyHelper.setPostalCode("sw1a ", "London SW1A 1AA, UK");
        //getAddPropertyHelper().pressContinue1();
        getAddPropertyHelper().pressContinue();

        addPropertyHelper.chooseArea("Knightsbridge");
        getAddPropertyHelper().pressContinue();

        addPropertyHelper.setTotalBedrooms("4");
        scrollDownPageOn("2000");
        addPropertyHelper.setMonthlyRent("500");
        getAddPropertyHelper().pressContinue();

        addPropertyHelper.continueListingWithoutPhoto();
        verificationHelper.finishPendingProperty();

        addPropertyHelper.chooseListingsFromDropDownMenu();
        verificationHelper.verifyPendingProperty();
        addPropertyHelper.removeListingClick("0");
        verificationHelper.verifyNoPropertyPending();
        verificationHelper.verificationUserNameOnHomePage("John");

        authorizationHelper.chooseTabFromInnerMenuDashboard("Settings");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test
    public void houseFeaturesListing() {

        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("agentNotpaid1");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("AgentF");

        addPropertyHelper.chooseListingsFromDropDownMenu();
        verificationHelper.verifyNoProperty();

        addPropertyHelper.chooseListingsFromDropDownMenu();
        addPropertyHelper.addListingFromListingPage();
        addPropertyHelper.setPostalCode("N11 1GN", "London N11 1GN, UK");
        //getAddPropertyHelper().pressContinue1();
        getAddPropertyHelper().pressContinue();

        addPropertyHelper.chooseArea("New Southgate");
        getAddPropertyHelper().pressContinue();

        addPropertyHelper.setTotalBedrooms("1");
        addPropertyHelper.isCheckedSutableFore("Professionals and/or Students");
        addPropertyHelper.clickSutableFore("Students Only");
        addPropertyHelper.isCheckedSutableFore("Students Only");
        addPropertyHelper.setAllAmanitiesFeatures("Gym", "Concierge");

        scrollDownPageOn("1000");

        addPropertyHelper.featuresPropertyClick("property-is_bills_included", checked);
        addPropertyHelper.featuresPropertyClick("property-has_no_deposit", checked);

        scrollDownPageOn("1000");
        paymentsHelper.addPropertyHelper.setMonthlyRent("1700");
        getAddPropertyHelper().pressContinue();
        sleep(1000);
        getAddPropertyHelper().pressBack();

        addPropertyHelper.featuresPropertyIsChecked("property-is_bills_included", checked);
        addPropertyHelper.featuresPropertyIsChecked("property-has_no_deposit", checked);
        //addPropertyHelper.featuresPropertyIsChecked("property-has_concierge", checked);
        //addPropertyHelper.featuresPropertyIsChecked("property-has_gym", checked);

        addPropertyHelper.saveQuitHeaderMenuListing();
        addPropertyHelper.continueListing();

        getAddPropertyHelper().pressContinue();

        paymentsHelper.addPropertyHelper.continueListingWithoutPhoto();

        helperBase.toHomePage();
        searchHelper.searchPropertyHome1("N11 1GN ");
        searchHelper.selectRadius("+3 km");
        //searchHelper.checkSort("Top matched");
        verificationHelper.featuresOnTheCard();

        removeListing();

    }


    @Test
    public void signUpPropertyAdding() {

        addPropertyHelper.pressAddListingFromHeaderNotLoggedUser();
        addPropertyHelper.selectTypeUser("An agency");

        signUpHelper.agentSignListing("Ronald", "agentRemoved", "passwUniv",
                                      "66666666", "Tell us about yourself");

        //verificationHelper.verificationUserNameOnHomePage("Ronald");
        addPropertyHelper.saveQuitHeaderMenuListing();

        addPropertyHelper.chooseListingsFromDropDownMenu();
        verificationHelper.verifyNoProperty();

        verificationHelper.verifyAddListingPage();
        addPropertyHelper.pressAddListingFromBody();

        addPropertyHelper.addListingWithoutPhotoEmptyAreaVerif("M11","Manchester M11 3FF, UK", "Bradford-with-Beswick", "2",
                                               "1500", "Area cannot be blank.");

        //addPropertyHelper.finishPropertyCreatingAgency();

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.verifyAddedProperty("Manchester M11 3FF, UK");

        addPropertyHelper.removeListingClick("0");

        authorizationHelper.chooseTabFromInnerMenuDashboard("My profile");
        verificationHelper.profileDisplays(new ProfileData("percentComplete4",  "myProfile4",
                "name4", "age4","lokingFor4", "aboutMe4","rooms4",
                "amountPropCards4"));

        authorizationHelper.chooseTabFromInnerMenuDashboard("Settings");
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }



    @Test
    public void propertyAddWithAllFields() {

        authorizationHelper.login("passwUniv", "agentNotPaid");

        matchingHelper.closePopupMatching();
        addPropertyHelper.closeRenewPopup();

        //getAddPropertyHelper().openDropDownMenu();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.verifyNoProperty();

        allFields();

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();
        verificationHelper.photoListingExist();
        verificationHelper.verifyAddedPropertyWithAllFields("February", "Room 1", "Room 2", "Room 3",
                "3 of 4 bedrooms available\n" + "Garden\n" + "Communal living room\n" +  "Balcony/patio\n" +
                        "Parking space\n" + "Smokers Accepted\n" +  "Suitable for couples\n" + "Pets Accepted\n" +
                        "LGBT Friendly\n" + "Trans Friendly\n" + "Family Friendly\n" + "Vegan Household\n" +
                        "Vegetarian Household\n" + "DSS Accepted", "Location\n"+"London SE8 5HY, UK - see more rooms to rent in Deptford");

        removeListing();
    }

    @Test
    public void propertyEditAllFieldsAbout() {

        authorizationHelper.login("passwUniv", "agentEdit");
        matchingHelper.closePopupMatching();
        addPropertyHelper.closeRenewPopup();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();

        verificationHelper.photoListingExist();
        verificationHelper.verifyAboutProperty("3 of 4 bedrooms available");

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        addPropertyHelper.clickEdit();
        addPropertyHelper.changeWholeOfProperty("No, by the room only", "Yes");
        addPropertyHelper.changeAboutOptions(" Garden", " Communal living room", " Balcony/patio", " Parking", "Pets Accepted", "Smokers Accepted", "Suitable for couples", "LGBT Friendly", "Family Friendly", "Trans Friendly", "Vegan Household", "Vegetarian Household", "DSS Accepted");


        clickButton("Save and update", "button");

        //getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();
        verificationHelper.verifyAboutProperty("3 of 4 bedrooms available\n" + "Garden\n" + "Communal living room\n" +  "Balcony/patio\n" +
                "Parking space\n" + "Smokers Accepted\n" +  "Suitable for couples\n" + "Pets Accepted\n" +
                        "LGBT Friendly\n" + "Trans Friendly\n" + "Family Friendly\n" + "Vegan Household\n" +
                        "Vegetarian Household\n" + "DSS Accepted");

        buddyUpHelper.groupSectionIsVisible(true);

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        addPropertyHelper.clickEdit();
        addPropertyHelper.changeWholeOfProperty("Yes", "No, by the room only");
        helperBase.clickButton("Decline", "a");
        addPropertyHelper.changeWholeOfProperty("Yes", "No, by the room only");
        helperBase.clickButton("Accept", "a");

        addPropertyHelper.changeAboutOptions(" Garden", " Communal living room", " Balcony/patio", " Parking", "Pets Accepted", "Smokers Accepted", "Suitable for couples", "LGBT Friendly", "Family Friendly", "Trans Friendly", "Vegan Household", "Vegetarian Household", "DSS Accepted");

        //addPropertyHelper.changeRoomsProperty();
        helperBase.clickButton("Save and update", "button");

        //getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();
        verificationHelper.verifyAboutProperty("3 of 4 bedrooms available");
        buddyUpHelper.groupSectionIsVisible(false);
        String areaSearch = "Bankside";
        addPropertyHelper.verifyBreadCrumbs("Search Rooms", "London", areaSearch,
                                            "3 bedrooms for rent in "+areaSearch+", South London from ");

        addPropertyHelper.goByLink(areaSearch);
        searchHelper.verificationSearchProperty("Find A Room To Rent",
                getNumberOfListingFound()+ " rooms to rent available", getNumberOfListingFound()+" room to rent available");



        authorizationHelper.logoutFromApp();
    }

    @Test
    public void propertyDeactivateRooms(final String roomId1, final String roomId2, final String roomId3, final String roomid2, final String roomID2, final String roomid3, final String roomID3, final String save, final String button) {

        authorizationHelper.login("passwUniv", "agentDeactivateRoom");
        matchingHelper.closePopupMatching();
        addPropertyHelper.closeRenewPopup();

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        String Month = monthAvailableFrom1("3");
        getAddPropertyHelper().viewListing();
        verificationHelper.verifyAboutProperty("3 bedrooms available\n" + "Garden\n" + "Communal living room\n" +
                "Balcony/patio\n" + "Parking space\n" + "Smokers Accepted\n" + "Suitable for couples\n" +
                "Pets Accepted\n" + "LGBT Friendly\n" + "Trans Friendly\n" + "Family Friendly\n" +
                "Vegan Household\n" + "DSS Accepted");
        verificationHelper.verifyAboutPropertyRooms("3 rooms available in 3 bed property in Birmingham. " +
                "Room 1 is £1900.00 per month. Room 2 is £1950.00 per month, the deposit is £500.00. " +
                "Room 3 is £1950.00 per month, the deposit is £700.00 and bills are an additional £1200.00 per month.");
        verificationHelper.roomVerification("Room 1", "1900", "no", "no",
                                            "Now", "", "", "no",
                                            "no");
        verificationHelper.roomVerification("Room 2", "1950", "£500", "no",
                                            "25th", "March", "2019",
                                            "minimum 2 months maximum 4 months","no");
        verificationHelper.roomVerification("Room 3", "1950", "£700", "£1200",
                                            "15th", Month, "2020",
                                            "minimum 6 months maximum 8 months",
                                            "How would you describe your room");

        String citySearch = "Birmingham";
        addPropertyHelper.goByLink(citySearch);
        propertySortBy("Price low to high");
        //searchHelper.verificationSearchProperty("Found " + getNumberOfListing() + " rooms to rent in "+citySearch);
        searchHelper.verificationSearchProperty("Find A Room To Rent",
                getNumberOfListingFound()+ " rooms to rent available", getNumberOfListingFound()+" room to rent available");
        int searchWithActivatedRooms = Integer.parseInt(getNumberOfListingFound());

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        addPropertyHelper.deactivateVerifyRoom("24155", "Available now", "Unavailable");
        addPropertyHelper.deactivateVerifyRoom("24156", "Available now", "Unavailable");
        addPropertyHelper.deactivateVerifyRoom("24157", "Available from 15 April", "Unavailable");
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();
        verificationHelper.verifyAboutPropertyRooms("room available in 3 bed property in Birmingham.");
        verificationHelper.noRoomVerification("Room 1");

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();
        verificationHelper.verifyAboutProperty("0 of 3 bedrooms available\n" + "Garden\n" +"Communal living room\n" +
                "Balcony/patio\n" + "Parking space\n" + "Smokers Accepted\n" + "Suitable for couples\n"+"Pets Accepted\n" +
                "LGBT Friendly\n" +"Trans Friendly\n" +"Family Friendly\n" + "Vegan Household\n" +"DSS Accepted");
        addPropertyHelper.goByLink(citySearch);
        propertySortBy("Top matched");
        searchHelper.verificationSearchProperty("Find A Room To Rent",
                getNumberOfListingFound()+ " rooms to rent available", getNumberOfListingFound()+" room to rent available");
        int searchResultDeactivRooms = Integer.parseInt(getNumberOfListingFound());


        Assert.assertEquals(searchWithActivatedRooms, searchResultDeactivRooms+1);

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        addPropertyHelper.activateVerifyRoom(roomId1);
        addPropertyHelper.activateVerifyRoom(roomId2);
        addPropertyHelper.activateVerifyRoom(roomId3);
        addPropertyHelper.clickEditRoom(roomid2);
        addPropertyHelper.availableEdiRoomCheck(roomID2);
        clickButton("Save", "button");
        addPropertyHelper.clickEditRoom(roomid3);
        addPropertyHelper.availableEdiRoomCheck(roomID3);
        clickButton(save, button);

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();
        verificationHelper.verifyAboutProperty("3 bedrooms available\n" + "Garden\n" +"Communal living room\n" +
                "Balcony/patio\n" + "Parking space\n" + "Smokers Accepted\n" + "Suitable for couples\n"+"Pets Accepted\n" +
                "LGBT Friendly\n" +"Trans Friendly\n" +"Family Friendly\n" + "Vegan Household\n" +"DSS Accepted");
        verificationHelper.verifyAboutPropertyRooms("3 rooms available in 3 bed property in Birmingham. " +
                "Room 1 is £1900.00 per month. Room 2 is £1950.00 per month, the deposit is £500.00. " +
                "Room 3 is £1950.00 per month, the deposit is £700.00 and bills are an additional £1200.00 per month.");

        verificationHelper.roomVerification("Room 1", "1900", "no", "no",
                                            "Now", "", "", "no",
                                            "no");
        verificationHelper.roomVerification("Room 2", "1950", "£500", "no",
                                            "25th", "March", "2019",
                                            "minimum 2 months maximum 4 months",
                                            "no");
        verificationHelper.roomVerification("Room 3", "1950", "£700", "£1200",
                                            "15th", Month, "2020",
                                            "minimum 6 months maximum 8 months",
                                            "How would you describe your room");


        addPropertyHelper.goByLink(citySearch);
        propertySortBy("Most recent");
        int searchResultNewActivRooms = Integer.parseInt(getNumberOfListingFound());
        searchHelper.verificationSearchProperty("Find A Room To Rent",
                getNumberOfListingFound()+ " rooms to rent available", getNumberOfListingFound()+" room to rent available");
        Assert.assertEquals(searchWithActivatedRooms, searchResultNewActivRooms);

        authorizationHelper.logoutFromApp();
    }

    @Test
    public void propertyEditRooms() {
        String idRoom = "24324";
        String price1 = "1500"; String price2 = "1200"; String deposit1 = "215"; String deposit2 = "230";
        String bill1 = "120"; String bill2 = "230";
        String year1 = "2022"; String year2 = "2021";   String date1 = "7"; String date2 = "18";
        String description1 = "test1"; String description2 = "test2 test";
        int minStay1 = 5; int minStay2 = 2;
        int maxStay1 = 6; int maxStay2 = 8;

        //SearchHelper listN = new SearchHelper();

        authorizationHelper.login("passwUniv", "agentEditRoom");

        matchingHelper.closePopupMatching();
        addPropertyHelper.closeRenewPopup();

        //getAddPropertyHelper().openDropDownMenu();
        addPropertyHelper.chooseListingsFromDropDownMenu();

        addPropertyHelper.clickEditRoom(idRoom);
        sleep(1000);
        addPropertyHelper.clickEditRoom(idRoom);//close edit
        sleep(1000);
        addPropertyHelper.clickEditRoom(idRoom);
        sleep(2000);
        //addPropertyHelper.availableDateIsChecked();
        addPropertyHelper.fillRoomData(price1, deposit1, bill1, year1, date1,
                                        minStay1, maxStay1, description1, "Next");
        clickButton("Save", "button");
        sleep(1000);
        String Month = addPropertyHelper.monthAvailableFrom(idRoom);
        sleep(1000);

        addPropertyHelper.viewListing();
        addPropertyHelper.clickRoomsSection();
        verificationHelper.roomVerification("Room 1", price1, "£"+deposit1, "£"+bill1,
                                            date1+"th", Month, year1,
                                            "minimum "+minStay1+" months maximum "+maxStay1+" months",
                                            description1);


        addPropertyHelper.chooseListingsFromDropDownMenu();
        addPropertyHelper.clickEditRoom("24324");
        addPropertyHelper.fillRoomData(price2, deposit2, bill2, year2, date2,  minStay2, maxStay2,
                                        description2, "Prev");
        clickButton("Save", "button");
        sleep(1000);
        String Month2 = addPropertyHelper.monthAvailableFrom(idRoom);
        sleep(1000);

        addPropertyHelper.viewListing();
        addPropertyHelper.clickRoomsSection();
        verificationHelper.roomVerification("Room 1", price2, "£"+deposit2, "£"+bill2,
                                             date2+"th", Month2, year2,
                                            "minimum "+minStay2+" months maximum "+maxStay2+" months",
                                            "test2");

        authorizationHelper.logoutFromApp();
    }

    @Test
    public void propertyAddRooms() {

        //SearchHelper listN = new SearchHelper();

        authorizationHelper.login("passwUniv", "agentAddRoom");

        sleep(2000);
        addPropertyHelper.closeRenewPopup();
        matchingHelper.closePopupMatching();


        //getAddPropertyHelper().openDropDownMenu();
        addPropertyHelper.chooseListingsFromDropDownMenu();

        clickButton("Add room", "a");
        sleep(1000);
        clickButton("Remove", "a");
        sleep(1000);
        clickButton("Add room", "a");

        addPropertyHelper.availableDateIsCheckedAddingRoom();
        addPropertyHelper.fillRoomData("1300", "300", "120", "2021", "7",
                                        4, 7,
                                        "How test1", "Next");
        clickButton("Save and create", "button");
        sleep(1000);
        String Month = monthAvailableFrom1("2");
        sleep(1000);

        clickButton("Add room", "a");
        addPropertyHelper.availableDateIsCheckedAddingRoom();
        addPropertyHelper.fillRoomData("", "300", "120", "2022", "7",
                                        5, 8,
                                        "How would you describe your room?", "Next");
        clickButton("Save and create", "button");
        verificationHelper.roomPriceNotif("Monthly rent cannot be blank.");

        addPropertyHelper.fillRoomData("1500", "700", "120", "2023", "20",
                                        1, 8,
                                        "How test2", "Next");

        addPropertyHelper.fillRoomData("1500", "700", "120", "2023", "20",
                                        1, 8,"How test2", "Prev");
        clickButton("Save and create", "button");


        addPropertyHelper.viewListing();
        verificationHelper.verifyAboutProperty("3 of 1 bedroom available\n" +   "Parking space\n" +                "Pets Accepted\n" +
                                                "Trans Friendly\n" +  "DSS Accepted");
        verificationHelper.verifyAboutPropertyRooms("Rome, 35 is a male professional . 3 rooms available in 1" +
                " bed property in Birmingham. Room 1 is £999.00 per month. " +
                "Room 2 is £1300.00 per month, the deposit is £300.00 and bills are an additional £120.00 per month." +
                " Room 3 is £1500.00 per month, the deposit is £700.00 and bills are an additional £120.00 per month.");
        addPropertyHelper.clickRoomsSection();
        verificationHelper.roomVerification("Room 1", "999", "no", "no", "Now",
                                            "", "", "no", "no");
        verificationHelper.roomVerification("Room 2", "1300", "£300", "£120",
                                            "7th",Month, "2021", "minimum 4 months maximum 7 months",
                                            "How test1");
        verificationHelper.roomVerification("Room 3", "1500", "£700",
                                            "£220", "20th",Month, "2023",
                                            "minimum 1 month maximum 8 months","How test2");

        addPropertyHelper.chooseListingsFromDropDownMenu();

        addPropertyHelper.removeRooms("2", "Yes, delete");
        addPropertyHelper.removeRooms("2", "Yes, delete");

        Assert.assertEquals(1, roomAmountIs());

        addPropertyHelper.viewListing();
        verificationHelper.verifyAboutProperty("1 bedroom available\n" + "Parking space\n" + "Pets Accepted\n" +
                                                "Trans Friendly\n" + "DSS Accepted");
        verificationHelper.verifyAboutPropertyRooms("Rome, 35 is a male professional . 1 room available in" +
                                                        " 1 bed property in Birmingham. Room 1 is £999.00 per month.");
        addPropertyHelper.clickRoomsSection();
        verificationHelper.roomVerification("Room 1", "999", "no", "no", "Now",
                                            "", "", "no", "no");

        authorizationHelper.logoutFromApp();
    }

    @Test
    public void titleListing() {

        authorizationHelper.login("passwUniv", "userTitle");
        verificationHelper.verificationUserNameOnHomePage("Title");
        verificationHelper.closeMatchingPopup();
        paymentsHelper.addPropertyHelper.chooseListingsFromDropDownMenu();
        verificationHelper.verifyNoProperty();

        addPropertyHelper.addListingFromListingPage();
        paymentsHelper.addPropertyHelper.setPostalCode("Knowsl",
                                                      "Knowsley Safari, Prescot, UK");
        getAddPropertyHelper().pressContinue();

        addPropertyHelper.chooseRoadFor("testRoad");
        //verificationHelper.addingListFlowCity("London");
        //verificationHelper.addingListFlowArea("Shoreditch");
        getAddPropertyHelper().pressContinue();

        //addPropertyHelper.pressBack();

        //verificationHelper.addingListFlowCity("London");
        //verificationHelper.roadFor("Liverpool Street");
        //getAddPropertyHelper().pressContinue();

        addPropertyHelper.setTotalBedrooms("4");
        scrollDownPageOn("1300");

        addPropertyHelper.setMonthlyRent("500");

        String text1 = "Test_Property_Title";
        addPropertyHelper.propertytitle(text1);

        getAddPropertyHelper().pressContinue();

        addPropertyHelper.continueListingWithoutPhoto();
        paymentsHelper.verificationPaymentPageFeatureListing("Now choose the plan that is right for you.");

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        closeMatchPopUp();
        getAddPropertyHelper().viewListing();

        verificationHelper.verifyTitleProperty(text1);

        removeListing();

    }



    public void allFields() {

        addPropertyHelper.pressAddListingFromBody();
        addPropertyHelper.setPostalCode("Se8", "London SE8 5HY, UK");
        addPropertyHelper.pressContinue();

        addPropertyHelper.chooseRoadFor("Idealstreet");
        addPropertyHelper.chooseArea("Deptford");
        addPropertyHelper.pressContinue();


        addPropertyHelper.setTotalBedrooms("4");
        addPropertyHelper.isCheckedSutableFore("Professionals and/or Students");
        addPropertyHelper.clickSutableFore("Professionals Only");
        addPropertyHelper.isCheckedSutableFore("Professionals Only");
        scrollDownPageOn("600");
        addPropertyHelper.setAllAmanities("Garden", "Parking", "Communal living room", "Balcony/patio",
                                            "Pet Friendly", "Smoker Friendly", "Family Friendly",
                                            "LGBT Friendly", "Trans Friendly", "Vegan Household",
                                            "Vegetarian Household", "DSS Accepted", "Suitable for couples",
                                             "Gym", "Concierge");
        addPropertyHelper.setPropertyDescription("Very good flat");
        scrollDownPageOn("600");
        addPropertyHelper.setMonthlyRent("500");
        addPropertyHelper.setDeposit("1000");
        addPropertyHelper.setTotalBills("400");
        addPropertyHelper.availabaleChecked("1");
        addPropertyHelper.setLeasePeriodRoom("1", "3", "7");
        addPropertyHelper.setRoomDescription("Very comfortable room");
        addPropertyHelper.copySecondRoom();
        scrollDownPageOn("400");
        addPropertyHelper.removeSecondRoom();
        addPropertyHelper.copySecondRoom();
        addPropertyHelper.addAnotherRoom();
        scrollDownPageOn("400");
        addPropertyHelper.setAnotherMonthlyRent("800", "800");
        addPropertyHelper.availabaleChecked("3");
        addPropertyHelper.setAvailablePeriodRoom("3", "2025", "15", "Next");
        scrollDownPageOn("400");
        addPropertyHelper.setPhoneNumber1("+44 20 7234 3456");
        addPropertyHelper.pressContinue();

        addPropertyHelper.uploadProperty3Photos();
        addPropertyHelper.checkPhotos();
        addPropertyHelper.uploadPropertyLargePhoto();
        addPropertyHelper.uploadPropertyNotPhoto();
        addPropertyHelper.checkPhotos();

        addPropertyHelper.pressBack();
        addPropertyHelper.checkAllAmanities("Garden", "Parking", "Communal living room", "Balcony/patio",
                                            "property-pets_accepted", "property-smokers_accepted",
                                            "property-family_friendly", "property-lgbt_friendly",
                                            "property-trans_friendly", "property-vegan_household",
                                            "property-vegetarian_household", "DSS Accepted", "Suitable for couples");

        addPropertyHelper.pressContinue();
        addPropertyHelper.checkPhotos();

        addPropertyHelper.finishPropertyCreatingAgency();
    }

    public void removeListing() {
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().removeListingClick("0");
        verificationHelper.verifyNoProperty();
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

}











