package buem.lak.service.impls;

import buem.lak.model.TradingPoint;
import buem.lak.repository.ITradingPointMongoRepository;
import buem.lak.service.interfaces.ITradingPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradingPointServiceImpl implements ITradingPointService {
    @Autowired
    private ITradingPointMongoRepository repository;

    @Override
    public TradingPoint create(TradingPoint tradingPoint) {
        return repository.save(tradingPoint);
    }

    @Override
    public TradingPoint update(TradingPoint tradingPoint) {
        return repository.save(tradingPoint);
    }

    @Override
    public TradingPoint get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<TradingPoint> getAll() {
        return repository.findAll();
    }
}
