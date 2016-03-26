package ar.com.futbolapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;

import ar.com.futbolapp.R;
import ar.com.futbolapp.flows.ProfileFlow;
import flowengine.annotations.flow.FEActivity;

@FEActivity(ProfileFlow.class)
public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
