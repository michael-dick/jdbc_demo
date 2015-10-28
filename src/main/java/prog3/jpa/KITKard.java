package prog3.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by MichaelDick on 28/10/15.
 */
@Entity
public class KITKard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private Student student;

}
