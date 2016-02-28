package ar.com.futbolapp.ui.activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import flowengine.FlowEngine;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FlowEngine.init(this, savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onResume();
        FlowEngine.start(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FlowEngine.resume(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        FlowEngine.saveInstanceState(this, outState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        FlowEngine.pause(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        FlowEngine.stop(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        FlowEngine.back(this);
    }

}