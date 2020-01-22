package com.github.ngoanh2n.scenarios;

import com.github.ngoanh2n.common.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

/**
 * BaseTest class
 * <br/>
 *
 * @author ngoanh2n@gmail.com (Ho Huu Ngoan)
 */

@Epic("Gitlab")
@Feature("Client UI")
@Severity(SeverityLevel.NORMAL)
public class ExampleTest extends BaseTest {

    @Test
    @Story("Displaying Repositories")
    @Description("This test demonstrates how to use Selenide, JUnit5, Allure...")
    void homePageTest() {
        this.homePage
                .verifyHomePageEmpty();
    }
}
