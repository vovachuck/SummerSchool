package buem.lak.service.impls;

import buem.lak.model.Client;
import buem.lak.repository.ClientFakeRepository;
import buem.lak.service.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private ClientFakeRepository repository;

    @Override
    public Client create(Client client) {
        return repository.save(client);
    }

    @Override
    public Client update(Client client) {
        return repository.update(client);
    }

    @Override
    public Client get(String id) {
        return repository.findById(id);
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
