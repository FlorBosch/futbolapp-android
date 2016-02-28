package ar.com.futbolapp.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

import ar.com.futbolapp.R;
import ar.com.futbolapp.flows.NavigationFlow;
import ar.com.futbolapp.ui.fragment.NavigationDrawerFragment;
import flowengine.annotations.flow.FEActivity;
import flowengine.annotations.flow.Flow;

@FEActivity(NavigationFlow.class)
public class UserDashboardActivity extends BaseActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Flow
    public NavigationFlow flow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close) {
        };
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }


    public void onNavigationDrawerItemSelected(int position) {
        flow.jumpToBench(null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
