package abdi.moein.mohammad.sampleroomapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import abdi.moein.mohammad.sampleroomapp.MainActivity;
import abdi.moein.mohammad.sampleroomapp.R;
import abdi.moein.mohammad.sampleroomapp.R2;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.add_user) Button add_user;
    @BindView(R.id.view_user) Button view_user;
    @BindView(R.id.delete_user) Button delete_user;
    @BindView(R.id.update_user) Button update_user;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
        add_user.setOnClickListener(this);
        view_user.setOnClickListener(this);
        delete_user.setOnClickListener(this);
        update_user.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_user:
                MainActivity.fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, new AddContactFragment())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.view_user:
                MainActivity.fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, new ReadContactsFragment())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.delete_user:
                MainActivity.fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, new DeleteContactFragment())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.update_user:
                MainActivity.fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, new UpdateContactFragment())
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
