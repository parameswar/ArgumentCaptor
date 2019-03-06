package com.service;

import com.data.TransactionDetail;
import com.message.service.MessageService;

public class BankingService {
	MessageService ms;

	public void setMessageService(MessageService ms) {
		this.ms = ms;

	}

	public void withDraw(TransactionDetail transactionDetail) {
		int salary = transactionDetail.getTransactionAmount();
		if (salary > 100) {
			transactionDetail.setPriority("high");
		} else {
			transactionDetail.setPriority("low");
		}
		ms.sendMessage(transactionDetail);
	}
}
