package buem.lak.service.interfaces;

import buem.lak.model.Payment;

import java.util.List;

public interface IPaymentService {
    Payment create(Payment payment);
    Payment update(Payment payment);
    Payment get(String id);
    void delete(String id);
    List<Payment> getAll();
}
