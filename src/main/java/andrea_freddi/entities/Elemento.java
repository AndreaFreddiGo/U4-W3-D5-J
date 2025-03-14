package andrea_freddi.entities;

import javax.persistence.*;
import java.util.List;

// creo la classe astratta Elemento padre di Libro e Rivista

@Entity
// rinomino la tabella in elementi_biblioteca
@Table(name = "elementi_biblioteca")
// definisco la strategia di ereditarietà SINGLE_TABLE
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// definisco la colonna discriminatoria
@DiscriminatorColumn(name = "tipo_elemento")

@NamedQuery(name = "findByISBN", query = "SELECT e FROM Elemento e WHERE e.codice_ISBN = :isbn")
@NamedQuery(name = "findByAnnoPubblicazione", query = "SELECT e FROM Elemento e WHERE e.annoPubblicazione = :annoPubblicazione")
@NamedQuery(name = "findByAutore", query = "SELECT e FROM Elemento e WHERE e.autore = :autore")
@NamedQuery(name = "findByTitolo", query = "SELECT e FROM Elemento e WHERE e.titolo LIKE :titolo")
public abstract class Elemento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "elemento_id", nullable = false)
    protected long id;
    @Column(name = "codice_ISBN", nullable = false)
    protected String codice_ISBN;
    @Column(name = "titolo", nullable = false)
    protected String titolo;
    @Column(name = "anno_pubblicazione", nullable = false)
    protected int annoPubblicazione;
    @Column(name = "numero_pagine")
    protected int numeroPagine;

    // creo la relazione uno a molti con la tabella prestiti (bidirezionale)
    @OneToMany(mappedBy = "elemento")
    protected List<Prestito> listaPrestiti;

    public Elemento() {
    }

    public Elemento(int annoPubblicazione, String codice_ISBN, int numeroPagine, String titolo) {
        this.annoPubblicazione = annoPubblicazione;
        this.codice_ISBN = codice_ISBN;
        this.numeroPagine = numeroPagine;
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getCodice_ISBN() {
        return codice_ISBN;
    }

    public void setCodice_ISBN(String codice_ISBN) {
        this.codice_ISBN = codice_ISBN;
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
                ", codice_ISBN='" + codice_ISBN + '\'' +
                ", id=" + id +
                ", numeroPagine=" + numeroPagine +
                ", titolo='" + titolo + '\'' +
                '}';
    }
}
