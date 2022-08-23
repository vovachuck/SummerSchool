package buem.lak.controller.api;

import buem.lak.model.Payment;
import buem.lak.model.PaymentLog;
import buem.lak.repository.IPaymentLogMongoRepository;
import buem.lak.service.impls.PaymentLogServiceImpl;
import buem.lak.service.impls.PaymentServiceImpl;
import buem.lak.service.interfaces.IPaymentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/paymentLogs/")
@RestController
public class PaymentLogRestController {
    @Autowired
    private PaymentLogServiceImpl service;

    @GetMapping
    public List<PaymentLog> showAll(){
        return service.getAll();
    }

    @GetMapping("{id}")
    public PaymentLog showOne(@PathVariable String id){
        return service.get(id);
    }

    @DeleteMapping("{id}")
    public void del(@PathVariable String id){
        service.delete(id);
    }

    @PostMapping()
    public PaymentLog insertOne(@RequestBody PaymentLog paymentLog){
        return service.create(paymentLog);
    }

    @PutMapping()
    public PaymentLog updateOne(@RequestBody PaymentLog paymentLog){
        return service.update(paymentLog);
    }
}
