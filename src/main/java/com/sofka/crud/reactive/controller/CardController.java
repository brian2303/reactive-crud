package com.sofka.crud.reactive.controller;

import com.sofka.crud.reactive.model.Card;
import com.sofka.crud.reactive.model.TypeCard;
import com.sofka.crud.reactive.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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

    @PutMapping
    public Mono<Card> update(@RequestBody Mono<Card> cardMono){
        return cardService.save(cardMono).onErrorStop();
    }

    @GetMapping("/{type}")
    public Flux<Card> findByType(@PathVariable("type") TypeCard type){
        return  cardService.findByType(type);
    }

}
