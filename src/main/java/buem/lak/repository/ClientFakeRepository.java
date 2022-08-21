package buem.lak.repository;

import buem.lak.model.Client;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class ClientFakeRepository {
    private LocalDateTime now = LocalDateTime.now();
    private List<Client> clients = new ArrayList<>(
            Arrays.asList(
                    new Client(UUID.randomUUID().toString(), "Volodymyr Lakusta", "Student", now, now, "Hlinichka 1", "+38099023452", "Mykyta Plotnikov"),
                    new Client(UUID.randomUUID().toString(), "Mykyta Plotnikov", "Tiktoker", now, now, "Hlinichka 1", "+38099056723", "Yevhen Darovykh"),
                    new Client(UUID.randomUUID().toString(), "Yevhen Darovykh", "Quiet person", now, now, "Hlinichka 1", "+38099456734", "Volodymyr Lakusta")
            ));

    public List<Client> findAll(){
        return this.clients;
    }

    public Client save(Client client){
        client.setId(UUID.randomUUID().toString());
        client.setCreateAt(now);
        client.setUpdateAt(now);
        this.clients.add(client);
        return client;
    }

    public Client findById(String id){
        return this.clients.stream().filter(client -> client.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Client update(Client client) {
        this.deleteById(client.getId());
        client.setUpdateAt(LocalDateTime.now());
        this.clients.add(client);
        return  client;
    }

    public void deleteById(String id) {
        Client client = this.findById(id);
        int index = clients.indexOf(client);
        this.clients.remove(index);
    }
}
