package abdi.moein.mohammad.sampleroomapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import abdi.moein.mohammad.sampleroomapp.MainActivity;
import abdi.moein.mohammad.sampleroomapp.R;
import abdi.moein.mohammad.sampleroomapp.RoomData.Contact;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateContactFragment extends Fragment {
    @BindView(R.id.up_contact_id) EditText u_id;
    @BindView(R.id.up_contact_name) EditText u_name;
    @BindView(R.id.up_contact_email) EditText u_email;
    @BindView(R.id.up_contact) Button up;
    public UpdateContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_update_contact, container, false);
        ButterKnife.bind(this,view);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (u_id.getText().toString().isEmpty()){
                    u_id.setError("Can't be Empty!");
                } else if (u_name.getText().toString().isEmpty()){
                    u_name.setError("Can't be Empty!");
                }else if (u_email.getText().toString().isEmpty()){
                    u_email.setError("Can't be Empty!");
                }else {
                    int up_id = Integer.parseInt(u_id.getText().toString());
                    String up_n = u_name.getText().toString();
                    String up_e = u_email.getText().toString();
                    //TODO (8) update contact here:
                    //init entity object:
                    Contact contact = new Contact(up_id,up_n,up_e);
                    //add entity to db:
                    MainActivity.dataBase.dataAccessObject().UpdateContact(contact);
                    //success toast:
                    Toast.makeText(getContext(),"Data updated",Toast.LENGTH_SHORT).show();
                    //reset fields:
                    u_id.setText(null);
                    u_name.setText(null);
                    u_email.setText(null);
                }
            }
        });
        return view;
    }

}
