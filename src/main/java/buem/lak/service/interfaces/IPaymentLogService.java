package buem.lak.service.interfaces;

import buem.lak.model.PaymentLog;

import java.util.List;

public interface IPaymentLogService {
    PaymentLog create(PaymentLog paymentLog);
    PaymentLog update(PaymentLog paymentLog);
    PaymentLog get(String id);
    void delete(String id);
    List<PaymentLog> getAll();
}
