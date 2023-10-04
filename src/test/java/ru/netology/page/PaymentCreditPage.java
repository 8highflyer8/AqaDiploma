package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PaymentCreditPage {
    private final SelenideElement buyButton = $(".button_size_m");
    private final SelenideElement buyCreditButton = $(".button_view_extra");
    private final SelenideElement continueButton = $("fieldset button");
    private final SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement monthField = $("[placeholder='08']");
    private final SelenideElement yearField = $("[placeholder='22']");
    private final SelenideElement cardHolderField = $x("//*[contains(text(),'Владелец')]");
    private final SelenideElement cvcField = $("[placeholder='999']");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification']");

    public PaymentCreditPage validLogin(DataHelper.CardInfo info) {
        buyButton.click();
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(DataHelper.generateRandomMonth());
        yearField.setValue(DataHelper.generateRandomYear());
        cardHolderField.setValue(DataHelper.generateFullName());
        cvcField.setValue(DataHelper.generateCvc());
        continueButton.click();
        return new PaymentCreditPage();
    }

    public void verifyErrorNotificationVisibility() {
        errorNotification.shouldBe(visible);
    }
}
