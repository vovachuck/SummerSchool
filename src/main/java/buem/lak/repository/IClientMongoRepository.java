package buem.lak.repository;

import buem.lak.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IClientMongoRepository extends MongoRepository<Client, String> {
    List<Client> findAllByCreatedAtAfterAndName(LocalDateTime date, String name);
}
