package com.kantar.airways.controller.checkout;

import com.kantar.airways.common.exception.BusinessException;
import com.kantar.airways.service.checkout.CheckoutService;
import com.kantar.airways.service.checkout.model.request.RequestChargeFee;
import com.kantar.airways.service.checkout.model.response.ResponseChargeFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/checkout")
public class CheckoutController {

	@Autowired
	CheckoutService service;

	@PostMapping
	public ResponseChargeFee charge(@RequestBody RequestChargeFee request) throws BusinessException {
		return service.chargeFee(request);
	}
}
