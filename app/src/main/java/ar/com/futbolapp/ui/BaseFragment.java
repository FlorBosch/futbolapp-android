package ar.com.futbolapp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.io.File;

import ar.com.futbolapp.injection.component.DaggerUiComponent;
import ar.com.futbolapp.injection.component.UiComponent;
import ar.com.futbolapp.injection.module.NetworkModule;

public abstract class BaseFragment extends Fragment {

    private UiComponent uiComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getActivity().getCacheDir(), "responses");
        uiComponent = DaggerUiComponent.builder()
                .networkModule(new NetworkModule(cacheFile))
                .build();
    }

    public UiComponent getComponent() {
        return uiComponent;
    }

}