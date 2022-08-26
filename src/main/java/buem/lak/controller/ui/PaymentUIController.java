package buem.lak.controller.ui;

import buem.lak.model.Payment;
import buem.lak.service.impls.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/ui/v1/payments/")
@Controller
public class PaymentUIController {
    @Autowired
    PaymentServiceImpl service;

    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("payments",service.getAll());
        return "payments";
    }


    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        return  "redirect:/ui/v1/payments/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addItem(Model model){
        Payment payment = new Payment();
        model.addAttribute("form", payment);
        return "addPayment";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("form") Payment paymentForm){
        paymentForm.setCreatedAt(LocalDateTime.now());
        paymentForm.setUpdatedAt(LocalDateTime.now());
        service.create(paymentForm);
        return "redirect:/ui/v1/payments/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateItem(Model model, @PathVariable("id") String id){
        Payment paymentToUpdate = service.get(id);
        Payment paymentsForm = new Payment();
        paymentsForm.setId(paymentToUpdate.getId());
        paymentsForm.setName(paymentToUpdate.getName());
        paymentsForm.setDescription(paymentToUpdate.getDescription());
        paymentsForm.setUpdatedAt(paymentToUpdate.getUpdatedAt());
        paymentsForm.setCreatedAt(paymentToUpdate.getCreatedAt());
        model.addAttribute("form", paymentsForm);
        return "updatePayment";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateItem( @ModelAttribute("form") Payment paymentsForm){
        Payment itemForm = service.get(paymentsForm.getId());
        Payment itemtoUpdate = new Payment();
        itemtoUpdate.setId(paymentsForm.getId());
        itemtoUpdate.setName(paymentsForm.getName());
        itemtoUpdate.setDescription(paymentsForm.getDescription());
        itemtoUpdate.setCreatedAt(itemForm.getCreatedAt());
        itemtoUpdate.setUpdatedAt(LocalDateTime.now());

        itemtoUpdate.setAmount(paymentsForm.getAmount());

        service.update(itemtoUpdate);

        return "redirect:/ui/v1/payments/";
    }
}
