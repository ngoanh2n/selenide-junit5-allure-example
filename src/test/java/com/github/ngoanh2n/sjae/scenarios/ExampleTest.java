package com.github.ngoanh2n.sjae.scenarios;

import com.github.ngoanh2n.sjae.common.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * ExampleTest class
 * <br/>
 *
 * @author ngoanh2n@gmail.com (Ho Huu Ngoan)
 */

@Epic("LearnThat")
@Feature("Client UI")
@Severity(SeverityLevel.NORMAL)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExampleTest extends BaseTest {

    @Test
    @Order(1)
    @Story("Portal UI")
    @Description("This test demonstrates how to use Selenide, JUnit5, Allure...")
    void passedTest() {
        this.portalPage.verifyDashboardTitle("Student Portal");
    }

    @Test
    @Order(2)
    @Story("Portal UI")
    @Description("This test demonstrates how to use Selenide, JUnit5, Allure...")
    void failedTest() {
        this.portalPage.verifyDashboardTitle("Teacher Portal");
    }

    @Test
    @Order(3)
    @Story("Portal UI")
    @Description("This test demonstrates how to use Selenide, JUnit5, Allure...")
    void brokenTest() {
        this.portalPage.verifyLastQuizMenu();
    }
}
