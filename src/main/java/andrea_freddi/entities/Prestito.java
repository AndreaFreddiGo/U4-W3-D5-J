package andrea_freddi.entities;

import javax.persistence.*;
import java.time.LocalDate;

// creo la classe Prestito

@Entity
// rinomino la tabella in prestiti
@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prestito_id", nullable = false)
    private Long id;
    @Column(name = "data_inizio_prestito", nullable = false)
    private LocalDate dataInizioPrestito;
    @Column(name = "data_restituzione_prevista", nullable = false)
    private LocalDate dataRestituzionePrevista;
    @Column(name = "data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    // creo la relazione molti a uno con la tabella utenti (bidirezionale)
    @ManyToOne
    @JoinColumn(name = "numero_tessera")
    private Utente utente;

    // creo la relazione molti a uno con la tabella elementi_biblioteca (bidirezionale)
    @ManyToOne
    @JoinColumn(name = "codice_ISBN")
    private Elemento elemento;

    public Prestito() {
    }

    public Prestito(LocalDate dataInizioPrestito, LocalDate dataRestituzioneEffettiva, LocalDate dataRestituzionePrevista, Elemento elemento, Utente utente) {
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.elemento = elemento;
        this.utente = utente;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public Long getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "dataInizioPrestito=" + dataInizioPrestito +
                ", id=" + id +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                ", utente=" + utente +
                ", elemento=" + elemento +
                '}';
    }
}
