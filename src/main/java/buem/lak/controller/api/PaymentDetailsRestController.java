package buem.lak.controller.api;

import buem.lak.model.Client;
import buem.lak.model.PaymentDetails;
import buem.lak.service.impls.ClientServiceImpl;
import buem.lak.service.impls.PaymentDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/paymentDetails/")
@RestController
public class PaymentDetailsRestController {
    @Autowired
    private PaymentDetailsServiceImpl service;

    @GetMapping
    public List<PaymentDetails> showAll(){
        return service.getAll();
    }

    @GetMapping("{id}")
    public PaymentDetails showOne(@PathVariable String id){
        return service.get(id);
    }

    @DeleteMapping("{id}")
    public void del(@PathVariable String id){
        service.delete(id);
    }

    @PostMapping()
    public PaymentDetails insertOne(@RequestBody PaymentDetails paymentDetails){
        return service.create(paymentDetails);
    }

    @PutMapping()
    public PaymentDetails updateOne(@RequestBody PaymentDetails paymentDetails){
        return service.update(paymentDetails);
    }
}
