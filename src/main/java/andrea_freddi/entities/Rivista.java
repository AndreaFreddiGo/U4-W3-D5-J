package andrea_freddi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

// creo la classe Rivista che estende Elemento

@Entity
public class Rivista extends Elemento {
    @Column(name = "periodicita")
    @Enumerated(EnumType.STRING)
    private Periodicità periodicità;

    public Rivista() {
    }

    public Rivista(String titolo, LocalDate annoPubblicazione, int numeroPagine, Periodicità periodicità) {
        super(titolo, annoPubblicazione, numeroPagine);
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
                ", id=" + id +
                ", numeroPagine=" + numeroPagine +
                ", titolo='" + titolo + '\'' +
                '}';
    }
}
