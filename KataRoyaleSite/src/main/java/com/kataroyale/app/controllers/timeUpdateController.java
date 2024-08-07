package com.kataroyale.app.controllers;

import com.kataroyale.app.services.RoyaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class timeUpdateController {

    private final RoyaleService service;
    private final Logger logger = LoggerFactory.getLogger(timeUpdateController.class);

    @Autowired
    public timeUpdateController(RoyaleService service) {
        this.service = service;
    }

    //second - minute - hour - day of month - month - day of week

    //every five minutes every monday to friday
    @Scheduled(cron = "0 */5 * * * MON-FRI")
    public void timedUpdate() {
        logger.info("performing timed update");
        service.updateCompetitors();
    }

    //midnight every monday to thursday
    @Scheduled(cron = "0 0 0 * * MON-THU")
    public void dailyCut() {
        logger.info("performing daily cut");
        service.cutFifthOfCompetitors();
    }

    //midnight every friday
    @Scheduled(cron = "0 0 0 * * FRI")
    public void determineWinner() {
        logger.info("performing determine winner");
        service.pickWinner();
    }

    //midnight every sunday
    @Scheduled(cron = "0 0 0 * * SUN")
    public void resetCompetitors() {
        logger.info("performing reset competitors");
        service.resetCompetitors();
    }
}
