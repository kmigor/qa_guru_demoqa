import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestsForDemoqa {

    @BeforeAll
    static void setUp(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void fillFormTest(){

        String firstName = "Rick";
        String lastName = "Astley";
        String userEmail = "RickAstley@gmail.com";
        String gender = "Male";
        String phoneNumber = "1234567890";
        String subject = "Maths";
        String hobby = "Sports";
        String pictureName = "rick.jpg";
        String currentAddress = "London, Great Britain";
        String state = "NCR";
        String city = "Noida";

        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //Заполнение полей
        $("#userName-wrapper #firstName").setValue(firstName);
        $("#userName-wrapper #lastName").setValue(lastName);
        $("#userEmail-wrapper #userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber-wrapper #userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $("[aria-label=\"Choose Sunday, September 1st, 2024\"]").click();
        $("#subjectsWrapper #subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $(".form-file #uploadPicture").uploadFromClasspath(pictureName);
        $("#currentAddress-wrapper #currentAddress").setValue(currentAddress);
        $("#stateCity-wrapper #react-select-3-input").setValue(state).pressEnter();
        $("#stateCity-wrapper #react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        //Проверка значений
        $(".table-responsive").shouldHave(text(firstName));
        $(".table-responsive").shouldHave(text(lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text(phoneNumber));
        $(".table-responsive").shouldHave(text("1 September,2024"));
        $(".table-responsive").shouldHave(text(subject));
        $(".table-responsive").shouldHave(text(hobby));
        $(".table-responsive").shouldHave(text(pictureName));
        $(".table-responsive").shouldHave(text(currentAddress));
        $(".table-responsive").shouldHave(text(state + " " + city));

    }
}
