package com.kataroyale.app.controllers;

import com.kataroyale.app.services.RoyaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
        //biDailyUpdate();
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

    //minute - hour - day of month - month - day of week

    //every ten minutes every monday to friday
    @Scheduled(cron = "*/10 * * * 1-5")
    public void timedUpdate() {
        logger.info("performing timed update");
        service.updateCompetitors();
    }

    //midnight every monday to thursday
    @Scheduled(cron = "0 0 * * 1-4")
    public void dailyCut() {
        logger.info("performing daily cut");
        service.cutFifthOfCompetitors();
    }

    //midnight every friday
    @Scheduled(cron = "0 0 * * 5")
    public void determineWinner() {
        logger.info("performing determine winner");
        service.pickWinner();
    }

    //midnight every sunday
    @Scheduled(cron = "0 0 * * 6")
    public void resetCompetitors() {
        logger.info("performing reset competitors");
        service.resetCompetitors();
    }
}
