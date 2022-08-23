package buem.lak.service.interfaces;

import buem.lak.model.Rent;

import java.util.List;

public interface IRentService {
    Rent create(Rent rent);
    Rent update(Rent rent);
    Rent get(String id);
    void delete(String id);
    List<Rent> getAll();
}
