package buem.lak.repository;

import buem.lak.model.Rent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IRentMongoRepository extends MongoRepository<Rent, String> {
    List<Rent> findAllByCreatedAtAfterAndName(LocalDateTime date, String name);
}
