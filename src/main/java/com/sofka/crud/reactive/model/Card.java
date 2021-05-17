package com.sofka.crud.reactive.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Optional;

@Document(collection = "cards")
public class Card {

    @Id
    private String number;

    private String title;
    private LocalDate date;
    private TypeCard type;

    public Card(String number, String title, LocalDate date, TypeCard type) {
        this.number = number;
        this.title = title;
        this.date = date;
        this.type = type;
    }

    public boolean isValid(){
        if (this.type.equals(TypeCard.MASTER_CARD)){
            return this.number.startsWith("03");
        }
        if (this.type.equals(TypeCard.VISA)){
            return this.number.startsWith("06");
        }
        return this.number.startsWith("12");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public TypeCard getType() {
        return type;
    }

    public void setType(TypeCard type) {
        this.type = type;
    }
}
