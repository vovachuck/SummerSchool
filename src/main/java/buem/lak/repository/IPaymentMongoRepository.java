package buem.lak.repository;

import buem.lak.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IPaymentMongoRepository extends MongoRepository<Payment, String> {
    List<Payment> findAllByCreatedAtAfterAndName(LocalDateTime date, String name);
}
