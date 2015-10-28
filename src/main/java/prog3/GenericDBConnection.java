package prog3;

import java.sql.*;

/**
 * Created by MichaelDick on 28/10/15.
 */

public abstract class GenericDBConnection<KEY , TYPE> {

    public Connection connection;

    public Statement mStatement;

    public PreparedStatement mPreparedStatement;

    public void connect(String dbName){
        //load jdbc driver
//        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            System.out.println("driver loaded");
//        } catch (Exception ex) {
//            System.out.println("Driver: " + ex.getMessage());
//            System.out.println("Error: " + ex.toString());
//        }

        //Connection
        try {
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost/" + dbName, "root", "");

            mStatement = connection.createStatement();

            System.out.println("connection established");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("Error: " + ex.getErrorCode());
        }
    }

    public void disconnect(){
        try {
            //mStatement.close();
            connection.close();
            System.out.println("disconnected");
        } catch (SQLException err) {
            System.err.println(err);
        }
    }

    public abstract void post(TYPE entity);

    public abstract void update (KEY identifier , TYPE update);

    public abstract void delete(KEY identifier);

    public abstract ResultSet search(KEY identifier) throws Exception;
}
