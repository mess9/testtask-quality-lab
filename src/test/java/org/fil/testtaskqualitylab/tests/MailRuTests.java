package org.fil.testtaskqualitylab.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Feature;
import org.fil.testtaskqualitylab.pages.BasePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("Тестовое задание")
public class MailRuTests extends BasePage {

	/*
		ТЗ
		Написать тестовый проект с использованием Java, Selenium, jUnit/TestNG и Page object паттерна и любого сборщика.
	    Тест должен уметь следующее:
	        - залогиниться на mail.ru;
	        - написать письмо любого содержания c заполнением поля Body (текста самого письма);
	        - отправить письмо.
	    Проверка доставки письма не нужна, только отправка.
	    Тестовый проект вставить как ссылку на GitHub и прислать.
	 */

	String login = "t_acc_ql";
	String password = "Ax4-EDw-9b4-nXC";
	String receiverAddress = "as0509@ya.ru";
	String bodyMail = """
			xxx: опиши себя
			yyy: брюнетка
			xxx: ага. а глаза?
			yyy: есть
			""";

	@BeforeEach
	public void setUp() {
		// Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
		Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
		open("https://mail.ru/");
	}

	@Test
	@DisplayName("Отправка письма")
	void sendMail() {
		step("логин", ()->
				mainPage.login(login, password));
		step("написать письмо", ()->{
			mailPage.clickNewMailButton();
			mailPage.fillMailFields(receiverAddress, bodyMail);
			mailPage.sendMail();
		});
	}
}
