package uk.co.idealflatmate.appmanager;


import com.codeborne.selenide.SelenideElement;
import utils.ConfData;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class AuthorHeaderMenuHelper extends HelperBase {


    private SelenideElement tab_header_JoinFree = $(".btn.btn-primary.u_m10-top.hidden-xs.hidden-sm.u_m20-right-md.u_m20-right-lg.u_ef-right");
    private SelenideElement tab_header_Login = $(byXpath("//nav//ul[contains(@class, 'nav navbar-nav navbar-right ')]/li[contains(., 'Login')]"));

    public  SelenideElement tab_header_Username = $("li.dropdown.nav-ihm-profile-bars span.user-welcome--name");

    private SelenideElement item_header_drop_Logout = $(byXpath("//li/a[contains(text(), ' Log out')]"));
    private SelenideElement tab_header_FindHome = $(byXpath("//header//nav//ul//li//a[contains(text(), 'Find a home')]"));
    private SelenideElement tab_header_AllProperties = $(byXpath("//a[@href='/search' and contains(text(), 'All properties')]"));
    private SelenideElement tab_header_GoFMPage = $(byXpath("//ul[starts-with(@class, 'nav navbar-nav')]//a[contains(.,'Find a flatmate')]"));
    private SelenideElement button_popup_login_Submit = $(byXpath("//button[contains(., 'Log in with email ')]"));
    private SelenideElement button_popup_FB = $(byXpath("//a[contains(@id,'js-signup-facebook')]"));
    private SelenideElement field_fb_Email = $("#email");
    private SelenideElement field_fb_Password = $("#pass");
    private SelenideElement field_login_Username = $("input#loginform-username");
    private SelenideElement field_login_Password = $("input#loginform-password");
    private SelenideElement button_login_FB = $(byXpath("//input[@value='Log In']"));
    private SelenideElement button_listing_Remove = $(byXpath("//button[@type='submit' and contains(text(), 'Delete!')]"));
    private SelenideElement notif_incorrect_EmailPassword = $(byXpath("//body//div[contains(@class,' required has-error')]/div[contains(text(),'Incorrect email or password.')]"));
    private static SelenideElement link_SignIn = $(byXpath("//a[contains(., 'Sign in')]"));

    private static SelenideElement link_LogIn = $(byXpath("//a[contains(., 'Login')]"));
    private SelenideElement popup_SignIn = $(byXpath("//div[@id='signupNeedspaceModal']//div//a[@class='text-bold' and contains(., 'Sign')]"));
    private SelenideElement popup_SignIn_phone = $(byXpath("//div[@id='signupRevealModal']//div//a[@class='text-bold' and contains(., 'Sign')]"));
    private String item_header_drop_Menu1 = "//ul[@class='dropdown-menu']//a[contains(., '";
    private String item_header_drop_Menu2 = "')]";
    private String  tab_inner_header1 = "//body//div[@class='inner-menu--scroll']//li/a[contains(., '";
    private String  tab_inner_header2 = "')]";
    private SelenideElement popup_button_close_SignUp = $(byXpath("//div[@id='signupNeedspaceModal']//button[@class='btn btn-sm close u_m15']"));

    private final VerificationHelper verificationHelper = new VerificationHelper();
    private final AddPropertyHelper addPropertyHelper = new AddPropertyHelper();
    private final SignUpHelper signUpHelper = new SignUpHelper();



    public void logoutFromApp() {
        refresh();
        sleep(2000);
        tabHeaderUserName();
        item_header_drop_Logout.waitUntil(visible, 10000).click();
    }

    public void tabHeaderUserName() {
        tab_header_Username.waitUntil(visible, 10000).click();
    }

    public void goToPropertyPage() {
        tab_header_FindHome.waitUntil(appears, 10000).hover();
        sleep(1000);
        tab_header_AllProperties.waitUntil(appears, 4000).click();
    }

    public void goToFMpage() {
        tab_header_GoFMPage.waitUntil(appears, 4000).click();
     }

    public void submitLogin() {
        button_popup_login_Submit.click();
        sleep(1000);
    }

    public void LoginFacebookWithActiveAccount(String email, String password) {
        sleep(2000);
        field_fb_Email.setValue(email);
        sleep(1000);
        field_fb_Password.setValue(password);
        button_login_FB.click();
    }

    public void LoginFacebookWithNewAccount(String confEmail, String confPassword) {
        sleep(2000);
        field_fb_Email.setValue(ConfData.getData(confEmail));
        field_fb_Password.setValue(ConfData.getData(confPassword)).pressEnter();
    }

    public void clickSignUp_In_WithFacebook() {
        button_popup_FB.waitUntil(visible, 4000).click();
    }

    public void clickJoinFreeButton() {
        tab_header_JoinFree.click();
    }

    public void removeAccount() {
        button_listing_Remove.waitUntil(appears, 4000).click();
        confirm("Are you sure you wish to delete your account?");
        sleep(2000);
    }

    public void removeAccountBeforeTest() {
        sleep(2000);
        if(notif_incorrect_EmailPassword.exists()){
            signUpHelper.quitLogin();
        }else{
            removeAnyAccount();
        }
    }

    public static void clickSignInButtonInForm() {
        link_SignIn.waitUntil(visible, 10000).click();
    }

    public static void clickLogInButtonInForm() {
        link_LogIn.waitUntil(visible, 10000).click();
    }



    public void clickSignInButtonInPopup() {
        sleep(2000);
        hoverClick1(popup_SignIn);
    }

    public void clickSignInButtonInPopupPhone() {
        sleep(2000);
        hoverClick1(popup_SignIn_phone);
    }

    public void chooseSectionDropDownMenu(final String menuSection) {
        $(byXpath(item_header_drop_Menu1 + menuSection + item_header_drop_Menu2)).waitUntil(visible, 5000).click();
    }

    public void chooseTabFromInnerMenuDashboard(final String item) {
        $(byXpath(tab_inner_header1 + item + tab_inner_header2)).click();
    }

    public void clickClosePopupSignUp() {
        sleep(5000);
        if (popup_button_close_SignUp.isDisplayed()){
            popup_button_close_SignUp.click();
        }else {}
    }

    public void FindHomeInMenu() {
        tab_header_FindHome.waitUntil(appears, 5000).click();
    }

    public void headerLogin() {
        tab_header_Login.waitUntil(appears, 5000).click();
    }

    public void setLoginAsUserWithoutPackage(String confEmail) {
        fillInField(ConfData.getData(confEmail), field_login_Username);
    }

    public void setLoginAsUserWithoutPackage1(String confEmail) {
        fillInField(confEmail, field_login_Username);
    }

    public void setPassword1(String confPassword) {
        field_login_Password.waitUntil(visible, 4000).setValue(confPassword);
    }

    public void setPassword(String confPassword) {
       field_login_Password.waitUntil(visible, 4000).setValue(ConfData.getData(confPassword));
    }

    public void login(String confPassword, String confEmail){
        clickJoinFreeButton();
        clickSignInButtonInForm();
        login2(confEmail,confPassword);
        submitLogin();
    }


    public void loginMessage(String confEmail, String confPassword) {
        login(confPassword, confEmail);
        closeListRenewPopUp();
        closeMatchPopUp();
    }

    public void login2(String confEmail, String confPassword) {
        setLoginAsUserWithoutPackage(confEmail);
        setPassword(confPassword);
    }

    public void loginTest1(String confEmail, String confPassword) {
        setLoginAsUserWithoutPackage1(confEmail);
        setPassword1(confPassword);
    }

    public void removeAnyAccount() {
        closeListRenewPopUp();
        closeMatchPopUp();
        addPropertyHelper.openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("70% complete");
        chooseSectionDropDownMenu("My profile");
        chooseTabFromInnerMenuDashboard("Settings");
        removeAccount();

        verificationHelper.isHomePage("Flatshare and Houseshare Across the UK: ideal flatmate");
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    public void loginBuddy_up(String confPassword, String confEmail){

        login2(confEmail,confPassword);
        submitLogin();
    }

    public void loginHeader1(String confPassword, String confEmail){
        headerLogin();
        loginTest1(confEmail,confPassword);
        submitLogin();
    }

    public void loginHeader2(String confPassword, String confEmail){
        pageUrlVerifStageGoLive();
        headerLogin();
        loginTest1(confEmail,confPassword);
        submitLogin();
    }

}