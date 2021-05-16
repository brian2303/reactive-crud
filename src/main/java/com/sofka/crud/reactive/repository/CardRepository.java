package com.sofka.crud.reactive.repository;

import com.sofka.crud.reactive.model.Card;
import com.sofka.crud.reactive.model.TypeCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CardRepository extends ReactiveMongoRepository<Card,Integer> {
    public Flux<Card> findByType(TypeCard typeCard);
}
