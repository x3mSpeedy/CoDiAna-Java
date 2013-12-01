package cz.edu.x3m.database.data;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jan Hybs
 */
public class AttemptItem extends AbstractDetailItem {

    private int id;
    private int ordinal;
    private int state;
    private String language;
    private String firstname;
    private String lastname;
    private boolean isComplex;



    public AttemptItem (int taskID, int relatedID, ResultSet row) throws SQLException {
        super (taskID, relatedID);
        id = row.getInt ("id");
        ordinal = row.getInt ("ordinal");
        state = row.getInt ("state");
        language = row.getString ("language");
        firstname = row.getString ("firstname");
        lastname = row.getString ("lastname");
        isComplex = row.getInt (language) == 1;
    }



    /**
     * @return the unique rown attempt id
     */
    public int getId () {
        return id;
    }



    /**
     * @return the ordinal (serial number) of this attempt
     */
    public int getOrdinal () {
        return ordinal;
    }



    /**
     * @return the attempt state
     */
    public int getState () {
        return state;
    }



    /**
     * @return the language used in this attempt
     */
    public String getLanguage () {
        return language;
    }



    /**
     * @return the firstname
     */
    public String getFirstname () {
        return firstname;
    }



    /**
     * @return the lastname
     */
    public String getLastname () {
        return lastname;
    }



    /**
     * @return the full name LASTNAME firstname
     */
    public String getFullname () {
        return String.format ("%s %s", lastname.toUpperCase (), firstname);
    }



    /**
     * @return the isComplex whether is solution zipped
     */
    public boolean isComplex () {
        return isComplex;
    }
}
