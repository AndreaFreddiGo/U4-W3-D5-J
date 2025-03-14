package andrea_freddi.entities;

import java.time.LocalDate;

// creo la classe Rivista che estende Elemento

public class Rivista extends Elemento {
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
