package com.devPortes.payments.controller;

import com.devPortes.payments.dto.AllMethodPaymentResponseDto;
import com.devPortes.payments.service.IAllPaymentMethodUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/payment-method")
public class PaymentMethodController {

    private final IAllPaymentMethodUseCase iAllPaymentMethodUseCase;

    @GetMapping("all")
    public ResponseEntity<AllMethodPaymentResponseDto> showAllMethodPayment (){
        AllMethodPaymentResponseDto response = iAllPaymentMethodUseCase.execute();
    return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
