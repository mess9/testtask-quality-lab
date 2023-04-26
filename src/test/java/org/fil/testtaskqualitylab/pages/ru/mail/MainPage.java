package org.fil.testtaskqualitylab.pages.ru.mail;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

// page_url = https://mail.ru/
public class MainPage {

	SelenideElement enterButtonStart = $x("//button[@data-testid='enter-mail-primary']");
	SelenideElement enterButtonFinal = $x("//div[@class='login-row']//span[contains(text(),'Войти')]");
	SelenideElement passwordButton = $x("//div[@class='login-row']//button[@data-test-id='next-button']");
	SelenideElement loginField = $x("//input[@name='username']");
	SelenideElement passwordField = $x("//input[@name='password']");


	public void login(String login, String password) {
		enterButtonStart.click();
		switchTo().frame($x("//iframe[@class='ag-popup__frame__layout__iframe']"));
		loginField.click();
		loginField.sendKeys(login);
		passwordButton.click();
		passwordField.click();
		passwordField.sendKeys(password);
		enterButtonFinal.click();
	}
}