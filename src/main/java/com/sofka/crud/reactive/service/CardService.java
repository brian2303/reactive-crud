package com.sofka.crud.reactive.service;

import com.sofka.crud.reactive.model.Card;
import com.sofka.crud.reactive.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CardService {

    private CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository repository) {
        cardRepository = repository;
    }


    public Flux<Card> findAll(){
        return cardRepository.findAll();
    }

}