package andrea_freddi.entities;

import javax.persistence.*;
import java.time.LocalDate;

// creo la classe astratta Elemento padre di Libro e Rivista

@Entity
// rinomino la tabella in elementi_biblioteca
@Table(name = "elementi_biblioteca")
// definisco la strategia di ereditarietà SINGLE_TABLE
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// definisco la colonna discriminatoria
@DiscriminatorColumn(name = "tipo_elemento")
public abstract class Elemento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codice_ISBN", nullable = false)
    protected long id;
    @Column(name = "titolo", nullable = false)
    protected String titolo;
    @Column(name = "anno_pubblicazione", nullable = false)
    protected LocalDate annoPubblicazione;
    @Column(name = "numero_pagine")
    protected int numeroPagine;

    // creo la relazione uno a molti con la tabella prestiti (bidirezionale)
    @OneToMany(mappedBy = "elemento")
    protected Prestito prestito;

    public Elemento() {
    }

    public Elemento(String titolo, LocalDate annoPubblicazione, int numeroPagine) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public long getId() {
        return id;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return "Elemento{" +
                "annoPubblicazione=" + annoPubblicazione +
                ", id=" + id +
                ", titolo='" + titolo + '\'' +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
