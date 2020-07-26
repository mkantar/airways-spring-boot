package com.kantar.airways.domain.vo;

import java.util.Collections;

public class CreditCard {
    private final String maskedCardNumber;

    private CreditCard(String creditCardNumber) {
        this.maskedCardNumber = creditCardNumber;
    }

    public static CreditCard from(String creditCardNumber) {
        String strippedCreditCard = creditCardNumber.replaceAll("[^0-9]", "");

        String prefix = strippedCreditCard.substring(0, 6);

        String sectionToMask = strippedCreditCard.substring(6, strippedCreditCard.length() - 4);

        String middle = String.join("", Collections.nCopies(sectionToMask.length(), "*"));

        String suffix = strippedCreditCard.substring(strippedCreditCard.length() - 4);

        return new CreditCard(prefix + middle + suffix);

    }

    public String toString() {
        return maskedCardNumber;
    }

}
