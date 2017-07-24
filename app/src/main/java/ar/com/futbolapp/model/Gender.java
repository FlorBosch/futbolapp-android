package ar.com.futbolapp.model;

import java.util.ArrayList;
import java.util.List;

import ar.com.futbolapp.R;
import ar.com.futbolapp.ui.component.ClickToSelectEditText;

public enum Gender implements ClickToSelectEditText.Listable {
    MALE, FEMALE;

    @Override
    public int getLabel() {
        return this == Gender.MALE ? R.string.male : R.string.female;
    }

    public static List<Gender> getAll() {
        List<Gender> genders = new ArrayList<>(2);
        genders.add(MALE);
        genders.add(FEMALE);
        return genders;
    }

}
