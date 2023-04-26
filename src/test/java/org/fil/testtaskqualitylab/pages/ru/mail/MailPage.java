package org.fil.testtaskqualitylab.pages.ru.mail;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.Wait;
import static java.time.Duration.ofSeconds;

// page_url = https://e.mail.ru/
public class MailPage {

	SelenideElement addressField = $x("//div[contains(@class,'contactsContainer')]//input");
	SelenideElement mailBodyField = $x("//div[@role='textbox']/div");
	SelenideElement sendButton = $x("//span[@class='vkuiButton__content' and text()='Отправить']");
	SelenideElement newMailButton = $x("//span[@class='compose-button__wrapper']");

	public void clickNewMailButton() {
		wait(newMailButton, 2, 15);
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


	private void wait(SelenideElement element, Integer interval, Integer timeout) {
		Wait()
				.withMessage("ожидание...")
				.pollingEvery(ofSeconds(interval))
				.withTimeout(ofSeconds(timeout))
				.ignoring(NoSuchElementException.class)
				.until(ExpectedConditions
						.visibilityOfElementLocated(
								By.xpath(element.getSearchCriteria().substring(10))));
	}

}
