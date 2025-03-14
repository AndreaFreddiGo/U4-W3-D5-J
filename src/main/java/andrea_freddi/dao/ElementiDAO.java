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

    // creo il metodo findById che cerca un elemento nel database in base all'id
    public Elemento findById(long id) {
        return entityManager.find(Elemento.class, id);
    }

    // creo il metodo findByIdAndDelete che cerca un elemento nel database in base all'id e lo elimina
    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Elemento elementoTrovato = entityManager.find(Elemento.class, id);
            if (elementoTrovato != null) {
                entityManager.remove(elementoTrovato);
                transaction.commit();
                System.out.println("Elemento " + elementoTrovato.getTitolo() + " correttamente eliminato dal catalogo della biblioteca");
            } else System.out.println("Elemento non trovato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // creo il metodo findByISBN che cerca un elemento nel database in base all'ISBN con la NamedQuery
    public Elemento findByISBN(String isbn) {
        return entityManager.createNamedQuery("findByISBN", Elemento.class).setParameter("isbn", isbn).getSingleResult();
    }

    // creo il metodo findByISBNAndDelete che cerca un elemento nel database in base al titolo con la NamedQuery e lo elimina
    public void findByISBNAndDelete(String isbn) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Elemento elementoTrovato = entityManager.createNamedQuery("findByISBN", Elemento.class).setParameter("isbn", isbn).getSingleResult();
            if (elementoTrovato != null) {
                entityManager.remove(elementoTrovato);
                transaction.commit();
                System.out.println("Elemento " + elementoTrovato.getTitolo() + " correttamente eliminato dal catalogo della biblioteca");
            } else System.out.println("Elemento non trovato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
