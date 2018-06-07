package abdi.moein.mohammad.sampleroomapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
public class DeleteContactFragment extends Fragment {
    @BindView(R.id.delete_user_id) TextView co_id;
    @BindView(R.id.delete_user_id_btn) Button delete;
    public DeleteContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_delete_contact, container, false);
        ButterKnife.bind(this,view);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (co_id.getText().toString().isEmpty()){
                    co_id.setError("Can't be Empty!");
                }else {
                    int id = Integer.parseInt(co_id.getText().toString());
                    Contact contact = new Contact();
                    contact.setContactId(id);
                    //TODO (7) delete a row with id:
                    MainActivity.dataBase.dataAccessObject().DeleteContact(contact);
                    //toast:
                    Toast.makeText(getContext(), "Removed", Toast.LENGTH_SHORT).show();
                    co_id.setText(null);
                }
            }
        });
        return view;
    }

}
