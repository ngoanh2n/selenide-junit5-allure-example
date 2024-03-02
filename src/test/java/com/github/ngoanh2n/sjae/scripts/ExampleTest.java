package com.github.ngoanh2n.sjae.scripts;

import com.github.ngoanh2n.sjae.common.AbstractTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

/**
 * @author ngoanh2n
 */
@Epic("LearnThat")
@Feature("Client UI")
public class ExampleTest extends AbstractTest {
    @Test
    @Order(1)
    @Story("Portal UI")
    @Description("Demonstrates how to use Selenide, JUnit5, Allure...")
    void passedTest() {
        portalPage.verifyDashboardTitle("Student Portal");
    }

    @Test
    @Order(2)
    @Story("Portal UI")
    @Description("Demonstrates how to use Selenide, JUnit5, Allure...")
    void failedTest() {
        portalPage.verifyDashboardTitle("Teacher Portal");
    }

    @Test
    @Order(3)
    @Story("Portal UI")
    @Description("Demonstrates how to use Selenide, JUnit5, Allure...")
    void brokenTest() {
        portalPage.verifyNumberOfQuizMenu();
    }
}
