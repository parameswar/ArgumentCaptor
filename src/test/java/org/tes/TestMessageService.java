package org.tes;

import com.data.TransactionDetail;
import com.message.service.MessageService;
import com.service.BankingService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.ArgumentCaptor;
import org.mockito.MockitoAnnotations;


public class TestMessageService {

	@Test
	public void check_if_correct_priority_is_set() {
		ArgumentCaptor<TransactionDetail> trArgumentCaptor = ArgumentCaptor.forClass(TransactionDetail.class);
		TransactionDetail transactionDetail = new TransactionDetail();
		BankingService service = new BankingService();
		MessageService ms = mock(MessageService.class);
		service.setMessageService(ms);
		transactionDetail.setTransactionAmount(1000);

		service.withDraw(transactionDetail);

		verify(ms).sendMessage(trArgumentCaptor.capture());

		Assertions.assertEquals(trArgumentCaptor.getValue().getPriority(), "high");
	}
}
