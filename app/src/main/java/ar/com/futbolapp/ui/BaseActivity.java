package ar.com.futbolapp.ui;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ar.com.futbolapp.injection.component.ActivityComponent;
import ar.com.futbolapp.injection.component.DaggerActivityComponent;

public abstract class BaseActivity extends AppCompatActivity {

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder().build();
    }

    public ActivityComponent activityComponent() {
        return mActivityComponent;
    }
}