package buem.lak.service.impls;

import buem.lak.model.Client;
import buem.lak.model.PaymentDetails;
import buem.lak.repository.ClientFakeRepository;
import buem.lak.service.interfaces.IPaymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentDetailsServiceImpl implements IPaymentDetailsService {
    @Autowired
    private ClientFakeRepository repository;

    @Override
    public PaymentDetails create(PaymentDetails paymentDetails) {
        return null;
    }

    @Override
    public PaymentDetails update(PaymentDetails paymentDetails) {
        return null;
    }

    @Override
    public PaymentDetails get(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<PaymentDetails> getAll() {
        return null;
    }
}
