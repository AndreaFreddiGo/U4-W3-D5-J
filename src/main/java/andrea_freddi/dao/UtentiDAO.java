package andrea_freddi.dao;

import andrea_freddi.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtentiDAO {
    private final EntityManager entityManager;

    public UtentiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // creo il metodo save che salva un utente nel database
    public void save(Utente utente) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(utente);
            transaction.commit();
            System.out.println("L'utente " + utente.getNome() + " " + utente.getCognome() + "è stato aggiunto con successo al registro della biblioteca!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // creo il metodo findById che cerca un utente nel database in base all'id
    public Utente findById(long id) {
        return entityManager.find(Utente.class, id);
    }
}
