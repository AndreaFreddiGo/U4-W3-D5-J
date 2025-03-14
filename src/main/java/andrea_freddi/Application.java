package andrea_freddi;

import andrea_freddi.dao.ElementiDAO;
import andrea_freddi.dao.PrestitiDAO;
import andrea_freddi.dao.UtentiDAO;
import andrea_freddi.entities.Libro;
import andrea_freddi.entities.Periodicità;
import andrea_freddi.entities.Rivista;
import andrea_freddi.entities.Utente;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D5-J");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker();
        ElementiDAO elementiDAO = new ElementiDAO(em);
        UtentiDAO utentiDAO = new UtentiDAO(em);
        PrestitiDAO prestitiDAO = new PrestitiDAO(em);

        // creo elementi del catalogo e li salvo nel database
        for (int i = 0; i < 10; i++) {
            Libro libro = new Libro(faker.number().numberBetween(1950, 2025), faker.code().isbn10(), faker.number().numberBetween(100, 400), faker.book().title(), faker.book().author(), faker.book().genre());
            elementiDAO.save(libro);
        }

        Rivista rivista1 = new Rivista(faker.number().numberBetween(2015, 2025), faker.code().isbn10(), faker.number().numberBetween(20, 50), faker.book().genre() + " Magazine", Periodicità.MENSILE);
        elementiDAO.save(rivista1);
        Rivista rivista2 = new Rivista(faker.number().numberBetween(2015, 2025), faker.code().isbn10(), faker.number().numberBetween(20, 50), faker.book().genre() + " Magazine", Periodicità.SETTIMANALE);
        elementiDAO.save(rivista2);
        Rivista rivista3 = new Rivista(faker.number().numberBetween(2015, 2025), faker.code().isbn10(), faker.number().numberBetween(20, 50), faker.book().genre() + " Magazine", Periodicità.SEMESTRALE);
        elementiDAO.save(rivista3);
        Rivista rivista4 = new Rivista(faker.number().numberBetween(2015, 2025), faker.code().isbn10(), faker.number().numberBetween(20, 50), faker.book().genre() + " Magazine", Periodicità.MENSILE);
        elementiDAO.save(rivista4);
        Rivista rivista5 = new Rivista(faker.number().numberBetween(2015, 2025), faker.code().isbn10(), faker.number().numberBetween(20, 50), faker.book().genre() + " Magazine", Periodicità.SETTIMANALE);
        elementiDAO.save(rivista5);
        Rivista rivista6 = new Rivista(faker.number().numberBetween(2015, 2025), faker.code().isbn10(), faker.number().numberBetween(20, 50), faker.book().genre() + " Magazine", Periodicità.SEMESTRALE);
        elementiDAO.save(rivista6);

        // creo utenti e li salvo nel database
        for (int i = 0; i < 10; i++) {
            Utente utente = new Utente(faker.name().lastName(), faker.date().birthday(), faker.name().firstName());
            utentiDAO.save(utente);
        }

        // creo prestiti e li salvo nel database


        em.close();
        emf.close();
    }
}
