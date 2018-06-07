package abdi.moein.mohammad.sampleroomapp.RoomData;

//TODO (2) create DataAccess object for room

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

//set the @Dao by this annotation:
@Dao
public interface DataAccessObject {
    //here you must create some methods for your room DB operations:

    //You can set the operation for each method by using annotations

    //for insert operation use this annotation:
    @Insert
    public void AddContact(Contact contact);

    //using @Query annotation for getting all the info from the Room database
    @Query("select * from Contact")
    public List<Contact> getContacts();

    //using delete annotation for deleting a row:
    @Delete
    public void DeleteContact(Contact contact);

    //using update annotation for updating a row:
    @Update
    public void UpdateContact(Contact contact);
}
