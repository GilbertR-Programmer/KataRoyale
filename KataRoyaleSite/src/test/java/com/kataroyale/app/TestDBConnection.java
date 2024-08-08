package com.kataroyale.app;

import com.kataroyale.app.documents.Competitor;
import com.kataroyale.app.documents.Timer;
import com.kataroyale.app.models.enums.Task;
import com.kataroyale.app.repositories.CompetitorRepository;
import com.kataroyale.app.repositories.TimerRepository;
import com.kataroyale.app.services.RoyaleService;
import com.kataroyale.app.services.TimerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class TestDBConnection {

    @Autowired
    CompetitorRepository competitorRepository;

    @Autowired
    RoyaleService royaleService;
    @Autowired
    TimerService timerService;
    @Autowired
    TimerRepository timerRepository;

    @Test
    public void addCompetitorTest(){
        long amount = competitorRepository.findAllBy().count();
        Competitor competitor = new Competitor(String.valueOf(Math.random() * Math.random()), true, (int) (Math.random() * 590), (int) (Math.random() * 200), 0,0);
        competitorRepository.save(competitor);

        long newAmount = competitorRepository.findAllBy().count();
        Assertions.assertEquals(amount+1, newAmount);
    }

    @Test
    public void findAllByTest(){
        System.out.println(competitorRepository.findAllBy().toList());
    }

    @Test
    @Disabled
    public void forceReset(){
        royaleService.resetCompetitors();
    }

    @Test
    @Disabled
    public void forceCut(){
        royaleService.cutFifthOfCompetitors();
    }

    @Test
    @Disabled
    public void forceAddTimers(){
        Timer pickWinner =  new Timer(Task.PICK_WINNER.getTaskName(), LocalDateTime.of(2024,8,2,0,0),10080);
        Timer cutLosers =  new Timer(Task.CUT_LOSERS.getTaskName(), LocalDateTime.of(2024,8,7,0,0),1440);
        Timer resetCompetitors =  new Timer(Task.RESET_COMPETITORS.getTaskName(), LocalDateTime.of(2024, 8, 4, 0, 0), 10080);
        timerRepository.save(pickWinner);
        timerRepository.save(cutLosers);
        timerRepository.save(resetCompetitors);
    }

    @Test
    public void findAllTimers(){
        timerRepository.findAllBy().forEach(System.out::println);
    }

    @Test
    public void resetTimer(){
        timerService.resetTimer(Task.CUT_LOSERS.getTaskName());
    }
}
