package ar.com.futbolapp.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ar.com.futbolapp.injection.component.DaggerUiComponent;
import ar.com.futbolapp.injection.component.UiComponent;

public abstract class BaseFragment extends Fragment {

    private UiComponent uiComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiComponent = DaggerUiComponent.builder().build();
    }

    public UiComponent getComponent() {
        return uiComponent;
    }

}