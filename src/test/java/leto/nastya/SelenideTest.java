package leto.nastya;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

import com.codeborne.selenide.Condition;


public class SelenideTest {

    @Test
    public void testIssueSearch() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $("input.form-control").click();
        $("input.form-control").setValue("eroshenkoam/allure-example").submit();
        $(linkText("eroshenkoam/allure-example")).click();
        //$("#issues-tab").click();
        $(withText("issue_to_test_allure_report")).should(Condition.exist);


    }
}
