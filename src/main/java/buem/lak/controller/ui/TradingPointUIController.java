package buem.lak.controller.ui;

import buem.lak.model.TradingPoint;
import buem.lak.service.impls.TradingPointServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/ui/v1/tradingPoints/")
@Controller
public class TradingPointUIController {
    @Autowired
    TradingPointServiceImpl service;

    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("tradingPoints",service.getAll());
        return "tradingPoints";
    }


    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        return  "redirect:/ui/v1/tradingPoints/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addItem(Model model){
        TradingPoint tradingPoint = new TradingPoint();
        model.addAttribute("form", tradingPoint);
        return "addTradingPoint";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("form") TradingPoint tradingPointForm){
        TradingPoint tradingPoint = new TradingPoint();
        tradingPoint.setName(tradingPointForm.getName());
        tradingPoint.setDescription(tradingPointForm.getDescription());
        service.create(tradingPoint);
        return "redirect:/ui/v1/tradingPoints/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateItem(Model model, @PathVariable("id") String id){
        TradingPoint tradingPointToUpdate = service.get(id);
        TradingPoint tradingPointForm = new TradingPoint();
        tradingPointForm.setId(tradingPointToUpdate.getId());
        tradingPointForm.setName(tradingPointToUpdate.getName());
        tradingPointForm.setDescription(tradingPointToUpdate.getDescription());
        tradingPointForm.setUpdatedAt(tradingPointToUpdate.getUpdatedAt());
        tradingPointForm.setCreatedAt(tradingPointToUpdate.getCreatedAt());
        model.addAttribute("form", tradingPointForm);
        return "updateTradingPoint";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateItem( @ModelAttribute("form") TradingPoint tradingPointForm){
        TradingPoint tradingPointUpdate = new TradingPoint();
        tradingPointUpdate.setId(tradingPointForm.getId());
        tradingPointUpdate.setName(tradingPointForm.getName());
        tradingPointUpdate.setDescription(tradingPointForm.getDescription());
        tradingPointUpdate.setCreatedAt(LocalDateTime.now());
        tradingPointUpdate.setUpdatedAt(LocalDateTime.now());

        service.update(tradingPointUpdate);

        return "redirect:/ui/v1/tradingPoints/";
    }
}
