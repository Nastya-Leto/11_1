package leto.nastya;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

import com.codeborne.selenide.Condition;


public class StepsTest {

    public static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    public void testLambdaStep() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий" + REPOSITORY, () -> {
            $("input.form-control").click();
            $("input.form-control").setValue(REPOSITORY).submit();
        });

        step("Кликаем по ссылке репозитория" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем название Issues в репозитории" + REPOSITORY, () -> {
            $(withText("issue_to_test_allure_report")).should(Condition.exist);
        });
    }

    @Test

    public void testAnnotatedStep() {
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldTextRepository();

    }
}

