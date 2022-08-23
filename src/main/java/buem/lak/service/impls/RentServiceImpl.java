package buem.lak.service.impls;

import buem.lak.model.Rent;
import buem.lak.repository.IPaymentMongoRepository;
import buem.lak.repository.IRentMongoRepository;
import buem.lak.service.interfaces.IRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements IRentService {
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
