package ar.com.futbolapp.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import ar.com.futbolapp.R;
import ar.com.futbolapp.flows.NavigationFlow;
import ar.com.futbolapp.ui.fragment.NavigationDrawerFragment;
import flowengine.annotations.flow.FEActivity;
import flowengine.annotations.flow.Flow;

@FEActivity(NavigationFlow.class)
public class UserDashboardActivity extends BaseActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    @Flow
    public NavigationFlow flow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        setUpNavigationView();

        toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close) {
        };
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

    }

    private void setUpNavigationView() {
        Menu menu = navigationView.getMenu().getItem(0).getSubMenu();
        addBenches(menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()){
                    case R.id.drawer_profile:
                        flow.editProfile();
                        return true;
                    case  R.id.drawer_settings:
                        flow.editSettings();
                        return true;
                    default:
                        flow.jumpToBench(getGroupId(menuItem.getItemId()));
                        return true;

                }
            }
        });
    }

    private void addBenches(Menu menu) {
        menu.add(Menu.NONE, 1,Menu.NONE,"Grupo 1");
        menu.add(Menu.NONE, 2,Menu.NONE,"Grupo 2");
        menu.add(Menu.NONE, 3,Menu.NONE, R.string.create_bench).setIcon(R.drawable.ic_add_black_18dp);
    }

    private Long getGroupId(int itemId) {
        return itemId * 1L;
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
