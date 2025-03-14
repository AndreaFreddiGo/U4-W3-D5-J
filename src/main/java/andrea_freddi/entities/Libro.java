package andrea_freddi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

// creo la classe Libro che estende Elemento

@Entity
public class Libro extends Elemento {
    @Column(name = "autore")
    private String autore;
    @Column(name = "genere")
    private String genere;

    public Libro() {
    }

    public Libro(int annoPubblicazione, String codice_ISBN, int numeroPagine, String titolo, String autore, String genere) {
        super(annoPubblicazione, codice_ISBN, numeroPagine, titolo);
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
                ", titolo='" + titolo + '\'' +
                ", numeroPagine=" + numeroPagine +
                ", id=" + id +
                ", codice_ISBN='" + codice_ISBN + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                '}';
    }
}
