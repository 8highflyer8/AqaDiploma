package ru.netology.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.CreditPage;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;

import static com.codeborne.selenide.Selenide.open;

public class PaymentCreditPageTest {

    @Test
    @DisplayName("Should successfully pay from APPROVED card")
    void shouldSuccessfullyPayFromApprovedCard() {
        var CardInfo = DataHelper.getFirstCardNumberAndStatus();
        var PaymentPage = MainPage.openPaymentPage(CardInfo);
        PaymentPage.validPayCard(CardInfo);
        PaymentPage.verifySuccessPayVisibility();
    }

    @Test
    @DisplayName("Should show error message when pay from DECLINED card")
    void shouldShowErrorWhenPayFromDeclinedCard() {
        var CardInfo = DataHelper.getSecondCardNumberAndStatus();
        var PaymentPage = MainPage.openPaymentPage(CardInfo);
        PaymentPage.validPayCard(CardInfo);
        PaymentPage.verifyDeclinePayVisibility();
    }


    @Test
    @DisplayName("Should successfully pay on credit from APPROVED card")
    void shouldSuccessfullyРayОnСreditFromApprovedCard() {
        var CardInfo = DataHelper.getFirstCardNumberAndStatus();
        var CreditPage = MainPage.openPaymentPage(CardInfo);
        CreditPage.validPayCard(CardInfo);
        CreditPage.verifySuccessPayVisibility();
    }

    @Test
    @DisplayName("Should show error message when pay on credit from DECLINED card")
    void shouldShowErrorWhenPayОnСreditFromDeclinedCard() {
        var CardInfo = DataHelper.getSecondCardNumberAndStatus();
        var CreditPage = MainPage.openPaymentPage(CardInfo);
        CreditPage.validPayCard(CardInfo);
        CreditPage.verifySuccessPayVisibility();
    }


    @Test
    @DisplayName("Should show error message when pay card and cardnumber field empty")
    void shouldShowErrorWhenPayCardAndCardNumberFieldEmpty() {
        var CardInfo = DataHelper.getFirstCardNumberAndStatus();
        var PaymentPage = MainPage.openPaymentPage(CardInfo);
        PaymentPage.emptyField(CardInfo);
        PaymentPage.verifyEmptyField();
    }

    @Test
    @DisplayName("Should show error message when pay on credit and cardnumber field empty")
    void shouldShowErrorWhenPayОnСreditAndCardNumberFieldEmpty() {
        var CardInfo = DataHelper.getFirstCardNumberAndStatus();
        var CreditPage = MainPage.openPaymentPage(CardInfo);
        CreditPage.emptyField(CardInfo);
        CreditPage.verifyEmptyField();
    }
}



