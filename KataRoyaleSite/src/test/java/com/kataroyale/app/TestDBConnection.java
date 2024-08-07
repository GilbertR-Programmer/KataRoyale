package com.kataroyale.app;

import com.kataroyale.app.documents.Competitor;
import com.kataroyale.app.repositories.CompetitorRepository;
import com.kataroyale.app.services.RoyaleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@SpringBootTest
public class TestDBConnection {

    @Autowired
    CompetitorRepository competitorRepository;

    @Autowired
    RoyaleService service;

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
        service.resetCompetitors();
    }

    @Test
    @Disabled
    public void forceCut(){
        service.cutFifthOfCompetitors();
    }
}
