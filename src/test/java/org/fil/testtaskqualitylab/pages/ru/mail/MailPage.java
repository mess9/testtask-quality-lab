package org.fil.testtaskqualitylab.pages.ru.mail;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://e.mail.ru/
public class MailPage {

	SelenideElement addressField = $x("//div[contains(@class,'contactsContainer')]//input");
	SelenideElement mailBodyField = $x("//div[@role='textbox']/div");
	SelenideElement sendButton = $x("//span[@class='vkuiButton__content' and text()='Отправить']");
	SelenideElement newMailButton = $x("//span[@class='compose-button__wrapper']");

	public void clickNewMailButton() {
		loadMailPage();
		newMailButton.click();
	}

	public void fillMailFields(String address, String body) {
		addressField.click();
		addressField.sendKeys(address);
		mailBodyField.click();
		mailBodyField.sendKeys(body);
	}

	public void sendMail() {
		sendButton.click();
	}


	// наверняка есть более подходящие инструменты, но на скорую руку ничего больше не придумал.
	private void loadMailPage() {
		int i = 0;
		while (i < 15) {
			if (newMailButton.shouldBe(Condition.visible).isDisplayed()) {
				break;
			} else {
				Selenide.sleep(1000);
				i++;
			}
		}
	}

}
