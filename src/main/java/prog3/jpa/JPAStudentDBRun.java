package prog3.jpa;

import prog3.jpa.KITCard;
import prog3.jpa.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by MichaelDick on 28/10/15.
 */
public class JPAStudentDBRun {

    //Create EntityManagerFactory
    public static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("jpastudentdb");

    //Create EntityManager
    public static EntityManager em = emf.createEntityManager();

    public static void main(String[] args){

        //Create Student
        Student michi = new Student(1641518 , "Michael" , "Dick" , "ukdyn@student.kit.edu");

        //Create KIT Card
        KITCard michisCard = new KITCard(0 , michi);

        michi.setKitCard(michisCard);


        try {
            em.getTransaction().begin();
            em.persist(michi);
            em.getTransaction().commit();
        }finally {
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
        }

    }

}
