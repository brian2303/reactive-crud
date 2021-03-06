package com.sofka.crud.reactive.service;

import com.sofka.crud.reactive.model.Card;
import com.sofka.crud.reactive.model.TypeCard;
import com.sofka.crud.reactive.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

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

    public Mono<Card> save(Mono<Card> cardMono){
        return cardMono
                .filter(Card::isValid)
                .flatMap(cardRepository::save);
    }

    public Flux<Card> findByType(TypeCard typeCard){
        return cardRepository.findByType(typeCard);
    }

    public Mono<Void> delete(String id){
        return cardRepository.deleteById(id).then();
    }

}
