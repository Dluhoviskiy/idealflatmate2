package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import com.codeborne.selenide.Configuration;
import java.io.File;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class AddPropertyHelper extends HelperBase {



    public final MessageHelper messageHelper = new MessageHelper();
    private String string;

    public void openDropDownMenu() {
        $(byXpath("(//li[@class='dropdown nav-ihm-profile-bars'])[1]")).waitUntil(visible, 5000).click();
    }

    public void pressAddListingFromBody() {
        //$(byXpath("/html/body/section/section/div/div/a")).click();
        if($(byXpath("//div[@class=\"container\"]/div[@id='property1']")).exists()) {
            RemoveUnfinishedListing();
            messageHelper.click(byXpath("(/html/body/header/div/nav/ul/li/a)[5]"));
        }else {
            //pressAddListingFromBody();
            messageHelper.click(byXpath("(/html/body/header/div/nav/ul/li/a)[5]"));
        }

    }

    public void chooseListingsFromDropDownMenu() {
        sleep(2000);
        $(byXpath("//nav//li//a//span[@class='hidden-xs']")).click();
        $(byXpath("(//a[contains(text(), 'My listings')])[1]")).click();

    }

    public void chooseListLoggedFromHeaderProfile() {
        sleep(2000);
        $(byXpath("//ul[@class='nav navbar-nav navbar-right nav-aux hidden-xs hidden-sm']//a[contains(.,'Add a Listing')]")).click();

    }




    public void setPostalCode(String postCode) {
        $(".form-control.u_ed-block").setValue(postCode).pressEnter();
        sleep(2000);
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

    public void chooseAreaforLondon(String AreaInDropDown) {
        messageHelper.click(byName("Property[area_link_id]"));
        messageHelper.click(byXpath("//*[@id=\"property-area_link_id\"]/option[" + AreaInDropDown + "]"));
        sleep(5000);
    }

    public void pressAddListingFromHeaderWithVerificationUnfinishedlisting() {
            if($(byXpath("/html/body/header/div/a[contains(text(), ' Continue ')]")).exists()) {
                openDropDownMenu();
                chooseListingsFromDropDownMenu();
                RemoveUnfinishedListing();
                messageHelper.click(byXpath("/html/body/header/div/a"));
            }else {
                //pressAddListingFromBody();
                messageHelper.click(byXpath("(/html/body/header/div/nav/ul/li/a)[5]"));
            }

         }

    public void pressAddListingFromHeaderNotLoggedUser() {
        $(byXpath("//ul[starts-with(@class, 'nav navbar-nav')]//a[contains(.,'List a room')]")).click();
    }


    public void setPhoneNumber(String Number, String text) {
       $(byXpath("//label[contains(text(), 'Phone Number')]")).scrollIntoView(text);
       fillInField1(Number, $("#property-phone_number"),  $(byXpath("#signup-need-firstname")));
    }

    public void setPhoneNumber1(String Number) {
        sleep(2000);
        fillInField1(Number, $(byXpath("//div//h2[contains(text(), 'Phone number')]/..//input[@id='property-phone_number']")),
                            $(byXpath("//input[@id='property-phone_number']")));

        $(byXpath("//input[@id='property-phone_number']")).setValue(Number);
        sleep(2000);
    }

    public void setTotalBedrooms(final String amount) {
        sleep(2000);
        $("#property-bedrooms_no").click();

        $(byXpath("//*[@id=\"property-bedrooms_no\"]")).selectOptionByValue(amount);
    }

    public void setAllAmanities(String text1, String text2, String text3, String text4, String text5, String text6, String text7, String text8, String text9, String text10, String text11) {
        String string = "//div/label[contains(.,'";
        String string2 = "')]";
        String string3 = "')]/..";
        String string4 = "//label[@for='";
        Condition attribute = attribute("class", "checkbox checked");

        $(byXpath(string + text1 + string2)).click();
        $(byXpath(string + text1 + string3)).shouldHave(attribute);
        sleep(1000);
        $(byXpath(string + text2 + string2)).click();
        $(byXpath(string + text2 + string3)).shouldHave(attribute);
        sleep(1000);
        $(byXpath(string + text3 + string2)).click();
        $(byXpath(string + text3 + string3)).shouldHave(attribute);
        sleep(1000);
        $(byXpath(string + text4 + string2)).click();
        $(byXpath(string + text4 + string3)).shouldHave(attribute);
        sleep(1000);
        $(byXpath(string4 + text5 + "']")).click();
        $("#"+text5+"").shouldBe(selected);
        sleep(1000);
        $(byXpath(string4 + text6 + "']")).click();
        $("#"+text6+"").shouldBe(selected);
        sleep(1000);
        $(byXpath(string4 + text7 + "']")).click();
        $("#"+text7+"").shouldBe(selected);
        sleep(1000);
        $(byXpath(string4 + text8 + "']")).click();
        $("#"+text7+"").shouldBe(selected);
        sleep(1000);
        $(byXpath(string4 + text9 + "']")).click();
        $("#"+text7+"").shouldBe(selected);
        sleep(1000);
        $(byXpath(string4 + text10 + "']")).click();
        $("#"+text7+"").shouldBe(selected);
        sleep(1000);
        $(byXpath(string4 + text11 + "']")).click();
        $("#"+text7+"").shouldBe(selected);
        sleep(1000);


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

    public void setLeasePeriodFirstRoom() {
        $(byXpath("//div[@class='field-room-1-availability']/div[1]")).waitUntil(appear, 4000).shouldHave(attribute("class", "checkbox checked"));
        $("#room-1-min_stay").click();
        $(byXpath("//*[@id=\"room-1-min_stay\"]/option[2]")).click();
        $("#room-1-max_stay").click();
        $("#room-1-max_stay > option:nth-child(13)").click();
    }


    public void setRoomDescription(String text) {
        $(byXpath("//div[@class='form-group field-room-1-description']/textarea")).click();
        $(byXpath("//div[@class='form-group field-room-1-description in-use']/textarea")).setValue(text);
        // $("#room-1-description").shouldHave(text("text"));
    }

    public void copySecondRoom() {
        $(byXpath("//button[@class='btn btn-sm btn-primary-outline js-room-copy']")).waitUntil(appear, 4000).click();
        $(byXpath("//div/input[@id='room-2-price']")).shouldBe(visible);
    }

    public void removeSecondRoom() {
        $(byXpath("//button[@class='btn btn-sm btn-primary-outline js-room-remove u_ef-left']")).waitUntil(appear, 4000).click();
        $(byXpath("//div/input[@id='room-2-price']")).shouldNotBe(visible);
    }

    public void addAnotherRoom() {
        $(byXpath("//button[@class='btn btn-sm btn-primary js-room-add']")).waitUntil(visible, 4000).click();
        $(byXpath("//div[@data-idx='3']")).waitUntil(appear, 4000);
        $(byXpath("//div[@data-idx='3']")).scrollIntoView(true);
    }


    public void setAnotherMonthlyRent(String rent) {
        fillInField(rent, $("#room-3-price"));
        $(byXpath("//div/input[@id='room-3-price']")).shouldHave(Condition.value("800"));

    }

    public void setLeasePeriodSecondRoom() {
        $(byXpath("//div[@class='field-room-3-availability']/div[1]")).waitUntil(appear, 4000).shouldHave(attribute("class", "checkbox checked"));
        $(byXpath("//div[@class='field-room-3-availability']/div/label")).waitUntil(appear, 4000).click();
        $(byXpath("//div[@class='field-room-3-availability']/div[1]")).waitUntil(appear, 4000).shouldHave(attribute("class", "checkbox"));
        $(byXpath("//input[@id='room-3-available_from']")).waitUntil(appear, 4000).click();
        $(".ui-icon.ui-icon-circle-triangle-e").waitUntil(appear, 4000).click();
        $(".ui-datepicker-year").waitUntil(appear, 4000).click();
        messageHelper.click(byXpath("//option[@value='2025']"));
        $(byXpath("//a[@class='ui-state-default' and contains(text(), '11')]")).waitUntil(appear, 4000).click();

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
        sleep(2000);
        $(byXpath("(//div[@class='file-preview-frame krajee-default file-preview-initial file-sortable kv-preview-thumb '])[1]")).shouldBe(Condition.visible);
        $(byXpath("//input[@id='uploadimageform-imagefiles']")).uploadFile(new File("src/test/resources/listing2.jpeg"));
        sleep(2000);
        $(byXpath("(//div[@class='file-preview-frame krajee-default file-preview-initial file-sortable kv-preview-thumb '])[2]")).shouldBe(Condition.visible);
        $(byXpath("//input[@id='uploadimageform-imagefiles']")).uploadFile(new File("src/test/resources/Profile.png"));
        sleep(2000);
        $(byXpath("(//div[@class='file-preview-frame krajee-default file-preview-initial file-sortable kv-preview-thumb '])[3]")).shouldBe(Condition.visible);
        sleep(1000);

    }

    public void finishPropertyCreating() {
        $(byXpath("//*[@id='wizard-finish-btn']")).shouldBe(enabled).click();
        //$(byXpath("//*[@id=\"wizard-finish\"]")).waitUntil(Condition.disappears, 4000);
        $(byXpath("//div[@class='u_p20-bottom u_b-bottom u_b-2']/a[contains(text(), 'Continue without upgrading')]")).waitUntil(appear, 4000).click();
        $(byXpath("//span[contains(text(), 'Your')]")).shouldHave(text("Your listing is now live!"));
    }
    public void finishPropertyCreatingAgency() {
        $(byXpath("//*[@id='wizard-finish-btn']")).shouldBe(enabled).click();
        //$(byXpath("//*[@id=\"wizard-finish\"]")).waitUntil(Condition.disappears, 4000);
        $(byXpath("//div[@class='u_p20-bottom u_b-bottom u_b-2']/a[contains(text(), 'Continue without upgrading')]")).waitUntil(appear, 4000).click();
        $(byXpath("//p[@class='u_m20-top list-property-title']")).shouldHave(text("In order to list your property you need to"));
    }

    public void finishPropertyCreatingWithoutPhoto() {
        $(byXpath("//div[@class='u_p20-bottom u_b-bottom u_b-2']/a[contains(text(), 'Continue without upgrading')]")).waitUntil(appear, 4000).click();
        $(byXpath("//span[contains(text(), 'Your')]")).shouldHave(text("Your listing is now live!"));
    }

    public void viewListing() {
        $(byXpath("//a[@class='btn btn-half btn-primary listing-panel-button u_m10-bottom-xs']")).waitUntil(appear, 4000).click();
    }

    public void RemoveListing() {
        $(byXpath("//button[contains(@class, \"listing-panel-delete\")]")).waitUntil(appear, 4000).click();
        $(byXpath("(//input[1][@type='radio'])[1]")).waitUntil(appear, 8000).selectRadio("0");
        $(byXpath("//button[@type='submit' and contains(text(), 'Delete property')]")).waitUntil(Condition.appears, 4000).click();
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
        sleep(5000);
        $("#wizard-form #wizard-next").waitUntil(appear, 4000).click();

        //byText("Continue ");

    }


    public void finishPropertyAgency() {
        $(byXpath("//div[@class='u_p20-bottom u_b-bottom u_b-2']/a[contains(text(), 'Continue without upgrading')]")).click();
        $(byXpath("//span[contains(., 'In order to list your property you need to')]/../a")).shouldHave(text("Upgrade to professional"));

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
        sleep(3000);
        if ($(byXpath(match1)).exists()) {
            $(byXpath(match1)).waitUntil(visible, 10000).click();
        }
    }

    public void clickCardWithMatch() {
        $(byXpath("//span[@class='u_ed-inline-block']")).click();

    }

    public void addListingWithoutPhoto(String postCode, String areaInDropDown, String amount, String rent) {
        setPostalCode(postCode);
        pressContinue();

        pressContinue1();
        //verificationHelper.areaBlank();

        chooseAreaforLondon(areaInDropDown);
        pressContinue();
        setTotalBedrooms(amount);
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


    public void clickAboutOptions() {

        //Configuration.browserSize = "1024x1024";
        $(byXpath("//label[contains(.,' Garden')]")).waitUntil(visible, 20000).click();
        $(byXpath("//label[contains(.,' Communal living room')]")).click();
        $(byXpath("//label[contains(.,' Balcony/patio')]")).click();
        $(byXpath("//label[contains(.,' Parking')]")).click();

        $(byXpath("//div[@class='container-max-940 u_bg-white']//a[contains(.,'ideal flatmate')]")).click();
        sleep(3000);

        $(byXpath("//label[contains(.,' Pets accepted')]")).click();
        $(byXpath("//label[contains(.,' Smokers accepted')]")).click();
        $(byXpath("//label[contains(.,' LGBT friendly')]")).click();
        $(byXpath("//label[contains(.,' Family Friendly')]")).click();
        $(byXpath("//label[contains(.,' Trans Friendly')]")).click();
        $(byXpath("//label[contains(.,' Vegan household')]")).click();
        //$(byXpath("//label[contains(.,' Vegetarian household')]")).click();
    }
}
