package pl.madison.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class Pracownik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String imie;
    private String nazwisko;

    @OneToOne(fetch = FetchType.EAGER)
    private Wynagrodzenie wynagrodzenie;
}
