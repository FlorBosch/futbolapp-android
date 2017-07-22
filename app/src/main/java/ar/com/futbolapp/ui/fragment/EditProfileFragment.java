package ar.com.futbolapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import ar.com.futbolapp.R;
import ar.com.futbolapp.model.Gender;
import ar.com.futbolapp.ui.component.ClickToSelectEditText;

public class EditProfileFragment extends BaseFragment {

    ClickToSelectEditText<Gender> ddSex;
    ClickToSelectEditText<Gender> etDateOfBirth;
    Gender selectedGender;

    public EditProfileFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        ddSex = (ClickToSelectEditText) view.findViewById(R.id.ddSex);
        ddSex.setItems(Gender.getAll());
        ddSex.setOnItemSelectedListener(new ClickToSelectEditText.OnItemSelectedListener<Gender>() {
            @Override
            public void onItemSelectedListener(Gender item, int selectedIndex) {
                selectedGender = item;
            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.user_edit_profile, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_edit) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
