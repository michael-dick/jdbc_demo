import org.junit.Test;
import prog3.student.StudentDBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MichaelDick on 28/10/15.
 */
public class StudentDBRun {


    @Test
    public void testSearchMichael() throws Exception {


        StudentDBConnection connection = new StudentDBConnection();

        //Search Michael
        try {
            ResultSet resultSet = connection.search(1641518);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("matnr"));
                System.out.println(resultSet.getString("firstname"));
                System.out.println(resultSet.getString("lastname"));
                System.out.println(resultSet.getString("email"));

            }
        } catch (SQLException e) {

            System.out.println("Could not find Michael");
            e.printStackTrace();
        }

    }
}
