package com.kataroyale.app.services;

import com.kataroyale.app.documents.Competitor;
import com.kataroyale.app.models.dtos.CompetitorDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Mono;

@Service
public class CodeWarsService {
    private final WebClient webClient;
    private final String API_BASE_URL = "https://www.codewars.com/api/v1/";

    public CodeWarsService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(API_BASE_URL).build();
    }

    public Competitor getCodeWarsUser(String username) throws WebClientException {
        CompetitorDTO competitorUserDetails = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/users/{user}")
                        .build(username))
                .retrieve()
                .bodyToMono(CompetitorDTO.class)
                .block();

        Competitor returnCompetitor = new Competitor(competitorUserDetails.getUsername(),
                false,
                0,
                0,
                0,
                competitorUserDetails.getHonor());

        return returnCompetitor;
    }

    public Competitor getCodeWarsUser(Competitor competitor) {
        Competitor codeWarsCompetitor = getCodeWarsUser(competitor.getUserName());

        competitor.setTotalHonor(codeWarsCompetitor.getTotalHonor());

        return competitor;
    }

}
