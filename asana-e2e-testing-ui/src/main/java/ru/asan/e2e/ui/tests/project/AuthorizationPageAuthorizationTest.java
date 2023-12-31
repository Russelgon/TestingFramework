package ru.asan.e2e.ui.tests.project;

import static asana.e2e.core.baseTech.RandomValueGenerator.ENG;
import static asana.e2e.core.baseTech.RandomValueGenerator.randomLengthString;

import asana.e2e.core.api.tech.data.DataLoaderUi;
import asana.e2e.core.api.tech.data.user.UserUi;
import asana.e2e.core.api.tech.tests.UiBaseTest;

import asana.e2e.core.web.asserts.AssertsUi;
import asana.e2e.integration.models.entites.enums.UiInformation;
import jdk.jfr.Name;
import org.junit.Test;

public class AuthorizationPageAuthorizationTest extends UiBaseTest {

    @Test
    @Name("TEST_5. UI. Authorization Page. Not correct email address")
    public void TEST_5_UI__Authorization__not_correct_email_address() {

        // Step 1.1 Arrange
        UserUi projectUser = DataLoaderUi.projectPositiveUser();
        projectUser.setMail(randomLengthString(5, 10, ENG));

        // Step 2.1 Steps
        mainPage.click_logIn_button();
        authorizationPage.fill_email(projectUser.getMail());
        authorizationPage.click_continue_button();

        // Step 3.1 Asserts
        AssertsUi.assertMessage(authorizationPage.get_emailAddress_message(),
                UiInformation.ERRORS_EMAIL.getMessage());
        AssertsUi.assertMessage(authorizationPage.get_alert_message(),
                UiInformation.ERRORS_EMAIL.getError());
    }

    @Test
    @Name("TEST_6. UI. Authorization Page. Not correct password")
    public void TEST_5_UI__Authorization__not_correct_password() {

        // Step 1.1 Arrange
        UserUi projectUser = DataLoaderUi.projectPositiveUser();
        projectUser.setPassword(randomLengthString(5, 10, ENG));

        // Step 2.1 Steps
        mainPage.click_logIn_button();
        authorizationPage.fill_email(projectUser.getMail());
        authorizationPage.click_continue_button();
        authorizationPage.fill_password(projectUser.getPassword());
        authorizationPage.click_continue_button();

        // Step 3.1 Asserts
        AssertsUi.assertMessage(authorizationPage.get_emailAddress_message(),
                UiInformation.ERRORS_PASSWORD.getMessage());
        AssertsUi.assertMessage(authorizationPage.get_alert_message(),
                UiInformation.ERRORS_PASSWORD.getError());
    }
}
