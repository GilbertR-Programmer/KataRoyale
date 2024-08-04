package com.kataroyale.app.services;

import com.kataroyale.app.documents.Competitor;
import com.kataroyale.app.repositories.CompetitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.stream.Stream;

@Service
public class RoyaleService {

    private final CompetitorRepository competitorRepository;
    private final CodeWarsService codeWarsService;

    @Autowired
    public RoyaleService(CompetitorRepository competitorRepository, CodeWarsService codeWarsService) {
        this.codeWarsService = codeWarsService;
        this.competitorRepository = competitorRepository;
    }
    public Stream<Competitor> getCompetitors() {
        return competitorRepository.findAllBy()
                .sorted(Comparator.comparingInt(Competitor::getHonorInBattle).reversed());
    }

    public void addCompetitor(String competitorUserName) {
        Competitor competitor = codeWarsService.getCodeWarsUser(competitorUserName);
        competitor.setHonorOnLastReset(competitor.getTotalHonor());
        competitorRepository.save(competitor);
    }
}
