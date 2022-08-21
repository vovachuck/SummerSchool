package buem.lak.service.interfaces;

import buem.lak.model.PaymentDetails;

import java.util.List;

public interface IPaymentDetailsService {
    PaymentDetails create(PaymentDetails paymentDetails);
    PaymentDetails update(PaymentDetails paymentDetails);
    PaymentDetails get(String id);
    void delete(String id);
    List<PaymentDetails> getAll();
}
