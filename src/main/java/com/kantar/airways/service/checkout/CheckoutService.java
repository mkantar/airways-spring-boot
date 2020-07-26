package com.kantar.airways.service.checkout;

import com.kantar.airways.common.exception.BusinessException;
import com.kantar.airways.service.checkout.model.request.RequestChargeFee;
import com.kantar.airways.service.checkout.model.response.ResponseChargeFee;

public interface CheckoutService {

    ResponseChargeFee chargeFee(RequestChargeFee request) throws BusinessException;

}
