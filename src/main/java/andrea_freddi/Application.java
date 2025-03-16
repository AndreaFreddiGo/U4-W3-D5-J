package andrea_freddi;

import andrea_freddi.dao.ElementiDAO;
import andrea_freddi.dao.PrestitiDAO;
import andrea_freddi.dao.UtentiDAO;
import andrea_freddi.entities.*;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D5-J");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker();
        ElementiDAO elementiDAO = new ElementiDAO(em);
        UtentiDAO utentiDAO = new UtentiDAO(em);
        PrestitiDAO prestitiDAO = new PrestitiDAO(em);
        Random random = new Random();

        // creo elementi del catalogo e li salvo nel database
        for (int i = 0; i < 10; i++) {
            Libro libro = new Libro(random.nextInt(1950, 2025), faker.code().isbn10(), random.nextInt(100, 400), faker.book().title(), faker.book().author(), faker.book().genre());
//            elementiDAO.save(libro);
        }

        Rivista rivista1 = new Rivista(random.nextInt(2015, 2025), faker.code().isbn10(), random.nextInt(20, 50), faker.book().genre() + " Magazine", Periodicità.MENSILE);
        Rivista rivista2 = new Rivista(random.nextInt(2015, 2025), faker.code().isbn10(), random.nextInt(20, 50), faker.book().genre() + " Magazine", Periodicità.SETTIMANALE);
        Rivista rivista3 = new Rivista(random.nextInt(2015, 2025), faker.code().isbn10(), random.nextInt(20, 50), faker.book().genre() + " Magazine", Periodicità.SEMESTRALE);
        Rivista rivista4 = new Rivista(random.nextInt(2015, 2025), faker.code().isbn10(), random.nextInt(20, 50), faker.book().genre() + " Magazine", Periodicità.MENSILE);
        Rivista rivista5 = new Rivista(random.nextInt(2015, 2025), faker.code().isbn10(), random.nextInt(20, 50), faker.book().genre() + " Magazine", Periodicità.SETTIMANALE);
        Rivista rivista6 = new Rivista(random.nextInt(2015, 2025), faker.code().isbn10(), random.nextInt(20, 50), faker.book().genre() + " Magazine", Periodicità.SEMESTRALE);

//        elementiDAO.save(rivista1);
//        elementiDAO.save(rivista2);
//        elementiDAO.save(rivista3);
//        elementiDAO.save(rivista4);
//        elementiDAO.save(rivista5);
//        elementiDAO.save(rivista6);

        // creo utenti e li salvo nel database
        for (int i = 0; i < 10; i++) {
            Utente utente = new Utente(faker.name().lastName(), faker.date().birthday(), faker.name().firstName());
//            utentiDAO.save(utente);
        }


        // prima genero 10 numeri causali unici fra 1 e 16 per definire gli elementi da prendere in prestito
        List<Integer> numeri = new ArrayList<>();
        for (int i = 1; i <= 16; i++) {
            numeri.add(i);
        }
        Collections.shuffle(numeri);
        List<Integer> estratti = numeri.subList(0, 10);
        // creo prestiti e li salvo nel database
        for (int i = 0; i < estratti.size(); i++) {
            Elemento elementoTrovato = elementiDAO.findById(estratti.get(i));
            Utente utenteTrovato = utentiDAO.findById(random.nextInt(1, 11));
            LocalDate dataInizioPrestito = LocalDate.of(2025, random.nextInt(1, 4), random.nextInt(1, 29));
            LocalDate dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
            // siccome genero le restituzioni con un delta randomico rispetto alla data di inizio prestito, ho fatto in modo che se la data di restituzione effettiva è futura, la setto a null
            LocalDate dataRestituzioneEffettiva = dataInizioPrestito.plusDays(random.nextInt(10, 50));
            if (dataRestituzioneEffettiva.isAfter(LocalDate.now())) {
                dataRestituzioneEffettiva = null;
            }
            Prestito prestito = new Prestito(dataInizioPrestito, dataRestituzioneEffettiva, dataRestituzionePrevista, elementoTrovato, utenteTrovato);
//            prestitiDAO.save(prestito);
        }

        // provo a cercare un elemento nel database in base all'ISBN
        elementiDAO.findByISBN("0968639380");
        elementiDAO.findByISBN("0968639381");

        // provo a cercare elementi nel database in base all'anno di pubblicazione
        elementiDAO.findByAnnoPubblicazione(2025);
        elementiDAO.findByAnnoPubblicazione(2008);

        // provo a cercare un elemento nel database in base all'autore
        elementiDAO.findByAutore("J.R.R. Tolkien");
        elementiDAO.findByAutore("Ryan Rempel");

        // provo a cercare un elemento nel database in base al titolo
        elementiDAO.findByTitolo("The");
        elementiDAO.findByTitolo("or");

        // provo a cercare elementi prestati in base al numero di tessera dell'utente
        elementiDAO.findBorrowedElemetsByUser(1);
        elementiDAO.findBorrowedElemetsByUser(3);

        // provo a cercare prestiti scaduti ma non ancora restituiti
        prestitiDAO.findStillActivePastLoans();

        em.close();
        emf.close();
    }
}
