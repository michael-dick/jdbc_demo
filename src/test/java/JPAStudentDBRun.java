import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by MichaelDick on 28/10/15.
 */
public class JPAStudentDBRun {

    //Create EntityManagerFactory
    public static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("jpaStudentDB");

    //Create EntityManager
    public static EntityManager em = emf.createEntityManager();

    public static void main(String[] args){


    }

}
