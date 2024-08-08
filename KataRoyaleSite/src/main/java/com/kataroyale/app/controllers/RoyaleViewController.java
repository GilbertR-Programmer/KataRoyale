package com.kataroyale.app.controllers;

import com.kataroyale.app.services.RoyaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoyaleViewController {

    private final RoyaleService service;
    private final Logger logger = LoggerFactory.getLogger(RoyaleViewController.class);


    @Autowired
    public RoyaleViewController(RoyaleService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewRoyale(Model model) {
        logger.info("Viewing Royale");
        model.addAttribute("competitors", service.getCompetitors().toArray());
        return "home";
    }

    @PostMapping("/competitors")
    public String joinBattle(@RequestParam String userName) {
        logger.info("posting user: {}", userName);
        service.addCompetitor(userName);
        return "redirect:/";
    }
}
