package buem.lak.service.interfaces;

import buem.lak.model.TradingPoint;

import java.util.List;

public interface ITradingPointService {
    TradingPoint create(TradingPoint rent);
    TradingPoint update(TradingPoint rent);
    TradingPoint get(String id);
    void delete(String id);
    List<TradingPoint> getAll();
}
