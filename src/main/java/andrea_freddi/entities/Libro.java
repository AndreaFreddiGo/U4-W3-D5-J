package andrea_freddi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

// creo la classe Libro che estende Elemento

@Entity
public class Libro extends Elemento {
    @Column(name = "autore")
    private String autore;
    @Column(name = "genere")
    private String genere;

    public Libro() {
    }

    public Libro(String titolo, LocalDate annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", id=" + id +
                ", numeroPagine=" + numeroPagine +
                ", titolo='" + titolo + '\'' +
                '}';
    }
}
