package buem.lak.controller.api;

import buem.lak.model.TradingPoint;
import buem.lak.service.impls.TradingPointServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/tradingPoints/")
@RestController
public class TradingPointRestController {
    @Autowired
    TradingPointServiceImpl service;

    @GetMapping
    public List<TradingPoint> showAll(){
        return service.getAll();
    }

    @GetMapping("{id}")
    public TradingPoint showOne(@PathVariable String id){
        return service.get(id);
    }

    @DeleteMapping("{id}")
    public void del(@PathVariable String id){
        service.delete(id);
    }

    @PostMapping()
    public TradingPoint insertOne(@RequestBody TradingPoint tradingPoint){
        return service.create(tradingPoint);
    }

    @PutMapping()
    public TradingPoint updateOne(@RequestBody TradingPoint tradingPoint){
        return service.update(tradingPoint);
    }
}
