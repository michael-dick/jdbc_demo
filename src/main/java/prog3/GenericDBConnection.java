package prog3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Created by MichaelDick on 28/10/15.
 */

public abstract class GenericDBConnection<KEY , TYPE> {

    Connection connection;

    Statement mStatement;
    
    PreparedStatement mPreparedStatement;




    public void connect(String dbName){

    }

    public void disconnect(){}

    public abstract void post(TYPE entity);

    public abstract void update (KEY identifier , TYPE update);

    public abstract void delete(KEY identifier);
}
