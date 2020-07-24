package com.kantar.airways.common.mapper;

import com.kantar.airways.domain.entity.PaymentEntity;
import com.kantar.airways.service.checkout.model.dto.PaymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentDTO paymentToPaymentDto(PaymentEntity payment);

    PaymentEntity paymentDtoToPayment(PaymentDTO payment);

}
