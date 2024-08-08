package com.kataroyale.app.repositories;

import com.kataroyale.app.documents.Timer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface TimerRepository extends MongoRepository<Timer, String>{
    Stream<Timer> findAllBy();
}
