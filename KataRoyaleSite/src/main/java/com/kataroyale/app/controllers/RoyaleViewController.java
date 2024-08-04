package com.kataroyale.app.controllers;

import com.kataroyale.app.services.RoyaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoyaleViewController {

    private RoyaleService service;

    @Autowired
    public RoyaleViewController(RoyaleService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewRoyale(Model model) {
        model.addAttribute("competitors", service.getCompetitors().toArray());
        return "home";
    }

    @PostMapping("/competitors")
    public String joinBattle(@RequestParam String userName) {
        service.addCompetitor(userName);
        return "redirect:/";
    }
}
