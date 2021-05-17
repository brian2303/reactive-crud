package com.sofka.crud.reactive.controller;

import com.sofka.crud.reactive.model.Card;
import com.sofka.crud.reactive.model.TypeCard;
import com.sofka.crud.reactive.repository.CardRepository;
import com.sofka.crud.reactive.service.CardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = CardController.class)
class CardControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @SpyBean
    private CardService service;

    @Captor
    private ArgumentCaptor<Mono<Card>> argumentCaptor;

    @MockBean
    private CardRepository repository;

    @Test
    void get(){
        var list = Flux.just(
                new Card("031332323","card mc", LocalDate.now(), TypeCard.MASTER_CARD),
                new Card("032435342","card mc", LocalDate.now(), TypeCard.MASTER_CARD)
        );

        Mockito.when(repository.findAll()).thenReturn(list);
        webTestClient.get()
                .uri("/card")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].number").isEqualTo("031332323")
                .jsonPath("$[1].number").isEqualTo("032435342");
        Mockito.verify(service).findAll();
        Mockito.verify(repository).findAll();
    }


}