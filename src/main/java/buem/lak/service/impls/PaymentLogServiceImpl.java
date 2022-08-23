package buem.lak.service.impls;

import buem.lak.model.Client;
import buem.lak.model.Payment;
import buem.lak.model.PaymentLog;
import buem.lak.repository.IClientMongoRepository;
import buem.lak.repository.IPaymentLogMongoRepository;
import buem.lak.repository.IPaymentMongoRepository;
import buem.lak.service.interfaces.IPaymentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentLogServiceImpl implements IPaymentLogService {
    @Autowired
    private IPaymentLogMongoRepository repository;

    @Override
    public PaymentLog create(PaymentLog paymentLog) {
        return repository.save(paymentLog);
    }

    @Override
    public PaymentLog update(PaymentLog paymentLog) {
        return repository.save(paymentLog);
    }

    @Override
    public PaymentLog get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<PaymentLog> getAll() {
        return repository.findAll();
    }
}
