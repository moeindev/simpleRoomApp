package abdi.moein.mohammad.sampleroomapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import abdi.moein.mohammad.sampleroomapp.MainActivity;
import abdi.moein.mohammad.sampleroomapp.R;
import abdi.moein.mohammad.sampleroomapp.RoomData.Contact;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadContactsFragment extends Fragment {
    @BindView(R.id.contacts_list) TextView list;

    public ReadContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_read_contacts, container, false);
        ButterKnife.bind(this,view);
        //TODO (6) reading all info:
        List<Contact> contacts = MainActivity.dataBase.dataAccessObject().getContacts();
        //getting all the data:
        String info = "";
        for (Contact contact : contacts){
            int id = contact.getContactId();
            String name = contact.getContactName();
            String email = contact.getContactEmail();
            info = info+"\n\n"+"id:"+id+"\n name:"+name+"\n email:"+email+"\n";
        }
        list.setText(info);
        return view;
    }

}
