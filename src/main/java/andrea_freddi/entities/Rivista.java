package andrea_freddi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

// creo la classe Rivista che estende Elemento

@Entity
public class Rivista extends Elemento {
    @Column(name = "periodicita")
    @Enumerated(EnumType.STRING)
    private Periodicità periodicità;

    public Rivista() {
    }

    public Rivista(int annoPubblicazione, String codice_ISBN, int numeroPagine, String titolo, Periodicità periodicità) {
        super(annoPubblicazione, codice_ISBN, numeroPagine, titolo);
        this.periodicità = periodicità;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicità=" + periodicità +
                ", annoPubblicazione=" + annoPubblicazione +
                ", codice_ISBN='" + codice_ISBN + '\'' +
                ", id=" + id +
                ", numeroPagine=" + numeroPagine +
                ", titolo='" + titolo + '\'' +
                '}';
    }
}
