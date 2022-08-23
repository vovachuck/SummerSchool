package buem.lak.service.impls;

import buem.lak.model.Payment;
import buem.lak.model.PaymentDetails;
import buem.lak.repository.IPaymentDetailsMongoRepository;
import buem.lak.repository.IPaymentMongoRepository;
import buem.lak.service.interfaces.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private IPaymentMongoRepository repository;

    @Override
    public Payment create(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Payment update(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Payment get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Payment> getAll() {
        return repository.findAll();
    }
}
