package ar.com.futbolapp.ui.activity;

import android.os.Bundle;

import ar.com.futbolapp.R;
import ar.com.futbolapp.flows.BenchFlow;
import flowengine.annotations.flow.FEActivity;

@FEActivity(BenchFlow.class)
public class BenchActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
    }
}
