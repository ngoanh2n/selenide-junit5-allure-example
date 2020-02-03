package com.github.ngoanh2n.sjae.common;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.github.ngoanh2n.sjae.pages.LoginPage;
import com.github.ngoanh2n.sjae.pages.PortalPage;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static java.lang.invoke.MethodHandles.lookup;

/**
 * BaseTest class
 * <br/>
 *
 * @author ngoanh2n@gmail.com (Ho Huu Ngoan)
 */

public abstract class BaseTest {

    private final static Logger logger = LoggerFactory.getLogger(lookup().lookupClass());
    private final static String selenideProperties = "selenide.properties";

    protected PortalPage portalPage;

    @BeforeAll
    static void setupClass() throws IOException {
        /*
         * Add AllureSelenide listener
         */
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        /*
         * Load selenide.properties file in resources
         */
        Properties props = new Properties();
        InputStream inputStream = BaseTest.class
                .getClassLoader()
                .getResourceAsStream(selenideProperties);
        props.load(inputStream);

        if (!props.isEmpty()) {
            for (Object propObj : props.keySet()) {
                String prop = String.valueOf(propObj);

                if (!System.getProperties().containsKey(prop)) {
                    System.setProperty(prop, props.getProperty(prop));
                }
            }
        }

        logger.info("Loading selenide properties as {}", selenideProperties);
    }

    @AfterAll
    static void cleanupClass() {
        /*
         * Generate environment properties to Allure report
         * */
        ImmutableMap.Builder<String, String> environmentBuilder = ImmutableMap.builder();
        /*
         * From selenide.properties
         * */
        System.getProperties().forEach((key, val) -> {
            if (key.toString().startsWith("selenide.")) {
                environmentBuilder.put(key.toString(), val.toString());
            }
        });
        /*
         * From allure.properties
         * */
        System.getProperties().forEach((key, val) -> {
            if (key.toString().startsWith("allure.")) {
                environmentBuilder.put(key.toString(), val.toString());
            }
        });
        AllureEnvironmentWriter.allureEnvironmentWriter(
                environmentBuilder.build(),
                System.getProperty("allure.results.directory") + "/"
        );

        SelenideLogger.removeListener("AllureSelenide");
        if (WebDriverRunner.hasWebDriverStarted()) WebDriverRunner.closeWebDriver();
    }

    @BeforeEach
    protected void setupTest() {
        this.portalPage = open("/users/login", LoginPage.class)
                .login("ngoanh2n", "ngoanh2n");
    }

    @AfterEach
    protected void cleanupTest() {
        this.portalPage.logout();
        WebDriverRunner.closeWindow();
    }
}
