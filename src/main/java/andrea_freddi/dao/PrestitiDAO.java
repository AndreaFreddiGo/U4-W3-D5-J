package andrea_freddi.dao;

import andrea_freddi.entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
}
