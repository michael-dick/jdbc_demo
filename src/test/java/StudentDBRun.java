import org.junit.Test;
import prog3.student.Student;
import prog3.student.StudentDBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MichaelDick on 28/10/15.
 */
public class StudentDBRun {
    StudentDBConnection connection;

    @Test
    public void testSearchMichael() throws Exception {

        connection = new StudentDBConnection();
        connection.connect("student");

        //Search Michael
        try {

            ResultSet resultSet = connection.search(1641518);
            while (resultSet.next()) {          //iterate thorugh all DB-entries in the result set (should be only one since matnr is identifier!)
                System.out.println(resultSet.getInt("matnr"));
                System.out.println(resultSet.getString("firstname"));
                System.out.println(resultSet.getString("lastname"));
                System.out.println(resultSet.getString("email"));

            }
        } catch (SQLException e) {

            System.out.println("Could not find Michael");
            e.printStackTrace();
        }

        connection.disconnect();

    }

    @Test
    public void testPost() throws Exception {
        connection = new StudentDBConnection();

        Student student = new Student(87654321, "Student", "Student", "student@kit.edu");

        connection.post(student);
    }

    @Test
    public void testUpdate() throws Exception {
        connection = new StudentDBConnection();

        connection.update(87654321 , new Student("Ratzi" , "Student" , "ratzi@kit.edu"));
    }
}
