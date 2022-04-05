package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setUP() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void fillFormTest() {
        open("/text-box");

        $("[id=userName]"). setValue("Serg Frolov");
        $("[id=userEmail]"). setValue("serg@frolov.com");
        $("[id=currentAddress]"). setValue("Some address56");
        $("[id=permanentAddress]"). setValue("Another address58");
        $("[id=submit]").click();

        $("[id=output]"). shouldHave(text("Serg Frolov"));
        $("[id=output]"). shouldHave(text("serg@frolov.com"));
        $("[id=output]"). shouldHave(text("Some address56"));
        $("[id=output]"). shouldHave(text("Another address58"));

    }
}
