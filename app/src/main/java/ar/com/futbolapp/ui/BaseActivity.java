package ar.com.futbolapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ar.com.futbolapp.injection.component.UiComponent;
import ar.com.futbolapp.injection.component.DaggerUiComponent;

public abstract class BaseActivity extends AppCompatActivity {

    private UiComponent uiComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiComponent = DaggerUiComponent.builder().build();
    }

    public UiComponent activityComponent() {
        return uiComponent;
    }
}