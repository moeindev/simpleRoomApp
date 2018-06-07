package abdi.moein.mohammad.sampleroomapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import abdi.moein.mohammad.sampleroomapp.MainActivity;
import abdi.moein.mohammad.sampleroomapp.R;
import abdi.moein.mohammad.sampleroomapp.RoomData.Contact;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddContactFragment extends Fragment{
    @BindView(R.id.contact_id) EditText id;
    @BindView(R.id.contact_name) EditText name;
    @BindView(R.id.contact_email) EditText email;
    @BindView(R.id.add_contact) Button add;
    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_contact, container, false);
        ButterKnife.bind(this,view);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id.getText().toString().isEmpty()){
                    id.setError("Can't be Empty!");
                } else if (name.getText().toString().isEmpty()){
                    name.setError("Can't be Empty!");
                }else if (email.getText().toString().isEmpty()){
                    email.setError("Can't be Empty!");
                }else {
                    int c_id = Integer.parseInt(id.getText().toString());
                    String c_n = name.getText().toString();
                    String c_e = email.getText().toString();
                    //TODO (5) add contact here:
                    //init entity object:
                    Contact contact = new Contact(c_id,c_n,c_e);
                    //add entity to db:
                    MainActivity.dataBase.dataAccessObject().AddContact(contact);
                    //success toast:
                    Toast.makeText(getContext(),"Data Added",Toast.LENGTH_SHORT).show();
                    //reset fields:
                    id.setText(null);
                    name.setText(null);
                    email.setText(null);
                }
            }
        });
        return view;
    }

}
