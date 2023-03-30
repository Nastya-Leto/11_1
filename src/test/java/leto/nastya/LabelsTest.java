package leto.nastya;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LabelsTest {

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("ZakharovaAnAn")
    @Severity(SeverityLevel.MINOR)
    @Link(value = "Testing", url = "https://github.com/Nastya-Leto")
    @DisplayName("Создание Issue для авторизванного пользователя")
    public void testStaticLabels() {

    }

    @Test

    public void testDynamicLabels() {


    }
}

