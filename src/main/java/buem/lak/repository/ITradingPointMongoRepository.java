package buem.lak.repository;

import buem.lak.model.TradingPoint;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ITradingPointMongoRepository extends MongoRepository<TradingPoint, String> {
    List<TradingPoint> findAllByCreatedAtAfterAndName(LocalDateTime date, String name);
}
