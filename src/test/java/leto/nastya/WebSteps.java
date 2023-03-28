package leto.nastya;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;


public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");

    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $("input.form-control").click();
        $("input.form-control").setValue(repo).submit();
    }

    @Step("Кликаем по ссылке репозитория{repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем название Issues в репозитории")
    public void shouldTextRepository() {
        $(withText("issue_to_test_allure_report")).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}



