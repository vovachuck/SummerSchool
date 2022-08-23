package buem.lak.repository;

import buem.lak.model.PaymentDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IPaymentDetailsMongoRepository extends MongoRepository<PaymentDetails, String> {
    List<PaymentDetails> findAllByCreatedAtAfterAndName(LocalDateTime date, String name);
}
