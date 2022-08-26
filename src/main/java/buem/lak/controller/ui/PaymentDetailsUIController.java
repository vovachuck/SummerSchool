package buem.lak.controller.ui;

import buem.lak.model.PaymentDetails;
import buem.lak.service.impls.PaymentDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/ui/v1/paymentDetails/")
@Controller
public class PaymentDetailsUIController {
    @Autowired
    PaymentDetailsServiceImpl service;

    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("paymentDetails",service.getAll());
        return "paymentDetails";
    }


    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        return  "redirect:/ui/v1/paymentDetails/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addItem(Model model){
        PaymentDetails paymentDetails = new PaymentDetails();
        model.addAttribute("form", paymentDetails);
        return "addPaymentDetails";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("form") PaymentDetails paymentDetailsForm){
        paymentDetailsForm.setCreatedAt(LocalDateTime.now());
        paymentDetailsForm.setUpdatedAt(LocalDateTime.now());
        service.create(paymentDetailsForm);
        return "redirect:/ui/v1/paymentDetails/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateItem(Model model, @PathVariable("id") String id){
        PaymentDetails paymentDetailsToUpdate = service.get(id);
        PaymentDetails paymentDetailsForm = new PaymentDetails();
        paymentDetailsForm.setId(paymentDetailsToUpdate.getId());
        paymentDetailsForm.setName(paymentDetailsToUpdate.getName());
        paymentDetailsForm.setDescription(paymentDetailsToUpdate.getDescription());
        paymentDetailsForm.setUpdatedAt(paymentDetailsToUpdate.getUpdatedAt());
        paymentDetailsForm.setCreatedAt(paymentDetailsToUpdate.getCreatedAt());
        model.addAttribute("form", paymentDetailsForm);
        return "updatePaymentDetails";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateItem( @ModelAttribute("form") PaymentDetails paymentDetailsForm){
        PaymentDetails itemForm = service.get(paymentDetailsForm.getId());
        PaymentDetails itemtoUpdate = new PaymentDetails();
        itemtoUpdate.setId(paymentDetailsForm.getId());
        itemtoUpdate.setName(paymentDetailsForm.getName());
        itemtoUpdate.setDescription(paymentDetailsForm.getDescription());
        itemtoUpdate.setCreatedAt(itemForm.getCreatedAt());
        itemtoUpdate.setUpdatedAt(LocalDateTime.now());

        itemtoUpdate.setIban(paymentDetailsForm.getIban());
        itemtoUpdate.setCardNumber(paymentDetailsForm.getCardNumber());
        itemtoUpdate.setSecurityCode(paymentDetailsForm.getSecurityCode());
        itemtoUpdate.setExpirationDate(paymentDetailsForm.getExpirationDate());

        service.update(itemtoUpdate);

        return "redirect:/ui/v1/paymentDetails/";
    }
}
