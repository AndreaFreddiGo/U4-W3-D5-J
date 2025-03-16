package andrea_freddi.dao;

import andrea_freddi.entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class PrestitiDAO {
    private final EntityManager entityManager;

    public PrestitiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // creo il metodo save che salva un prestito nel database
    public void save(Prestito prestito) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(prestito);
            transaction.commit();
            System.out.println("Il prestito di " + prestito.getElemento().getTitolo() + " all'utente " + prestito.getUtente().getNome() + prestito.getUtente().getCognome() + " è stato salvato con successo!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // creo il metodo findById che cerca un prestito nel database in base all'id
    public Prestito findById(long id) {
        return entityManager.find(Prestito.class, id);
    }

    // creo il metodo findStillActivePastLoans che cerca i prestiti scaduti e non ancora restituiti
    public List<Prestito> findStillActivePastLoans() {
        List<Prestito> prestitiTrovati = entityManager.createNamedQuery("findStillActivePastLoans", Prestito.class).getResultList();
        if (prestitiTrovati.isEmpty()) {
            System.out.println("Non ci sono prestiti scaduti e non ancora restituiti.");
        } else {
            System.out.println("Prestiti scaduti e non ancora restituiti:");
            for (Prestito prestito : prestitiTrovati) {
                System.out.println(prestito.getElemento().getTitolo() + " dato in prestito all'utente " + prestito.getUtente().getNome() + " " + prestito.getUtente().getCognome() + " e scaduto il " + prestito.getDataRestituzionePrevista());
            }
        }
        return prestitiTrovati;
    }
}
