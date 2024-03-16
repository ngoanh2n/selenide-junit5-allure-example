package com.github.ngoanh2n.example.common;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.ngoanh2n.AllureEnvironment;
import com.github.ngoanh2n.example.models.Account;
import com.github.ngoanh2n.example.pages.LoginPage;
import com.github.ngoanh2n.example.pages.PortalPage;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * @author ngoanh2n
 */
@CanIgnoreReturnValue
@ParametersAreNonnullByDefault
@Severity(SeverityLevel.NORMAL)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public abstract class AbstractTest {
    protected static Account account;
    protected PortalPage portalPage;

    @BeforeAll
    public static void setupScenario() {
        // Add AllureSelenide listener
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // Load account data
        account = new Account().toModel();
    }

    @AfterAll
    public static void cleanupScenario() {
        // Remove AllureSelenide listener
        SelenideLogger.removeListener("AllureSelenide");

        // Close the current WebDriver.
        // Selenide has a mechanism to close WebDriver automatically before the main thread ends using Shutdown Hook.
        WebDriverRunner.closeWebDriver();

        // Put environment properties to Allure results
        AllureEnvironment.write("selenide.properties", "allure.properties");
    }

    @BeforeEach
    protected void setupTest() {
        portalPage = Selenide.open("/users/login", LoginPage.class)
                .login(account);
    }

    @AfterEach
    protected void cleanupTest() {
        portalPage.logout();
        WebDriverRunner.closeWindow();
    }
}
