package abdi.moein.mohammad.sampleroomapp.RoomData;

//TODO (3) create room dataBase class :

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

//it must be an abstract class that inheritance from RoomDatabase
//you must define this class as database class by using @Database(Class Entities={},int version) annotation:
@Database(entities = {Contact.class},version = 1)
public abstract class MyDataBase extends RoomDatabase{
    //it must return your @Dao as an abstract:
    public abstract DataAccessObject dataAccessObject();
}
