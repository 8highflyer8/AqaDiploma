package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PaymentCreditPage {
    private final SelenideElement buyButton = $(byText("Купить"));
    private final SelenideElement buyCreditButton = $(byText("Купить в кредит"));
    private final SelenideElement continueButton = $(byText("Продолжить"));
    private final SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement monthField = $("[placeholder='08']");
    private final SelenideElement yearField = $("[placeholder='22']");
    private final SelenideElement cardHolderField = $(byText("Владелец"));
    private final SelenideElement cvcField = $("[placeholder='999']");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification']");

    public PaymentCreditPage validLogin(DataHelper.UserData info) {
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
