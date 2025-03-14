package andrea_freddi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D5-J");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        
        em.close();
        emf.close();
    }
}
