package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.File;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AddPropertyHelper extends HelperBase {



    private String check_listFlow_aboutProp_privateRooms = "//div[@id='property-is_whole_rent']//label[contains(.,'Private room(s)')]";
    private String check_listFlow_aboutProp_whole = "//div[@id='property-is_whole_rent']//label[contains(.,'Entire property')]";
    private String input = "/input";
    private String setAmanity_string1 = "//div/label[contains(.,'";
    private String end_string = "')]";
    private SelenideElement tab_openDropDownMenuHeader = $(byXpath("(//li[@class='dropdown nav-ihm-profile-bars'])[1]"));
    private SelenideElement tab_addListing = $(byXpath("//ul[contains(@class,'nav navbar-nav')]//a[contains(.,'Add a Listing')]"));
    private String item_header_drop_Menu1 = "//ul[@class='dropdown-menu']//li/a[contains(., '";
    private String tab_Header_AddListing = "//ul[contains(@class,'nav-aux hidden-xs hidden-sm')]//a[contains(.,'Add a Listing')]";
    private String input_listingFlow_postcode = "//input[contains(@class,'select2-search')]";
    private String input_listingFlow_postcode_inner = "//span[contains(@id,'select2-property-location-container')]";
    private String input_listingFlow_postcode2 = "//span[@class='selection']//span[contains(@class,'select2-selection__rendered')]";
    private String drop_postcode_location1 = "//li[contains(.,'";
    private String input_road = "//input[@id='property-route']";
    private String drop_listFlow_area = "//select[@id='property-area_link_id']";
    private String drop_listFlow_area_list = "//select[@id='property-area_link_id']/option[contains(.,'";
    private String tab_listing_List_a_room = "//ul[starts-with(@class, 'nav navbar-nav')]//a[contains(.,'List a room')]";
    private String button_listing_blockSelect_homePage = "//div[@class='skew-links']//a[contains(., 'List your room')]";
    private String button_listing_blockUnderSearch_homePage = "//div[starts-with(@class, 'col-md-7 u_p15 u_p0-right')]//a[contains(., 'Add')]";
    private String button_addYourListing_bottomBlock_HomePage = "//div[@class='col-xs-12 col-sm-6']/a";
    private String input_listingFlow_phone = "//label[contains(., 'Phone Number')]/..//input[@id='property-phone_number']";
    private String drop_totalRoom = "#property-bedrooms_no";
    private String drop_totalRoom_field = "//label[contains(.,'Total bedrooms')]";
    private String select_icon_Amanity = "//div/label[contains(.,'";
    private String check_Amanity = "//div/label[contains(.,'";

    private String check_Amanity_end = "')]/input[@type='checkbox']";
    private String check_Amanity1 = "#";
    private String check_Amanity_end1 = "";
    private String field_ListFlow_propDecription = "//textarea[@id='property-description']";
    private String input_ListFlow_roomPrice = "#room-1-price";
    private String input_ListFlow_roomDeposit = "input#room-1-deposit";
    private String input_ListFlow_roomBills = "input#room-1-bills";
    private String input_room_Stay = "#room-";
    private String minStay_End = "-min_stay";
    private String maxStay_End = "-max_stay";
    private String option_Stay_max = "//*[@id='room-1-max_stay']/option[contains(.,'";
    private String option_Stay_min = "//*[@id='room-1-max_stay']/option[contains(.,'";
    private String check_list_flow_Available = "//div[@id='js-groups-list']//label//input[@id='buddyupgroup-available_now']";
    private String check_suitable_ListFlow = "//span[contains(.,'";
    private String check_suitable_ListFlow_end = "')]/../input";
    private String tab_buddy_Available = "//div[@id='js-groups-list']//label[contains(.,'Or choose date')]";
    private String input_buddy_Date = "//div[@id='js-groups-list']//input[contains(@class,'form-control u_m5-top')]";
    private String tab_buddy_Date = "//div//a[@class='ui-datepicker-next ui-corner-all']";
    private String tab_select_buddy_year = "select.ui-datepicker-year > option:nth-child(13)";
    private String option_buddy_year = "//tr//a[@class='ui-state-default' and contains(.,'13')]";
    private String room_Text = "//div[@class='form-group field-room-1-description']/textarea";
    private String input_room_Text = "//div[@class='form-group field-room-1-description in-use']/textarea";
    private String button_copy_Room = "//button[@class='btn btn-sm btn--type-5 js-room-copy']";
    private String input_price_second_Room = "input#room-2-price";
    private String input_price_third_Room = "input#room-3-price";
    private String button_remove_Room = "//button[@class='btn btn-sm btn-primary-outline js-room-remove u_ef-left']";
    private String button_add_Room = "//button[@class='btn btn-sm btn--type-4 js-room-add']";

    private String check_room_Available = "//input[contains(@id,'room-available_from') and @name='Room[";
    private String check_room_Available_end = "][availability]']";

    private String button_listing_photo_Finish = "//*[@id='wizard-finish-btn']";
    private String button_listing_Next = "#wizard-form #wizard-next";
    private String button_listing_Back = "#wizard-form #wizard-back";
    private String button_listing_photo_Finish_confirm = "//button[@class='confirm']";
    private String input_Photo = "//input[@id='uploadimageform-imagefiles']";
    private String listing_preview_Photo1 = "(//div[@class='kv-file-content']/img)[1]";
    private String listing_preview_Photo2 = "(//div[@class='kv-file-content']/img)[2]";
    private String listing_preview_Photo3 = "(//div[@class='kv-file-content']/img)[3]";
    private String listing_preview_Photo = "//div[@class='kv-file-content']/img";

    private String button_viewListing = "//a[@class='btn btn-half btn-primary listing-panel-button u_m10-bottom-xs']";
    private String button_removeListing = "//button[contains(@class, 'listing-panel-delete')]";
    private String radio_button_Remove_first = "(//input[1][@type='radio'])[1]";
    private String radio_button_listPage_toFMBlock = "//div[@class='container-max-940 u_bg-white']//a[contains(.,'ideal flatmate')]";
    private String button_submit_Remove = "//button[@type='submit' and contains(text(), 'Delete property')]";
    private String field_select_UserType1 = "//label[starts-with(@for,'type_id_') and contains(.,'";
    private String text_view_finishListing = "//div[@class='u_p20-bottom u_b-bottom']/span";
    private String h1_Page = "//h1";
    private String h3_select_Homepage = "//h3[contains(.,'Select')]";
    private String button_myListingPage_addNewListing = "//a[@class='btn btn-info btn-sm u_ef-right-sm u_ed-block-xs']";
    private String button_closeRenewPopup = "//button[@class='btn btn-sm close u_m15' and @aria-label='Close']";
    private String input_listing_Titile = "#property-title";
    private String button_listingEdit = "//div/a[contains(.,'Edit')]";
    private String link_breadCrumb = "//ul[@class='custom-breadcrumbs']//li[contains(.,'";
    private String input_roomPrice = "//input[@id='room-price']";
    private String input_roomDeposit = "//input[@id='room-deposit']";
    private String input_roomBills = "//input[@id='room-bills']";
    private String field_roomMinStay = "//select[@id='room-min_stay']";
    private String field_roomMaxStay = "//select[@id='room-max_stay']";
    private String field_roomMinStay_option = "//select[@id='room-min_stay']/option";
    private String field_roomMaxStay_option = "//select[@id='room-max_stay']";
    private String input_roomDescr_editPage = "//textarea[@id='room-description']";
    private String check_edit_addingRoom_Available = "//form[@id='property_add_room']//input[contains(@id,'room-available_from') and @name='Room[availability]']";
    private String check_edit_roomDate_Available1 = "//tr[@data-room-id='";
    private String check_edit_roomDate_Available1_end = "']//label[input[contains(@id,'room-available_from')]]";
    private String icon_edit_room = "//a[@aria-controls='room_editor_";
    private String text_available_Room = "//td[@data-state='availability_";
    private String icon_disable_Room = "//a[@data-room-id='";
    private String icon_disable_Room_Room_end = "' and @data-action='toggle-availability']";






    private  MessageHelper messageHelper = new MessageHelper();


    //SelenideElement continueUpgradeListAgent =  $(byXpath("//div[@class='container u_p20-top-xs u_p30-top-sm']/a[contains(., 'Continue without upgrading')]"));


    public void openDropDownMenu() {
        tab_openDropDownMenuHeader.waitUntil(visible, 5000).click();
    }

    public void pressAddListingFromBody() {
        tab_addListing.click();
    }

    public void chooseListingsFromDropDownMenu() {
        sleep(2000);
        tab_openDropDownMenuHeader.click();
        chooseFromDropDownMenu("My listings");
    }

    public void chooseFromDropDownMenu(String item) {
        $(byXpath(item_header_drop_Menu1+item+end_string)).click();
    }

    public void mySavedPropertiesMenu() {
        chooseFromDropDownMenu("My saved");
    }

    public void chooseListLoggedFromHeaderProfile() {
        sleep(2000);
        $(byXpath(tab_Header_AddListing)).click();

    }

    public void setPostalCode(String postCode, final String location) {
        String val = postCode;
        SelenideElement element = $(By.xpath(input_listingFlow_postcode));

        sleep(2000);

        $(By.xpath(input_listingFlow_postcode_inner)).click();
        element.clear();
        sleep(1000);
        for (int i = 0; i < val.length(); i++) {

            char c = val.charAt(i);
            sleep(500);
            //String s = new StringBuilder().append(c).toString();
            String s = String.valueOf(c);
            element.sendKeys(s);
            //$(By.xpath(input_listingFlow_postcode)).setValue(postCode);
            //$(By.xpath(input_listingFlow_postcode)).sendKeys(postCode);

        }

        sleep(1000);
        $(By.xpath(drop_postcode_location1+location+end_string)).click();
        sleep(1000);
    }

    public void setPostalCode1(String postCode, final String location) {
        String val = postCode;
        SelenideElement element = $(By.xpath(input_listingFlow_postcode));

        sleep(2000);
        $(By.xpath(input_listingFlow_postcode2)).click();
        $(By.xpath(input_listingFlow_postcode)).clear();
        sleep(1000);

        for (char  c : val.toCharArray()) {
            sleep(500);
            String s = String.valueOf(c);
            element.sendKeys(s);

        }

        sleep(1000);
        $(By.xpath(drop_postcode_location1+location+end_string)).click();
        sleep(1000);
    }

    public void chooseRoadFor(String road) {
        fillInField(road, $(byXpath(input_road)));
        sleep(1000);
    }

    public void chooseArea(final String area) {
        $(byXpath(drop_listFlow_area)).click();
        messageHelper.click(byXpath(drop_listFlow_area_list + area + end_string));
        sleep(2000);
    }

    public void pressAddListingFromHeaderNotLoggedUser() {
        $(byXpath(tab_listing_List_a_room)).click();
    }

    public void setPhoneNumber1(String Number) {
        fillInField(Number, $(byXpath(input_listingFlow_phone)));
        sleep(1000);
    }

    public void setTotalBedrooms(final String amount) {
        SelenideElement totalbedrooms = $(drop_totalRoom);
        sleep(2000);

        totalbedrooms.click();
        sleep(1000);
        totalbedrooms.selectOptionContainingText(amount);
        sleep(1000);
        $(byXpath(drop_totalRoom_field)).click();
    }

    public void setAllAmanities(String text1, String text2, String text3, String text4, String text5,
                                String text6, String text7, String text8, String text9, String text10,
                                String text11, String text12, String text13, String text14, String text15) {


        $(byXpath(setAmanity_string1 + text1 + end_string)).click();
        sleep(1000);
        $(byXpath(setAmanity_string1 + text2 + end_string)).click();
        sleep(1000);
        $(byXpath(setAmanity_string1 + text3 + end_string)).click();
        sleep(1000);
        $(byXpath(setAmanity_string1 + text4 + end_string)).click();
        sleep(1000);
        $(byXpath(setAmanity_string1 + text12 + end_string)).click();
        sleep(1000);
        $(byXpath(setAmanity_string1 + text13 + end_string)).click();
        sleep(1000);
        $(byXpath(setAmanity_string1 + text5 + end_string)).click();
        sleep(1000);
        $(byXpath(setAmanity_string1 + text6 + end_string)).click();
        sleep(1000);
        $(byXpath(setAmanity_string1 + text7 + end_string)).click();
        sleep(1000);
        $(byXpath(setAmanity_string1 + text8 + end_string)).click();
        sleep(1000);
        $(byXpath(setAmanity_string1 + text9 + end_string)).click();
        sleep(1000);
        $(byXpath(setAmanity_string1 + text10 + end_string)).click();
        sleep(1000);
        $(byXpath(setAmanity_string1 + text11 + end_string)).click();
        sleep(1000);
        $(byXpath(setAmanity_string1 + text14 + end_string)).click();
        sleep(1000);
        $(byXpath(setAmanity_string1 + text15 + end_string)).click();
        sleep(1000);

    }

    public void setAllAmanitiesFeatures(String text14, String text15) {

        $(byXpath(select_icon_Amanity+text14+end_string)).click();
        sleep(1000);
        $(byXpath(select_icon_Amanity+text15+end_string)).click();
        sleep(1000);
    }

    public void checkAllAmanities(String text1, String text2, String text3, String text4, String text5,
                                String text6, String text7, String text8, String text9, String text10,
                                String text11, String text12, String text13) {
        Condition attribute = attribute("checked");

        $(byXpath(check_Amanity+text1+check_Amanity_end)).shouldHave(attribute);
        $(byXpath(check_Amanity+text2+check_Amanity_end)).shouldHave(attribute);
        $(byXpath(check_Amanity+text3+check_Amanity_end)).shouldHave(attribute);
        $(byXpath(check_Amanity+text4+check_Amanity_end)).shouldHave(attribute);
        $(byXpath(check_Amanity+text12+check_Amanity_end)).shouldHave(attribute);
        $(byXpath(check_Amanity+text13+check_Amanity_end)).shouldHave(attribute);
        $(check_Amanity1+text5+check_Amanity_end1).shouldBe(selected);
        $(check_Amanity1+text6+check_Amanity_end1).shouldBe(selected);
        $(check_Amanity1+text7+check_Amanity_end1).shouldBe(selected);
        $(check_Amanity1+text8+check_Amanity_end1).shouldBe(selected);
        $(check_Amanity1+text9+check_Amanity_end1).shouldBe(selected);
        $(check_Amanity1+text10+check_Amanity_end1).shouldBe(selected);
        $(check_Amanity1+text11+check_Amanity_end1).shouldBe(selected);
    }


    public void setPropertyDescription(final String text) {
        fillInField(text, $(byXpath(field_ListFlow_propDecription)));
    }

    public void setMonthlyRent(String rent) {
        fillInField(rent, $(input_ListFlow_roomPrice));
     }

    public void setDeposit(String deposit) {
        fillInField(deposit, $(input_ListFlow_roomDeposit));
    }

    public void setTotalBills(String bills) {
        $(input_ListFlow_roomBills).scrollIntoView(true).setValue(bills);
        $(input_ListFlow_roomBills).shouldHave(value("400"));
    }

    public void setLeasePeriodRoom(final String roomNumber, final String min_Staying, final String max_Staying) {
        periodDate(roomNumber, min_Staying, max_Staying);
    }

    public void periodDate(final String roomNumber, final String minStaying,final String maxStaying) {

        $(input_room_Stay + roomNumber + minStay_End).click();
        $(byXpath(option_Stay_min + minStaying + end_string)).click();
        $(input_room_Stay + roomNumber + maxStay_End).click();
        $(byXpath(option_Stay_max + maxStaying + end_string)).click();
    }

    public void periodDateBuddy_up() {
        sleep(3000);
        $(byXpath(check_list_flow_Available)).shouldBe(checked);
        sleep(1000);
        $(byXpath(tab_buddy_Available)).click();
        sleep(1000);
        $(byXpath(input_buddy_Date)).click();
        sleep(1000);
        $(byXpath(tab_buddy_Date)).click();
        sleep(1000);
        $(tab_select_buddy_year).click();
        sleep(1000);
        $(byXpath(option_buddy_year)).click();
        sleep(1000);
    }


    public void setRoomDescription(String text) {
        $(byXpath(room_Text)).click();
        $(byXpath(input_room_Text)).setValue(text);
        // $("#room-1-description").shouldHave(text("text"));
    }

    public void copySecondRoom() {
        $(byXpath(button_copy_Room)).waitUntil(appear, 4000).click();
        $(input_price_second_Room).shouldBe(visible);
    }

    public void removeSecondRoom() {
        $(byXpath(button_remove_Room)).waitUntil(appear, 4000).click();
        $(input_price_second_Room).shouldNotBe(visible);
    }

    public void addAnotherRoom() {
        $(byXpath(button_add_Room)).waitUntil(visible, 4000).click();
    }


    public void setAnotherMonthlyRent(String rent, final String expectedValue) {
        fillInField(rent, $(input_price_third_Room));
        $(input_price_third_Room).shouldHave(Condition.value(expectedValue));
    }

    public void setAvailablePeriodRoom(final String roomNumber, final String year, final String date, final String nextMonth) {
        dateChange(roomNumber, year, date, nextMonth);
    }

    public void availabaleChecked(final String roomNumber) {
        $(byXpath(check_room_Available+roomNumber+check_room_Available_end)).shouldBe(checked);
    }

    public void continueListingWithoutPhoto() {
        $(byXpath(button_listing_photo_Finish)).waitUntil(appear, 4000).click();
        sleep(4000);
        $(byXpath(button_listing_photo_Finish_confirm)).waitUntil(appear, 6000).click();
        sleep(4000);
    }

    public void uploadProperty3Photos() {
        $(byXpath(input_Photo)).uploadFile(new File("src/test/resources/listing1.jpg"));
        sleep(6000);
        $(byXpath(input_Photo)).uploadFile(new File("src/test/resources/listing2.jpeg"));
        sleep(6000);
        $(byXpath(input_Photo)).uploadFile(new File("src/test/resources/Profile.png"));
        sleep(6000);
    }

    public void checkPhotos() {
        $(byXpath(listing_preview_Photo1)).shouldBe(Condition.visible);
        $(byXpath(listing_preview_Photo2)).shouldBe(Condition.visible);
        $(byXpath(listing_preview_Photo3)).shouldBe(Condition.visible);
    }

    public void finishPropertyCreatingAgency() {
        $(byXpath(button_listing_photo_Finish)).shouldBe(enabled).click();
    }

    public void viewListing() {
        sleep(2000);
        $(byXpath(button_viewListing)).click();
    }

    public void removeListingClick(final String option) {
        $(byXpath(button_removeListing)).waitUntil(appear, 10000).click();
        sleep(2000);
        $(byXpath(radio_button_Remove_first)).waitUntil(appear, 10000).selectRadio(option);
        sleep(2000);
        $(byXpath(button_submit_Remove)).waitUntil(Condition.appears, 10000).click();
        sleep(2000);
    }

    public void selectTypeUser(final String userType) {
        $(byXpath(field_select_UserType1+userType+end_string)).waitUntil(appear, 4000).click();
    }

    public void pressContinue() {
        $(button_listing_Next).waitUntil(appear, 4000).click();
    }

    public void pressBack() {
        sleep(3000);
        $(button_listing_Back).waitUntil(appear, 4000).click();
    }

    public void pressContinue1() {
        $(byXpath(h1_Page)).click();
        sleep(2000);
        $(button_listing_Next).waitUntil(appear, 4000).click();
    }

    public void finishPropertyAgencyWithSubs(String text) {
        $(byXpath(text_view_finishListing)).shouldHave(text(text));
    }

    public void pressAddListingNotLogged() {
        $(byXpath(tab_listing_List_a_room)).click();
    }

    public void pressAddListingNotLoggedBlock() {
        $(byXpath(button_listing_blockUnderSearch_homePage)).click();
    }

    public void pressAddListingNotLoggedBlock1() {
        $(byXpath(h3_select_Homepage)).click();
        $(byXpath(button_listing_blockSelect_homePage)).click();
    }

    public void addListingFromListingPage() {
        $(byXpath(button_myListingPage_addNewListing)).click();
    }

    public void uploadPropertyLargePhoto() {
        int before = $$(byXpath(listing_preview_Photo)).size();
        $(byXpath(input_Photo)).uploadFile(new File("src/test/resources/8mb-artwork.jpg"));
        sleep(2000);
        $(byXpath(listing_preview_Photo1)).shouldBe(Condition.visible);
        sleep(6000);
        int after = $$(byXpath(listing_preview_Photo)).size();
        Assert.assertEquals(before, after);


    }

    public void uploadPropertyNotPhoto() {
        int before = $$(byXpath(listing_preview_Photo)).size();
        $(byXpath(input_Photo)).uploadFile(new File("src/test/resources/IF-pdf.pdf"));
        sleep(2000);
        $(byXpath(listing_preview_Photo1)).shouldBe(Condition.visible);
        sleep(6000);
        int after = $$(byXpath(listing_preview_Photo)).size();
        Assert.assertEquals(before, after);


    }

    public void bottomAddListing() {
        $(byXpath(button_addYourListing_bottomBlock_HomePage)).click();
    }


    public void closeRenewPopup() {
        sleep(2000);
        if ($(byXpath(button_closeRenewPopup)).exists()) {
            $(byXpath(button_closeRenewPopup)).waitUntil(visible, 2000).click();        }
    }

    public void clickCardWithMatch() {
        $(byXpath("//span[@class='u_ed-inline-block']")).click();
    }

    public void addListingWithoutPhotoEmptyAreaVerif(String postCode, String locationDropInDown, String area, String totalBedrooms,
                                                     String rent, final String errorMessage) {
        setPostalCode1(postCode, locationDropInDown);
        pressContinue();
        sleep(2000);
        pressContinue1();
        VerificationHelper.areaBlank(errorMessage);
        chooseArea(area);
        pressContinue();
        setTotalBedrooms(totalBedrooms);
        scrollDownPageOn("1300");
        setMonthlyRent(rent);
        pressContinue();
        continueListingWithoutPhoto();
    }

    public void addListingWithoutAreaDefault(String postCode, String totalBedrooms, String rent, String locationDropInDown, final String city) {
        setPostalCode(postCode, locationDropInDown);
        pressContinue();
        verifyCity(city);
        pressContinue1();
        //verificationHelper.areaBlank();
        pressContinue();
        setTotalBedrooms(totalBedrooms);
        scrollDownPageOn("1400");
        setMonthlyRent(rent);
        pressContinue();
        continueListingWithoutPhoto();
    }

    public void propertytitle(String title) {
        $(input_listing_Titile).setValue(title);
    }

    public void clickEdit() {
        $(byXpath(button_listingEdit)).click();
    }


    public void changeAboutOptions(final String amenity1, final String amenity2, final String amenity3, final String amenity4, final String amenity5, final String amenity6, final String amenity7, final String amenity8, final String amenity9, final String amenity10, final String amenity11, final String amenity12, final String amenity13) {
        $(byXpath(select_icon_Amanity+amenity1+end_string)).waitUntil(visible, 20000).click();
        $(byXpath(select_icon_Amanity+amenity2+end_string)).click();
        $(byXpath(select_icon_Amanity+amenity3+end_string)).click();
        $(byXpath(select_icon_Amanity+amenity4+end_string)).click();
        $(byXpath(radio_button_listPage_toFMBlock)).click();
        sleep(1000);
        $(byXpath(select_icon_Amanity+amenity5+end_string)).click();
        $(byXpath(select_icon_Amanity+amenity6+end_string)).click();
        $(byXpath(select_icon_Amanity+amenity7+end_string)).click();
        $(byXpath(select_icon_Amanity+amenity8+end_string)).click();
        $(byXpath(select_icon_Amanity+amenity9+end_string)).click();
        $(byXpath(select_icon_Amanity+amenity10+end_string)).click();
        $(byXpath(select_icon_Amanity+amenity11+end_string)).click();
        $(byXpath(select_icon_Amanity+amenity12+end_string)).click();
        $(byXpath(select_icon_Amanity+amenity13+end_string)).click();

    }

    public void addListingWithoutPhotoBuddyUp(String postCode, String locationDropInDown, String area, String totalBedrooms,
                                              String rent, final String errorMessage) {
        setPostalCode(postCode, locationDropInDown);
        pressContinue();
        sleep(2000);
        pressContinue1();
        VerificationHelper.areaBlank(errorMessage);
        chooseArea(area);
        pressContinue1();
        verifyRoomOnly("-300");
        checkWholeProperty("-300");
        setTotalBedrooms(totalBedrooms);
        scrollDownPageOn("1300");
        setMonthlyRent(rent);
        pressContinue();
        continueListingWithoutPhoto();
    }

    private void checkWholeProperty(final String scrollPoints) {
        if (!$(byXpath(check_listFlow_aboutProp_privateRooms)).exists()) {
            scrollDownPageOn(scrollPoints);
            sleep(500);}
        $(byXpath(check_listFlow_aboutProp_privateRooms +input)).shouldBe(checked);
        $(byXpath(check_listFlow_aboutProp_whole)).click();
        $(byXpath(check_listFlow_aboutProp_whole +input)).shouldBe(checked);
        $(byXpath(check_listFlow_aboutProp_privateRooms +input)).shouldNotBe(checked);
    }

    private void verifyRoomOnly(final String scrollPoints) {
        if (!$(byXpath(check_listFlow_aboutProp_privateRooms)).exists()) {
            scrollDownPageOn(scrollPoints);
        sleep(500);}
        $(byXpath(check_listFlow_aboutProp_whole +input)).shouldNotBe(checked);
        $(byXpath(check_listFlow_aboutProp_privateRooms +input)).shouldBe(checked);

    }

    public void verifyBreadCrumbs(final String roomsSearch, final String citySearch, final String areaSearch, final String listingOverview) {
        verifyBreadCrumbsWithoutArea(roomsSearch,citySearch,listingOverview);
        $(byXpath(link_breadCrumb+areaSearch+end_string)).should(exist);

    }

    public void verifyBreadCrumbsWithoutArea(final String roomsSearch, final String citySearch, final String listingOverview) {
        $(byXpath(link_breadCrumb+roomsSearch+end_string)).should(exist);
        $(byXpath(link_breadCrumb+citySearch+end_string)).should(exist);
        $(byXpath(link_breadCrumb+listingOverview+end_string)).should(exist);
    }

    public void goByLink(final String areaSearch) {
        $(byXpath(link_breadCrumb+areaSearch+end_string)).click();
    }

    public void isCheckedSutableFore(final String sutableFor) {
        $(byXpath(check_suitable_ListFlow+sutableFor+check_suitable_ListFlow_end)).shouldBe(checked);
    }

    public void clickSutableFore(final String sutableFor) {
        $(byXpath(check_suitable_ListFlow+sutableFor+end_string)).click();
    }

    public void fillRoomData(String newRent, String newDeposit, String newBills, String year, String date,
                             final int optionMinStay, final int optionMaxStay, String roomDescription, final String Month) {

        fillInField(newRent, $(byXpath(input_roomPrice)));
        fillInField(newDeposit, $(byXpath(input_roomDeposit)));
        fillInField(newBills, $(byXpath(input_roomBills)));

        dateChangeEdit( year, date, Month);

        $(byXpath(field_roomMinStay)).click();
        $$(byXpath(field_roomMinStay_option)).get(optionMinStay).click();

        $(byXpath(field_roomMaxStay)).click();
        $$(byXpath(field_roomMaxStay_option)).get(optionMaxStay).click();


        fillInField(roomDescription, $(byXpath(input_roomDescr_editPage)));
        sleep(1000);
    }

    public void availableDateIsCheckedAddingRoom() {
        $(byXpath(check_edit_addingRoom_Available)).shouldBe(checked);
    }

    public void availableEdiRoomCheck(final String roomID) {
        $(byXpath(check_edit_roomDate_Available1+roomID+check_edit_roomDate_Available1_end)).click();
    }

    public void clickEditRoom(final String roomNumber) {
        $(byXpath(icon_edit_room+roomNumber+end_string)).click();
    }

    public void deactivateVerifyRoom(final String roomId1, String availableFrom, final String textRoomAvail) {
        $(byXpath(text_available_Room+roomId1+end_string)).shouldHave(text(availableFrom));
        sleep(1000);
        $(byXpath(icon_disable_Room+roomId1+icon_disable_Room_Room_end)).click();
        sleep(1000);
        $(byXpath(text_available_Room+roomId1+end_string)).shouldHave(text(textRoomAvail));

    }
    public String monthAvailableFrom(String roomID) {

        String monthAvailableFrom = $(byXpath(text_available_Room+roomID+end_string)).text().substring(17);
        return monthAvailableFrom;

    }

    public static String monthAvailableFrom1(final String roomNumber) {

        String monthAvailableFrom1 = $(byXpath("(//td[contains(@data-state,'availability_')])[" + roomNumber + "]")).text().substring(17);
        return monthAvailableFrom1;

    }


    public void activateVerifyRoom(final String roomId) {

        $(byXpath("//td[@data-state='availability_" + roomId + "']")).shouldHave(text("Unavailable"));
        sleep(1000);
        $(byXpath(icon_disable_Room+roomId+icon_disable_Room_Room_end)).click();
        sleep(1000);
        $(byXpath("//td[@data-state='availability_" + roomId + "']")).shouldHave(text("Available now"));

    }

    public void dateChange(String roomNumber, final String year, final String date, final String Month) {

        if ($(byXpath("//input[contains(@id,'room-available_from') and @name='Room[" + roomNumber + "][availability]']")).is(checked)){
            $(byXpath("//label[input[contains(@id,'room-available_from') and @name='Room[" + roomNumber + "][availability]']]")).click();}

        $(byXpath("//div[input[contains(@id,'room-" + roomNumber + "-available_from')]]")).click();

        $(byXpath("//a[contains(@class,'ui-corner-all') and @title='" + Month + "']")).waitUntil(appear, 4000).click();
        $(".ui-datepicker-year").waitUntil(appear, 4000).click();
        messageHelper.click(byXpath("//option[@value='" + year + "']"));
        $(byXpath("//a[@class='ui-state-default' and contains(text(), '" + date + "')]")).waitUntil(appear, 4000).click();
    }

    public void dateChangeEdit(final String year, final String date, final String Month) {

        if ($(byXpath("//div[contains(@class,'form-group')]//input[contains(@id,'room-available_from') and @name='Room[availability]']")).is(checked)){
            $(byXpath("//div[contains(@class,'form-group')]//label[input[contains(@id,'room-available_from') and @name='Room[availability]']]")).click();}

        $(byXpath("//label[contains(.,'Available from')]")).click();

        $(byXpath("//a[contains(@class,'ui-corner-all') and @title='" + Month + "']")).waitUntil(appear, 4000).click();
        $(".ui-datepicker-year").waitUntil(appear, 4000).click();
        messageHelper.click(byXpath("//option[@value='" + year + "']"));
        $(byXpath("//a[@class='ui-state-default' and contains(text(), '" + date + "')]")).waitUntil(appear, 4000).click();
    }

    public void verifyAvailable(final Condition checked) {
        $(byXpath("//div[contains(@class,'form-group')]//input[contains(@id,'room-available_from') " +
                "and @name='Room[availability]']")).shouldBe(checked);
    }





    public void verifyCity(final String city) {
        $(byXpath("//input[@id='property-city']")).shouldHave(value(city));
    }

    public void clickRoomsSection() {
        $(byXpath("//div[@class='row']//a[contains(.,'Rooms')]")).click();
    }

    public void removeRooms(final String roomNumber, final String expectedDialogText) {
        $(byXpath("(//a[@title='Delete'])[" + roomNumber + "]")).click();
        //confirm(expectedDialogText);
        sleep(1000);
        clickButton(expectedDialogText, "button");
        sleep(2000);

    }

    public static int roomAmountIs() {
        int roomAmountIs = $$(byXpath("//table[contains(@class,'table u_m20-bottom-xs u_m0-bottom-sm')]")).size();
        return roomAmountIs;
    }


    public void changeWholeOfProperty(final String defaultListingIs, final String clickChangeTo) {
        checkerPropertyWhole(defaultListingIs);
        $(byXpath("//label[contains(.,'" + clickChangeTo + "')]")).click();

    }

    public void checkerPropertyWhole(final String listingIs) {
        $(byXpath("//label[contains(.,'" + listingIs + "')]/input")).shouldBe(checked);

    }


    public void featuresPropertyClick(final String featureIdName, final Condition conditionNot) {

        $(byXpath("//label/input[@id='"+featureIdName+"']")).shouldNotBe(conditionNot);
        $(byXpath("//label[input[@id='"+featureIdName+"']]")).click();
    }

    public void featuresPropertyIsChecked(final String featureIdName, final Condition condition) {
        $(byXpath("//label/input[@id='"+featureIdName+"']")).shouldBe(condition);

    }

    public void saveQuitHeaderMenuListing() {
        $(byXpath("//header//a[contains(.,'Save & quit')]")).click();
        //$(byXpath("//header//ul[@class='nav navbar-right']/a")).click();


    }

    public void continueListing() {
        $(byXpath("//header//a[span[contains(.,'adding a')]]")).click();
    }


    public void editRoomVerifData(final String roomId, String monthlyRentOld, String oldDeposit, String totalBills, final String optionMinStay, final String optionMaxStay, String roomDescription) {
        $(byXpath("//a[@data-room-id='" + roomId + "' and @data-toggle]")).click();
        $(byXpath("//input[@id='room-price']")).shouldHave(value(monthlyRentOld));
        $(byXpath("//input[@id='room-deposit']")).shouldHave(value(oldDeposit));
        $(byXpath("//input[@id='room-deposit']")).shouldHave(value(totalBills));
        $(byXpath("//select[@id='room-min_stay']/option[@value='" + optionMinStay + "']")).shouldBe(selected);
        $(byXpath("//select[@id='room-max_stay']/option[@value='" + optionMaxStay + "']")).shouldBe(selected);
        $(byXpath("//textarea[@id='room-description']")).shouldHave(text(roomDescription));
    }
}
