package andrea_freddi.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

// creo la classe Utente

@Entity
// rinomino la tabella in utenti
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_tessera", nullable = false)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cognome", nullable = false)
    private String cognome;
    @Column(name = "data_di_nascita", nullable = false)
    private Date dataDiNascita;

    // creo la relazione uno a molti con la tabella prestiti (bidirezionale)
    @OneToMany(mappedBy = "utente")
    private List<Prestito> listaPrestiti;

    public Utente() {
    }

    public Utente(String cognome, Date dataDiNascita, String nome) {
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "cognome='" + cognome + '\'' +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                '}';
    }
}
