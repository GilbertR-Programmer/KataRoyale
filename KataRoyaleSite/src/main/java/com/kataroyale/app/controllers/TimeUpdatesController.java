package com.kataroyale.app.controllers;

import com.kataroyale.app.models.enums.Task;
import com.kataroyale.app.services.RoyaleService;
import com.kataroyale.app.services.TimerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimeUpdatesController {

    private final RoyaleService royaleService;
    private final TimerService timerService;
    private final Logger logger = LoggerFactory.getLogger(TimeUpdatesController.class);

    @Autowired
    public TimeUpdatesController(RoyaleService service, TimerService timerService) {
        this.royaleService = service;
        this.timerService = timerService;
    }

    @GetMapping("/super/secret/force/update")
    public String updateRoyale() {
        logger.info("Using Super Secret Force Update");
        timedUpdateWeekends();
        timedUpdateWeekdays();
        return "redirect:/";
    }


    //second - minute - hour - day of month - month - day of week

    //every five minutes every monday to friday
    @Scheduled(cron = "0 */5 * * * MON-FRI")
    public void timedUpdateWeekdays() {
        logger.info("performing timed update weekdays");
        royaleService.updateCompetitors();
        logger.info("checking if it is time to cut");
        if(timerService.getNeedsDone(Task.CUT_LOSERS.getTaskName())){
            dailyCut();
            timerService.resetTimer(Task.CUT_LOSERS.getTaskName());
        }

    }

    //every five minutes every saturday to sunday
    @Scheduled(cron = "0 */5 * * * SAT-SUN")
    public void timedUpdateWeekends() {
        logger.info("performing timed update for weekends");
        royaleService.updateCompetitors();
        logger.info("checking if it is time to pick winner");
        if(timerService.getNeedsDone(Task.PICK_WINNER.getTaskName())){
            pickWinner();
            timerService.resetTimer(Task.PICK_WINNER.getTaskName());
        }
        logger.info("checking if it is time to reset competitors");
        if(timerService.getNeedsDone(Task.RESET_COMPETITORS.getTaskName())){
            resetCompetitors();
            timerService.resetTimer(Task.RESET_COMPETITORS.getTaskName());
        }
    }

    public void dailyCut() {
        logger.info("performing daily cut");
        royaleService.cutFifthOfCompetitors();
    }

    public void pickWinner() {
        logger.info("performing determine winner");
        royaleService.pickWinner();
    }

    public void resetCompetitors() {
        logger.info("performing reset competitors");
        royaleService.resetCompetitors();
    }
}
