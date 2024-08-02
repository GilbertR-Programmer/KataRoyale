package com.kataroyale.app;

import com.kataroyale.app.documents.Competitor;
import com.kataroyale.app.repositories.CompetitorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestDBConnection {

    @Autowired
    CompetitorRepository competitorRepository;

    @Test
    public void addCompetitorTest(){
        Competitor competitor = new Competitor("john2", true, 100, 100, 0);
        competitorRepository.save(competitor);
    }

    @Test
    public void findAllByTest(){
        System.out.println(competitorRepository.findAllBy().toList());
    }
}
