package com.kataroyale.app.services;

import com.kataroyale.app.documents.Timer;
import com.kataroyale.app.repositories.TimerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TimerService {

    private final Logger logger = LoggerFactory.getLogger(TimerService.class);
    private final TimerRepository timerRepository;

    @Autowired
    public TimerService(TimerRepository timerRepository) {
        this.timerRepository = timerRepository;
    }

    public boolean getNeedsDone(String timerName){
        logger.info("Checking timer : {}",timerName);
        Timer timerToCheck = timerRepository.findById(timerName).orElseThrow();
        return timerToCheck.getTimeDone().plusMinutes(timerToCheck.getTimeBetweenInMinutes()).isBefore(LocalDateTime.now());
    }

    public void resetTimer(String timerName){
        logger.info("Resetting timer : {}", timerName);
        Timer timerToReset = timerRepository.findById(timerName).orElseThrow();
        timerToReset.setTimeDone(LocalDateTime.now());
        timerRepository.save(timerToReset);
    }
}
