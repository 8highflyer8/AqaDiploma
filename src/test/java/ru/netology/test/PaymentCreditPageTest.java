package ru.netology.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.PaymentCreditPage;

import static com.codeborne.selenide.Selenide.open;

public class PaymentCreditPageTest {
    /*@Test
    void shouldShowRandomMonth() {
        System.out.println(DataHelper.generateRandomMonth());
        System.out.println(DataHelper.generateValidDate());
        System.out.println(DataHelper.generateRandomYear());
        System.out.println(DataHelper.generateFullName());
        System.out.println(DataHelper.generateCvc());


    }*/
    @Test
    @DisplayName("Should successfully pay from APPROVED card")
    void shouldSuccessfulLogin() {
        var PaymentCreditPage = open("http://localhost:8080/", PaymentCreditPage.class);
        var CardInfo = DataHelper.getFirstCardNumberAndStatus();
        PaymentCreditPage.validLogin(CardInfo);





    }
}
