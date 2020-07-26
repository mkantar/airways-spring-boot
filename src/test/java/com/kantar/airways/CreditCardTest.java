package com.kantar.airways;

import com.kantar.airways.domain.vo.CreditCard;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreditCardTest {

    @Test
    public void testFrom() {
        CreditCard cardDash = CreditCard.from("1234-1247-1247-1247");
        CreditCard cardComma = CreditCard.from("1234,1247,1247,1247");
        CreditCard cardBlank = CreditCard.from("1234 1247 1247 1247");
        CreditCard card = CreditCard.from("12341!247!1247!1247");

        assertThat(cardDash.toString(), equalTo("123412******1247"));
        assertThat(cardComma.toString(), equalTo("123412******1247"));
        assertThat(cardBlank.toString(), equalTo("123412******1247"));
        assertThat(card.toString(), equalTo("123412******1247"));

    }

}
