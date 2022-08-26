package buem.lak.controller.ui;

import buem.lak.model.Rent;
import buem.lak.service.impls.RentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/ui/v1/rents/")
@Controller
public class RentUIController {
    @Autowired
    RentServiceImpl service;

    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("rents",service.getAll());
        return "rents";
    }


    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        return  "redirect:/ui/v1/rents/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addItem(Model model){
        Rent rent = new Rent();
        model.addAttribute("form", rent);
        return "addRent";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("form") Rent rentForm){
        rentForm.setCreatedAt(LocalDateTime.now());
        rentForm.setUpdatedAt(LocalDateTime.now());
        service.create(rentForm);
        return "redirect:/ui/v1/rents/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateItem(Model model, @PathVariable("id") String id){
        Rent rentToUpdate = service.get(id);
        Rent rentForm = new Rent();
        rentForm.setId(rentToUpdate.getId());
        rentForm.setName(rentToUpdate.getName());
        rentForm.setDescription(rentToUpdate.getDescription());
        rentForm.setUpdatedAt(rentToUpdate.getUpdatedAt());
        rentForm.setCreatedAt(rentToUpdate.getCreatedAt());
        model.addAttribute("form", rentForm);
        return "updateRent";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateItem( @ModelAttribute("form") Rent rentForm){
        Rent itemForm = service.get(rentForm.getId());
        Rent itemtoUpdate = new Rent();
        itemtoUpdate.setId(rentForm.getId());
        itemtoUpdate.setName(rentForm.getName());
        itemtoUpdate.setDescription(rentForm.getDescription());
        itemtoUpdate.setCreatedAt(itemForm.getCreatedAt());
        itemtoUpdate.setUpdatedAt(LocalDateTime.now());

        itemtoUpdate.setStartDate(rentForm.getStartDate());
        itemtoUpdate.setEndDate(rentForm.getEndDate());

        service.update(itemtoUpdate);

        return "redirect:/ui/v1/rents/";
    }
}
