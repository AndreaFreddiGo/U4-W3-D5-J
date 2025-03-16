package andrea_freddi.dao;

import andrea_freddi.entities.Elemento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

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
        try {
            Elemento elementoTrovato = entityManager.createNamedQuery("findByISBN", Elemento.class).setParameter("isbn", isbn).getSingleResult();
            System.out.println("Elemento con codice ISBN " + isbn + " trovato: " + elementoTrovato.getTitolo());
            return elementoTrovato;
        } catch (Exception e) {
            System.out.println("Elemento con codice ISBN " + isbn + " non trovato.");
            return null;
        }
    }

    // creo il metodo findByISBNAndDelete che cerca un elemento nel database in base all'ISBN con la NamedQuery e lo elimina
    public void findByISBNAndDelete(String isbn) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Elemento elementoTrovato = entityManager.createNamedQuery("findByISBN", Elemento.class).setParameter("isbn", isbn).getSingleResult();
            if (elementoTrovato != null) {
                entityManager.remove(elementoTrovato);
                transaction.commit();
                System.out.println("Elemento " + elementoTrovato.getTitolo() + " correttamente eliminato dal catalogo della biblioteca");
            } else System.out.println("Elemento con codice ISBN " + isbn + " non trovato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // creo il metodo findByAnnoPubblicazione che cerca elementi nel database in base all'anno di pubblicazione con la NamedQuery
    public List<Elemento> findByAnnoPubblicazione(int annoPubblicazione) {
        List<Elemento> elementiTrovati = entityManager.createNamedQuery("findByAnnoPubblicazione", Elemento.class).setParameter("annoPubblicazione", annoPubblicazione).getResultList();
        if (elementiTrovati.isEmpty()) {
            System.out.println("Nessun elemento trovato per l'anno di pubblicazione " + annoPubblicazione);
        } else {
            for (Elemento elemento : elementiTrovati) {
                System.out.println("Elemento trovato per l'anno di pubblicazione " + annoPubblicazione + ": " + elemento.getTitolo());
            }
        }
        return elementiTrovati;
    }

    // creo il metodo findByAutore che cerca elementi nel database in base all'autore con la NamedQuery
    public List<Elemento> findByAutore(String autore) {
        List<Elemento> elementiTrovati = entityManager.createNamedQuery("findByAutore", Elemento.class).setParameter("autore", autore).getResultList();
        if (elementiTrovati.isEmpty()) {
            System.out.println("Nessun elemento trovato per l'autore " + autore);
        } else {
            for (Elemento elemento : elementiTrovati) {
                System.out.println("Elemento trovato per l'autore " + autore + ": " + elemento.getTitolo());
            }
        }
        return elementiTrovati;
    }

    // creo il metodo findByTitolo che cerca elementi nel database in base al titolo (o parte di esso) con la NamedQuery
    public List<Elemento> findByTitolo(String titolo) {
        List<Elemento> elementiTrovati = entityManager.createNamedQuery("findByTitolo", Elemento.class).setParameter("titolo", "%" + titolo + "%").getResultList();
        if (elementiTrovati.isEmpty()) {
            System.out.println("Nessun elemento trovato con il titolo " + titolo);
        } else {
            for (Elemento elemento : elementiTrovati) {
                System.out.println("Elemento trovato con il titolo " + titolo + ": " + elemento.getTitolo());
            }
        }
        return elementiTrovati;
    }

    // creo il metodo findBorrowedElementsByUser che cerca elementi prestati in base al numero di tessera dell'utente con la NamedQuery
    public List<Elemento> findBorrowedElemetsByUser(long numero_tessera) {
        List<Elemento> elementiTrovati = entityManager.createNamedQuery("findBorrowedElementsByUser", Elemento.class).setParameter("numero_tessera", numero_tessera).getResultList();
        if (elementiTrovati.isEmpty()) {
            System.out.println("Nessun elemento attualmente in prestito all'utente con numero di tessera " + numero_tessera);
        } else {
            for (Elemento elemento : elementiTrovati) {
                System.out.println("Elemento attualmente in prestito all'utente con numero di tessera " + numero_tessera + ": " + elemento.getTitolo());
            }
        }
        return elementiTrovati;
    }
}
