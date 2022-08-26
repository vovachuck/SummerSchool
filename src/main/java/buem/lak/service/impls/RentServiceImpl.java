package buem.lak.service.impls;

import buem.lak.model.Client;
import buem.lak.model.Rent;
import buem.lak.repository.IPaymentMongoRepository;
import buem.lak.repository.IRentMongoRepository;
import buem.lak.service.interfaces.IRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class RentServiceImpl implements IRentService {

    private LocalDateTime now = LocalDateTime.now();
    private List<Rent> rents = new ArrayList<>(
            Arrays.asList(
                    new Rent(UUID.randomUUID().toString(), "payment1", "By car", now, now, now, now),
                    new Rent(UUID.randomUUID().toString(), "payment2", "By car", now, now, now, now),
                    new Rent(UUID.randomUUID().toString(), "payment3", "By car", now, now, now, now)
            ));

//    @PostConstruct
//    void init(){
//        repository.saveAll(rents);
//    }

    @Autowired
    private IRentMongoRepository repository;

    @Override
    public Rent create(Rent rent) {
        return repository.save(rent);
    }

    @Override
    public Rent update(Rent rent) {
        return repository.save(rent);
    }

    @Override
    public Rent get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Rent> getAll() {
        return repository.findAll();
    }
}
