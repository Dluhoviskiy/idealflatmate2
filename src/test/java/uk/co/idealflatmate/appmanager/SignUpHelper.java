package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import utils.ConfData;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class SignUpHelper extends HelperBase {
    static SelenideElement roomClick = $(byXpath("//h3[@class='u_m0' and contains (text(), 'A room')]"));
    static SelenideElement photoClick = $(byXpath("//input[@id='moreinfosignupform-file']"));
    static SelenideElement dragLow = $(byXpath("//div[@class='noUi-handle noUi-handle-lower']"));
    static SelenideElement dragUpper = $(byXpath("//div[@class='noUi-handle noUi-handle-upper']"));

    public static void clickRoom1() {
        roomClick.click();
        navigator.forward();
    }

    public void clickRoom() {
        roomClick.click();
        backFromEmailToRoom();
    }

    public void backFromEmailToRoom() {
        $(byXpath("//a[contains (., 'back')]")).click();
        roomClick.click();
    }

    public void clickEmailPopup() {
        $(byXpath("//div[@id='signupRevealModal']//a[span[contains (text(), 'Sign up with email')]]")).click();
    }
    public void clickEmail() { $(byXpath("//span[contains (text(), 'Sign up with email')]")).click();

    }
    public void clickEmailMatching1() {
        $(byXpath("//a[contains (., 'Sign up with email')]")).click();
    }

    public void setSignUpNameF(String nameF) {
        fillInField (nameF, $(byXpath("//input[contains(@id,'-username')]")));
    }

    public void setSignUpNameFMessage(String nameF) {
        fillInField(nameF, $(byXpath("//input[contains(@id,'-username')]")));
    }

    public void genderFemaleSelect() {

      $(byXpath("//div[contains(@class,'gender required')]//label[contains(text(), 'Female')]")).click();

    }

    public void genderFemSelectAfterMesError() {
        $(byXpath("//div[contains(@class,'gender required')]//label[contains(text(), 'Male')]")).click();
    }

    public void genderFemaleSelectMessage() {
        $(byXpath("//div[@class='form-group field-yourinfoadditionalsignupform-gender required']/div[1]/label[contains(text(), 'Female')]")).click();
    }
    public void genderMaleSelectAfterBlank() {

        $(byXpath("//div[@id='yourinfosignupform-gender']/label[contains(text(), 'Male')]")).click();
        //$(byXpath("//div[@class='form-group field-yourinfosignupform-gender required']/div[1]/label[contains(text(), 'Female')]")).selectRadio("Female");
    }


    public void genderMaleSelect() {
        $(byXpath("//div[@class='form-group field-yourinfosignupform-gender required']/div[1]/label[contains(text(), 'Male')]")).click();
    }

    public void setSignEmail(String confEmail) {
        fillInField(ConfData.getData(confEmail), $(byXpath("//input[contains(@id,'-email')]")));
    }

    public void setSignEmailMessage(String confEmail) {
        fillInField(ConfData.getData(confEmail), $(byXpath("//input[contains(@id,'-email')]")));
    }

    public void setSignPassword(String confPassword) {
        fillInField(ConfData.getData(confPassword), $(byXpath("//input[contains(@id,'-password')]")));
    }

    public void setSignPasswordMessage(String confPassword) {
        fillInField(ConfData.getData(confPassword), $(byXpath("//input[contains(@id,'-password')]")));
    }

    public void clickFormSignUpContinue() {
        $(byXpath("(//button[contains(text(), 'Continue')])[1]")).waitUntil(appears, 4000).click();
        sleep(2000);
    }
    public void clickYourInformationContinue() {

        $(byXpath("//button[contains(text(), 'Continue')]")).waitUntil(appears, 4000).click();
        sleep(2000);
    }

    public void clickCompleteSearchPref() {

        $(byXpath("//button[@class='btn btn-block btn-primary ws-normal u_m20-bottom']")).waitUntil(appears, 8000).click();
        sleep(2000);
    }

    public void profilePhotoAddJpeg() {
        photoClick.uploadFile(new File("src/test/resources/profile1.jpeg"));
        sleep(2000);
    }
    public void profilePhotoAddPng() {
        photoClick.uploadFile(new File("src/test/resources/Profile.png"));
        sleep(2000);
    }
    public void profilePhotoAddJpg() {
        photoClick.uploadFile(new File("src/test/resources/Property1.jpg"));
        sleep(2000);
    }

    public void profilePhotoAddJpeg10Mb() {
        photoClick.uploadFile(new File("src/test/resources/8mb-artwork.jpg"));
        sleep(2000);
    }

    public void profilePhotoAddPdf() {
        photoClick.uploadFile(new File("src/test/resources/IF-pdf.pdf"));
        sleep(2000);
    }

    public void profilePhotoRemove() {
        $(byXpath("//div[@onclick='Auth.removeUploadImage()']")).waitUntil(appears, 4000).click();
        sleep(3000);

    }
    public void profileDateBirthAdd(String day, String month, String year) {
        dateMonthYear(day, month, year, $(byXpath("//select[contains(@id,'-day')]")),
                                        $(byXpath("//select[contains(@id,'-month')]")),
                                        $(byXpath("//select[contains(@id,'-year')]")));
    }

    public void profileDateBirthAddMessage(String day, String month, String year) {
        dateMonthYear(day, month, year, $(byXpath("//select[contains(@id,'-day')]")),
                                        $(byXpath("//select[contains(@id,'-month')]")),
                                        $(byXpath("//select[contains(@id,'-year')]")));
    }

    public void profilePhone(String phone) {
        //Field2("input#moreinfosignupform-phone", phone);


            String val = phone;
            SelenideElement element = $("input#moreinfosignupform-phone");
            element.clear();
            for (char  c : val.toCharArray()) {
                sleep(500);
                String s = String.valueOf(c);
                element.sendKeys(s);
            }
            sleep(1000);


    }

    public void profilePhoneMessage(String phone) {
        //Field2("#messagewritesignupform-phone",phone);
        String val = phone;
        SelenideElement element = $("#messagewritesignupform-phone");

        for (char  c : val.toCharArray()) {
            sleep(500);
            String s = String.valueOf(c);
            element.sendKeys(s);
        }
        sleep(1000);
    }

    public void occupation(String profOption, String defaultOccupation, String occupationNew) {
        String occupation = $(byXpath("//select[@id='moreinfosignupform-occupation_id']")).getSelectedOption().getText();
        Assert.assertEquals(defaultOccupation, occupation);
        $(byXpath("//select[@id='moreinfosignupform-occupation_id']")).selectOptionByValue(profOption);
        String newOccupation = $(byXpath("//select[@id='moreinfosignupform-occupation_id']")).getSelectedOption().getText();
        Assert.assertEquals(occupationNew, newOccupation);
    }

    public void aboutYourself(String text) {
        $(byXpath("//textarea[@id='moreinfosignupform-bio']")).setValue(text);
    }

    public void aboutAgency(String text, String text1) {
        $(byXpath("//textarea[@id='moreinfosignupform-bio']")).setValue(text);
        $(byXpath("//textarea[@id='moreinfosignupform-bio']/../../div/label")).shouldHave(text(text1));
    }



    public void preferredLocation(String location, String area) {

        FieldEnter(location, $("input#location"), $(byXpath("//li//div[contains(text(), '" + area + "')]")));

    }

    public void preferredLocationButton(String area2) {
        $(byXpath("//a[starts-with(@class,'btn btn-primary-outline') and contains(.,'" + area2 + "')]")).click();
    }

    public void backClick() {
        $(byXpath("//a[contains (., 'back')]")).click();

    }

    public static void budgetMin() {

        dragLow.dragAndDropTo($(byXpath("//span[@class='text-12']")));
        //dragLow.dragAndDropTo($(byXpath("//div/span[@class='text-14']")));
    }

    public static void budgetMax() {

        dragUpper.dragAndDropTo($(byXpath("//div[@class='text-11 u_m35-top text-center']")));

    }


    public void verifyToMoveCheckboxDisabled() {
        //$(byXpath("//div[@class='form-group field-budgetpreferredsignupform-move_in_now has-success']//input[@type='checkbox']")).shouldBe(checked);
        $("select#budgetpreferredsignupform-move_in_day").shouldHave(disabled);
        sleep(2000);
    }
    public void toMoveCheckboxEnabled() {
        //$(byXpath("//div[@class='form-group field-budgetpreferredsignupform-move_in_now has-success']//input[@type='checkbox']")).shouldBe(checked);
        $(byXpath("//label[@for='budgetpreferredsignupform-move_in_now']")).click();
    }

    public void verificationDataProfileFullAgent() {
        $(byXpath("//div[@class='col-sm-5 h5 heading-spaced text-normal u_m20-top u_m30-top-md text-normal-weight']")).shouldNot(exist);
    }

    public void verificationDataProfileNameUser(String name, String age) {
        $(byXpath("//h2/strong")).shouldHave(text(name));
        $(byXpath("//h2/span")).shouldHave(text(age));
    }

    public void verificationDataProfileFotoDashboard() {
        $(byXpath("//div[@class='row u_m40-bottom-xs']//a/img[@src='/images/no-image-initial-square.jpg']")).shouldNot(exist);
    }

    public void clickFM() {
       $(byXpath("//h3[@class='u_m0' and contains (text(), 'A flatmate for my vacant room')]")).click();
    }

    public void verificationDataFBYourInf(String FirstName, String email, String password) {
        $(byXpath("//input[@id='yourinfosignupform-username']")).shouldHave(value(FirstName));
        $(byXpath("//input[@id='yourinfosignupform-email']")).shouldHave(value(email));
        $(byXpath("yourinfosignupform-password")).shouldHave(value(password));
    }

    public void quit() {
        $(byXpath("//a[starts-with(@class,'btn btn--type-2')]")).click();
    }
    public void quitLogin() {
        $(byXpath("//a[contains(.,'Quit Log in')]")).click();
        sleep(2000);
    }

    public void selectMoveDate(String day, String month, String year) {
        dateMonthYear(day, month, year, $(byXpath("//select[contains(@id,'move_in_day')]")),
                                        $(byXpath("//select[contains(@id,'move_in_month')]")),
                                        $(byXpath("//select[contains(@id,'move_in_year')]")));
    }

    public void selectHappyReceiveNews() {
        $(byXpath("//label[@for='budgetpreferredsignupform-is_subscribed']")).click();
    }

    public void clickShowMeMyMatches() {
        $(byXpath("//a[contains(., 'Show me my matches! ')]")).click();
    }

    public void clickListYourRoomMatching() {
        $(byXpath("//a[contains(., 'List your room! ')]")).click();
    }
    public void clickSearchFMMatching() {
        $(byXpath("//a[contains(., 'Search for a flatmate ')]")).click();
    }

    public void clearEmail() {
        $(byXpath("//input[contains(@id,'-email')]")).clear();
        
    }

    public void clearEmailMessage() {
        $(byXpath("//input[contains(@id,'-email')]")).clear();
    }

    public void clearFirstname() {
        $(byXpath("//input[contains(@id,'-username')]")).clear();
    }

    public void clearFirstnameMessage() {
        $(byXpath("//input[contains(@id,'-username')]")).clear();
    }

    public void clearPassword() {
        $(byXpath("//input[contains(@id,'-password')]")).clear();
    }

    public void clearPasswordMessage() {
        $(byXpath("//input[contains(@id,'-password')]")).clear();
    }

    public void click1CardMessage(final String numberOfCard) {
        $(byXpath("(//div[@class='card-infos-flex-row']/a[2][@href])[" + numberOfCard + "]")).click();

    }

    public void click1PropCardMes(String property_id) {
        $(byXpath("//div[@id='property_card_"+ConfData.getData(property_id)+"']//div[@class='card-infos-flex-row']/a[2][@href]")).click();

    }

    public void click1PropCardIDMes(final String id_property) {
        $(byXpath("//div[@id='property_card_" + id_property + "']//a[@class='card-start-chat btn btn-circle']")).click();

    }

    public void photoOfOwner(String photo1) {
        if (photo1.endsWith("no-image-initial.jpg")) {
            String photo2 = photo1.substring(0, 77);
            String messagePhoto = $("div.col-xs-12 img").getAttribute("src").substring(0, 77);
            Assert.assertEquals(photo2, messagePhoto);
        } else {
            String photo2 = photo1.substring(0, 73);
            String messagePhoto = $("div.col-xs-12 img").getAttribute("src").substring(0, 73);
            Assert.assertEquals(photo2, messagePhoto);

        }

    }

    public void verificationAutoMessageProperty(String name1) {

        String messagePlaceholder = $("textarea#messagewritesignupform-message").text();
        String name2 = (name1.substring(0, 1).toUpperCase() + name1.substring(1));
        String name3 =(name2.split(","))[0].replaceAll("/,",  "");
        String name4 = "Hi " + name3 + ", your room looks great! Are you holding viewings?";
        Assert.assertEquals(name4, messagePlaceholder);
    }

    public void verificationAutoMessageFM(String name1) {

        String messagePlaceholder = $("textarea#messagewritesignupform-message").text();
        String name2 = (name1.substring(0, 1).toUpperCase() + name1.substring(1));
        String name3 =(name2.split(","))[0].replaceAll("/,",  "");
        String name4 = "Hi " + name3 + ", looks like we are well matched. When are you looking to move?";
        Assert.assertEquals(name4, messagePlaceholder);
    }

    public void nameOfOwner(String name1) {
        //String name2 = "Message " + (name1.substring(0, 1).toUpperCase() + name1.substring(1)).replaceAll("[^a-zA-z]",  "");
        String name2 = "Message " + (name1.substring(0, 1).toUpperCase() + name1.substring(1));
        String name3 =(name2.split(","))[0].replaceAll("/,",  "");
        String nameInMessage = $("h1").getText();
        Assert.assertEquals(name3, nameInMessage);
    }

    public void nameOfOwnerOnPopup(String name1) {
        //String name2 = "Message " + (name1.substring(0, 1).toUpperCase() + name1.substring(1)).replaceAll("[^a-zA-z]",  "");
        String name2 = "Sign up to send a message to " + (name1.substring(0, 1).toUpperCase() + name1.substring(1));
        String name3 =(name2.split(","))[0].replaceAll("/,",  "");
        String nameInMessage = $("h1").getText();
        Assert.assertEquals(name3, nameInMessage);
    }


    public void clickBackToSearch() {
        $(byXpath("//button[@value='back_to_search']")).waitUntil(visible, 10000).click();
    }

    public void titleOfSearchPage(String title1) {
        String title2 = $(byXpath("//head/title")).getText();
        Assert.assertEquals(title1, title2);

    }

    public void clickSubmit() {
        $(byXpath("//button[@type='submitLogin']")).click();
    }

    public void clickPropertyCard1(int indexOfCard) {
        $(byXpath("//h1")).click();
        $$(byXpath("//div[@class='card-img']")).get(indexOfCard).click();

    }

    public void clickMessageProperty(String buttonText) {

        $(byXpath("//section//a[contains(.,'" + buttonText + "')]")).click();

    }

    public void clickLikePropertyCard() {
        $$(byXpath("//a[starts-with(@class,'buddy')]")).get(3).click();

    }

    public void backToSearch() {
        $(byXpath("//button[starts-with(@class,'btn-link')]")).click();

    }

    public void clickLikePropertyCardHomePage(int propertyCard) {


        $$(byXpath("//a[starts-with(@class,'buddy-star')]")).get(propertyCard).click();

    }

    public void removeLike() {
        $(byXpath("//span[starts-with(@class,'saved-property')]")).click();
        sleep(4000);
        $(byXpath("//button[@class='confirm']")).waitUntil(appear, 6000).click();
        sleep(4000);

    }




    public void yourInformation(String confPassword, String firstName, String confEmail) {
        setSignUpNameF(firstName);
        genderFemaleSelect();
        login1(confEmail, confPassword);
        clickYourInformationContinue();
    }

    public void yourInformationWithPhone (String password, String firstName, String email) {
        setSignUpNameF(firstName);
        genderFemaleSelect();
        setSignEmail(email);
        setSignPassword(password);
        clickYourInformationContinue();
    }

    public void priceMove(String day, String month, String year) {
        verifyToMoveCheckboxDisabled();
        toMoveCheckboxEnabled();
        selectMoveDate(day, month, year);
        selectHappyReceiveNews();
        clickYourInformationContinue();
    }

    public void whereWouldLikeLive(String location, String area1) {
        preferredLocation(location, area1);
        clickYourInformationContinue();
    }

    public void moreAboutYou(String day, String month, String year, String phone, String newOccupation, String text, String defaultOccupation, String occupationNew) {
        profilePhotoAddJpeg();
        profileDateBirthAdd(day, month, year);
        profilePhone(phone);
        occupation(newOccupation, defaultOccupation, occupationNew);
        aboutYourself(text);
        clickYourInformationContinue();
    }

    public void moreAboutYou2(String day, String month, String year, String phone, String newOccupation, String text, String defaultOccupation, String occupationNew) {
        profilePhotoAddPng();
        profileDateBirthAdd(day, month, year);
        profilePhone(phone);
        occupation(newOccupation, defaultOccupation, occupationNew);
        aboutYourself(text);
        clickYourInformationContinue();
    }

    public void signListingFM_LiveIn(String confEmail, String confPassword, String day, String month, String year, String phone, String newOccupation, String firstName, String defaultOccupation, String occupationNew) {


        clickEmail();

        setSignUpNameF(firstName);
        genderMaleSelect();
        login1(confEmail, confPassword);
        clickYourInformationContinue();

        profilePhotoAddJpeg();
        profilePhotoRemove();
        profileDateBirthAdd(day, month, year);
        profilePhone(phone);
        occupation(newOccupation, defaultOccupation, occupationNew);
        //signUpHelper.aboutYourself("Tell us about yourself");
        clickYourInformationContinue();
    }

    public void signListingLiveOut(String confEmail, String confPassword, String firstName, String phone) {


        clickEmail();

        setSignUpNameF(firstName);
        login1(confEmail, confPassword);
        clickYourInformationContinue();

        profilePhotoAddJpeg();
        profilePhone(phone);

        clickYourInformationContinue();

    }


    public void agentSignListing(String name, String confEmail, String confPassword, String phone, String text) {


        clickEmail();
        setSignUpNameF(name);
        //signUpHelper.genderFemaleSelect();
        login1(confEmail, confPassword);
        clickYourInformationContinue();

        profilePhotoAddJpeg();
        profilePhotoRemove();
        //signUpHelper.profileDateBirthAdd("2", "5", "2000");
        profilePhone(phone);
        //signUpHelper.occupation("19");
        aboutYourself(text);
        clickYourInformationContinue();

    }

    public void login1(String confEmail, String confPassword) {
        setSignEmail(confEmail);
        setSignPassword(confPassword);
    }
    public static String userName() {
        String userName = $("span.user-welcome--name").text();
        return userName;
    }

}
