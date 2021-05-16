package com.sofka.crud.reactive.controller;

import com.sofka.crud.reactive.model.Card;
import com.sofka.crud.reactive.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public Mono<Card> save(@RequestBody Mono<Card> cardMono){
        return cardService.save(cardMono).onErrorStop();
    }

    @PostMapping
    public Mono<Card> update(@RequestBody Mono<Card> cardMono){
        return cardService.save(cardMono).onErrorStop();
    }

}
