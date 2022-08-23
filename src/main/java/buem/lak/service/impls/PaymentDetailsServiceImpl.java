package buem.lak.service.impls;

import buem.lak.model.PaymentDetails;
import buem.lak.repository.IPaymentDetailsMongoRepository;
import buem.lak.service.interfaces.IPaymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentDetailsServiceImpl implements IPaymentDetailsService {
    private LocalDateTime now = LocalDateTime.now();
    private List<PaymentDetails> paymentDetailsList = new ArrayList<>(
            Arrays.asList(
                     new PaymentDetails(UUID.randomUUID().toString(), "name1", "description1", now, now, "AL47 2121 1009 0000 0002 3569 87411", "1234123412341234", "212", now)
            ));

//    @PostConstruct
//    void init(){
//        repository.saveAll(paymentDetailsList);
//    }

    @Autowired
    private IPaymentDetailsMongoRepository repository;

    @Override
    public PaymentDetails create(PaymentDetails paymentDetails) {
        return repository.save(paymentDetails);
    }

    @Override
    public PaymentDetails update(PaymentDetails paymentDetails) {
        return repository.save(paymentDetails);
    }

    @Override
    public PaymentDetails get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<PaymentDetails> getAll() {
        return repository.findAll();
    }
}
