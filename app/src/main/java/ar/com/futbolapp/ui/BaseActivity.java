package ar.com.futbolapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

import ar.com.futbolapp.injection.component.DaggerUiComponent;
import ar.com.futbolapp.injection.component.UiComponent;
import ar.com.futbolapp.injection.module.NetworkModule;

public abstract class BaseActivity extends AppCompatActivity {

    private UiComponent uiComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        uiComponent = DaggerUiComponent.builder()
                .networkModule(new NetworkModule(cacheFile))
                .build();
    }

    public UiComponent activityComponent() {
        return uiComponent;
    }
}