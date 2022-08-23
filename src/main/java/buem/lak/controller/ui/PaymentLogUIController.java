package buem.lak.controller.ui;

import buem.lak.model.PaymentLog;
import buem.lak.service.impls.PaymentLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/ui/v1/paymentLogs/")
@Controller
public class PaymentLogUIController {
    @Autowired
    PaymentLogServiceImpl service;

    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("paymentLogs",service.getAll());
        return "paymentLogs";
    }


    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        return  "redirect:/ui/v1/paymentLogs/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addItem(Model model){
        PaymentLog paymentLog = new PaymentLog();
        model.addAttribute("form", paymentLog);
        return "addPaymentLog";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("form") PaymentLog paymentLogForm){
        PaymentLog paymentLog = new PaymentLog();
        paymentLog.setName(paymentLogForm.getName());
        paymentLog.setDescription(paymentLogForm.getDescription());
        service.create(paymentLog);
        return "redirect:/ui/v1/paymentLogs/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateItem(Model model, @PathVariable("id") String id){
        PaymentLog paymentLogToUpdate = service.get(id);
        PaymentLog paymentLogForm = new PaymentLog();
        paymentLogForm.setId(paymentLogToUpdate.getId());
        paymentLogForm.setName(paymentLogToUpdate.getName());
        paymentLogForm.setDescription(paymentLogToUpdate.getDescription());
        paymentLogForm.setUpdatedAt(paymentLogToUpdate.getUpdatedAt());
        paymentLogForm.setCreatedAt(paymentLogToUpdate.getCreatedAt());
        model.addAttribute("form", paymentLogForm);
        return "updatePaymentLog";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateItem( @ModelAttribute("form") PaymentLog paymentLogForm){
        PaymentLog paymentLogUpdate = new PaymentLog();
        paymentLogUpdate.setId(paymentLogForm.getId());
        paymentLogUpdate.setName(paymentLogForm.getName());
        paymentLogUpdate.setDescription(paymentLogForm.getDescription());
        paymentLogUpdate.setCreatedAt(LocalDateTime.now());
        paymentLogUpdate.setUpdatedAt(LocalDateTime.now());

        service.update(paymentLogUpdate);

        return "redirect:/ui/v1/paymentLogs/";
    }
}
