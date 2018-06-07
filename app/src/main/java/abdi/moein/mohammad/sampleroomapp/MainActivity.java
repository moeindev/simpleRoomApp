package abdi.moein.mohammad.sampleroomapp;

import android.arch.persistence.room.Room;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import abdi.moein.mohammad.sampleroomapp.Fragments.HomeFragment;
import abdi.moein.mohammad.sampleroomapp.RoomData.MyDataBase;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    //set fragment manager:
    public static FragmentManager fragmentManager;
    public static MyDataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init fragment manager:
        fragmentManager = getSupportFragmentManager();
        //TODO (4) init Room database:
        /**
         * By default, Room database does not allow you to perform the operations on the main thread;
         * So you can change it by adding :  .allowMainThreadQueries()
         */
        dataBase = Room.databaseBuilder(getApplicationContext(), MyDataBase.class
                , "RoomDatabase").allowMainThreadQueries().build();
        //add Home Fragment:
        if (findViewById(R.id.fragment_container) != null){
            if (savedInstanceState != null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
    }
}
