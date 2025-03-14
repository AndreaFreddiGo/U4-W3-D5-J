package andrea_freddi.dao;

import andrea_freddi.entities.Elemento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ElementiDAO {
    private final EntityManager entityManager;

    public ElementiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // creo il metodo save che salva un elemento nel database
    public void save(Elemento elemento) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(elemento);
            transaction.commit();
            System.out.println("L'elemento " + elemento.getTitolo() + "è stato aggiunto con successo al catalogo della biblioteca!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
