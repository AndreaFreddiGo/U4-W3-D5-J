package andrea_freddi.entities;

import java.time.LocalDate;

// creo la classe astratta Elemento padre di Libro e Rivista

public abstract class Elemento {
    protected long id;
    protected String titolo;
    protected LocalDate annoPubblicazione;
    protected int numeroPagine;

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
