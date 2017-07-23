package ar.com.futbolapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;

import ar.com.futbolapp.R;
import ar.com.futbolapp.ui.BaseActivity;

public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
