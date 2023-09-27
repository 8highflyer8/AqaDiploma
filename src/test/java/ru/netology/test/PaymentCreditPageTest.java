package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;

public class PaymentCreditPageTest {
    @Test
    void shouldShowRandomMonth() {
        System.out.println(DataHelper.generateRandomMonth());
        System.out.println(DataHelper.generateValidDate());
        System.out.println(DataHelper.generateRandomYear());
        System.out.println(DataHelper.generateFullName());
        System.out.println(DataHelper.generateCvc());


    }
}
