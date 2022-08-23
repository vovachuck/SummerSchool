package buem.lak.repository;

import buem.lak.model.PaymentLog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IPaymentLogMongoRepository extends MongoRepository<PaymentLog, String> {
    List<PaymentLog> findAllByCreatedAtAfterAndName(LocalDateTime date, String name);
}
