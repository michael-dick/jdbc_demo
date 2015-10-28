package prog3.student;


import prog3.GenericDBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MichaelDick on 28/10/15.
 */
public class StudentDBConnection extends GenericDBConnection<Integer, Student> {

    @Override
    public void post(Student entity) {
        connect("student");

        try {
            mPreparedStatement = connection.prepareStatement("INSERT INTO student (matnr, firstname, lastname, email) VALUES (?,?,?,?)");
            mPreparedStatement.setInt(1, entity.getMatnr());
            mPreparedStatement.setString(2, entity.getFirstname());
            mPreparedStatement.setString(3, entity.getLastname());
            mPreparedStatement.setString(4, entity.getEmail());

            mPreparedStatement.executeUpdate();
        } catch (SQLException err) {
            System.err.print(err);
        }

        disconnect();
    }

    @Override
    public void update(Integer matnr, Student entity) {
        //MATRIKELNR stays alwas the same, since this attribute is the primary key
        String newFirstName = entity.getFirstname();
        String newLastName = entity.getLastname();
        String newEMail = entity.getEmail();

        connect("student");
        try {
            mPreparedStatement = connection.prepareStatement("UPDATE student SET firstname = ?, lastname = ?, email = ? WHERE matnr = ?");
            mPreparedStatement.setString(1, newFirstName);
            mPreparedStatement.setString(2, newLastName);
            mPreparedStatement.setString(3, newEMail);
            mPreparedStatement.setInt(4, matnr);

            mPreparedStatement.executeUpdate();

        } catch (SQLException err) {
            System.err.print(err);
        }

        disconnect();
    }

    @Override
    public void delete(Integer matnr) {
        connect("student");

        try {
            mPreparedStatement = connection.prepareStatement("DELETE FROM student WHERE matnr = ?");
            mPreparedStatement.setInt(1, matnr);

            mPreparedStatement.executeUpdate();

        } catch (SQLException err) {
            System.err.print(err);
        }

        disconnect();
    }

    @Override
    public ResultSet search(Integer matnr) throws SQLException {

        ResultSet rs;

        connect("student");

            rs = mStatement.executeQuery("SELECT * FROM student WHERE matnr = '" + matnr + "';");

        disconnect();

        return rs;
    }

}
