package com.kantar.airways.service.checkout.model.response;

import com.kantar.airways.common.model.BaseResponse;
import com.kantar.airways.service.checkout.model.dto.PaymentDTO;

public class ResponseChargeFee extends BaseResponse {
    private PaymentDTO payment;

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }
}
