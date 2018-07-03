package uk.co.idealflatmate.appmanager;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class EmailHelper {

    public void openGmailPage() {

        open("https://www.gmail.google.com/");
    }
    public void setLoginAsUserEmail(String email) {
        $(byXpath("//input[@type='email']")).waitUntil(appears, 4000).click();
        $(byXpath("//input[@type='email']")).waitUntil(appears, 4000);
        $(byXpath("//input[@type='email']")).shouldBe(visible);
        $(byXpath("//input[@type='email']")).setValue(email);
        $(byXpath("(//content[@class='CwaK9'])[3]/span")).click();
        sleep(2000);
    }
    public void setLoginAsUserPassword(String password) {
        $(byXpath("//input[@type='password']")).waitUntil(appears, 4000).click();
        $(byXpath("//input[@type='password']")).waitUntil(appears, 4000);
        $(byXpath("//input[@type='password']")).shouldBe(visible);
        $(byXpath("//input[@type='password']")).setValue(password);
        $(byXpath("(//content[@class='CwaK9'])[1]/span")).click();
        sleep(2000);
    }

    public void enterEmail() {
        $(byXpath("(//content[@class='CwaK9'])[2]/span")).click();
    }
}
