package buem.lak.controller.api;

import buem.lak.model.Rent;
import buem.lak.service.impls.RentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/rents/")
@RestController
public class RentRestController {
    @Autowired
    private RentServiceImpl service;

    @GetMapping
    public List<Rent> showAll(){
        return service.getAll();
    }

    @GetMapping("{id}")
    public Rent showOne(@PathVariable String id){
        return service.get(id);
    }

    @DeleteMapping("{id}")
    public void del(@PathVariable String id){
        service.delete(id);
    }

    @PostMapping()
    public Rent insertOne(@RequestBody Rent rent){
        return service.create(rent);
    }

    @PutMapping()
    public Rent updateOne(@RequestBody Rent rent){
        return service.update(rent);
    }
}
