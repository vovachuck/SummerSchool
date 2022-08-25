package buem.lak.controller.ui;

import buem.lak.model.Client;
import buem.lak.service.impls.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/ui/v1/clients/")
@Controller
public class ClientUIController {
    @Autowired
    ClientServiceImpl service;

    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("clients",service.getAll());
        return "clients";
    }


    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        return  "redirect:/ui/v1/clients/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addItem(Model model){
        Client client = new Client();
        model.addAttribute("form", client);
        return "addClient";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("form") Client clientForm){
        clientForm.setCreatedAt(LocalDateTime.now());
        clientForm.setUpdatedAt(LocalDateTime.now());
        service.create(clientForm);
        return "redirect:/ui/v1/clients/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateItem(Model model, @PathVariable("id") String id){
        Client clientToUpdate = service.get(id);
        Client clientForm = new Client();
        clientForm.setId(clientToUpdate.getId());
        clientForm.setName(clientToUpdate.getName());
        clientForm.setDescription(clientToUpdate.getDescription());
        clientForm.setUpdatedAt(clientToUpdate.getUpdatedAt());
        clientForm.setCreatedAt(clientToUpdate.getCreatedAt());
        model.addAttribute("form", clientForm);
        return "updateClient";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateItem( @ModelAttribute("form") Client clientForm){
        Client clientUpdate = new Client();
        clientUpdate.setId(clientForm.getId());
        clientUpdate.setName(clientForm.getName());
        clientUpdate.setDescription(clientForm.getDescription());
        clientUpdate.setCreatedAt(LocalDateTime.now());
        clientUpdate.setUpdatedAt(LocalDateTime.now());

        service.update(clientUpdate);

        return "redirect:/ui/v1/clients/";
    }
}
