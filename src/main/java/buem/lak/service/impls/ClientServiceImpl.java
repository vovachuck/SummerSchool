package buem.lak.service.impls;

import buem.lak.model.Client;
import buem.lak.repository.ClientFakeRepository;
import buem.lak.repository.ClientMongoRepository;
import buem.lak.service.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements IClientService {
    private LocalDateTime now = LocalDateTime.now();
    private List<Client> clients = new ArrayList<>(
            Arrays.asList(
                    new Client(UUID.randomUUID().toString(), "Volodymyr Lakusta", "Student", now, now, "Hlinichka 1", "+38099023452", "Mykyta Plotnikov"),
                    new Client(UUID.randomUUID().toString(), "Mykyta Plotnikov", "Tiktoker", now, now, "Hlinichka 1", "+38099056723", "Yevhen Darovykh"),
                    new Client(UUID.randomUUID().toString(), "Yevhen Darovykh", "Quiet person", now, now, "Hlinichka 1", "+38099456734", "Volodymyr Lakusta")
            ));
    @Autowired
    ClientMongoRepository repository;

//    @PostConstruct
//    void init(){
//        repository.saveAll(clients);
//    }

    @Override
    public Client create(Client client) {
        return repository.save(client);
    }

    @Override
    public Client update(Client client) {
        return repository.save(client);
    }

    @Override
    public Client get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }
}
