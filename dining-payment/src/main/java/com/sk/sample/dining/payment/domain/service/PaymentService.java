package com.sk.sample.dining.payment.domain.service;

import com.sk.sample.dining.payment.domain.model.Purchase;

public interface PaymentService {
	Purchase purchase(Purchase purchase);
}
