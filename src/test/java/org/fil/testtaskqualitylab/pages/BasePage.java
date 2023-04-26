package org.fil.testtaskqualitylab.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.fil.testtaskqualitylab.pages.ru.mail.MailPage;
import org.fil.testtaskqualitylab.pages.ru.mail.MainPage;
import org.junit.jupiter.api.BeforeAll;

public class BasePage {

	public MainPage mainPage = new MainPage();
	public MailPage mailPage = new MailPage();

	@BeforeAll
	public static void setUpAll() {
		Configuration.browserSize = "1280x800";
		SelenideLogger.addListener("allure", new AllureSelenide());
	}

}
