package com.kataroyale.app.repositories;

import com.kataroyale.app.documents.Competitor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.stream.Stream;

public interface CompetitorRepository extends MongoRepository<Competitor, String> {

    Stream<Competitor> findAllBy();
}
