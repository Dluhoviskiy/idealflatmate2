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
    String privateRooms = "//div[@id='property-is_whole_rent']//label[contains(.,'Private room(s)')]";
    String whole = "//div[@id='property-is_whole_rent']//label[contains(.,'Entire property')]";



    public final MessageHelper messageHelper = new MessageHelper();


    SelenideElement continueUpgradeListAgent =  $(byXpath("//div[@class='container u_p20-top-xs u_p30-top-sm']/a[contains(., 'Continue without upgrading')]"));


    public void openDropDownMenu() {
        $(byXpath("(//li[@class='dropdown nav-ihm-profile-bars'])[1]")).waitUntil(visible, 5000).click();
    }

    public void pressAddListingFromBody() {
        SelenideElement addListing = $(byXpath("//ul[contains(@class,'nav navbar-nav')]//a[contains(.,'Add a Listing')]"));
        addListing.click();

    }

    public void chooseListingsFromDropDownMenu() {
        sleep(2000);
        $(byXpath("//nav//li//a//span[@class='hidden-xs']")).click();
        $(byXpath("(//a[contains(text(), 'My listings')])[1]")).click();

    }

    public void chooseListLoggedFromHeaderProfile() {
        sleep(2000);
        $(byXpath("//ul[contains(@class,'nav-aux hidden-xs hidden-sm')]//a[contains(.,'Add a Listing')]")).click();

    }

    public void setPostalCode(String postCode, final String location) {
        String val = postCode;
        SelenideElement element = $(By.xpath("//input[contains(@class,'select2-search')]"));

        sleep(2000);

        $(By.xpath("//span[contains(@id,'select2-property-location-container')]")).click();
        element.clear();
        sleep(1000);
        for (int i = 0; i < val.length(); i++) {

            char c = val.charAt(i);
            sleep(500);
            //String s = new StringBuilder().append(c).toString();
            String s = String.valueOf(c);
            element.sendKeys(s);
            //$(By.xpath("//input[contains(@class,'select2-search')]")).setValue(postCode);
            //$(By.xpath("//input[contains(@class,'select2-search')]")).sendKeys(postCode);

        }

        sleep(1000);
        $(By.xpath("//li[contains(.,'"+ location + "')]")).click();
        sleep(1000);
    }

    public void setPostalCode1(String postCode, final String location) {
        String val = postCode;
        SelenideElement element = $(By.xpath("//input[contains(@class,'select2-search')]"));

        sleep(2000);
        $(By.xpath("//span[@class='selection']//span[contains(@class,'select2-selection__rendered')]")).click();
        $(By.xpath("//input[contains(@class,'select2-search')]")).clear();
        sleep(1000);

        for (char  c : val.toCharArray()) {
            sleep(500);
            String s = String.valueOf(c);
            element.sendKeys(s);

        }

        sleep(1000);
        $(By.xpath("//li[contains(.,'"+ location + "')]")).click();
        sleep(1000);
    }

    public void pressContinueButton() {
        $(byXpath("//button")).waitUntil(visible, 6000).click();
        sleep(4000);
    }

    public void chooseRoadFor(String road) {

        messageHelper.click(byXpath("//input[@id='property-route']"));
        $(byXpath("//input[@id='property-route']")).setValue(road);
        sleep(2000);
    }

    public void chooseArea(final String area) {
        messageHelper.click(byName("Property[area_link_id]"));
        messageHelper.click(byXpath("//select[@id='property-area_link_id']/option[contains(.,'" + area + "')]"));
        sleep(2000);
    }

    public void pressAddListingFromHeaderNotLoggedUser() {
        $(byXpath("//ul[starts-with(@class, 'nav navbar-nav')]//a[contains(.,'List a room')]")).click();
    }


    public void setPhoneNumber(String Number, String text) {
       $(byXpath("//label[contains(text(), 'Phone Number')]")).scrollIntoView(text);
       fillInField1(Number, $("#property-phone_number"),  $(byXpath("#signup-need-firstname")));
    }

    public void setPhoneNumber1(String Number) {

        fillInField1(Number, $(byXpath("//label[contains(., 'Phone Number')]/..//input[@id='property-phone_number']")),
                            $(byXpath("//input[@id='property-phone_number']")));

        $(byXpath("//input[@id='property-phone_number']")).setValue(Number);
        sleep(2000);
    }

    public void setTotalBedrooms(final String amount) {
        SelenideElement totalbedrooms = $("#property-bedrooms_no");
        sleep(1000);

        totalbedrooms.click();
        sleep(1000);
        totalbedrooms.selectOptionContainingText(amount);
        sleep(1000);
        $(byXpath("//label[contains(.,'Total bedrooms')]")).click();
    }

    public void setAllAmanities(String text1, String text2, String text3, String text4, String text5,
                                String text6, String text7, String text8, String text9, String text10,
                                String text11, String text12, String text13, String text14, String text15) {
        String string = "//div/label[contains(.,'";
        String string2 = "')]";

        $(byXpath(string + text1 + string2)).click();
        sleep(1000);
        $(byXpath(string + text2 + string2)).click();
        sleep(1000);
        $(byXpath(string + text3 + string2)).click();
        sleep(1000);
        $(byXpath(string + text4 + string2)).click();
        sleep(1000);
        $(byXpath(string + text12 + string2)).click();
        sleep(1000);
        $(byXpath(string + text13 + string2)).click();
        sleep(1000);
        $(byXpath(string + text5 + string2)).click();
        sleep(1000);
        $(byXpath(string + text6 + string2)).click();
        sleep(1000);
        $(byXpath(string + text7 + string2)).click();
        sleep(1000);
        $(byXpath(string + text8 + string2)).click();
        sleep(1000);
        $(byXpath(string + text9 + string2)).click();
        sleep(1000);
        $(byXpath(string + text10 + string2)).click();
        sleep(1000);
        $(byXpath(string + text11 + string2)).click();
        sleep(1000);
        $(byXpath(string + text14 + string2)).click();
        sleep(1000);
        $(byXpath(string + text15 + string2)).click();
        sleep(1000);

    }

    public void setAllAmanitiesFeatures(String text14, String text15) {
        String string = "//div/label[contains(.,'";
        String string2 = "')]";


        $(byXpath(string + text14 + string2)).click();
        sleep(1000);
        $(byXpath(string + text15 + string2)).click();
        sleep(1000);

    }

    public void checkAllAmanities(String text1, String text2, String text3, String text4, String text5,
                                String text6, String text7, String text8, String text9, String text10,
                                String text11, String text12, String text13) {
        String string = "//div/label[contains(.,'";
        String string3 = "')]/input[@type='checkbox']";
        Condition attribute = attribute("checked");

        $(byXpath(string + text1 + string3)).shouldHave(attribute);
        $(byXpath(string + text2 + string3)).shouldHave(attribute);
        $(byXpath(string + text3 + string3)).shouldHave(attribute);
        $(byXpath(string + text4 + string3)).shouldHave(attribute);
        $(byXpath(string + text12 + string3)).shouldHave(attribute);
        $(byXpath(string + text13 + string3)).shouldHave(attribute);
        $("#"+text5+"").shouldBe(selected);
        $("#"+text6+"").shouldBe(selected);
        $("#"+text7+"").shouldBe(selected);
        $("#"+text8+"").shouldBe(selected);
        $("#"+text9+"").shouldBe(selected);
        $("#"+text10+"").shouldBe(selected);
        $("#"+text10+"").shouldBe(selected);
    }


    public void setPropertyDescription() {
        $(byXpath("//div[@class='form-group field-property-description']/div[1]/textarea")).click();
        $(byXpath("//textarea[@id='property-description']")).setValue("Very good flat");
        // $(byXpath("//div[@class='form-group field-property-description']/div[1]/textarea")).shouldHave(text("Very good flat"));
    }

    public void setMonthlyRent(String rent) {

        fillInField(rent, $("#room-1-price"));
     }

    public void setDeposit(String deposit) {
        fillInField(deposit, $("input#room-1-deposit"));
    }

    public void setTotalBills(String bills) {
        $("input#room-1-bills").scrollIntoView(true).setValue(bills);
        $("#room-1-bills").shouldHave(value("400"));
    }

    public void setLeasePeriodRoom(final String roomNumber, final String min_Staying, final String max_Staying) {
        periodDate(roomNumber, min_Staying, max_Staying);
    }

    public void setPeriodBuddy_up() {
        periodDateBuddy_up();
    }

    public void periodDate(final String roomNumber, final String minStaying,final String maxStaying) {

        $("#room-" + roomNumber + "-min_stay").click();
        $(byXpath("//*[@id='room-1-min_stay']/option[contains(.,'" + minStaying + "')]")).click();
        $("#room-" + roomNumber + "-max_stay").click();
        $(byXpath("//*[@id='room-1-max_stay']/option[contains(.,'" + maxStaying + "')]")).click();
        //$("#room-" + roomNumber + "-max_stay > option:nth-child(13)").click();
    }

    public void periodDateBuddy_up() {
        sleep(3000);
        $(byXpath("//div[@id='js-groups-list']//label//input[@id='buddyupgroup-available_now']")).shouldBe(checked);
        sleep(1000);
        $(byXpath("//div[@id='js-groups-list']//label[contains(.,'Or choose date')]")).click();
        sleep(1000);
        $(byXpath("//div[@id='js-groups-list']//input[contains(@class,'form-control u_m5-top')]")).click();
        sleep(1000);
        $(byXpath("//div//a[@class='ui-datepicker-next ui-corner-all']")).click();
        sleep(1000);
        $("select.ui-datepicker-year > option:nth-child(13)").click();
        sleep(1000);
        $(byXpath("//tr//a[@class='ui-state-default' and contains(.,'13')]")).click();
        sleep(1000);
    }


    public void setRoomDescription(String text) {
        $(byXpath("//div[@class='form-group field-room-1-description']/textarea")).click();
        $(byXpath("//div[@class='form-group field-room-1-description in-use']/textarea")).setValue(text);
        // $("#room-1-description").shouldHave(text("text"));
    }

    public void copySecondRoom() {
        $(byXpath("//button[@class='btn btn-sm btn--type-5 js-room-copy']")).waitUntil(appear, 4000).click();
        $(byXpath("//div/input[@id='room-2-price']")).shouldBe(visible);
    }

    public void removeSecondRoom() {
        $(byXpath("//button[@class='btn btn-sm btn-primary-outline js-room-remove u_ef-left']")).waitUntil(appear, 4000).click();
        $(byXpath("//div/input[@id='room-2-price']")).shouldNotBe(visible);
    }

    public void addAnotherRoom() {
        $(byXpath("//button[@class='btn btn-sm btn--type-4 js-room-add']")).waitUntil(visible, 4000).click();

    }


    public void setAnotherMonthlyRent(String rent) {
        fillInField(rent, $("#room-3-price"));
        $(byXpath("//div/input[@id='room-3-price']")).shouldHave(Condition.value("800"));

    }

    public void setAvailablePeriodRoom(final String roomNumber, final String year, final String date, final String nextMonth) {

        dateChange(roomNumber, year, date, nextMonth);

    }

    public void availabaleChecked(final String roomNumber) {
        $(byXpath("//input[contains(@id,'room-available_from') and @name='Room[" + roomNumber + "][availability]']")).shouldBe(checked);


    }



    public void ContinueListingWithoutPhoto() {
        $(byXpath("//*[@id=\"wizard-finish-btn\"]")).waitUntil(appear, 4000).click();
        sleep(4000);
        $(byXpath("//button[@class='confirm']")).waitUntil(appear, 6000).click();
        sleep(4000);

        //confirm("Are you sure you want to continue without photos?");
       // $("#uploadimageform-imagefiles").uploadFile(new File("src/test/resources/Property1.jpg"));
       // $(byXpath("(//div[@class='file-preview-frame krajee-default file-preview-initial file-sortable kv-preview-thumb '])[1]")).shouldBe(Condition.visible);
    }

    public void uploadProperty3Photos() {
        $(byXpath("//input[@id='uploadimageform-imagefiles']")).uploadFile(new File("src/test/resources/listing1.jpg"));
        sleep(6000);
        $(byXpath("//input[@id='uploadimageform-imagefiles']")).uploadFile(new File("src/test/resources/listing2.jpeg"));
        sleep(6000);
        $(byXpath("//input[@id='uploadimageform-imagefiles']")).uploadFile(new File("src/test/resources/Profile.png"));
        sleep(6000);
    }

    public void checkPhotos() {
        $(byXpath("(//div[@class='file-preview-frame krajee-default file-preview-initial file-sortable kv-preview-thumb '])[1]")).shouldBe(Condition.visible);
        $(byXpath("(//div[@class='file-preview-frame krajee-default file-preview-initial file-sortable kv-preview-thumb '])[2]")).shouldBe(Condition.visible);
        $(byXpath("(//div[@class='file-preview-frame krajee-default file-preview-initial file-sortable kv-preview-thumb '])[3]")).shouldBe(Condition.visible);
    }

    public void finishPropertyCreatingAgency() {
        $(byXpath("//*[@id='wizard-finish-btn']")).shouldBe(enabled).click();
       // continueUpgradeListAgent.click();
       // $(byXpath("//p[@class='u_m20-top list-property-title']")).shouldHave(text("In order to list your property you need to"));
    }

    public void viewListing() {
        sleep(2000);
        $(byXpath("//a[@class='btn btn-half btn-primary listing-panel-button u_m10-bottom-xs']")).click();
    }

    public void RemoveListing() {
        $(byXpath("//button[contains(@class, \"listing-panel-delete\")]")).waitUntil(appear, 10000).click();
        sleep(2000);
        $(byXpath("(//input[1][@type='radio'])[1]")).waitUntil(appear, 10000).selectRadio("0");
        sleep(2000);
        $(byXpath("//button[@type='submit' and contains(text(), 'Delete property')]")).waitUntil(Condition.appears, 10000).click();
        sleep(2000);
    }
    private void RemoveUnfinishedListing() {
        $(byXpath("//button[starts-with(@class,'btn btn-primary-o')]")).waitUntil(appear, 4000).click();
        $(byXpath("(//input[1][@type='radio'])[1]")).waitUntil(appear, 4000).selectRadio("0");
        $(byXpath("//button[@type='submit' and contains(text(), 'Delete property')]")).waitUntil(Condition.appears, 4000).click();
        sleep(4000);
    }

    public void selectTypeUser(final String userType) {
        $(byXpath("//label[starts-with(@for,'type_id_') and contains(.,'" + userType + "')]")).waitUntil(appear, 4000).click();
    }



    public void pressContinue() {
        $("#wizard-form #wizard-next").waitUntil(appear, 4000).click();
    }

    public void pressBack() {
        sleep(3000);
        $("#wizard-back").waitUntil(appear, 4000).click();
    }

    public void pressContinue1() {

        $(byXpath("//h1")).click();
        sleep(2000);
        $("#wizard-form #wizard-next").waitUntil(appear, 4000).click();

        //byText("Continue ");

    }


    public void finishPropertyAgencyWithSubs(String text) {

        $(byXpath("//div[@class='u_p20-bottom u_b-bottom']/span")).shouldHave(text(text));

    }

    public void pressAddListingNotLogged() {
        $(byXpath("(//a[contains(., 'List a room')])[1]")).click();
    }

    public void pressAddListingNotLoggedBlock() {
        $(byXpath("//div[starts-with(@class, 'col-md-7 u_p15 u_p0-right')]//a[contains(., 'Add')]")).click();
    }
    public void pressAddListingNotLoggedBlock1() {
        $(byXpath("//h3[contains(.,'Select')]")).click();
        $(byXpath("//a[contains(., 'List your room')]")).click();
    }


    public void addListingFromPage() {
        $(byXpath("//a[@class='btn btn-info btn-sm u_ef-right-sm u_ed-block-xs']")).click();
    }


    public void uploadPropertyLargePhoto() {
        int before = $$(byXpath("//div[@class='kv-file-content']/img")).size();
        $(byXpath("//input[@id='uploadimageform-imagefiles']")).uploadFile(new File("src/test/resources/8mb-artwork.jpg"));
        sleep(2000);
        $(byXpath("(//div[@class='file-preview-frame krajee-default file-preview-initial file-sortable kv-preview-thumb '])[1]")).shouldBe(Condition.visible);
        sleep(6000);
        int after = $$(byXpath("//div[@class='kv-file-content']/img")).size();
        Assert.assertEquals(before, after);


    }

    public void uploadPropertyNotPhoto() {
        int before = $$(byXpath("//div[@class='kv-file-content']/img")).size();
        $(byXpath("//input[@id='uploadimageform-imagefiles']")).uploadFile(new File("src/test/resources/IF-pdf.pdf"));
        sleep(2000);
        $(byXpath("(//div[@class='file-preview-frame krajee-default file-preview-initial file-sortable kv-preview-thumb '])[1]")).shouldBe(Condition.visible);
        sleep(6000);
        int after = $$(byXpath("//div[@class='kv-file-content']/img")).size();
        Assert.assertEquals(before, after);


    }

    public void bottomAddListing() {
        $(byXpath("//div[@class='col-xs-12 col-sm-6']/a")).click();
    }


    public void closeRenewPopup() {
        String match1= "//button[@class='btn btn-sm close u_m15' and @aria-label='Close']";
        sleep(2000);
        if ($(byXpath(match1)).exists()) {
            $(byXpath(match1)).waitUntil(visible, 2000).click();
        }
    }

    public void clickCardWithMatch() {
        $(byXpath("//span[@class='u_ed-inline-block']")).click();

    }

    public void addListingWithoutPhoto(String postCode,  String area,  String totalBedrooms, String rent, String locationDropInDown) {
        setPostalCode1(postCode, locationDropInDown);
        pressContinue();
        sleep(2000);
        pressContinue1();
        //verificationHelper.areaBlank();
        chooseArea(area);
        pressContinue();
        setTotalBedrooms(totalBedrooms);
        scrollDownPageOn("1300");
        setMonthlyRent(rent);
        pressContinue();

        ContinueListingWithoutPhoto();
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

        ContinueListingWithoutPhoto();
    }

    public void propertytitle(String title) {
        $("#property-title").setValue(title);
    }

    public void clickEdit() {
        $(byXpath("//div/a[contains(.,'Edit')]")).click();
    }


    public void changeAboutOptions() {

        //Configuration.browserSize = "1024x1024";
        $(byXpath("//label[contains(.,' Garden')]")).waitUntil(visible, 20000).click();
        $(byXpath("//label[contains(.,' Communal living room')]")).click();
        $(byXpath("//label[contains(.,' Balcony/patio')]")).click();
        $(byXpath("//label[contains(.,' Parking')]")).click();

        $(byXpath("//div[@class='container-max-940 u_bg-white']//a[contains(.,'ideal flatmate')]")).click();
        sleep(3000);

        $(byXpath("//label[contains(.,'Pets Accepted')]")).click();
        $(byXpath("//label[contains(.,'Smokers Accepted')]")).click();
        $(byXpath("//label[contains(.,'Suitable for couples')]")).click();
        $(byXpath("//label[contains(.,'LGBT Friendly')]")).click();
        $(byXpath("//label[contains(.,'Family Friendly')]")).click();
        $(byXpath("//label[contains(.,'Trans Friendly')]")).click();
        $(byXpath("//label[contains(.,'Vegan Household')]")).click();
        $(byXpath("//label[contains(.,'Vegetarian Household')]")).click();
        $(byXpath("//label[contains(.,'DSS Accepted')]")).click();

    }

    public void addListingWithoutPhotoBuddyUp(String postCode, String amount, String rent, String location) {
            setPostalCode(postCode, location);
            pressContinue();

            pressContinue1();
            //verificationHelper.areaBlank();

            verifyRoomOnly();
            checkWholeProperty();

            setTotalBedrooms(amount);

            scrollDownPageOn("1400"); sleep(1000);
            setMonthlyRent(rent);
            pressContinue();

            ContinueListingWithoutPhoto();
    }

    private void checkWholeProperty() {
        if (!$(byXpath(privateRooms)).exists()) {
            scrollDownPageOn("-300");
            sleep(500);}
        $(byXpath(privateRooms+"/input")).shouldBe(checked);
        $(byXpath(whole)).click();
        $(byXpath(whole+"/input")).shouldBe(checked);
        $(byXpath(privateRooms+"/input")).shouldNotBe(checked);
    }

    private void verifyRoomOnly() {
        if (!$(byXpath(privateRooms)).exists()) {
            scrollDownPageOn("-300");
        sleep(500);}

        $(byXpath(whole+"/input")).shouldNotBe(checked);
        $(byXpath(privateRooms+"/input")).shouldBe(checked);

    }

    public void verifyBreadCrumbs(final String roomsSearch, final String citySearch, final String areaSearch, final String listingOverview) {
        verifyBreadCrumbsWithoutArea(roomsSearch,citySearch,listingOverview);
        $(byXpath("//ul[@class='custom-breadcrumbs']//li/a[contains(.,'" + areaSearch + "')]")).should(exist);

    }

    public void verifyBreadCrumbsWithoutArea(final String roomsSearch, final String citySearch, final String listingOverview) {
        $(byXpath("//ul[@class='custom-breadcrumbs']//li/a[contains(.,'" + roomsSearch + "')]")).should(exist);
        $(byXpath("//ul[@class='custom-breadcrumbs']//li/a[contains(.,'" + citySearch + "')]")).should(exist);

        $(byXpath("//ul[@class='custom-breadcrumbs']//li[contains(.,'" + listingOverview + "')]")).should(exist);
    }



    public void goByLink(final String areaSearch) {
        $(byXpath("//ul[@class='custom-breadcrumbs']//li/a[contains(.,'" + areaSearch + "')]")).click();
    }

    public void isCheckedSutableFore(final String sutableFor) {
        $(byXpath("//span[contains(.,'" + sutableFor + "')]/../input")).shouldBe(checked);
    }

    public void clickSutableFore(final String sutableFor) {
        $(byXpath("//span[contains(.,'" + sutableFor + "')]")).click();
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

    public void fillRoomData(String newRent, String newDeposit, String newBills, String year, String date,
                             final int optionMinStay, final int optionMaxStay, String roomDescription, final String Month) {

        //int optionMaxStay1 = optionMaxStay + 1;
        //int optionMinStay1 = optionMinStay + 1;
        fillInField1(newRent, $(byXpath("//input[@id='room-price']")), $(byXpath("//input[@id='room-price']")));
        fillInField1(newDeposit, $(byXpath("//input[@id='room-deposit']")), $(byXpath("//input[@id='room-deposit']")));
        fillInField1(newBills, $(byXpath("//input[@id='room-bills']")), $(byXpath("//input[@id='room-bills']")));

        dateChangeEdit( year, date, Month);

        $(byXpath("//select[@id='room-min_stay']")).click();
        $$(byXpath("//select[@id='room-min_stay']/option")).get(optionMinStay).click();

        $(byXpath("//select[@id='room-max_stay']")).click();
        $$(byXpath("//select[@id='room-max_stay']/option")).get(optionMaxStay).click();


        fillInField1(roomDescription, $(byXpath("//textarea[@id='room-description']")), $(byXpath("//textarea[@id='room-description']")));
        sleep(1000);
    }

    public void availableDateIsCheckedEdit() {
        $(byXpath("//form[@id='property_add_room']//input[contains(@id,'room-available_from') and @name='Room[availability]']")).shouldBe(checked);

    }

    public void availableDateCheck(final String roomID) {
        $(byXpath("//tr[@data-room-id='" + roomID + "']//label[input[contains(@id,'room-available_from')]]")).click();

    }

    public void saveCreateRoom() {

        $(byXpath("//button[contains(.,'Save and create')]")).click();
    }

    public void clickEditRoom(final String roomNumber) {
        $(byXpath("//a[@aria-controls='room_editor_" + roomNumber + "']")).click();
    }

    public void deactivateVerifyRoom(final String roomId1, String availableFrom) {
        $(byXpath("//td[@data-state='availability_" + roomId1 + "']")).shouldHave(text(availableFrom));
        sleep(1000);
        $(byXpath("//a[@data-room-id='" + roomId1 + "' and @data-action='toggle-availability']")).click();
        sleep(1000);
        $(byXpath("//td[@data-state='availability_" + roomId1 + "']")).shouldHave(text("Unavailable"));

    }
    public static String monthAvailableFrom(String roomID) {

        String monthAvailableFrom = $(byXpath("//td[@data-state='availability_" + roomID + "']")).text().substring(17);
        return monthAvailableFrom;

    }

    public static String monthAvailableFrom1(final String roomNumber) {

        String monthAvailableFrom1 = $(byXpath("(//td[contains(@data-state,'availability_')])[" + roomNumber + "]")).text().substring(17);
        return monthAvailableFrom1;

    }


    public void activateVerifyRoom(final String roomId) {

        $(byXpath("//td[@data-state='availability_" + roomId + "']")).shouldHave(text("Unavailable"));
        sleep(1000);
        $(byXpath("//a[@data-room-id='" + roomId + "' and @data-action='toggle-availability']")).click();
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
}
