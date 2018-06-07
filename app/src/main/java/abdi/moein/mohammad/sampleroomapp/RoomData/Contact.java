package abdi.moein.mohammad.sampleroomapp.RoomData;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
//TODO (1) create an Entity class:
//this is the @Entity class for Room
@Entity
/**
 * by default, room will create a table with the name of your @Entity class;
 * So if you want to change the name of your table, use this annotation:
 * @Entity(tableName = "TableName")
 */
public class Contact {
    //set ContactId as @PrimaryKey:
    @PrimaryKey
    private int ContactId;

    /**
     * by default, room will user variables name for columnName;
     * So you can change the columnName by this annotation:
     * @ColumnInfo(name = "ColumnName")
     */
    @ColumnInfo(name = "contactName")
    private String ContactName;

    @ColumnInfo(name = "contactEmail")
    private String ContactEmail;

    //create Constructors:
    public Contact(){

    }
    public Contact(int id,String n,String e){
        this.ContactId = id;
        this.ContactName = n;
        this.ContactEmail = e;
    }
    //Getters and setters:
    public int getContactId() {
        return ContactId;
    }

    public void setContactId(int contactId) {
        ContactId = contactId;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getContactEmail() {
        return ContactEmail;
    }

    public void setContactEmail(String contactEmail) {
        ContactEmail = contactEmail;
    }
}
